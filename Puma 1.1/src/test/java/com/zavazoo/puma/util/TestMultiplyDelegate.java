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

package com.zavazoo.puma.util;

import java.util.HashMap;
import java.util.Map;

import com.zavazoo.puma.InfiniteDecimalPlacesException;
import com.zavazoo.puma.Puma;

/**
 * Delegates between Puma numbers and the application on the subject of
 * multiplication using an alternative algorithm that is slower but guarantees
 * accuracy.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public abstract class TestMultiplyDelegate extends AbstractPumaProxy {

	/** The matrix of data used to perform multiplications. */
	private static Map<Character, Map<Character, UnitsAndTenthsBean>> MULTIPLICATION_MATRIX;

	static {

		MULTIPLICATION_MATRIX = new HashMap<Character, Map<Character, UnitsAndTenthsBean>>();

		Map<Character, UnitsAndTenthsBean> entryZero = new HashMap<Character, UnitsAndTenthsBean>();
		entryZero.put('0', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryZero.put('1', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryZero.put('2', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryZero.put('3', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryZero.put('4', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryZero.put('5', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryZero.put('6', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryZero.put('7', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryZero.put('8', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryZero.put('9', new UnitsAndTenthsBean(false, '0', false, '0'));

		Map<Character, UnitsAndTenthsBean> entryOne = new HashMap<Character, UnitsAndTenthsBean>();
		entryOne.put('0', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryOne.put('1', new UnitsAndTenthsBean(true, '1', false, '0'));
		entryOne.put('2', new UnitsAndTenthsBean(true, '2', false, '0'));
		entryOne.put('3', new UnitsAndTenthsBean(true, '3', false, '0'));
		entryOne.put('4', new UnitsAndTenthsBean(true, '4', false, '0'));
		entryOne.put('5', new UnitsAndTenthsBean(true, '5', false, '0'));
		entryOne.put('6', new UnitsAndTenthsBean(true, '6', false, '0'));
		entryOne.put('7', new UnitsAndTenthsBean(true, '7', false, '0'));
		entryOne.put('8', new UnitsAndTenthsBean(true, '8', false, '0'));
		entryOne.put('9', new UnitsAndTenthsBean(true, '9', false, '0'));

		Map<Character, UnitsAndTenthsBean> entryTwo = new HashMap<Character, UnitsAndTenthsBean>();
		entryTwo.put('0', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryTwo.put('1', new UnitsAndTenthsBean(true, '2', false, '0'));
		entryTwo.put('2', new UnitsAndTenthsBean(true, '4', false, '0'));
		entryTwo.put('3', new UnitsAndTenthsBean(true, '6', false, '0'));
		entryTwo.put('4', new UnitsAndTenthsBean(true, '8', false, '0'));
		entryTwo.put('5', new UnitsAndTenthsBean(true, '0', true, '1'));
		entryTwo.put('6', new UnitsAndTenthsBean(true, '2', true, '1'));
		entryTwo.put('7', new UnitsAndTenthsBean(true, '4', true, '1'));
		entryTwo.put('8', new UnitsAndTenthsBean(true, '6', true, '1'));
		entryTwo.put('9', new UnitsAndTenthsBean(true, '8', true, '1'));

		Map<Character, UnitsAndTenthsBean> entryThree = new HashMap<Character, UnitsAndTenthsBean>();
		entryThree.put('0', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryThree.put('1', new UnitsAndTenthsBean(true, '3', false, '0'));
		entryThree.put('2', new UnitsAndTenthsBean(true, '6', false, '0'));
		entryThree.put('3', new UnitsAndTenthsBean(true, '9', false, '0'));
		entryThree.put('4', new UnitsAndTenthsBean(true, '2', true, '1'));
		entryThree.put('5', new UnitsAndTenthsBean(true, '5', true, '1'));
		entryThree.put('6', new UnitsAndTenthsBean(true, '8', true, '1'));
		entryThree.put('7', new UnitsAndTenthsBean(true, '1', true, '2'));
		entryThree.put('8', new UnitsAndTenthsBean(true, '4', true, '2'));
		entryThree.put('9', new UnitsAndTenthsBean(true, '7', true, '2'));

		Map<Character, UnitsAndTenthsBean> entryFour = new HashMap<Character, UnitsAndTenthsBean>();
		entryFour.put('0', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryFour.put('1', new UnitsAndTenthsBean(true, '4', false, '0'));
		entryFour.put('2', new UnitsAndTenthsBean(true, '8', false, '0'));
		entryFour.put('3', new UnitsAndTenthsBean(true, '2', true, '1'));
		entryFour.put('4', new UnitsAndTenthsBean(true, '6', true, '1'));
		entryFour.put('5', new UnitsAndTenthsBean(true, '0', true, '2'));
		entryFour.put('6', new UnitsAndTenthsBean(true, '4', true, '2'));
		entryFour.put('7', new UnitsAndTenthsBean(true, '8', true, '2'));
		entryFour.put('8', new UnitsAndTenthsBean(true, '2', true, '3'));
		entryFour.put('9', new UnitsAndTenthsBean(true, '6', true, '3'));

		Map<Character, UnitsAndTenthsBean> entryFive = new HashMap<Character, UnitsAndTenthsBean>();
		entryFive.put('0', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryFive.put('1', new UnitsAndTenthsBean(true, '5', false, '0'));
		entryFive.put('2', new UnitsAndTenthsBean(true, '0', true, '1'));
		entryFive.put('3', new UnitsAndTenthsBean(true, '5', true, '1'));
		entryFive.put('4', new UnitsAndTenthsBean(true, '0', true, '2'));
		entryFive.put('5', new UnitsAndTenthsBean(true, '5', true, '2'));
		entryFive.put('6', new UnitsAndTenthsBean(true, '0', true, '3'));
		entryFive.put('7', new UnitsAndTenthsBean(true, '5', true, '3'));
		entryFive.put('8', new UnitsAndTenthsBean(true, '0', true, '4'));
		entryFive.put('9', new UnitsAndTenthsBean(true, '5', true, '4'));

		Map<Character, UnitsAndTenthsBean> entrySix = new HashMap<Character, UnitsAndTenthsBean>();
		entrySix.put('0', new UnitsAndTenthsBean(false, '0', false, '0'));
		entrySix.put('1', new UnitsAndTenthsBean(true, '6', false, '0'));
		entrySix.put('2', new UnitsAndTenthsBean(true, '2', true, '1'));
		entrySix.put('3', new UnitsAndTenthsBean(true, '8', true, '1'));
		entrySix.put('4', new UnitsAndTenthsBean(true, '4', true, '2'));
		entrySix.put('5', new UnitsAndTenthsBean(true, '0', true, '3'));
		entrySix.put('6', new UnitsAndTenthsBean(true, '6', true, '3'));
		entrySix.put('7', new UnitsAndTenthsBean(true, '2', true, '4'));
		entrySix.put('8', new UnitsAndTenthsBean(true, '8', true, '4'));
		entrySix.put('9', new UnitsAndTenthsBean(true, '4', true, '5'));

		Map<Character, UnitsAndTenthsBean> entrySeven = new HashMap<Character, UnitsAndTenthsBean>();
		entrySeven.put('0', new UnitsAndTenthsBean(false, '0', false, '0'));
		entrySeven.put('1', new UnitsAndTenthsBean(true, '7', false, '0'));
		entrySeven.put('2', new UnitsAndTenthsBean(true, '4', true, '1'));
		entrySeven.put('3', new UnitsAndTenthsBean(true, '1', true, '2'));
		entrySeven.put('4', new UnitsAndTenthsBean(true, '8', true, '2'));
		entrySeven.put('5', new UnitsAndTenthsBean(true, '5', true, '3'));
		entrySeven.put('6', new UnitsAndTenthsBean(true, '2', true, '4'));
		entrySeven.put('7', new UnitsAndTenthsBean(true, '9', true, '4'));
		entrySeven.put('8', new UnitsAndTenthsBean(true, '6', true, '5'));
		entrySeven.put('9', new UnitsAndTenthsBean(true, '3', true, '6'));

		Map<Character, UnitsAndTenthsBean> entryEight = new HashMap<Character, UnitsAndTenthsBean>();
		entryEight.put('0', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryEight.put('1', new UnitsAndTenthsBean(true, '8', false, '0'));
		entryEight.put('2', new UnitsAndTenthsBean(true, '6', true, '1'));
		entryEight.put('3', new UnitsAndTenthsBean(true, '4', true, '2'));
		entryEight.put('4', new UnitsAndTenthsBean(true, '2', true, '3'));
		entryEight.put('5', new UnitsAndTenthsBean(true, '0', true, '4'));
		entryEight.put('6', new UnitsAndTenthsBean(true, '8', true, '4'));
		entryEight.put('7', new UnitsAndTenthsBean(true, '6', true, '5'));
		entryEight.put('8', new UnitsAndTenthsBean(true, '4', true, '6'));
		entryEight.put('9', new UnitsAndTenthsBean(true, '2', true, '7'));

		Map<Character, UnitsAndTenthsBean> entryNine = new HashMap<Character, UnitsAndTenthsBean>();
		entryNine.put('0', new UnitsAndTenthsBean(false, '0', false, '0'));
		entryNine.put('1', new UnitsAndTenthsBean(true, '9', false, '0'));
		entryNine.put('2', new UnitsAndTenthsBean(true, '8', true, '1'));
		entryNine.put('3', new UnitsAndTenthsBean(true, '7', true, '2'));
		entryNine.put('4', new UnitsAndTenthsBean(true, '6', true, '3'));
		entryNine.put('5', new UnitsAndTenthsBean(true, '5', true, '4'));
		entryNine.put('6', new UnitsAndTenthsBean(true, '4', true, '5'));
		entryNine.put('7', new UnitsAndTenthsBean(true, '3', true, '6'));
		entryNine.put('8', new UnitsAndTenthsBean(true, '2', true, '7'));
		entryNine.put('9', new UnitsAndTenthsBean(true, '1', true, '8'));

		MULTIPLICATION_MATRIX.put('0', entryZero);
		MULTIPLICATION_MATRIX.put('1', entryOne);
		MULTIPLICATION_MATRIX.put('2', entryTwo);
		MULTIPLICATION_MATRIX.put('3', entryThree);
		MULTIPLICATION_MATRIX.put('4', entryFour);
		MULTIPLICATION_MATRIX.put('5', entryFive);
		MULTIPLICATION_MATRIX.put('6', entrySix);
		MULTIPLICATION_MATRIX.put('7', entrySeven);
		MULTIPLICATION_MATRIX.put('8', entryEight);
		MULTIPLICATION_MATRIX.put('9', entryNine);

	}

	/**
	 * Multiplies the specified subject Puma number by the specified candidate
	 * Puma number and yields a new Puma number that encapsulates the result.<br/>
	 * Both numbers must represent a value with a terminating decimal expansion;
	 * a finite number of decimal places, otherwise this method will yield an
	 * exception.
	 * 
	 * @param subject
	 *            the subject number.
	 * @param candidate
	 *            the candidate number.
	 * @return the result.
	 * @exception InfiniteDecimalPlacesException
	 *                if either number represents a value with infinite decimal
	 *                places.
	 */
	public static Puma multiply(Puma subject, Puma candidate)
			throws InfiniteDecimalPlacesException {

		OperationTestBean subjectData = createOperationData(subject);
		OperationTestBean candidateData = createOperationData(candidate);

		char[] subjectIntegerCharacters = subjectData.getInteger();
		char[] subjectFractionalCharacters = subjectData.getFractional();

		char[] candidateIntegerCharacters = candidateData.getInteger();
		char[] candidateFractionalCharacters = candidateData.getFractional();

		int subjectDecimalPlaces = 0;

		char[] subjectCharacters = subjectIntegerCharacters;

		if (subjectFractionalCharacters != null) {

			subjectDecimalPlaces = subjectFractionalCharacters.length;

			subjectCharacters = TestArrayUtils.joinCharacterArrays(
					subjectIntegerCharacters, subjectFractionalCharacters);

		}

		int candidateDecimalPlaces = 0;

		char[] candidateCharacters = candidateIntegerCharacters;

		if (candidateFractionalCharacters != null) {

			candidateDecimalPlaces = candidateFractionalCharacters.length;

			candidateCharacters = TestArrayUtils.joinCharacterArrays(
					candidateIntegerCharacters, candidateFractionalCharacters);

		}

		int subjectCharactersLength = subjectCharacters.length;
		int candidateCharactersLength = candidateCharacters.length;

		char[] reversedUnscaledCharacters = new char[] { '0' };

		for (int subjectIndex = 0; subjectIndex < subjectCharactersLength; subjectIndex++) {

			char subjectCharacter = subjectCharacters[subjectIndex];

			int subjectScale = subjectCharactersLength - subjectIndex - 1;

			for (int candidateIndex = 0; candidateIndex < candidateCharactersLength; candidateIndex++) {

				char candidateCharacter = candidateCharacters[candidateIndex];

				UnitsAndTenthsBean unitsAndTenths = MULTIPLICATION_MATRIX.get(
						subjectCharacter).get(candidateCharacter);

				if (unitsAndTenths.isUnit()) {

					int candidateScale = candidateCharactersLength
							- candidateIndex - 1;

					int intermediateScale = subjectScale + candidateScale;

					char[] reversedIntermediateCharacters = null;

					if (unitsAndTenths.isTenth()) {

						reversedIntermediateCharacters = new char[] {
								unitsAndTenths.getUnits(),
								unitsAndTenths.getTenths() };

						intermediateScale = intermediateScale + 2;

					} else {

						reversedIntermediateCharacters = new char[] { unitsAndTenths
								.getUnits() };

						intermediateScale = intermediateScale + 1;

					}

					reversedIntermediateCharacters = TestArrayUtils
							.extendCharacterArrayCapacityAtStart(
									reversedIntermediateCharacters,
									intermediateScale, '0');

					int reversedUnscaledCharactersLength = reversedUnscaledCharacters.length;
					int reversedIntermediateCharactersLength = reversedIntermediateCharacters.length;

					if (reversedIntermediateCharactersLength > reversedUnscaledCharactersLength) {

						reversedUnscaledCharacters = TestAddDelegate
								.addReversedRecursively(
										reversedIntermediateCharacters,
										reversedUnscaledCharacters);

					} else {

						reversedUnscaledCharacters = TestAddDelegate
								.addReversedRecursively(
										reversedUnscaledCharacters,
										reversedIntermediateCharacters);

					}

				}

			}

		}

		int reversedUnscaledCharactersLength = reversedUnscaledCharacters.length;

		int decimalPlaces = subjectDecimalPlaces + candidateDecimalPlaces;

		char[] reversedMultipliedIntegerCharacters = new char[reversedUnscaledCharactersLength
				- decimalPlaces];
		char[] reversedMultipliedFractionalCharacters = new char[decimalPlaces];

		for (int index = 0, multipliedIndex = 0 - decimalPlaces; index < reversedUnscaledCharactersLength; index++, multipliedIndex++) {

			char unscaledCharacter = reversedUnscaledCharacters[index];

			if (index < decimalPlaces) {

				reversedMultipliedFractionalCharacters[index] = unscaledCharacter;

			} else {

				reversedMultipliedIntegerCharacters[multipliedIndex] = unscaledCharacter;

			}

		}

		TestArrayUtils
				.reverseCharacterArray(reversedMultipliedIntegerCharacters);
		TestArrayUtils
				.reverseCharacterArray(reversedMultipliedFractionalCharacters);

		char[] multipliedIntegerCharacters = reversedMultipliedIntegerCharacters;
		char[] multipliedFractionalCharacters = reversedMultipliedFractionalCharacters;

		boolean subjectNegative = subjectData.isNegative();
		boolean candidateNegative = candidateData.isNegative();

		boolean negative = false;

		if ((subjectNegative && !candidateNegative)
				|| (!subjectNegative && candidateNegative)) {

			negative = true;

		}

		Puma multipliedNumber = createPuma(new OperationTestBean(
				multipliedIntegerCharacters, multipliedFractionalCharacters,
				negative));

		return multipliedNumber;

	}

}