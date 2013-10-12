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

import java.math.BigDecimal;

import com.zavazoo.puma.Puma;
import com.zavazoo.puma.util.TestAddDelegate;
import com.zavazoo.puma.util.TestMultiplyDelegate;
import com.zavazoo.puma.util.TestSubtractDelegate;

import junit.framework.TestCase;

/**
 * Tests operations on Puma numbers which are very large.<br/>
 * The operations exposed by this class mimic their counterpart operations
 * exposed by the Puma number class, using alternative algorithms which are
 * slower but guarantee accuracy, in order to ensure the voracity of any
 * resultant test data.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
abstract class AbstractLargePumaTest extends TestCase {

	/**
	 * Tests a particular operation on Puma numbers which are very large.
	 */
	abstract public void testLarge();

	/**
	 * Adds the specified Puma number to the specified native Puma number,
	 * equivalent to {@code native + number} using an alternative algorithm that
	 * is slower but guarantees accuracy, and yields a new Puma number that
	 * encapsulates the result.
	 * 
	 * @param nativ
	 *            the native number.
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	protected Puma add(Puma nativ, Puma number) {

		// native is misspelled to avoid clash with native keyword

		if (nativ.infinite() && number.infinite()) {

			boolean nativePositive = nativ.positive();
			boolean specifiedPositive = number.positive();

			if (nativePositive && specifiedPositive) {

				return new Puma(Puma.ONE_BIG_DECIMAL, Puma.ZERO_BIG_DECIMAL);

			} else if (!nativePositive && !specifiedPositive) {

				return new Puma(Puma.MINUS_ONE_BIG_DECIMAL,
						Puma.ZERO_BIG_DECIMAL);

			} else {

				return new Puma(Puma.ZERO_BIG_DECIMAL, null);

			}

		}

		BigDecimal nativeNumerator = nativ.getNumerator();
		BigDecimal nativeDenominator = nativ.getDenominator();

		BigDecimal specifiedNumerator = number.getNumerator();
		BigDecimal specifiedDenominator = number.getDenominator();

		if (nativeDenominator == null) {

			if (specifiedDenominator == null) {

				// x/1 + y/1 = ((x * 1) / (1 * 1)) + ((1 * y) / (1 * 1)) =
				// ((x * 1) + (1 * y)) / 1 = (x + y) / 1 = x + y

				Puma addedNumerators = TestAddDelegate.add(new Puma(
						nativeNumerator, null), new Puma(specifiedNumerator,
						null));

				return new Puma(addedNumerators.getNumerator(), null);

			} else {

				// x/1 + y/z = ((x * z) / (1 * z)) + ((1 * y) / (1 * z)) =
				// ((x * z) / z)) + y/z = ((x * z) + y) / z

				Puma nativeMultipliedNumerator = TestMultiplyDelegate.multiply(
						new Puma(nativeNumerator, null), new Puma(
								specifiedDenominator, null));

				Puma addedNumerators = TestAddDelegate.add(new Puma(
						nativeMultipliedNumerator.getNumerator(), null),
						new Puma(specifiedNumerator, null));

				return new Puma(addedNumerators.getNumerator(),
						specifiedDenominator);

			}

		} else {

			if (specifiedDenominator == null) {

				// x/z + y/1 = ((x * 1) / (z * 1)) + ((y * z) / (z * 1)) =
				// x/z + ((y * z) / z) = (x + (y * z)) / z

				Puma specifiedMultipliedNumerator = TestMultiplyDelegate
						.multiply(new Puma(nativeDenominator, null), new Puma(
								specifiedNumerator, null));

				Puma addedNumerators = TestAddDelegate.add(new Puma(
						nativeNumerator, null), new Puma(
						specifiedMultipliedNumerator.getNumerator(), null));

				return new Puma(addedNumerators.getNumerator(),
						nativeDenominator);

			} else {

				// a/b + x/y = ((a * y) / (b * y)) + ((x * b) / (y * b)) =
				// ((a * y) + (x * b)) / (b * y)

				Puma nativeMultipliedNumerator = TestMultiplyDelegate.multiply(
						new Puma(nativeNumerator, null), new Puma(
								specifiedDenominator, null));

				Puma specifiedMultipliedNumerator = TestMultiplyDelegate
						.multiply(new Puma(nativeDenominator, null), new Puma(
								specifiedNumerator, null));

				Puma addedNumerators = TestAddDelegate.add(new Puma(
						nativeMultipliedNumerator.getNumerator(), null),
						new Puma(specifiedMultipliedNumerator.getNumerator(),
								null));

				Puma multipliedDenominators = TestMultiplyDelegate.multiply(
						new Puma(nativeDenominator, null), new Puma(
								specifiedDenominator, null));

				return new Puma(addedNumerators.getNumerator(),
						multipliedDenominators.getNumerator());

			}

		}

	}

	/**
	 * Subtracts the specified Puma number from the specified native Puma
	 * number, equivalent to {@code native - number} using an alternative
	 * algorithm that is slower but guarantees accuracy, and yields a new Puma
	 * number that encapsulates the result.
	 * 
	 * @param nativ
	 *            the native number.
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	protected Puma subtract(Puma nativ, Puma number) {

		// native is misspelled to avoid clash with native keyword

		if (nativ.infinite() && number.infinite()) {

			boolean nativePositive = nativ.positive();
			boolean specifiedPositive = number.positive();

			if (nativePositive && !specifiedPositive) {

				return new Puma(Puma.ONE_BIG_DECIMAL, Puma.ZERO_BIG_DECIMAL);

			} else if (!nativePositive && specifiedPositive) {

				return new Puma(Puma.MINUS_ONE_BIG_DECIMAL,
						Puma.ZERO_BIG_DECIMAL);

			}

		}

		BigDecimal nativeNumerator = nativ.getNumerator();
		BigDecimal nativeDenominator = nativ.getDenominator();

		BigDecimal specifiedNumerator = number.getNumerator();
		BigDecimal specifiedDenominator = number.getDenominator();

		if (nativeDenominator == null) {

			if (specifiedDenominator == null) {

				// x/1 - y/1 = ((x * 1) / (1 * 1)) - ((1 * y) / (1 * 1)) =
				// ((x * 1) - (1 * y)) / 1 = (x - y) / 1 = x - y

				Puma subtractedNumerators = TestSubtractDelegate.subtract(
						new Puma(nativeNumerator, null), new Puma(
								specifiedNumerator, null));

				return new Puma(subtractedNumerators.getNumerator(), null);

			} else {

				// x/1 - y/z = ((x * z) / (1 * z)) - ((1 * y) / (1 * z)) =
				// ((x * z) / z)) - y/z = ((x * z) - y) / z

				Puma nativeMultipliedNumerator = TestMultiplyDelegate.multiply(
						new Puma(nativeNumerator, null), new Puma(
								specifiedDenominator, null));

				Puma subtractedNumerators = TestSubtractDelegate
						.subtract(new Puma(nativeMultipliedNumerator
								.getNumerator(), null), new Puma(
								specifiedNumerator, null));

				return new Puma(subtractedNumerators.getNumerator(),
						specifiedDenominator);

			}

		} else {

			if (specifiedDenominator == null) {

				// x/z - y/1 = ((x * 1) / (z * 1)) - ((y * z) / (z * 1)) =
				// x/z - ((y * z) / z) = (x - (y * z)) / z

				Puma specifiedMultipliedNumerator = TestMultiplyDelegate
						.multiply(new Puma(nativeDenominator, null), new Puma(
								specifiedNumerator, null));

				Puma subtractedNumerators = TestSubtractDelegate.subtract(
						new Puma(nativeNumerator, null), new Puma(
								specifiedMultipliedNumerator.getNumerator(),
								null));

				return new Puma(subtractedNumerators.getNumerator(),
						nativeDenominator);

			} else {

				// a/b - x/y = ((a * y) / (b * y)) - ((x * b) / (y * b)) =
				// ((a * y) - (x * b)) / (b * y)

				Puma nativeMultipliedNumerator = TestMultiplyDelegate.multiply(
						new Puma(nativeNumerator, null), new Puma(
								specifiedDenominator, null));

				Puma specifiedMultipliedNumerator = TestMultiplyDelegate
						.multiply(new Puma(nativeDenominator, null), new Puma(
								specifiedNumerator, null));

				Puma subtractedNumerators = TestSubtractDelegate
						.subtract(new Puma(nativeMultipliedNumerator
								.getNumerator(), null), new Puma(
								specifiedMultipliedNumerator.getNumerator(),
								null));

				Puma multipliedDenominators = TestMultiplyDelegate.multiply(
						new Puma(nativeDenominator, null), new Puma(
								specifiedDenominator, null));

				return new Puma(subtractedNumerators.getNumerator(),
						multipliedDenominators.getNumerator());

			}

		}

	}

	/**
	 * Multiplies the specified Puma number by the specified native Puma number,
	 * equivalent to {@code native * number} using an alternative algorithm that
	 * is slower but guarantees accuracy, and yields a new Puma number that
	 * encapsulates the result.
	 * 
	 * @param nativ
	 *            the native number.
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	protected Puma multiply(Puma nativ, Puma number) {

		// native is misspelled to avoid clash with native keyword

		BigDecimal nativeNumerator = nativ.getNumerator();
		BigDecimal nativeDenominator = nativ.getDenominator();

		BigDecimal specifiedNumerator = number.getNumerator();
		BigDecimal specifiedDenominator = number.getDenominator();

		if (nativeDenominator == null) {

			if (specifiedDenominator == null) {

				// x/1 * y/1 = (x * y) / (1 * 1) = (x * y) / 1 = x * y

				Puma multipliedNumerators = TestMultiplyDelegate.multiply(
						new Puma(nativeNumerator, null), new Puma(
								specifiedNumerator, null));

				return new Puma(multipliedNumerators.getNumerator(), null);

			} else {

				// x/1 * y/z = (x * y) / (1 * z) = (x * y) / z

				Puma multipliedNumerators = TestMultiplyDelegate.multiply(
						new Puma(nativeNumerator, null), new Puma(
								specifiedNumerator, null));

				return new Puma(multipliedNumerators.getNumerator(),
						specifiedDenominator);

			}

		} else {

			if (specifiedDenominator == null) {

				// x/z * y/1 = (x * y) / (z * 1) = (x * y) / z

				Puma multipliedNumerators = TestMultiplyDelegate.multiply(
						new Puma(nativeNumerator, null), new Puma(
								specifiedNumerator, null));

				return new Puma(multipliedNumerators.getNumerator(),
						nativeDenominator);

			} else {

				// a/b * x/y = (a * x) / (b * y)

				Puma multipliedNumerators = TestMultiplyDelegate.multiply(
						new Puma(nativeNumerator, null), new Puma(
								specifiedNumerator, null));

				Puma multipliedDenominators = TestMultiplyDelegate.multiply(
						new Puma(nativeDenominator, null), new Puma(
								specifiedDenominator, null));

				return new Puma(multipliedNumerators.getNumerator(),
						multipliedDenominators.getNumerator());

			}

		}

	}

	/**
	 * Divides the specified Puma number into the specified native Puma number,
	 * equivalent to {@code native / number} using an alternative algorithm that
	 * is slower but guarantees accuracy, and yields a new Puma number that
	 * encapsulates the result.
	 * 
	 * @param nativ
	 *            the native number.
	 * @param number
	 *            the number.
	 * @return the result.
	 */
	protected Puma divide(Puma nativ, Puma number) {

		// native is misspelled to avoid clash with native keyword

		boolean nativeInfinite = nativ.infinite();
		boolean specifiedInfinite = number.infinite();

		if (nativeInfinite && specifiedInfinite) {

			boolean nativePositive = nativ.positive();
			boolean specifiedPositive = number.positive();

			if ((nativePositive && specifiedPositive)
					|| (!nativePositive && !specifiedPositive)) {

				return new Puma(Puma.ONE_BIG_DECIMAL, null);

			} else {

				return new Puma(Puma.MINUS_ONE_BIG_DECIMAL, null);

			}

		}

		if (nativeInfinite && !specifiedInfinite && number.negative()) {

			boolean nativePositive = nativ.positive();

			if (nativePositive) {

				return new Puma(Puma.MINUS_ONE_BIG_DECIMAL,
						Puma.ZERO_BIG_DECIMAL);

			} else {

				return new Puma(Puma.ONE_BIG_DECIMAL, Puma.ZERO_BIG_DECIMAL);

			}

		}

		BigDecimal nativeNumerator = nativ.getNumerator();
		BigDecimal nativeDenominator = nativ.getDenominator();

		BigDecimal specifiedNumerator = number.getNumerator();
		BigDecimal specifiedDenominator = number.getDenominator();

		if (nativeDenominator == null) {

			if (specifiedDenominator == null) {

				// x/1 / y/1 = x/1 * 1/y = (x * 1) / (1 * y) = x / y

				return new Puma(nativeNumerator, specifiedNumerator);

			} else {

				// x/1 / y/z = x/1 * z/y = (x * z) / (1 * y) = (x * z) / y

				Puma nativeMultipliedNumerator = TestMultiplyDelegate.multiply(
						new Puma(nativeNumerator, null), new Puma(
								specifiedDenominator, null));

				return new Puma(nativeMultipliedNumerator.getNumerator(),
						specifiedNumerator);

			}

		} else {

			if (specifiedDenominator == null) {

				// x/z / y/1 = x/z * 1/y = (x * 1) / (z * y) = x / (z * y)

				Puma nativeMultipliedDenominator = TestMultiplyDelegate
						.multiply(new Puma(nativeDenominator, null), new Puma(
								specifiedNumerator, null));

				return new Puma(nativeNumerator, nativeMultipliedDenominator
						.getNumerator());

			} else {

				// a/b / x/y = a/b * y/x = (a * y) / (b * x)

				Puma nativeMultipliedNumerator = TestMultiplyDelegate.multiply(
						new Puma(nativeNumerator, null), new Puma(
								specifiedDenominator, null));

				Puma nativeMultipliedDenominator = TestMultiplyDelegate
						.multiply(new Puma(nativeDenominator, null), new Puma(
								specifiedNumerator, null));

				return new Puma(nativeMultipliedNumerator.getNumerator(),
						nativeMultipliedDenominator.getNumerator());

			}

		}

	}

}