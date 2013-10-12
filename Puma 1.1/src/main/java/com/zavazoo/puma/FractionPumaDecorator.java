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

/**
 * Decorates a Puma number as the most concise fraction possible where both the
 * numerator and denominator are integers and therefore not floating-point
 * numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 * @see com.zavazoo.puma.Puma#createFractionDecorator()
 */
public class FractionPumaDecorator {

	/** The decorated Puma number. */
	private Puma number;

	/**
	 * Creates a fraction Puma decorator for the specified Puma number.
	 * 
	 * @param number
	 *            the number.
	 */
	FractionPumaDecorator(Puma number) {

		this.number = number;

	}

	/**
	 * Yields a Puma number equivalent to this decorated Puma number expressed
	 * as the most concise fraction possible where both the numerator and
	 * denominator are integers and therefore not floating-point numbers.
	 * 
	 * @return the fraction number.
	 */
	public Puma toFractionPuma() {

		if (number.zero()) {

			return new Puma("0", "1");

		}

		if (number.integer()) {

			String numeratorRepresentation = number.getNumerator()
					.toPlainString();

			return new Puma(numeratorRepresentation, "1");

		}

		if (number.equals(Puma.ONE)) {

			return new Puma("1", "1");

		}

		if (number.equals(Puma.MINUS_ONE)) {

			return new Puma("-1", "1");

		}

		if (number.positiveInfinity()) {

			return new Puma("1", "0");

		}

		if (number.negativeInfinity()) {

			return new Puma("-1", "0");

		}

		Puma absolute = null;
		boolean negative = false;

		if (number.negative()) {

			absolute = number.absolute();
			negative = true;

		} else {

			absolute = number;

		}

		BigDecimal absoluteNumerator = absolute.getNumerator();
		BigDecimal absoluteDenominator = absolute.getDenominator();

		if (absoluteDenominator == null) {

			absoluteDenominator = Puma.ONE_BIG_DECIMAL;

		}

		int numeratorScale = absoluteNumerator.scale();
		int denominatorScale = absoluteDenominator.scale();

		if (numeratorScale > 0 || denominatorScale > 0) {

			int maximumScale = numeratorScale;

			if (denominatorScale > numeratorScale) {

				maximumScale = denominatorScale;

			}

			// x/y = (x * (10 ^ z)) / (y * (10 ^ z))
			absoluteNumerator = absoluteNumerator
					.scaleByPowerOfTen(maximumScale);
			absoluteDenominator = absoluteDenominator
					.scaleByPowerOfTen(maximumScale);

		}

		BigDecimal absoluteLowest = absoluteNumerator;
		BigDecimal absoluteHighest = absoluteDenominator;

		boolean reciprocal = false;

		if (absoluteNumerator.compareTo(absoluteDenominator) > 0) {

			absoluteLowest = absoluteDenominator;
			absoluteHighest = absoluteNumerator;

			reciprocal = true;

		}

		// x/y = b/a where (x * a) / (y * b) = 1

		BigDecimal lowestMultiplied = absoluteLowest;
		BigDecimal lowestMultiplications = Puma.ONE_BIG_DECIMAL;

		BigDecimal highestMultiplied = absoluteHighest;
		BigDecimal highestMultiplications = Puma.ONE_BIG_DECIMAL;

		reduce: while (lowestMultiplied.compareTo(highestMultiplied) != 0) {

			lowestMultiplied = lowestMultiplied.add(absoluteLowest);
			lowestMultiplications = lowestMultiplications
					.add(Puma.ONE_BIG_DECIMAL);

			if (lowestMultiplied.compareTo(highestMultiplied) == 0) {

				break reduce;

			}

			if (lowestMultiplied.compareTo(highestMultiplied) > 0) {

				highestMultiplied = highestMultiplied.add(absoluteHighest);
				highestMultiplications = highestMultiplications
						.add(Puma.ONE_BIG_DECIMAL);

			}

		}

		BigDecimal reducedNumerator = null;
		BigDecimal reducedDenominator = null;

		if (reciprocal) {

			reducedNumerator = lowestMultiplications;
			reducedDenominator = highestMultiplications;

		} else {

			reducedNumerator = highestMultiplications;
			reducedDenominator = lowestMultiplications;

		}

		if (negative) {

			reducedNumerator = reducedNumerator.negate();

		}

		String numeratorRepresentation = reducedNumerator.toPlainString();
		String denominatorRepresentation = reducedDenominator.toPlainString();

		return new Puma(numeratorRepresentation, denominatorRepresentation);

	}

	/**
	 * Yields a string representation of this decorated Puma number expressed as
	 * the most concise fraction possible where both the numerator and
	 * denominator are integers and not floating-point numbers.<br/>
	 * The representation will be precise, regardless of any infinities, and may
	 * be persisted and later used to create a Puma number in order to continue
	 * any precise calculations.
	 * 
	 * @return the representation.
	 */
	public String toFractionString() {

		return toFractionPuma().toString();

	}

	/**
	 * Yields a string representation of this decorated Puma number.<br/>
	 * The representation will be precise, regardless of any infinities, and may
	 * be persisted and later used to create a Puma number in order to continue
	 * any precise calculations.
	 * 
	 * @return the representation.
	 */
	@Override
	public String toString() {

		return number.toString();

	}

}