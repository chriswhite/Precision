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

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a Puma number that maintains precision along a series of
 * calculations comprised of various operations including division that may
 * result with infinite or infinitely recurring results.<br/>
 * <br/>
 * Puma numbers are immutable and thread-safe.<br/>
 * <br/>
 * Any unrounded representation of a Puma number will be precise, regardless of
 * any infinities, and may be persisted and later used to create a Puma number
 * in order to continue any precise calculations. <br/>
 * <br/>
 * Valid Puma numbers are comprised of an optional minus sign then an integer
 * optionally followed by a decimal point then another integer, allowing leading
 * and trailing zeros, for example: <br/>
 * <br/>
 * 0<br/>
 * 0.0<br/>
 * 12<br/>
 * -12<br/>
 * 012.34<br/>
 * 12.0034<br/>
 * -0012.3400
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class Puma implements Comparable<Puma>, Serializable {

	/** The serialization version unique identifier. */
	private static final long serialVersionUID = 1l;

	/** A Puma number with a value of zero. */
	public static final Puma ZERO = new Puma("0");

	/** A Puma number with a value of one. */
	public static final Puma ONE = new Puma("1");

	/** A Puma number with a value of two. */
	public static final Puma TWO = new Puma("2");

	/** A Puma number with a value of three. */
	public static final Puma THREE = new Puma("3");

	/** A Puma number with a value of four. */
	public static final Puma FOUR = new Puma("4");

	/** A Puma number with a value of five. */
	public static final Puma FIVE = new Puma("5");

	/** A Puma number with a value of six. */
	public static final Puma SIX = new Puma("6");

	/** A Puma number with a value of seven. */
	public static final Puma SEVEN = new Puma("7");

	/** A Puma number with a value of eight. */
	public static final Puma EIGHT = new Puma("8");

	/** A Puma number with a value of nine. */
	public static final Puma NINE = new Puma("9");

	/** A Puma number with a value of ten. */
	public static final Puma TEN = new Puma("10");

	/** A Puma number with a value of minus one. */
	public static final Puma MINUS_ONE = new Puma("-1");

	/** A Puma number with a value of positive infinity. */
	public static final Puma POSITIVE_INFINITY = new Puma("1", "0");

	/** A Puma number with a value of negative infinity. */
	public static final Puma NEGATIVE_INFINITY = new Puma("-1", "0");

	/** A big decimal with a value of zero. */
	static final BigDecimal ZERO_BIG_DECIMAL = new BigDecimal("0");

	/** A big decimal with a value of one. */
	static final BigDecimal ONE_BIG_DECIMAL = new BigDecimal("1");

	/** A big decimal with a value of two. */
	static final BigDecimal TWO_BIG_DECIMAL = new BigDecimal("2");

	/** A big decimal with a value of three. */
	static final BigDecimal THREE_BIG_DECIMAL = new BigDecimal("3");

	/** A big decimal with a value of minus one. */
	static final BigDecimal MINUS_ONE_BIG_DECIMAL = new BigDecimal("-1");

	/** A big decimal with a value equivalent to the maximum integer. */
	static final BigDecimal MAX_INTEGER_BIG_DECIMAL = new BigDecimal(
			Integer.MAX_VALUE);

	/**
	 * The big decimal that represents the value when this Puma number
	 * represents a real number or that encapsulates the numerator when this
	 * Puma number represents a fraction.
	 */
	private final BigDecimal numerator;

	/**
	 * The big decimal that represents the denominator when this Puma number
	 * represents a fraction or null when this Puma number represents a real
	 * number.
	 */
	private final BigDecimal denominator;

	/**
	 * Creates a Puma number using the specified representation of a valid Puma
	 * number or a valid Puma expression.
	 * 
	 * @param number
	 *            the number or expression.
	 * @exception NumberFormatException
	 *                if the specified number does not represent a valid Puma
	 *                number or a valid Puma expression.
	 * @see com.zavazoo.puma.PumaExpression
	 */
	public Puma(String number) throws NumberFormatException {

		// following code contains structural workarounds so that the numerator
		// and denominator can be declared final

		BigDecimal numerator = null;
		BigDecimal denominator = null;
		NumberFormatException invalid = null;

		try {

			numerator = new BigDecimal(number);

		} catch (NumberFormatException mutable) {

			invalid = mutable;

			PumaExpression expression = new PumaExpression(number);

			try {

				Puma evaluated = expression.evaluate();

				numerator = evaluated.numerator;
				denominator = evaluated.denominator;

				invalid = null;

			} catch (InvalidExpressionException superceded) {

			}

		}

		if (invalid != null) {

			throw invalid;

		}

		this.numerator = numerator;
		this.denominator = denominator;

	}

	/**
	 * Creates a Puma number using the specified representation of a valid Puma
	 * number or a valid Puma expression.
	 * 
	 * @param number
	 *            the number or expression.
	 * @exception NumberFormatException
	 *                if the specified number does not represent a valid Puma
	 *                number or a valid Puma expression.
	 * @see com.zavazoo.puma.PumaExpression
	 */
	public Puma(char[] number) throws NumberFormatException {

		// following code contains structural workarounds so that the numerator
		// and denominator can be declared final

		BigDecimal numerator = null;
		BigDecimal denominator = null;
		NumberFormatException invalid = null;

		try {

			numerator = new BigDecimal(number);

		} catch (NumberFormatException mutable) {

			invalid = mutable;

			PumaExpression expression = new PumaExpression(new String(number));

			try {

				Puma evaluated = expression.evaluate();

				numerator = evaluated.numerator;
				denominator = evaluated.denominator;

				invalid = null;

			} catch (InvalidExpressionException superceded) {

			}

		}

		if (invalid != null) {

			throw invalid;

		}

		this.numerator = numerator;
		this.denominator = denominator;

	}

	/**
	 * Creates a Puma number using the specified numerator and denominator.
	 * 
	 * @param numerator
	 *            the numerator.
	 * @param denominator
	 *            the denominator.
	 */
	Puma(String numerator, String denominator) {

		this.numerator = new BigDecimal(numerator);

		if (denominator == null) {

			this.denominator = null;

		} else {

			this.denominator = new BigDecimal(denominator);

		}

	}

	/**
	 * Creates a Puma number using the specified numerator and denominator
	 * reducing the resultant Puma number to the simplest possible form suitable
	 * for further calculations.
	 * 
	 * @param numerator
	 *            the numerator.
	 * @param denominator
	 *            the denominator.
	 */
	Puma(BigDecimal numerator, BigDecimal denominator) {

		// following code contains structural workarounds so that the numerator
		// and denominator can be declared final

		initialise: {

			numerator = numerator.stripTrailingZeros();

			if (denominator == null) {

				// x/1
				break initialise;

			}

			if (numerator.compareTo(ZERO_BIG_DECIMAL) == 0) {

				// 0/x = 0
				denominator = null;

				break initialise;

			}

			denominator = denominator.stripTrailingZeros();

			if (denominator.compareTo(ZERO_BIG_DECIMAL) == 0) {

				if (numerator.compareTo(ZERO_BIG_DECIMAL) < 0) {

					// -x/0 = -1/0
					numerator = MINUS_ONE_BIG_DECIMAL;

				} else {

					// +x/0 = 1/0
					numerator = ONE_BIG_DECIMAL;

				}

				break initialise;

			}

			if (denominator.compareTo(ZERO_BIG_DECIMAL) < 0) {

				// +x/-y = -x/y
				// -x/-y = x/y
				numerator = numerator.negate();
				denominator = denominator.negate();

			}

			try {

				// reduce the number to a real number eliminating the fraction

				// x/y = (x/y) / (y/y) = (x/y) / (1)

				numerator = numerator.divide(denominator);

				denominator = null;

				break initialise;

			} catch (ArithmeticException moreProbable) {

				try {

					// reduce the number to a readable fraction such as 1/3

					// x/y = (x/x) / (y/x) = (1) / (y/x)

					denominator = denominator.divide(numerator);

					numerator = ONE_BIG_DECIMAL;

				} catch (ArithmeticException lessProbable) {

					// reduce the fraction to an integer divided by an integer

					int numeratorScale = numerator.scale();
					int denominatorScale = denominator.scale();

					if (numeratorScale > 0 || denominatorScale > 0) {

						int maximumScale = numeratorScale;

						if (denominatorScale > numeratorScale) {

							maximumScale = denominatorScale;

						}

						// x/y = (x * (10 ^ z)) / (y * (10 ^ z))
						numerator = numerator.scaleByPowerOfTen(maximumScale);
						denominator = denominator
								.scaleByPowerOfTen(maximumScale);

					}

				}

			}

			if (denominator.compareTo(ZERO_BIG_DECIMAL) < 0) {

				// +x/-y = -x/y
				// -x/-y = x/y
				numerator = numerator.negate();
				denominator = denominator.negate();

			}

		}

		this.numerator = numerator;
		this.denominator = denominator;

	}

	/**
	 * Adds the specified Puma number to this Puma number, equivalent to {@code
	 * this + number}, and yields a new Puma number that encapsulates the
	 * result.
	 * 
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	public Puma add(Puma number) {

		if (infinite() && number.infinite()) {

			boolean nativePositive = positive();
			boolean specifiedPositive = number.positive();

			if (nativePositive && specifiedPositive) {

				return new Puma(ONE_BIG_DECIMAL, ZERO_BIG_DECIMAL);

			} else if (!nativePositive && !specifiedPositive) {

				return new Puma(MINUS_ONE_BIG_DECIMAL, ZERO_BIG_DECIMAL);

			} else {

				return new Puma(ZERO_BIG_DECIMAL, null);

			}

		}

		BigDecimal nativeNumerator = numerator;
		BigDecimal nativeDenominator = denominator;

		BigDecimal specifiedNumerator = number.numerator;
		BigDecimal specifiedDenominator = number.denominator;

		if (nativeDenominator == null) {

			if (specifiedDenominator == null) {

				// x/1 + y/1 = ((x * 1) / (1 * 1)) + ((1 * y) / (1 * 1)) =
				// ((x * 1) + (1 * y)) / 1 = (x + y) / 1 = x + y

				BigDecimal addedNumerators = nativeNumerator
						.add(specifiedNumerator);

				return new Puma(addedNumerators, null);

			} else {

				// x/1 + y/z = ((x * z) / (1 * z)) + ((1 * y) / (1 * z)) =
				// ((x * z) / z)) + y/z = ((x * z) + y) / z

				BigDecimal nativeMultipliedNumerator = nativeNumerator
						.multiply(specifiedDenominator);

				BigDecimal addedNumerators = nativeMultipliedNumerator
						.add(specifiedNumerator);

				return new Puma(addedNumerators, specifiedDenominator);

			}

		} else {

			if (specifiedDenominator == null) {

				// x/z + y/1 = ((x * 1) / (z * 1)) + ((y * z) / (z * 1)) =
				// x/z + ((y * z) / z) = (x + (y * z)) / z

				BigDecimal specifiedMultipliedNumerator = nativeDenominator
						.multiply(specifiedNumerator);

				BigDecimal addedNumerators = nativeNumerator
						.add(specifiedMultipliedNumerator);

				return new Puma(addedNumerators, nativeDenominator);

			} else {

				// a/b + x/y = ((a * y) / (b * y)) + ((x * b) / (y * b)) =
				// ((a * y) + (x * b)) / (b * y)

				BigDecimal nativeMultipliedNumerator = nativeNumerator
						.multiply(specifiedDenominator);

				BigDecimal specifiedMultipliedNumerator = nativeDenominator
						.multiply(specifiedNumerator);

				BigDecimal addedNumerators = nativeMultipliedNumerator
						.add(specifiedMultipliedNumerator);

				BigDecimal multipliedDenominators = nativeDenominator
						.multiply(specifiedDenominator);

				return new Puma(addedNumerators, multipliedDenominators);

			}

		}

	}

	/**
	 * Subtracts the specified Puma number from this Puma number, equivalent to
	 * {@code this - number}, and yields a new Puma number that encapsulates the
	 * result.
	 * 
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	public Puma subtract(Puma number) {

		if (infinite() && number.infinite()) {

			boolean nativePositive = positive();
			boolean specifiedPositive = number.positive();

			if (nativePositive && !specifiedPositive) {

				return new Puma(ONE_BIG_DECIMAL, ZERO_BIG_DECIMAL);

			} else if (!nativePositive && specifiedPositive) {

				return new Puma(MINUS_ONE_BIG_DECIMAL, ZERO_BIG_DECIMAL);

			}

		}

		BigDecimal nativeNumerator = numerator;
		BigDecimal nativeDenominator = denominator;

		BigDecimal specifiedNumerator = number.numerator;
		BigDecimal specifiedDenominator = number.denominator;

		if (nativeDenominator == null) {

			if (specifiedDenominator == null) {

				// x/1 - y/1 = ((x * 1) / (1 * 1)) - ((1 * y) / (1 * 1)) =
				// ((x * 1) - (1 * y)) / 1 = (x - y) / 1 = x - y

				BigDecimal subtractedNumerators = nativeNumerator
						.subtract(specifiedNumerator);

				return new Puma(subtractedNumerators, null);

			} else {

				// x/1 - y/z = ((x * z) / (1 * z)) - ((1 * y) / (1 * z)) =
				// ((x * z) / z)) - y/z = ((x * z) - y) / z

				BigDecimal nativeMultipliedNumerator = nativeNumerator
						.multiply(specifiedDenominator);

				BigDecimal subtractedNumerators = nativeMultipliedNumerator
						.subtract(specifiedNumerator);

				return new Puma(subtractedNumerators, specifiedDenominator);

			}

		} else {

			if (specifiedDenominator == null) {

				// x/z - y/1 = ((x * 1) / (z * 1)) - ((y * z) / (z * 1)) =
				// x/z - ((y * z) / z) = (x - (y * z)) / z

				BigDecimal specifiedMultipliedNumerator = nativeDenominator
						.multiply(specifiedNumerator);

				BigDecimal subtractedNumerators = nativeNumerator
						.subtract(specifiedMultipliedNumerator);

				return new Puma(subtractedNumerators, nativeDenominator);

			} else {

				// a/b - x/y = ((a * y) / (b * y)) - ((x * b) / (y * b)) =
				// ((a * y) - (x * b)) / (b * y)

				BigDecimal nativeMultipliedNumerator = nativeNumerator
						.multiply(specifiedDenominator);

				BigDecimal specifiedMultipliedNumerator = nativeDenominator
						.multiply(specifiedNumerator);

				BigDecimal subtractedNumerators = nativeMultipliedNumerator
						.subtract(specifiedMultipliedNumerator);

				BigDecimal multipliedDenominators = nativeDenominator
						.multiply(specifiedDenominator);

				return new Puma(subtractedNumerators, multipliedDenominators);

			}

		}

	}

	/**
	 * Multiplies the specified Puma number by this Puma number, equivalent to
	 * {@code this * number}, and yields a new Puma number that encapsulates the
	 * result.
	 * 
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	public Puma multiply(Puma number) {

		BigDecimal nativeNumerator = numerator;
		BigDecimal nativeDenominator = denominator;

		BigDecimal specifiedNumerator = number.numerator;
		BigDecimal specifiedDenominator = number.denominator;

		if (nativeDenominator == null) {

			if (specifiedDenominator == null) {

				// x/1 * y/1 = (x * y) / (1 * 1) = (x * y) / 1 = x * y

				BigDecimal multipliedNumerators = nativeNumerator
						.multiply(specifiedNumerator);

				return new Puma(multipliedNumerators, null);

			} else {

				// x/1 * y/z = (x * y) / (1 * z) = (x * y) / z

				BigDecimal multipliedNumerators = nativeNumerator
						.multiply(specifiedNumerator);

				return new Puma(multipliedNumerators, specifiedDenominator);

			}

		} else {

			if (specifiedDenominator == null) {

				// x/z * y/1 = (x * y) / (z * 1) = (x * y) / z

				BigDecimal multipliedNumerators = nativeNumerator
						.multiply(specifiedNumerator);

				return new Puma(multipliedNumerators, nativeDenominator);

			} else {

				// a/b * x/y = (a * x) / (b * y)

				BigDecimal multipliedNumerators = nativeNumerator
						.multiply(specifiedNumerator);

				BigDecimal multipliedDenominators = nativeDenominator
						.multiply(specifiedDenominator);

				return new Puma(multipliedNumerators, multipliedDenominators);

			}

		}

	}

	/**
	 * Divides the specified Puma number into this Puma number, equivalent to
	 * {@code this / number}, and yields a new Puma number that encapsulates the
	 * result.
	 * 
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	public Puma divide(Puma number) {

		boolean nativeInfinite = infinite();
		boolean specifiedInfinite = number.infinite();

		if (nativeInfinite && specifiedInfinite) {

			boolean nativePositive = positive();
			boolean specifiedPositive = number.positive();

			if ((nativePositive && specifiedPositive)
					|| (!nativePositive && !specifiedPositive)) {

				return new Puma(ONE_BIG_DECIMAL, null);

			} else {

				return new Puma(MINUS_ONE_BIG_DECIMAL, null);

			}

		}

		if (nativeInfinite && !specifiedInfinite && number.negative()) {

			boolean nativePositive = positive();

			if (nativePositive) {

				return new Puma(MINUS_ONE_BIG_DECIMAL, ZERO_BIG_DECIMAL);

			} else {

				return new Puma(ONE_BIG_DECIMAL, ZERO_BIG_DECIMAL);

			}

		}

		BigDecimal nativeNumerator = numerator;
		BigDecimal nativeDenominator = denominator;

		BigDecimal specifiedNumerator = number.numerator;
		BigDecimal specifiedDenominator = number.denominator;

		if (nativeDenominator == null) {

			if (specifiedDenominator == null) {

				// x/1 / y/1 = x/1 * 1/y = (x * 1) / (1 * y) = x / y

				return new Puma(nativeNumerator, specifiedNumerator);

			} else {

				// x/1 / y/z = x/1 * z/y = (x * z) / (1 * y) = (x * z) / y

				BigDecimal nativeMultipliedNumerator = nativeNumerator
						.multiply(specifiedDenominator);

				return new Puma(nativeMultipliedNumerator, specifiedNumerator);

			}

		} else {

			if (specifiedDenominator == null) {

				// x/z / y/1 = x/z * 1/y = (x * 1) / (z * y) = x / (z * y)

				BigDecimal nativeMultipliedDenominator = nativeDenominator
						.multiply(specifiedNumerator);

				return new Puma(nativeNumerator, nativeMultipliedDenominator);

			} else {

				// a/b / x/y = a/b * y/x = (a * y) / (b * x)

				BigDecimal nativeMultipliedNumerator = nativeNumerator
						.multiply(specifiedDenominator);

				BigDecimal nativeMultipliedDenominator = nativeDenominator
						.multiply(specifiedNumerator);

				return new Puma(nativeMultipliedNumerator,
						nativeMultipliedDenominator);

			}

		}

	}

	/**
	 * Increments this Puma number, equivalent to {@code this + 1}, and yields a
	 * new Puma number that encapsulates the result.
	 * 
	 * @return the result.
	 */
	public Puma increment() {

		return add(ONE);

	}

	/**
	 * Decrements this Puma number, equivalent to {@code this - 1}, and yields a
	 * new Puma number that encapsulates the result.
	 * 
	 * @return the result.
	 */
	public Puma decrement() {

		return subtract(ONE);

	}

	/**
	 * Halves this Puma number, equivalent to {@code this / 2}, and yields a new
	 * Puma number that encapsulates the result.
	 * 
	 * @return the result.
	 */
	public Puma halve() {

		return divide(TWO);

	}

	/**
	 * Multiplies this Puma number by ten to the power of the specified scale,
	 * equivalent to {@code this * (10 ^ scale)}, and yields a new Puma number
	 * that encapsulates the result.<br/>
	 * For example the following numbers when scaled by {@code (10 ^ scale)}
	 * would result in the corresponding numbers:<br/>
	 * <br/>
	 * 1 * (10 ^ 0) = 1<br/>
	 * 1 * (10 ^ 1) = 10<br/>
	 * 1 * (10 ^ 2) = 100<br/>
	 * 10 * (10 ^ 3) = 10000<br/>
	 * 1 * (10 ^ -1) = 0.1<br/>
	 * 1 * (10 ^ -2) = 0.01<br/>
	 * 10 * (10 ^ -3) = 0.01<br/>
	 * -10 * (10 ^ 3) = -10000<br/>
	 * 1/3 * (10 ^ 3) = 1/0.003
	 * 
	 * @param scale
	 *            the scale.
	 * @return the result.
	 */
	public Puma scale(int scale) {

		BigDecimal scaledNumerator = numerator;
		BigDecimal nativeDenominator = denominator;

		if (scale != 0) {

			if (finite()) {

				scaledNumerator = scaledNumerator.scaleByPowerOfTen(scale);

			}

		}

		return new Puma(scaledNumerator, nativeDenominator);

	}

	/**
	 * Calculates this Puma number squared, equivalent to {@code this ^ 2}, and
	 * yields a new Puma number that encapsulates the result.<br/>
	 * This operation regards the exponent operator to have higher precedence
	 * than the negation operator therefore {@code -this ^ 2} is equivalent to
	 * {@code -1 * (this ^ 2)}.
	 * 
	 * @return the result.
	 */
	public Puma squared() {

		Puma number = new Puma(TWO_BIG_DECIMAL, null);

		return power(number);

	}

	/**
	 * Calculates the square root of this Puma number, equivalent to {@code this
	 * ^ (1/2)}, and yields a new Puma number that encapsulates the result.<br/>
	 * This operation regards the exponent operator to have higher precedence
	 * than the negation operator therefore {@code -this ^ (1/2)} is equivalent
	 * to {@code -1 * (this ^ (1/2))}.
	 * 
	 * @return the result.
	 */
	public Puma squareRoot() {

		Puma number = new Puma(ONE_BIG_DECIMAL, TWO_BIG_DECIMAL);

		return power(number);

	}

	/**
	 * Calculates this Puma number squared, equivalent to {@code this ^ 3}, and
	 * yields a new Puma number that encapsulates the result.<br/>
	 * This operation regards the exponent operator to have higher precedence
	 * than the negation operator therefore {@code -this ^ 3} is equivalent to
	 * {@code -1 * (this ^ 3)}.
	 * 
	 * @return the result.
	 */
	public Puma cubed() {

		Puma number = new Puma(THREE_BIG_DECIMAL, null);

		return power(number);

	}

	/**
	 * Calculates the cube root of this Puma number, equivalent to {@code this ^
	 * (1/3)}, and yields a new Puma number that encapsulates the result.<br/>
	 * This operation regards the exponent operator to have higher precedence
	 * than the negation operator therefore {@code -this ^ (1/3)} is equivalent
	 * to {@code -1 * (this ^ (1/3))}.
	 * 
	 * @return the result.
	 */
	public Puma cubeRoot() {

		Puma number = new Puma(ONE_BIG_DECIMAL, THREE_BIG_DECIMAL);

		return power(number);

	}

	/**
	 * Calculates this Puma number to the power of the specified Puma number,
	 * equivalent to {@code this ^ number}, and yields a new Puma number that
	 * encapsulates the result. <br/>
	 * The result may be imprecise if the specified number is not an integer,
	 * due to the limitations of mechanical procedures for root calculations,
	 * but in such cases will be precise up to 10 decimal places.<br/>
	 * This operation regards the exponent operator to have higher precedence
	 * than the negation operator therefore {@code -this ^ number} is equivalent
	 * to {@code -1 * (this ^ number)}.
	 * 
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	public Puma power(Puma number) {

		return power(number, 10);

	}

	/**
	 * Calculates this Puma number to the power of the specified Puma number,
	 * equivalent to {@code this ^ number}, and yields a new Puma number that
	 * encapsulates the result. <br/>
	 * The result may be imprecise if the specified number is not an integer,
	 * due to the limitations of mechanical procedures for root calculations,
	 * but in such cases will be precise up to the specified scale; the number
	 * of decimal places. The reader will note that a larger scale will result
	 * in a more precise result but will take longer to calculate.<br/>
	 * This operation regards the exponent operator to have higher precedence
	 * than the negation operator therefore {@code -this ^ number} is equivalent
	 * to {@code -1 * (this ^ number)}.
	 * 
	 * @param number
	 *            the number.
	 * @param decimalPlaces
	 *            the number of decimal places; only used if the specified
	 *            number is not an integer.
	 * @return the result.
	 */
	public Puma power(Puma number, final int decimalPlaces) {

		// simplify the fraction used to represent the specified exponent in
		// order to improve performance
		number = number.createFractionDecorator().toFractionPuma();

		Puma absolute = null;
		boolean negative = false;

		if (positive()) {

			absolute = this;

		} else {

			absolute = absolute();
			negative = true;

		}

		boolean zeroToOne = false;

		if (absolute.notZero() && absolute.lessThan(ONE)) {

			zeroToOne = true;

		}

		if (zeroToOne) {

			if (number.positiveInfinity()) {

				return ZERO;

			}

			if (number.negativeInfinity()) {

				if (negative()) {

					return NEGATIVE_INFINITY;

				}

				return POSITIVE_INFINITY;

			}

		}

		if (zero()) {

			if (number.negative()) {

				// 0 ^ -x = 1/0 ^ x = 1/0
				return POSITIVE_INFINITY;

			}

			// 0 ^ x = 0
			return ZERO;

		}

		if (infinite() && number.negative()) {

			// 1/0 ^ -x = 0 ^ x = 0
			return ZERO;

		}

		if (equals(ONE) || equals(MINUS_ONE) || infinite()) {

			// 1 ^ x = 1
			// -1 ^ x = -1
			// 1/0 ^ x = 1/0
			// -1/0 ^ x = -1/0
			return new Puma(numerator, denominator);

		}

		if (number.positiveInfinity()) {

			if (negative()) {

				// -x ^ 1/0 = -1/0
				return NEGATIVE_INFINITY;

			}

			// x ^ 1/0 = 1/0
			return POSITIVE_INFINITY;

		}

		if (number.negativeInfinity()) {

			if (equals(ONE)) {

				// 1 ^ -1/0 = 1 ^ 1/0 = 1
				return ONE;

			}

			if (equals(MINUS_ONE)) {

				// -1 ^ -1/0 = -1 ^ 1/0 = -1/0
				return NEGATIVE_INFINITY;

			}

			// x ^ -1/0 = 0
			return ZERO;

		}

		if (number.zero()) {

			if (negative()) {

				// -x ^ 0 = -1
				return MINUS_ONE;

			}

			// x ^ 0 = 1
			return ONE;

		}

		if (equals(MINUS_ONE)) {

			// -1 ^ x = 1 (ignoring complex numbers)
			return ONE;

		}

		if (number.equals(ONE)) {

			// x ^ 1 = x
			return new Puma(numerator, denominator);

		}

		if (number.negative()) {

			// x ^ -y = 1/x ^ y

			Puma nativeReciprocal = reciprocal();

			Puma specifiedAbsolute = number.absolute();

			return nativeReciprocal.power(specifiedAbsolute, decimalPlaces);

		}

		BigDecimal specifiedNumerator = number.numerator;
		BigDecimal specifiedDenominator = number.denominator;

		// scale the numerator to an integer

		int numeratorScale = specifiedNumerator.scale();

		if (numeratorScale > 0) {

			// x/y = (x * (10 ^ z)) / (y * (10 ^ z))
			specifiedNumerator = specifiedNumerator
					.scaleByPowerOfTen(numeratorScale);

			// scale the denominator to an integer to the same extent as the
			// numerator

			if (specifiedDenominator == null) {

				// assign 1 to the denominator so that it may be scaled with the
				// numerator

				specifiedDenominator = ONE_BIG_DECIMAL;

			}

			// x/y = (x * (10 ^ z)) / (y * (10 ^ z))
			specifiedDenominator = specifiedDenominator
					.scaleByPowerOfTen(numeratorScale);

		}

		if (absolute.infiniteDecimalPlaces()) {

			// apply generous rounding to a non-terminating native number to
			// improve performance
			absolute = new Puma(absolute.createRoundedDecorator()
					.toRoundedString(decimalPlaces + 10, RoundingMode.HALF_UP));

		}

		Puma result = absolute;

		if (specifiedDenominator != null) {

			Puma specifiedDenominatorInteger = new Puma(specifiedDenominator,
					null);

			Puma minimumDifference = ONE.scale(-4 - decimalPlaces);

			Puma maximum = result;
			Puma minimum = ZERO;

			if (zeroToOne) {

				maximum = ONE;

			}

			Puma root = result;
			Puma guess = result.halve();

			boolean exact = false;

			estimate: for (int limit = 0; limit < Integer.MAX_VALUE; limit++) {

				root = result;

				Puma index = specifiedDenominatorInteger.decrement();

				while (index.notZero()) {

					root = root.divide(guess);

					index = index.decrement();

				}

				if (root.equals(guess)) {

					exact = true;

					break estimate;

				}

				// oscillate between the minimum and maximum guess and thereby
				// converge on the correct root

				if (root.greaterThan(guess)) {

					minimum = guess;

					// increase the current guess to half way between the
					// maximum and the current guess
					guess = maximum.subtract(guess).halve().add(guess);

					if (guess.equals(ONE)) {

						// if the current guess is 1 then set the guess slightly
						// higher because any root of 1 is equal to 1
						guess = new Puma("1.1");

					}

				} else {

					maximum = guess;

					// decrease the current guess to half way between the
					// minimum and the current guess
					guess = guess.subtract(minimum).halve().add(minimum);

					if (guess.equals(ONE)) {

						// if the current guess is 1 then set the guess slightly
						// lower because any root of 1 is equal to 1
						guess = new Puma("0.9");

					}

				}

				// assert that the difference between the last guess and the
				// estimated root is small enough to comply with the specified
				// scale of precision

				Puma difference = root.subtract(guess).absolute();

				if (difference.lessThan(minimumDifference)) {

					break estimate;

				}

			}

			if (exact) {

				result = root;

			} else {

				// attempt to refine the estimated root

				Puma rootFloor = new Puma(root.createRoundedDecorator()
						.toRoundedString(decimalPlaces, RoundingMode.FLOOR));

				Puma floor = rootFloor.power(specifiedDenominatorInteger,
						decimalPlaces);

				if (floor.equals(result)) {

					result = rootFloor;

				} else {

					Puma rootCeiling = new Puma(root.createRoundedDecorator()
							.toRoundedString(decimalPlaces,
									RoundingMode.CEILING));

					Puma ceiling = rootCeiling.power(
							specifiedDenominatorInteger, decimalPlaces);

					if (ceiling.equals(result)) {

						result = rootCeiling;

					} else {

						result = root;

					}

				}

			}

		}

		BigDecimal resultNumerator = result.numerator;
		BigDecimal resultDenominator = result.denominator;

		if (specifiedNumerator.compareTo(MAX_INTEGER_BIG_DECIMAL) < 0) {

			// utilise the pow operation exposed by bigdecimal in order to
			// improve performance when the exponent can be expressed as an int
			// without overflowing and therefore passed to the pow operation

			int specifiedNumeratorInt = specifiedNumerator.intValue();

			// (x/y) ^ z = (x ^ z) / (y ^ z)

			BigDecimal resultNumeratorExponent = resultNumerator
					.pow(specifiedNumeratorInt);

			BigDecimal resultDenominatorExponent = null;

			if (resultDenominator != null) {

				resultDenominatorExponent = resultDenominator
						.pow(specifiedNumeratorInt);

			}

			result = new Puma(resultNumeratorExponent,
					resultDenominatorExponent);

		} else {

			Puma specifiedNumeratorInteger = new Puma(specifiedNumerator, null);

			BigDecimal resultNumeratorExponent = resultNumerator;
			BigDecimal resultDenominatorExponent = resultDenominator;

			Puma index = specifiedNumeratorInteger.decrement();

			while (index.notZero()) {

				// (x/y) ^ z = (x ^ z) / (y ^ z)

				resultNumeratorExponent = resultNumeratorExponent
						.multiply(resultNumeratorExponent);

				if (resultDenominatorExponent != null) {

					resultDenominatorExponent = resultDenominatorExponent
							.multiply(resultDenominatorExponent);

				}

				index = index.decrement();

			}

			result = new Puma(resultNumeratorExponent,
					resultDenominatorExponent);

		}

		if (negative) {

			result = result.negate();

		}

		return result;

	}

	/**
	 * Calculates this Puma number to the root of the specified Puma number,
	 * equivalent to {@code this ^ (1/number)}, and yields a new Puma number
	 * that encapsulates the result. <br/>
	 * The result may be imprecise, due to the limitations of mechanical
	 * procedures for root calculations, but in such cases will be precise up to
	 * 10 decimal places.<br/>
	 * This operation regards the exponent operator to have higher precedence
	 * than the negation operator therefore {@code -this ^ (1/number)} is
	 * equivalent to {@code -1 * (this ^ (1/number))}.
	 * 
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	public Puma root(Puma number) {

		return root(number, 10);

	}

	/**
	 * Calculates this Puma number to the root of the specified Puma number,
	 * equivalent to {@code this ^ (1/number)}, and yields a new Puma number
	 * that encapsulates the result. <br/>
	 * The result may be imprecise, due to the limitations of mechanical
	 * procedures for root calculations, but in such cases will be precise up to
	 * the specified scale; the number of decimal places. The reader will note
	 * that a larger scale will result in a more precise result but will take
	 * longer to calculate.<br/>
	 * This operation regards the exponent operator to have higher precedence
	 * than the negation operator therefore {@code -this ^ (1/number)} is
	 * equivalent to {@code -1 * (this ^ (1/number))}.
	 * 
	 * @param number
	 *            the number.
	 * @param decimalPlaces
	 *            the number of decimal places.
	 * @return the result.
	 */
	public Puma root(Puma number, int decimalPlaces) {

		BigDecimal specifiedNumerator = number.numerator;
		BigDecimal specifiedDenominator = number.denominator;

		if (specifiedDenominator == null) {

			specifiedDenominator = ONE_BIG_DECIMAL;

		}

		Puma inverted = new Puma(specifiedDenominator, specifiedNumerator);

		return power(inverted, decimalPlaces);

	}

	/**
	 * Derives the absolute value of this Puma number and yields a new Puma
	 * number that encapsulates the result. For example 1 would yield 1 and -1
	 * would yield 1
	 * 
	 * @return the result.
	 */
	public Puma absolute() {

		BigDecimal absoluteNumerator = numerator.abs();

		Puma absolute = new Puma(absoluteNumerator, denominator);

		return absolute;

	}

	/**
	 * Negates this Puma number and yields a new Puma number that encapsulates
	 * the result. For example 1 would yield -1 and -1 would yield 1
	 * 
	 * @return the result.
	 */
	public Puma negate() {

		BigDecimal negatedNumerator = numerator.negate();

		return new Puma(negatedNumerator, denominator);

	}

	/**
	 * Calculates the modulus of this Puma number when divided by the specified
	 * Puma number, equivalent to {@code this mod number} alternatively
	 * expressed as {@code this % number}, and yields a new Puma number that
	 * encapsulates the result.<br/>
	 * This operation calculates the modulus according to the Ada 83 Language
	 * Reference Manual from the U.S. Government that specifies the behaviour of
	 * the modulus function {@code X mod Y} where X and Y may be positive or
	 * negative as follows:<br/>
	 * <br/>
	 * 
	 * <pre>
	 *  X    Y    X mod Y
	 *  
	 *  10   5    0
	 *  11   5    1
	 *  12   5    2
	 *  13   5    3
	 *  14   5    4
	 *  
	 *  10  -5    0
	 *  11  -5   -4
	 *  12  -5   -3
	 *  13  -5   -2
	 *  14  -5   -1
	 *  
	 * -10   5    0
	 * -11   5    4
	 * -12   5    3
	 * -13   5    2
	 * -14   5    1
	 * 
	 * -10  -5    0
	 * -11  -5   -1
	 * -12  -5   -2
	 * -13  -5   -3
	 * -14  -5   -4
	 * </pre>
	 * 
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	public Puma modulus(Puma number) {

		if (zero() || number.zero() || equals(number) || infinite()) {

			return ZERO;

		}

		if (number.infinite()) {

			return this;

		}

		if (number.absolute().greaterThan(absolute())) {

			return this;

		}

		Puma remainder = remainder(number);

		if (remainder.zero()) {

			return ZERO;

		}

		if (negative()) {

			if (number.negative()) {

				return remainder;

			} else {

				return number.add(remainder);

			}

		} else {

			if (number.negative()) {

				return number.add(remainder);

			} else {

				return remainder;

			}

		}

	}

	/**
	 * Calculates the remainder when this Puma number is divided by the
	 * specified Puma number, equivalent to {@code this rem number}, and yields
	 * a new Puma number that encapsulates the result.<br/>
	 * This operation calculates the remainder according to the Ada 83 Language
	 * Reference Manual from the U.S. Government that specifies the behaviour of
	 * the remainder function {@code X rem Y} where X and Y may be positive or
	 * negative as follows:<br/>
	 * <br/>
	 * 
	 * <pre>
	 *  X    Y    X rem Y
	 *  
	 *  10   5    0
	 *  11   5    1
	 *  12   5    2
	 *  13   5    3
	 *  14   5    4
	 *  
	 *  10  -5    0
	 *  11  -5    1
	 *  12  -5    2
	 *  13  -5    3
	 *  14  -5    4
	 *  
	 * -10   5    0
	 * -11   5   -1
	 * -12   5   -2
	 * -13   5   -3
	 * -14   5   -4
	 * 
	 * -10  -5    0
	 * -11  -5   -1
	 * -12  -5   -2
	 * -13  -5   -3
	 * -14  -5   -4
	 * </pre>
	 * 
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	public Puma remainder(Puma number) {

		if (zero() || number.zero() || equals(number) || infinite()) {

			return ZERO;

		}

		if (number.infinite()) {

			return this;

		}

		Puma nativeAbsolute = absolute();
		Puma specifiedAbsolute = number.absolute();

		if (specifiedAbsolute.greaterThan(nativeAbsolute)) {

			return this;

		}

		Puma divided = nativeAbsolute.divide(specifiedAbsolute);

		Puma integer = new Puma(divided.createRoundedDecorator()
				.toRoundedString(0, RoundingMode.FLOOR));

		Puma multiplied = integer.multiply(specifiedAbsolute);

		Puma remainder = nativeAbsolute.subtract(multiplied);

		if (negative()) {

			remainder = remainder.negate();

		}

		return remainder;

	}

	/**
	 * Calculates the reciprocal of this Puma number, equivalent to {@code
	 * 1/this}, and yields a new Puma number that encapsulates the result. For
	 * example the reciprocal of 2 would yield 0.5, 0.5 would yield 2, -2 would
	 * yield -0.5 and 3 would yield 1/3
	 * 
	 * @return the result.
	 */
	public Puma reciprocal() {

		if (infinite()) {

			// 1 / (1/0) = 0
			// 1 / (-1/0) = 0
			return ZERO;

		}

		BigDecimal reciprocalDenominator = denominator;

		if (reciprocalDenominator == null) {

			reciprocalDenominator = ONE_BIG_DECIMAL;

		}

		return new Puma(reciprocalDenominator, numerator);

	}

	/**
	 * Asserts that the specified Puma number is equal to this Puma number.
	 * 
	 * @param number
	 *            the number.
	 * @return true if the specified number is equal to this number, false
	 *         otherwise.
	 */
	@Override
	public boolean equals(Object number) {

		Puma specified = (Puma) number;

		Puma subtracted = subtract(specified);

		if (subtracted.zero()) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that the specified Puma number is not equal to this Puma number.
	 * 
	 * @param number
	 *            the number.
	 * @return true if the specified number does not equal this number, false
	 *         otherwise.
	 */
	public boolean notEqualTo(Puma number) {

		return !equals(number);

	}

	/**
	 * Asserts that this Puma number is greater than the specified Puma number.
	 * 
	 * @param number
	 *            the number.
	 * @return true if this number is greater than the specified number, false
	 *         otherwise.
	 */
	public boolean greaterThan(Puma number) {

		Puma subtracted = subtract(number);

		if (subtracted.positive()) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number is not greater than the specified Puma
	 * number.
	 * 
	 * @param number
	 *            the number.
	 * @return true if this number is not greater than the specified number,
	 *         false otherwise.
	 */
	public boolean notGreaterThan(Puma number) {

		return !greaterThan(number);

	}

	/**
	 * Asserts that this Puma number is greater than or equal to the specified
	 * Puma number.
	 * 
	 * @param number
	 *            the number.
	 * @return true if this number is greater than or equal to the specified
	 *         number, false otherwise.
	 */
	public boolean greaterThanOrEqualTo(Puma number) {

		Puma subtracted = subtract(number);

		if (subtracted.zeroOrPositive()) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number is not greater than or equal to the
	 * specified Puma number.
	 * 
	 * @param number
	 *            the number.
	 * @return true if this number is not greater than or equal to the specified
	 *         number, false otherwise.
	 */
	public boolean notGreaterThanOrEqualTo(Puma number) {

		return lessThan(number);

	}

	/**
	 * Asserts that this Puma number is less than the specified Puma number.
	 * 
	 * @param number
	 *            the number.
	 * @return true if this number is less than the specified number, false
	 *         otherwise.
	 */
	public boolean lessThan(Puma number) {

		Puma subtracted = subtract(number);

		if (subtracted.negative()) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number is not less than the specified Puma number.
	 * 
	 * @param number
	 *            the number.
	 * @return true if this number is not less than the specified number, false
	 *         otherwise.
	 */
	public boolean notLessThan(Puma number) {

		return !lessThan(number);

	}

	/**
	 * Asserts that this Puma number is less than or equal to the specified Puma
	 * number.
	 * 
	 * @param number
	 *            the number.
	 * @return true if this number is less than or equal to the specified
	 *         number, false otherwise.
	 */
	public boolean lessThanOrEqualTo(Puma number) {

		Puma subtracted = subtract(number);

		if (subtracted.zeroOrNegative()) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number is not less than or equal to the specified
	 * Puma number.
	 * 
	 * @param number
	 *            the number.
	 * @return true if this number is not less than or equal to the specified
	 *         number, false otherwise.
	 */
	public boolean notLessThanOrEqualTo(Puma number) {

		return greaterThan(number);

	}

	/**
	 * Asserts that this Puma number is zero.
	 * 
	 * @return true if this number is zero, false otherwise.
	 */
	public boolean zero() {

		if (numerator.compareTo(ZERO_BIG_DECIMAL) == 0) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number is not zero.
	 * 
	 * @return true if this number is not zero, false otherwise.
	 */
	public boolean notZero() {

		return !zero();

	}

	/**
	 * Asserts that this Puma number is either zero or positive.
	 * 
	 * @return true if this number is either zero or positive, false otherwise.
	 */
	public boolean zeroOrPositive() {

		if (numerator.compareTo(ZERO_BIG_DECIMAL) >= 0) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number is both positive and not zero.
	 * 
	 * @return true if this number is positive and not zero, false otherwise.
	 */
	public boolean positive() {

		if (numerator.compareTo(ZERO_BIG_DECIMAL) > 0) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number is either zero or negative.
	 * 
	 * @return true if this number is either zero or negative, false otherwise.
	 */
	public boolean zeroOrNegative() {

		if (numerator.compareTo(ZERO_BIG_DECIMAL) <= 0) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number is both negative and not zero.
	 * 
	 * @return true if this number is negative and not zero, false otherwise.
	 */
	public boolean negative() {

		if (numerator.compareTo(ZERO_BIG_DECIMAL) < 0) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number represents an integer and therefore not a
	 * floating-point number.
	 */
	public boolean integer() {

		if (denominator != null) {

			return false;

		}

		if (!(numerator.scale() > 0)) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number represents a floating-point number and
	 * therefore not an integer.
	 * 
	 * @return true if this number is a floating-point number, false otherwise.
	 */
	public boolean floatingPoint() {

		if (denominator != null) {

			return true;

		}

		if (numerator.scale() > 0) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number represents either positive infinity or
	 * negative infinity.
	 * 
	 * @return true if this number is infinite, false otherwise.
	 */
	public boolean infinite() {

		if (denominator != null && denominator.compareTo(ZERO_BIG_DECIMAL) == 0) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number is finite and therefore does not represent
	 * either positive infinity or negative infinity.
	 * 
	 * @return true if this number is finite, false otherwise.
	 */
	public boolean finite() {

		return !infinite();

	}

	/**
	 * Asserts that this Puma number represents positive infinity.
	 * 
	 * @return true if this number represents positive infinity, false
	 *         otherwise.
	 */
	public boolean positiveInfinity() {

		if (infinite() && positive()) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number represents negative infinity.
	 * 
	 * @return true if this number represents negative infinity, false
	 *         otherwise.
	 */
	public boolean negativeInfinity() {

		if (infinite() && negative()) {

			return true;

		}

		return false;

	}

	/**
	 * Asserts that this Puma number represents a value with a terminating
	 * decimal expansion; a finite number of decimal places.
	 * 
	 * @return true if this number represents a terminating value, false
	 *         otherwise.
	 */
	public boolean finiteDecimalPlaces() {

		if (denominator == null) {

			return true;

		}

		if (infinite()) {

			return false;

		}

		try {

			numerator.divide(denominator);

		} catch (ArithmeticException expected) {

			return false;

		}

		return true;

	}

	/**
	 * Asserts that this Puma number represents a value with a non-terminating
	 * decimal expansion; an infinite number of decimal places.
	 * 
	 * @return true if this number represents a non-terminating value, false
	 *         otherwise.
	 */
	public boolean infiniteDecimalPlaces() {

		return !finiteDecimalPlaces();

	}

	/**
	 * Creates a fraction Puma decorator that expresses this Puma number as the
	 * most concise fraction possible where both the numerator and denominator
	 * are integers and therefore not floating-point numbers.
	 * 
	 * @return the decorator.
	 */
	public FractionPumaDecorator createFractionDecorator() {

		return new FractionPumaDecorator(this);

	}

	/**
	 * Creates a rounded Puma decorator that rounds this Puma number according
	 * to a given scale, precision and rounding mode.
	 * 
	 * @return the decorator.
	 */
	public RoundedPumaDecorator createRoundedDecorator() {

		return new RoundedPumaDecorator(this);

	}

	/**
	 * Compares the specified Puma number with this Puma number for order.
	 * 
	 * @param number
	 *            the number.
	 * @return a negative integer, zero, or a positive integer as this number is
	 *         less than, equal to, or greater than the specified number.
	 */
	public int compareTo(Puma number) {

		Puma specified = (Puma) number;

		Puma subtracted = subtract(specified);

		if (subtracted.positive()) {

			return 1;

		}

		if (subtracted.negative()) {

			return -1;

		}

		return 0;

	}

	/**
	 * Yields a hash code that uniquely represents any Puma number with a value
	 * equal to this Puma number.
	 * 
	 * @return the hash code.
	 */
	@Override
	public int hashCode() {

		return toString().hashCode();

	}

	/**
	 * Yields a string representation of this Puma number.<br/>
	 * The representation will be precise, regardless of any infinities, and may
	 * be persisted and later used to create a Puma number in order to continue
	 * any precise calculations.
	 * 
	 * @return the representation.
	 */
	@Override
	public String toString() {

		StringBuilder representation = new StringBuilder();

		String numeratorRepresentation = rationaliseRepresentation(numerator
				.toPlainString());

		representation.append(numeratorRepresentation);

		if (denominator != null) {

			representation.append("/");

			String denominatorRepresentation = rationaliseRepresentation(denominator
					.toPlainString());

			representation.append(denominatorRepresentation);

		}

		return representation.toString();

	}

	/**
	 * Gets the big decimal that represents the numerator.
	 * 
	 * @return the numerator.
	 */
	BigDecimal getNumerator() {

		return numerator;

	}

	/**
	 * Gets the big decimal that represents the denominator.
	 * 
	 * @return the denominator.
	 */
	BigDecimal getDenominator() {

		return denominator;

	}

	/**
	 * Removes all leading zeros from the integer part and all trailing zeros
	 * from the fraction part, and any resultant trailing decimal point, from
	 * the specified representation of a number in order to rationalise the
	 * representation of the number.
	 * 
	 * @param representation
	 *            the representation.
	 * @return the rationalised representation.
	 */
	private static String rationaliseRepresentation(String representation) {

		char[] characters = representation.toCharArray();

		characters = reduceCharacterArrayCapacityAtStart(characters, '0');

		if (representation.contains(".")) {

			characters = reduceCharacterArrayCapacity(characters, '0');
			characters = reduceCharacterArrayCapacity(characters, '.');

		}

		if (characters.length == 0) {

			characters = new char[] { '0' };

		} else if (characters[0] == '.') {

			characters = joinCharacterArrays(new char[] { '0' }, characters);

		}

		return new String(characters);

	}

	/**
	 * Joins the specified arrays of characters by appending the specified
	 * second array of characters to the end of the specified first array of
	 * characters.
	 * 
	 * @param first
	 *            the first characters.
	 * @param second
	 *            the second characters.
	 * @return the joined array.
	 */
	private static char[] joinCharacterArrays(char[] first, char[] second) {

		int firstLength = first.length;
		int secondLength = second.length;

		char[] joined = new char[firstLength + secondLength];

		for (int index = 0; index < firstLength; index++) {

			joined[index] = first[index];

		}

		for (int secondIndex = 0, joinedIndex = firstLength; secondIndex < secondLength; secondIndex++, joinedIndex++) {

			joined[joinedIndex] = second[secondIndex];

		}

		return joined;

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