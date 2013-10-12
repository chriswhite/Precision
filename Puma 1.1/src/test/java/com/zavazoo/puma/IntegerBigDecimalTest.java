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

import java.math.BigDecimal;

import junit.framework.TestCase;

/**
 * Tests the representation and comparison of big decimal as an integer in order
 * to assert expected behaviour in future versions of BigDecimal.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class IntegerBigDecimalTest extends TestCase {

	/**
	 * Tests the representation and comparison of big decimal as an integer.
	 */
	public void testInteger() {

		try {

			BigDecimal one = new BigDecimal("1");

			int maximumInteger = Integer.MAX_VALUE;

			BigDecimal exactlyMaximumInteger = new BigDecimal(maximumInteger);
			BigDecimal nearlyMaximumInteger = exactlyMaximumInteger
					.subtract(one);
			BigDecimal overflowedMaximumInteger = exactlyMaximumInteger
					.add(one);

			assertTrue(exactlyMaximumInteger.compareTo(exactlyMaximumInteger) == 0);
			assertEquals(maximumInteger, exactlyMaximumInteger.intValue());

			assertTrue(nearlyMaximumInteger.compareTo(exactlyMaximumInteger) < 0);
			assertEquals(maximumInteger - 1, nearlyMaximumInteger.intValue());

			assertTrue(overflowedMaximumInteger
					.compareTo(exactlyMaximumInteger) > 0);

		} catch (Exception error) {

			error.printStackTrace();

		}

	}

}