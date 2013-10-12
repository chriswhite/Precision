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

import com.zavazoo.puma.PumaExpression;

/**
 * Tests the multiply operation on Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class MultiplyPumaTest extends AbstractPumaTest {

	/**
	 * Tests the multiply operation on positive or negative integers.
	 */
	public void testInteger() {

		try {

			assertEquals("8", new PumaExpression("4 * 2").evaluate().toString());

			assertEquals("-20", new PumaExpression("-4 * 5").evaluate()
					.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the multiply operation on positive or negative floating-point
	 * numbers.
	 */
	public void testFloatingPoint() {

		try {

			assertEquals("-137104.5277248", new PumaExpression(
					"-449.376 * 305.0998").evaluate().toString());

			assertEquals("0.6666666666666666", new PumaExpression(
					"0.3333333333333333 * 2").evaluate().toString());

			assertEquals("95338045.524039291", new PumaExpression(
					"28630043.7009127 * 3.33").evaluate().toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the multiply operation on quotients with a numerator and
	 * denominator which may be positive or negative, integer or floating-point
	 * numbers.
	 */
	public void testQuotient() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the multiply operation on positive or negative numbers equivalent
	 * to exactly zero or one.
	 */
	public void testZeroOne() {

		try {

			assertEquals("0", new PumaExpression("4 * 0").evaluate().toString());

			assertEquals("0", new PumaExpression("-4 * 0").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("0 * 5").evaluate().toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the multiply operation on positive or negative non-terminating
	 * floating-point numbers with an infinite number of decimal places.
	 */
	public void testNonTerminating() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the multiply operation on positive or negative infinity.
	 */
	public void testInfinite() {

		try {

			assertEquals("0", new PumaExpression("(1/0) * 0").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("(1/0) * -0").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("(-1/0) * 0").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("(-1/0) * -0").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("0 * (1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("0 * (-1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-0 * (1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-0 * (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) * (1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(1/0) * (-1/0)")
					.evaluate().toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) * (1/0)")
					.evaluate().toString());

			assertEquals("1/0", new PumaExpression("(-1/0) * (-1/0)")
					.evaluate().toString());

			assertEquals("1/0", new PumaExpression("2 * (1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("2 * (-1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("-2 * (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("-2 * (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) * 2").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(1/0) * -2").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) * 2").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(-1/0) * -2").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("2.3 * (1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("2.3 * (-1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("-2.3 * (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("-2.3 * (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) * 2.3").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(1/0) * -2.3").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) * 2.3").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(-1/0) * -2.3").evaluate()
					.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

}