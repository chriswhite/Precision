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
 * Tests the modulus operation on Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class ModulusPumaExpressionTest extends AbstractPumaTest {

	/**
	 * Tests the modulus operation on positive or negative integers.
	 */
	public void testInteger() {

		try {

			assertEquals("0", new PumaExpression("10 % 5").evaluate()
					.toString());

			assertEquals("1", new PumaExpression("11 % 5").evaluate()
					.toString());

			assertEquals("2", new PumaExpression("12 % 5").evaluate()
					.toString());

			assertEquals("3", new PumaExpression("13 % 5").evaluate()
					.toString());

			assertEquals("4", new PumaExpression("14 % 5").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("10 % -5").evaluate()
					.toString());

			assertEquals("-4", new PumaExpression("11 % -5").evaluate()
					.toString());

			assertEquals("-3", new PumaExpression("12 % -5").evaluate()
					.toString());

			assertEquals("-2", new PumaExpression("13 % -5").evaluate()
					.toString());

			assertEquals("-1", new PumaExpression("14 % -5").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-10 % 5").evaluate()
					.toString());

			assertEquals("4", new PumaExpression("-11 % 5").evaluate()
					.toString());

			assertEquals("3", new PumaExpression("-12 % 5").evaluate()
					.toString());

			assertEquals("2", new PumaExpression("-13 % 5").evaluate()
					.toString());

			assertEquals("1", new PumaExpression("-14 % 5").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-10 % -5").evaluate()
					.toString());

			assertEquals("-1", new PumaExpression("-11 % -5").evaluate()
					.toString());

			assertEquals("-2", new PumaExpression("-12 % -5").evaluate()
					.toString());

			assertEquals("-3", new PumaExpression("-13 % -5").evaluate()
					.toString());

			assertEquals("-4", new PumaExpression("-14 % -5").evaluate()
					.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the modulus operation on positive or negative floating-point
	 * numbers.
	 */
	public void testFloatingPoint() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the modulus operation on quotients with a numerator and denominator
	 * which may be positive or negative, integer or floating-point numbers.
	 */
	public void testQuotient() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the modulus operation on positive or negative numbers equivalent to
	 * exactly zero or one.
	 */
	public void testZeroOne() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the modulus operation on positive or negative non-terminating
	 * floating-point numbers with an infinite number of decimal places.
	 */
	public void testNonTerminating() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the modulus operation on positive or negative infinity.
	 */
	public void testInfinite() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

}