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
 * Tests the greater than operation on Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class GreaterThanPumaTest extends AbstractPumaTest {

	/**
	 * Tests the greater than operation on positive or negative integers.
	 */
	public void testInteger() {

		try {

			assertTrue(new Puma("4").greaterThan(new Puma("2")));

			assertTrue(new Puma("-2").greaterThan(new Puma("-4")));

			assertTrue(new Puma("2").greaterThan(new Puma("-4")));

			assertTrue(new Puma("4").greaterThanOrEqualTo(new Puma("2")));

			assertTrue(new Puma("-2").greaterThanOrEqualTo(new Puma("-4")));

			assertTrue(new Puma("2").greaterThanOrEqualTo(new Puma("-4")));

			assertTrue(new Puma("2").greaterThanOrEqualTo(new Puma("2")));

			assertTrue(new Puma("-2").greaterThanOrEqualTo(new Puma("-2")));

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the greater than operation on positive or negative floating-point
	 * numbers.
	 */
	public void testFloatingPoint() {

		try {

			assertTrue(new Puma("4.4").greaterThan(new Puma("4.32")));

			assertTrue(new Puma("4.4").greaterThan(new Puma("-4.32")));

			assertTrue(new Puma("-4").greaterThan(new Puma("-4.2")));

			assertTrue(new Puma("4.2").greaterThan(new Puma("4")));

			assertTrue(new Puma("-04.0000002").greaterThan(new Puma("-4.030")));

			assertTrue(new Puma(
					"1000000000000000000000000000000002.900000000000000000000000000000044")
					.greaterThan(new Puma(
							"1000000000000000000000000000000002.900000000000000000000000000000004")));

			assertTrue(new Puma(
					"-1000000000000000000000000000000002.900000000000000000000000000000044")
					.greaterThan(new Puma(
							"-1000000000000000000000000000000002.900000000000000000000000000000094")));

			assertTrue(new Puma(
					"398478326486347987349730948723908472907482064872648.010000032653287638276386238762832873")
					.greaterThan(new Puma(
							"398478326486347987349730948723908472907482064872648.000000032653287638276386238762832873")));

			assertTrue(new Puma("4.4").greaterThanOrEqualTo(new Puma("4.32")));

			assertTrue(new Puma("4.4").greaterThanOrEqualTo(new Puma("-4.32")));

			assertTrue(new Puma("-4").greaterThanOrEqualTo(new Puma("-4.2")));

			assertTrue(new Puma("4.2").greaterThanOrEqualTo(new Puma("4")));

			assertTrue(new Puma("-04.0000002").greaterThanOrEqualTo(new Puma(
					"-4.030")));

			assertTrue(new Puma(
					"1000000000000000000000000000000002.900000000000000000000000000000044")
					.greaterThanOrEqualTo(new Puma(
							"1000000000000000000000000000000002.900000000000000000000000000000004")));

			assertTrue(new Puma(
					"-1000000000000000000000000000000002.900000000000000000000000000000044")
					.greaterThanOrEqualTo(new Puma(
							"-1000000000000000000000000000000002.900000000000000000000000000000094")));

			assertTrue(new Puma(
					"398478326486347987349730948723908472907482064872648.010000032653287638276386238762832873")
					.greaterThanOrEqualTo(new Puma(
							"398478326486347987349730948723908472907482064872648.000000032653287638276386238762832873")));

			assertTrue(new Puma("2.2").greaterThanOrEqualTo(new Puma("2.2")));

			assertTrue(new Puma("020.0202").greaterThanOrEqualTo(new Puma(
					"20.0202")));

			assertTrue(new Puma("-20.0202").greaterThanOrEqualTo(new Puma(
					"-0020.020200")));

			assertTrue(new Puma(
					"1000000000000000000000000000000002.900000000000000000000000000000044")
					.greaterThanOrEqualTo(new Puma(
							"1000000000000000000000000000000002.900000000000000000000000000000044")));

			assertTrue(new Puma(
					"398478326486347987349730948723908472907482064872648.010000032653287638276386238762832873")
					.greaterThanOrEqualTo(new Puma(
							"398478326486347987349730948723908472907482064872648.010000032653287638276386238762832873")));

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the greater than operation on quotients with a numerator and
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
	 * Tests the greater than operation on positive or negative numbers
	 * equivalent to exactly zero or one.
	 */
	public void testZeroOne() {

		try {

			assertTrue(new Puma("0").greaterThanOrEqualTo(new Puma("0")));

			assertTrue(new Puma("-0").greaterThanOrEqualTo(new Puma("-0")));

			assertTrue(new Puma("0").greaterThanOrEqualTo(new Puma("-0")));

			assertTrue(new Puma("-0").greaterThanOrEqualTo(new Puma("0")));

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the greater than operation on positive or negative non-terminating
	 * floating-point numbers with an infinite number of decimal places.
	 */
	public void testNonTerminating() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the greater than operation on positive or negative infinity.
	 */
	public void testInfinite() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

}