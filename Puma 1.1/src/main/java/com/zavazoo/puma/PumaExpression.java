/*
 * Zavazoo Puma 1.1 - Java API for Precise Unbounded MAthematics 
 * Copyright (C) 2011-2013 Chris White <chriswhitelondon@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.zavazoo.puma;

/**
 * Represents a Puma expression that constitutes an algebraic expression
 * comprised of Puma numbers and various operational syntax.<br/>
 * <br/>
 * Puma expressions are immutable and thread-safe.<br/>
 * <br/>
 * Puma expressions are evaluated left to right and are comprised of valid Puma
 * numbers, any space characters which will be ignored, brackets to isolate a
 * subsidiary expression and the following operators all of equal precedence:<br/>
 * <br/>
 * + Add the next Puma number to the result of the previous Puma expression<br/>
 * - Subtract the next Puma number from the result of the previous Puma
 * expression<br/>
 * * Multiply the next Puma number by the result of the previous Puma expression<br/>
 * / Divide the next Puma number into the result of the previous Puma expression<br/>
 * ^ Calculate the result of the previous Puma expression to the power of the
 * next Puma number with an accuracy of 10 decimal places<br/>
 * % Calculate the modulus of the previous Puma expression when divided by the
 * next Puma number<br/>
 * <br/>
 * Examples of valid Puma expressions:<br/>
 * <br/>
 * 1234+5678<br/>
 * 1234 + 5678<br/>
 * 12.34 + -56.78<br/>
 * 12.34-56.78<br/>
 * 12.34 - 56.78<br/>
 * -12.34 - 56.78<br/>
 * -12.34 - -56.78<br/>
 * (1/2) + (3 / 4)<br/>
 * (1 + 2) / 3<br/>
 * ((1+2) / 3) * 4<br/>
 * 1 * (10 ^ 3)<br/>
 * 9 ^ (1/2)<br/>
 * 9 ^ 0.5<br/>
 * 11 % 5<br/>
 * 11 % 5.5
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 * @see com.zavazoo.puma.Puma
 * @see com.zavazoo.puma.Puma#add(Puma)
 * @see com.zavazoo.puma.Puma#subtract(Puma)
 * @see com.zavazoo.puma.Puma#multiply(Puma)
 * @see com.zavazoo.puma.Puma#divide(Puma)
 * @see com.zavazoo.puma.Puma#power(Puma)
 * @see com.zavazoo.puma.Puma#modulus(Puma)
 */
public class PumaExpression {

	/** The expression. */
	private final String expression;

	/**
	 * Creates a Puma expression equivalent to the valid Puma expression
	 * represented by the specified text.
	 * 
	 * @param expression
	 *            the expression.
	 */
	public PumaExpression(String expression) {

		this.expression = expression;

	}

	/**
	 * Evaluates this Puma expression and yields a Puma number that encapsulates
	 * the result.
	 * 
	 * @return the result.
	 * @exception NumberFormatException
	 *                if the specified Puma expression comprises a
	 *                representation of a Puma number that is not valid.
	 * @exception InvalidExpressionException
	 *                if the specified Puma expression is not valid.
	 */
	public Puma evaluate() throws NumberFormatException,
			InvalidExpressionException {

		return evaluateRecursively(expression);

	}

	/**
	 * Recursively evaluates the specified Puma expression, in respect of any
	 * subsidiary expressions enclosed in brackets, and yields a Puma number
	 * that encapsulates the result.
	 * 
	 * @param expression
	 *            the expression.
	 * @return the result.
	 * @exception NumberFormatException
	 *                if the specified Puma expression comprises a
	 *                representation of a Puma number that is not valid.
	 * @exception InvalidExpressionException
	 *                if the specified Puma expression is not valid.
	 */
	private Puma evaluateRecursively(String expression)
			throws NumberFormatException, InvalidExpressionException {

		Puma result = null;

		boolean add = false;
		boolean subtract = false;
		boolean multiply = false;
		boolean divide = false;
		boolean exponent = false;
		boolean modulus = false;

		char[] characters = expression.toCharArray();

		characters = reduceCharacterArrayCapacityAtStart(characters, ' ');
		characters = reduceCharacterArrayCapacity(characters, ' ');

		int charactersLength = characters.length;
		int charactersLastIndex = charactersLength - 1;

		evaluateExpression: for (int index = 0; index < charactersLength; index++) {

			char character = characters[index];

			if (character == ' ') {

				// ignore all spaces in the expression

			} else if (character == '(') {

				int brackets = 1;

				StringBuilder subExpression = new StringBuilder();

				for (index++; index < charactersLength; index++) {

					character = characters[index];

					if (character == '(') {

						brackets++;

					} else if (character == ')') {

						brackets--;

					}

					if (brackets == 0) {

						String subExpressionCharacters = subExpression
								.toString();

						Puma subResult = evaluateRecursively(subExpressionCharacters);

						if (add) {

							result = result.add(subResult);

							add = false;

						} else if (subtract) {

							result = result.subtract(subResult);

							subtract = false;

						} else if (multiply) {

							result = result.multiply(subResult);

							multiply = false;

						} else if (divide) {

							result = result.divide(subResult);

							divide = false;

						} else if (exponent) {

							result = result.power(subResult);

							exponent = false;

						} else if (modulus) {

							result = result.modulus(subResult);

							modulus = false;

						} else {

							result = subResult;

						}

						continue evaluateExpression;

					} else {

						subExpression.append(character);

					}

				}

				throw new InvalidExpressionException(
						"The specified expression contains mismatched brackets: "
								+ expression, expression);

			} else if (Character.isDigit(character) || character == '-') {

				if (character == '-') {

					if (index == charactersLastIndex) {

						throw new InvalidExpressionException(
								"The specified expression contains an invalid minus symbol as the last character: "
										+ expression, expression);

					}

					if (index == 0 || add || subtract || multiply || divide
							|| exponent || modulus) {

						char nextCharacter = characters[index + 1];

						if (!Character.isDigit(nextCharacter)) {

							throw new InvalidExpressionException(
									"The specified expression contains an invalid minus symbol at position ["
											+ index + "]: " + expression,
									expression);

						}

					} else {

						subtract = true;

						continue evaluateExpression;

					}

				}

				char[] numberCharacters = new char[] { character };

				groupNumber: while (index < charactersLastIndex) {

					// group any further digits that comprise the number

					int nextIndex = index + 1;

					char nextCharacter = characters[nextIndex];

					if (Character.isDigit(nextCharacter)
							|| nextCharacter == '.') {

						numberCharacters = incrementCharacterArrayCapacity(numberCharacters);

						numberCharacters[numberCharacters.length - 1] = nextCharacter;

						index = nextIndex;

					} else {

						break groupNumber;

					}

				}

				if (add) {

					Puma number = new Puma(numberCharacters);

					result = result.add(number);

					add = false;

				} else if (subtract) {

					Puma number = new Puma(numberCharacters);

					result = result.subtract(number);

					subtract = false;

				} else if (multiply) {

					Puma number = new Puma(numberCharacters);

					result = result.multiply(number);

					multiply = false;

				} else if (divide) {

					Puma number = new Puma(numberCharacters);

					result = result.divide(number);

					divide = false;

				} else if (exponent) {

					Puma number = new Puma(numberCharacters);

					result = result.power(number);

					exponent = false;

				} else if (modulus) {

					Puma number = new Puma(numberCharacters);

					result = result.modulus(number);

					modulus = false;

				} else {

					result = new Puma(numberCharacters);

				}

			} else if (character == '+') {

				add = true;

			} else if (character == '*') {

				multiply = true;

			} else if (character == '/') {

				divide = true;

			} else if (character == '^') {

				exponent = true;

			} else if (character == '%') {

				modulus = true;

			} else {

				throw new InvalidExpressionException(
						"The specified expression contains an invalid character at position ["
								+ index + "]: " + expression, expression);

			}

		}

		return result;

	}

	/**
	 * Yields a string representation of this Puma expression.
	 * 
	 * @return the representation.
	 */
	@Override
	public String toString() {

		return expression;

	}

	/**
	 * Extends the capacity of the specified array of characters by one at the
	 * end of the array.
	 * 
	 * @param characters
	 *            the characters.
	 * @return the extended array.
	 */
	private static char[] incrementCharacterArrayCapacity(char[] characters) {

		int length = characters.length;

		char[] extended = new char[length + 1];

		for (int index = 0; index < length; index++) {

			extended[index] = characters[index];

		}

		return extended;

	}

	/**
	 * Pseudo-iteratively decrements the capacity of the specified array of
	 * characters at the end of the array while the last character in the array
	 * is equal to the specified character.
	 * 
	 * @param characters
	 *            the characters.
	 * @param character
	 *            the character.
	 * @return the reduced array.
	 */
	private static char[] reduceCharacterArrayCapacity(char[] characters,
			char character) {

		int charactersLength = characters.length;

		int reducedLength = -1;

		locateCharacters: for (int index = charactersLength - 1; index > -1; index--) {

			char lastCharacter = characters[index];

			if (lastCharacter == character) {

				reducedLength = index;

			} else {

				break locateCharacters;

			}

		}

		if (reducedLength == -1) {

			return characters;

		}

		if (reducedLength == 0) {

			return new char[0];

		}

		char[] reduced = new char[reducedLength];

		for (int index = 0; index < reducedLength; index++) {

			reduced[index] = characters[index];

		}

		return reduced;

	}

	/**
	 * Pseudo-iteratively decrements the capacity of the specified array of
	 * characters at the beginning of the array while the first character in the
	 * array is equal to the specified character.
	 * 
	 * @param characters
	 *            the characters.
	 * @param character
	 *            the character.
	 * @return the reduced array.
	 */
	private static char[] reduceCharacterArrayCapacityAtStart(
			char[] characters, char character) {

		int charactersLength = characters.length;

		int reducedOffset = 0;

		locateCharacters: for (int index = 0; index < charactersLength; index++) {

			char firstCharacter = characters[index];

			if (firstCharacter == character) {

				reducedOffset = index + 1;

			} else {

				break locateCharacters;

			}

		}

		if (reducedOffset == 0) {

			return characters;

		}

		if (reducedOffset == charactersLength) {

			return new char[0];

		}

		int reducedLength = charactersLength - reducedOffset;

		char[] reduced = new char[reducedLength];

		for (int reducedIndex = 0, charactersIndex = reducedOffset; reducedIndex < reducedLength; reducedIndex++, charactersIndex++) {

			reduced[reducedIndex] = characters[charactersIndex];

		}

		return reduced;

	}

}