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
 * Tests the remainder operation on Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class RemainderPumaTest extends AbstractPumaTest {

	/**
	 * Tests the remainder operation on positive or negative integers.
	 */
	public void testInteger() {

		try {

			assertEquals("0", new Puma("10").remainder(new Puma("5"))
					.toString());

			assertEquals("1", new Puma("11").remainder(new Puma("5"))
					.toString());

			assertEquals("2", new Puma("12").remainder(new Puma("5"))
					.toString());

			assertEquals("3", new Puma("13").remainder(new Puma("5"))
					.toString());

			assertEquals("4", new Puma("14").remainder(new Puma("5"))
					.toString());

			assertEquals("0", new Puma("10").remainder(new Puma("-5"))
					.toString());

			assertEquals("1", new Puma("11").remainder(new Puma("-5"))
					.toString());

			assertEquals("2", new Puma("12").remainder(new Puma("-5"))
					.toString());

			assertEquals("3", new Puma("13").remainder(new Puma("-5"))
					.toString());

			assertEquals("4", new Puma("14").remainder(new Puma("-5"))
					.toString());

			assertEquals("0", new Puma("-10").remainder(new Puma("5"))
					.toString());

			assertEquals("-1", new Puma("-11").remainder(new Puma("5"))
					.toString());

			assertEquals("-2", new Puma("-12").remainder(new Puma("5"))
					.toString());

			assertEquals("-3", new Puma("-13").remainder(new Puma("5"))
					.toString());

			assertEquals("-4", new Puma("-14").remainder(new Puma("5"))
					.toString());

			assertEquals("0", new Puma("-10").remainder(new Puma("-5"))
					.toString());

			assertEquals("-1", new Puma("-11").remainder(new Puma("-5"))
					.toString());

			assertEquals("-2", new Puma("-12").remainder(new Puma("-5"))
					.toString());

			assertEquals("-3", new Puma("-13").remainder(new Puma("-5"))
					.toString());

			assertEquals("-4", new Puma("-14").remainder(new Puma("-5"))
					.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the remainder operation on positive or negative floating-point
	 * numbers.
	 */
	public void testFloatingPoint() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the remainder operation on quotients with a numerator and
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
	 * Tests the remainder operation on positive or negative numbers equivalent
	 * to exactly zero or one.
	 */
	public void testZeroOne() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the remainder operation on positive or negative non-terminating
	 * floating-point numbers with an infinite number of decimal places.
	 */
	public void testNonTerminating() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the remainder operation on positive or negative infinity.
	 */
	public void testInfinite() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

}