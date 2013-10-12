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

import java.math.MathContext;
import java.math.RoundingMode;

import com.zavazoo.puma.NegativeInfinityException;
import com.zavazoo.puma.PositiveInfinityException;
import com.zavazoo.puma.Puma;

import junit.framework.TestCase;

/**
 * Tests the representation of Puma numbers using a rounded Puma decorator.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class RoundedPumaDecoratorTest extends TestCase {

	/**
	 * Tests the representation of Puma numbers rounded according to a given
	 * scale, precision and rounding mode.
	 */
	public void testRoundedString() {

		try {

			MathContext context = new MathContext(5, RoundingMode.CEILING);

			assertEquals("0", new Puma("0").createRoundedDecorator()
					.toRoundedString(context));

			String positiveInfinity = null;

			try {

				positiveInfinity = new Puma("1/0").createRoundedDecorator()
						.toRoundedString(context);

			} catch (PositiveInfinityException expected) {

				assertNull(positiveInfinity);

			}

			String negativeInfinity = null;

			try {

				negativeInfinity = new Puma("-1/0").createRoundedDecorator()
						.toRoundedString(context);

			} catch (NegativeInfinityException expected) {

				assertNull(negativeInfinity);

			}

			assertEquals("1", new Puma("1").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("-1", new Puma("-1").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("0", new Puma("0").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("0", new Puma("0.0").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("0", new Puma("-0").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("0", new Puma("-0.0").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("0", new Puma("000000").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("0", new Puma("00000.00000").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("12.34", new Puma("12.34").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("-12.34", new Puma("-12.34").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("12.34", new Puma("00012.340000")
					.createRoundedDecorator().toRoundedString(context));

			assertEquals("-12.34", new Puma("-00012.34000")
					.createRoundedDecorator().toRoundedString(context));

			assertEquals("12.346", new Puma("00012.345670")
					.createRoundedDecorator().toRoundedString(context));

			assertEquals("-12.345", new Puma("-00012.34567000")
					.createRoundedDecorator().toRoundedString(context));

			assertEquals("0.33334", new Puma("1/3").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("0.33334", new Puma("2/6").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("0.5", new Puma("2/4").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("-0.33333", new Puma("1/-3").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("-0.33333", new Puma("-2/6").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("0.5", new Puma("-2/-4").createRoundedDecorator()
					.toRoundedString(context));

			assertEquals("5000000000", new Puma("000020000000000/00004")
					.createRoundedDecorator().toRoundedString(context));

			assertEquals("5000000000", new Puma("00005000000000")
					.createRoundedDecorator().toRoundedString(context));

			assertEquals("0.00000000005", new Puma("00002/40000000000")
					.createRoundedDecorator().toRoundedString(context));

			int decimalPlaces = 5;
			RoundingMode mode = RoundingMode.HALF_UP;

			assertEquals("0", new Puma("0").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			positiveInfinity = null;

			try {

				positiveInfinity = new Puma("1/0").createRoundedDecorator()
						.toRoundedString(decimalPlaces, mode);

			} catch (PositiveInfinityException expected) {

				assertNull(positiveInfinity);

			}

			negativeInfinity = null;

			try {

				negativeInfinity = new Puma("-1/0").createRoundedDecorator()
						.toRoundedString(decimalPlaces, mode);

			} catch (NegativeInfinityException expected) {

				assertNull(negativeInfinity);

			}

			assertEquals("1", new Puma("1").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("-1", new Puma("-1").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("0", new Puma("0").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("0", new Puma("0.0").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("0", new Puma("-0").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("0", new Puma("-0.0").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("0", new Puma("000000").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("0", new Puma("00000.00000").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("12.34", new Puma("12.34").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("-12.34", new Puma("-12.34").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("12.34", new Puma("00012.340000")
					.createRoundedDecorator().toRoundedString(decimalPlaces,
							mode));

			assertEquals("-12.34", new Puma("-00012.34000")
					.createRoundedDecorator().toRoundedString(decimalPlaces,
							mode));

			assertEquals("12.34568", new Puma("00012.3456789")
					.createRoundedDecorator().toRoundedString(decimalPlaces,
							mode));

			assertEquals("-12.34568", new Puma("-00012.345678900")
					.createRoundedDecorator().toRoundedString(decimalPlaces,
							mode));

			assertEquals("0.33333", new Puma("1/3").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("0.33333", new Puma("2/6").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("0.5", new Puma("2/4").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("-0.33333", new Puma("1/-3").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("-0.33333", new Puma("-2/6").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("0.5", new Puma("-2/-4").createRoundedDecorator()
					.toRoundedString(decimalPlaces, mode));

			assertEquals("5000000000", new Puma("000020000000000/00004")
					.createRoundedDecorator().toRoundedString(decimalPlaces,
							mode));

			assertEquals("5000000000", new Puma("00005000000000")
					.createRoundedDecorator().toRoundedString(decimalPlaces,
							mode));

			assertEquals("0", new Puma("00002/40000000000")
					.createRoundedDecorator().toRoundedString(decimalPlaces,
							mode));

		} catch (Exception error) {

			error.printStackTrace();

		}

	}

}