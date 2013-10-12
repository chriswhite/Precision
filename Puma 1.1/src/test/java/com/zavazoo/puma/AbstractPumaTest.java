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

import junit.framework.TestCase;

/**
 * Tests operations on Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
abstract class AbstractPumaTest extends TestCase {

	/**
	 * Tests a particular operation on positive or negative integers.
	 */
	abstract public void testInteger();

	/**
	 * Tests a particular operation on positive or negative floating-point
	 * numbers.
	 */
	abstract public void testFloatingPoint();

	/**
	 * Tests a particular operation on quotients with a numerator and
	 * denominator which may be positive or negative, integer or floating-point
	 * numbers.
	 */
	abstract public void testQuotient();

	/**
	 * Tests a particular operation on positive or negative numbers equivalent
	 * to exactly zero or one.
	 */
	abstract public void testZeroOne();

	/**
	 * Tests a particular operation on positive or negative non-terminating
	 * floating-point numbers with an infinite number of decimal places.
	 */
	abstract public void testNonTerminating();

	/**
	 * Tests a particular operation on positive or negative infinity.
	 */
	abstract public void testInfinite();

}