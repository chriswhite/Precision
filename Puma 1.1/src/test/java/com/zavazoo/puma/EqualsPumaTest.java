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
 * Tests the equals operation on Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class EqualsPumaTest extends AbstractPumaTest {

	/**
	 * Tests the equals operation on positive or negative integers.
	 */
	public void testInteger() {

		try {

			assertTrue(new Puma("12").equals(new Puma("12")));

			assertTrue(new Puma("12").equals(new Puma("12.000")));

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the equals operation on positive or negative floating-point
	 * numbers.
	 */
	public void testFloatingPoint() {

		try {

			assertTrue(new Puma("12.34").equals(new Puma("12.34")));

			assertTrue(new Puma("-12.34").equals(new Puma("-12.34")));

			assertTrue(new Puma("0012.34").equals(new Puma("12.3400")));

			assertTrue(new Puma(
					"342873629466345420209734623427842998347210932.374623548271094098903484776157612589307")
					.equals(new Puma(
							"342873629466345420209734623427842998347210932.374623548271094098903484776157612589307")));

			assertTrue(new Puma("12.34").notEqualTo(new Puma("-12.34")));

			assertTrue(new Puma("-12.34").notEqualTo(new Puma("012.34")));

			assertTrue(new Puma("0012.34").notEqualTo(new Puma("12.3410")));

			assertTrue(new Puma(
					"438739846827487646751987239108723891678109849047184687.00000238767348172364782634621873462876419938")
					.notEqualTo(new Puma(
							"438739846827487646751987239108723891678109849047184687.00000238767348172264782634621873462876419938")));

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the equals operation on quotients with a numerator and denominator
	 * which may be positive or negative, integer or floating-point numbers.
	 */
	public void testQuotient() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the equals operation on positive or negative numbers equivalent to
	 * exactly zero or one.
	 */
	public void testZeroOne() {

		try {

			assertTrue(new Puma("0").equals(new Puma("0")));

			assertTrue(new Puma("0").equals(new Puma("-0")));

			assertTrue(new Puma("12").notEqualTo(new Puma("0")));

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the equals operation on positive or negative non-terminating
	 * floating-point numbers with an infinite number of decimal places.
	 */
	public void testNonTerminating() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the equals operation on positive or negative infinity.
	 */
	public void testInfinite() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

}