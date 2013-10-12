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

import com.zavazoo.puma.Puma;

/**
 * Tests the creation of Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class CreatePumaTest extends AbstractPumaTest {

	/**
	 * Tests the creation of positive or negative integers.
	 */
	public void testInteger() {

		try {

			assertEquals(
					"1982763840092889378784387289379823798237982739872310928102",
					new Puma(
							"1982763840092889378784387289379823798237982739872310928102")
							.toString());

			assertEquals(
					"-1982763840092889378784387289379823798237982739872310928102",
					new Puma(
							"-1982763840092889378784387289379823798237982739872310928102")
							.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the creation of positive or negative floating-point numbers.
	 */
	public void testFloatingPoint() {

		try {

			assertEquals("123.456", new Puma("123.456000").toString());

			assertEquals("-129.456", new Puma("-000129.456000").toString());

			assertEquals("-129000.000456", new Puma("-000129000.000456000")
					.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the creation of quotients with a numerator and denominator which
	 * may be positive or negative, integer or floating-point numbers.
	 */
	public void testQuotient() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the creation of positive or negative numbers equivalent to exactly
	 * zero or one.
	 */
	public void testZeroOne() {

		try {

			assertEquals("1", new Puma("0001").toString());

			assertEquals("-1", new Puma("-0001").toString());

			assertEquals("0", new Puma("0").toString());

			assertEquals("0", new Puma("0000").toString());

			assertEquals("0", new Puma("-0").toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the creation of positive or negative non-terminating floating-point
	 * numbers with an infinite number of decimal places.
	 */
	public void testNonTerminating() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the creation of positive or negative infinity.
	 */
	public void testInfinite() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

}