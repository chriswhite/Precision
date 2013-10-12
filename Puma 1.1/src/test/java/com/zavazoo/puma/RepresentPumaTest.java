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

import junit.framework.TestCase;

/**
 * Tests the representation of Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class RepresentPumaTest extends TestCase {

	/**
	 * Tests the representation of Puma numbers.
	 */
	public void testRepresentation() {

		try {

			assertEquals("12", new Puma("12").toString());

			assertEquals("0", new Puma("0").toString());

			assertEquals("0", new Puma("0.0").toString());

			assertEquals("0", new Puma("-0").toString());

			assertEquals("0", new Puma("-0.0").toString());

			assertEquals("0", new Puma("000000").toString());

			assertEquals("0", new Puma("00000.00000").toString());

			assertEquals("12.34", new Puma("12.34").toString());

			assertEquals("-12.34", new Puma("-12.34").toString());

			assertEquals("12.34", new Puma("00012.340000").toString());

			assertEquals("-12.34", new Puma("-00012.34000").toString());

			assertEquals("1/3", new Puma("1/3").toString());

			assertEquals("1/3", new Puma("2/6").toString());

			assertEquals("0.5", new Puma("2/4").toString());

			assertEquals("-1/3", new Puma("1/-3").toString());

			assertEquals("-1/3", new Puma("-2/6").toString());

			assertEquals("0.5", new Puma("-2/-4").toString());

			assertEquals("5000000000", new Puma("000020000000000/00004")
					.toString());

			assertEquals("5000000000", new Puma("00005000000000").toString());

			assertEquals("0.00000000005", new Puma("00002/40000000000")
					.toString());

		} catch (Exception error) {

			error.printStackTrace();

		}

	}

}