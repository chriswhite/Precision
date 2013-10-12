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
 * Tests the scale operation on Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class ScalePumaTest extends AbstractPumaTest {

	/**
	 * Tests the scale operation on positive or negative integers.
	 */
	public void testInteger() {

		try {

			assertEquals("10000", new Puma("10").scale(3).toString());

			assertEquals("0.01", new Puma("10").scale(-3).toString());

			assertEquals("-10000", new Puma("-10").scale(3).toString());

			assertEquals("-0.01", new Puma("-10").scale(-3).toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the scale operation on positive or negative floating-point numbers.
	 */
	public void testFloatingPoint() {

		try {

			assertEquals("12340", new Puma("12.34").scale(3).toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the scale operation on quotients with a numerator and denominator
	 * which may be positive or negative, integer or floating-point numbers.
	 */
	public void testQuotient() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the scale operation on positive or negative numbers equivalent to
	 * exactly zero or one.
	 */
	public void testZeroOne() {

		try {

			assertEquals("0", new Puma("0").scale(0).toString());

			assertEquals("0", new Puma("-0").scale(0).toString());

			assertEquals("0", new Puma("0").scale(1).toString());

			assertEquals("0", new Puma("-0").scale(1).toString());

			assertEquals("0", new Puma("0").scale(-1).toString());

			assertEquals("0", new Puma("-0").scale(-1).toString());

			assertEquals("1", new Puma("1").scale(0).toString());

			assertEquals("0.0001", new Puma("1").scale(-4).toString());

			assertEquals("10", new Puma("1").scale(1).toString());

			assertEquals("100", new Puma("1").scale(2).toString());

			assertEquals("0.1", new Puma("1").scale(-1).toString());

			assertEquals("0.01", new Puma("1").scale(-2).toString());

			assertEquals("-1", new Puma("-1").scale(0).toString());

			assertEquals("-10", new Puma("-1").scale(1).toString());

			assertEquals("-100", new Puma("-1").scale(2).toString());

			assertEquals("-0.1", new Puma("-1").scale(-1).toString());

			assertEquals("-0.01", new Puma("-1").scale(-2).toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the scale operation on positive or negative non-terminating
	 * floating-point numbers with an infinite number of decimal places.
	 */
	public void testNonTerminating() {

		try {

			assertEquals("1/0.003", new Puma("1/3").scale(3).toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the scale operation on positive or negative infinity.
	 */
	public void testInfinite() {

		try {

			assertEquals("1/0", new Puma("1/0").scale(2).toString());

			assertEquals("-1/0", new Puma("-1/0").scale(2).toString());

			assertEquals("1/0", new Puma("1/0").scale(-2).toString());

			assertEquals("-1/0", new Puma("-1/0").scale(-2).toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

}