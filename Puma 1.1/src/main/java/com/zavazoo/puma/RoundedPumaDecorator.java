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
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Decorates a Puma number by rounding according to a given scale, precision and
 * rounding mode.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 * @see com.zavazoo.puma.Puma#createRoundedDecorator()
 */
public class RoundedPumaDecorator {

	/** The decorated Puma number. */
	private Puma number;

	/**
	 * Creates a rounded Puma decorator for the specified Puma number.
	 * 
	 * @param number
	 *            the number.
	 */
	RoundedPumaDecorator(Puma number) {

		this.number = number;

	}

	/**
	 * Yields a Puma number equivalent to this decorated Puma number rounded to
	 * 10 decimal places using the half-up rounding mode.<br/>
	 * The half-up rounding mode is documented in the JDK as follows: rounding
	 * mode to round towards "nearest neighbor" unless both neighbors are
	 * equidistant, in which case round up. Behaves as for RoundingMode.UP if
	 * the discarded fraction is >= 0.5; otherwise, behaves as for
	 * RoundingMode.DOWN. Note that this is the rounding mode commonly taught at
	 * school.
	 * 
	 * @return the rounded number.
	 * @exception PositiveInfinityException
	 *                if this decorated number represents positive infinity.
	 * @exception NegativeInfinityException
	 *                if this decorated number represents negative infinity.
	 * @see java.math.RoundingMode#HALF_UP
	 */
	public Puma toRoundedPuma() throws PositiveInfinityException,
			NegativeInfinityException {

		return toRoundedPuma(10, RoundingMode.HALF_UP);

	}

	/**
	 * Yields a string representation of this decorated Puma number rounded to
	 * 10 decimal places using the half-up rounding mode.<br/>
	 * The representation may therefore be imprecise but may be persisted and
	 * later used to create a Puma number in order to continue any further
	 * imprecise calculations.<br/>
	 * The half-up rounding mode is documented in the JDK as follows: rounding
	 * mode to round towards "nearest neighbor" unless both neighbors are
	 * equidistant, in which case round up. Behaves as for RoundingMode.UP if
	 * the discarded fraction is >= 0.5; otherwise, behaves as for
	 * RoundingMode.DOWN. Note that this is the rounding mode commonly taught at
	 * school.
	 * 
	 * @return the representation.
	 * @exception PositiveInfinityException
	 *                if this decorated number represents positive infinity.
	 * @exception NegativeInfinityException
	 *                if this decorated number represents negative infinity.
	 * @see java.math.RoundingMode#HALF_UP
	 */
	public String toRoundedString() throws PositiveInfinityException,
			NegativeInfinityException {

		return toRoundedString(10, RoundingMode.HALF_UP);

	}

	/**
	 * Yields a Puma number equivalent to this decorated Puma number rounded
	 * according to the specified context settings.<br/>
	 * Callers are advised not to use the UNNECESSARY rounding mode in order to
	 * avoid a potential unchecked ArithmeticException if rounding is deemed to
	 * be necessary.
	 * 
	 * @param context
	 *            the context settings.
	 * @return the rounded number.
	 * @exception PositiveInfinityException
	 *                if this decorated number represents positive infinity.
	 * @exception NegativeInfinityException
	 *                if this decorated number represents negative infinity.
	 */
	public Puma toRoundedPuma(MathContext context)
			throws PositiveInfinityException, NegativeInfinityException {

		if (number.positiveInfinity()) {

			throw new PositiveInfinityException(number);

		}

		if (number.negativeInfinity()) {

			throw new NegativeInfinityException(number);

		}

		BigDecimal rounded = null;

		if (number.getDenominator() == null) {

			rounded = number.getNumerator().divide(Puma.ONE_BIG_DECIMAL,
					context);

		} else {

			rounded = number.getNumerator().divide(number.getDenominator(),
					context);

		}

		String roundedRepresentation = rounded.toPlainString();

		return new Puma(roundedRepresentation, null);

	}

	/**
	 * Yields a string representation of this decorated Puma number rounded
	 * according to the specified context settings.<br/>
	 * The representation may therefore be imprecise but may be persisted and
	 * later used to create a Puma number in order to continue any further
	 * imprecise calculations.<br/>
	 * Callers are advised not to use the UNNECESSARY rounding mode in order to
	 * avoid a potential unchecked ArithmeticException if rounding is deemed to
	 * be necessary.
	 * 
	 * @param context
	 *            the context settings.
	 * @return the representation.
	 * @exception PositiveInfinityException
	 *                if this decorated number represents positive infinity.
	 * @exception NegativeInfinityException
	 *                if this decorated number represents negative infinity.
	 */
	public String toRoundedString(MathContext context)
			throws PositiveInfinityException, NegativeInfinityException {

		return toRoundedPuma(context).toString();

	}

	/**
	 * Yields a Puma number equivalent to this decorated Puma number rounded
	 * according to the specified scale; the number of decimal places, and the
	 * specified rounding mode.<br/>
	 * Callers are advised not to use the UNNECESSARY rounding mode in order to
	 * avoid a potential unchecked ArithmeticException if rounding is deemed to
	 * be necessary.
	 * 
	 * @param decimalPlaces
	 *            the number of decimal places.
	 * @param mode
	 *            the rounding mode.
	 * @return the rounded number.
	 * @exception PositiveInfinityException
	 *                if this decorated number represents positive infinity.
	 * @exception NegativeInfinityException
	 *                if this decorated number represents negative infinity.
	 */
	public Puma toRoundedPuma(int decimalPlaces, RoundingMode mode)
			throws PositiveInfinityException, NegativeInfinityException {

		if (number.positiveInfinity()) {

			throw new PositiveInfinityException(number);

		}

		if (number.negativeInfinity()) {

			throw new NegativeInfinityException(number);

		}

		BigDecimal rounded = null;

		if (number.getDenominator() == null) {

			rounded = number.getNumerator().divide(Puma.ONE_BIG_DECIMAL,
					decimalPlaces, mode);

		} else {

			rounded = number.getNumerator().divide(number.getDenominator(),
					decimalPlaces, mode);

		}

		String roundedRepresentation = rounded.toPlainString();

		return new Puma(roundedRepresentation, null);

	}

	/**
	 * Yields a string representation of this decorated Puma number rounded
	 * according to the specified scale; the number of decimal places, and the
	 * specified rounding mode.<br/>
	 * The representation may therefore be imprecise but may be persisted and
	 * later used to create a Puma number in order to continue any further
	 * imprecise calculations.<br/>
	 * Callers are advised not to use the UNNECESSARY rounding mode in order to
	 * avoid a potential unchecked ArithmeticException if rounding is deemed to
	 * be necessary.
	 * 
	 * @param decimalPlaces
	 *            the number of decimal places.
	 * @param mode
	 *            the rounding mode.
	 * @return the representation.
	 * @exception PositiveInfinityException
	 *                if this decorated number represents positive infinity.
	 * @exception NegativeInfinityException
	 *                if this decorated number represents negative infinity.
	 */
	public String toRoundedString(int decimalPlaces, RoundingMode mode)
			throws PositiveInfinityException, NegativeInfinityException {

		return toRoundedPuma(decimalPlaces, mode).toString();

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