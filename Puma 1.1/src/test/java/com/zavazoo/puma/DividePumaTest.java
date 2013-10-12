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
 * Tests the divide operation on Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class DividePumaTest extends AbstractPumaTest {

	/**
	 * Tests the divide operation on positive or negative integers.
	 */
	public void testInteger() {

		try {

			assertEquals("2", new PumaExpression("4 / 2").evaluate().toString());

			assertEquals("0.8", new PumaExpression("-4 / -5").evaluate()
					.toString());

			assertEquals("-0.8", new PumaExpression("4 / -5").evaluate()
					.toString());

			assertEquals("-0.8", new PumaExpression("-4 / 5").evaluate()
					.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the divide operation on positive or negative floating-point
	 * numbers.
	 */
	public void testFloatingPoint() {

		try {

			assertEquals("1/3", new PumaExpression("0.1 / 0.3").evaluate()
					.toString());

			assertEquals("1/300", new PumaExpression("0.001 / 0.3").evaluate()
					.toString());

			assertEquals("3762/32983", new PumaExpression("0.3762 / 3.2983")
					.evaluate().toString());

			assertEquals("0.0862", new PumaExpression("0.24846288 / 2.8824")
					.evaluate().toString());

			assertEquals("8726.3263", new PumaExpression(
					"29442002.74913481 / 3373.9287").evaluate().toString());

			assertEquals("-8726.3263", new PumaExpression(
					"-29442002.74913481 / 3373.9287").evaluate().toString());

			assertEquals("-8726.3263", new PumaExpression(
					"29442002.74913481 / -3373.9287").evaluate().toString());

			assertEquals("8726.3263", new PumaExpression(
					"-29442002.74913481 / -3373.9287").evaluate().toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the divide operation on quotients with a numerator and denominator
	 * which may be positive or negative, integer or floating-point numbers.
	 */
	public void testQuotient() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the divide operation on positive or negative numbers equivalent to
	 * exactly zero or one.
	 */
	public void testZeroOne() {

		try {

			assertEquals("0", new PumaExpression("0 / 3").evaluate().toString());

			assertEquals("0", new PumaExpression("-0 / 3").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("0 / 0").evaluate().toString());

			assertEquals("0", new PumaExpression("-0 / 0").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-0 / -0").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("0 / -0").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("0.234 / -0").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("-1.234 / 0").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("-1.234 / -0").evaluate()
					.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the divide operation on positive or negative non-terminating
	 * floating-point numbers with an infinite number of decimal places.
	 */
	public void testNonTerminating() {

		try {

			assertEquals("1/3", new PumaExpression("1 / 3").evaluate()
					.toString());

			assertEquals("1/3", new PumaExpression("2 / 6").evaluate()
					.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the divide operation on positive or negative infinity.
	 */
	public void testInfinite() {

		try {

			assertEquals("1/0", new PumaExpression("(1/0) / 0").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) / -0").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) / 0").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) / -0").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("0 / (1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("0 / (-1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-0 / (1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-0 / (-1/0)").evaluate()
					.toString());

			assertEquals("1", new PumaExpression("(1/0) / (1/0)").evaluate()
					.toString());

			assertEquals("-1", new PumaExpression("(1/0) / (-1/0)").evaluate()
					.toString());

			assertEquals("-1", new PumaExpression("(-1/0) / (1/0)").evaluate()
					.toString());

			assertEquals("1", new PumaExpression("(-1/0) / (-1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("2 / (1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("2 / (-1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-2 / (1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-2 / (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) / 2").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(1/0) / -2").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) / 2").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(-1/0) / -2").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("2.3 / (1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("2.3 / (-1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-2.3 / (1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-2.3 / (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) / 2.3").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(1/0) / -2.3").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) / 2.3").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(-1/0) / -2.3").evaluate()
					.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

}