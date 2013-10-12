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

import junit.framework.TestCase;

/**
 * Tests the add operation on Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class AddPumaTest extends TestCase {

	/**
	 * Tests the add operation on positive or negative integers.
	 */
	public void testInteger() {

		try {

			assertEquals("46", new PumaExpression("12 + 34").evaluate()
					.toString());

			assertEquals("46", new PumaExpression("12+34").evaluate()
					.toString());

			assertEquals("36", new PumaExpression("18 + 18").evaluate()
					.toString());

			assertEquals("10036", new PumaExpression("18 + 10018").evaluate()
					.toString());

			assertEquals("196", new PumaExpression("98 + 98").evaluate()
					.toString());

			assertEquals("195", new PumaExpression("98 + 97").evaluate()
					.toString());

			assertEquals("3000000003", new PumaExpression("3 + 3000000000")
					.evaluate().toString());

			assertEquals("2", new PumaExpression("-2 + 4").evaluate()
					.toString());

			assertEquals("-2", new PumaExpression("2 + -04").evaluate()
					.toString());

			assertEquals("-6", new PumaExpression("-02 + -4").evaluate()
					.toString());

			assertEquals("-9574755753510085", new PumaExpression(
					"-000287362873682687 + -9287392879827398").evaluate()
					.toString());

			assertEquals(
					"-9284519597101092026053544711",
					new PumaExpression(
							"2873282708000362873682687 + -00009287392879809092388927227398")
							.evaluate().toString());

			assertEquals("9284519597101092026053544711", new PumaExpression(
					"9287392879809092388927227398+-2873282708000362873682687")
					.evaluate().toString());

			assertEquals(
					"-9290266162517092751800910085",
					new PumaExpression(
							"-000000002873282708000362873682687 + -0000009287392879809092388927227398")
							.evaluate().toString());

			assertEquals(
					"87298734986238746208374098409384092384029878251",
					new PumaExpression(
							"87298734986238746208374098409384092384029878237 + 14")
							.evaluate().toString());

			assertEquals(
					"872987349862387462083740984093840923298472385689736485739807209578323898324582379821398720000009852395809275098384029878349",
					new PumaExpression(
							"872987349862387462083740984093840923298472385689736485739807209578323898324582379821398720000009852395809275098384029878237 + 112")
							.evaluate().toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the add operation on positive or negative floating-point numbers.
	 */
	public void testFloatingPoint() {

		try {

			assertEquals("8.2", new PumaExpression("4 + 4.2").evaluate()
					.toString());

			assertEquals("46.47", new PumaExpression("12.12 + 34.35")
					.evaluate().toString());

			assertEquals("46.47", new PumaExpression("12.12+34.35").evaluate()
					.toString());

			assertEquals("36.37", new PumaExpression("0018.19 + 18.1800")
					.evaluate().toString());

			assertEquals("10036.29018", new PumaExpression(
					"18.19 + 10018.10018").evaluate().toString());

			assertEquals("197.96", new PumaExpression("98.9800 + 98.98")
					.evaluate().toString());

			assertEquals("196.95", new PumaExpression("98.98 + 97.97")
					.evaluate().toString());

			assertEquals("195.970098", new PumaExpression("98.000098 + 97.97")
					.evaluate().toString());

			assertEquals("3000000003.6", new PumaExpression(
					"3.3 + 3000000000.3000000000").evaluate().toString());

			assertEquals("1.8", new PumaExpression("-2.3 + 4.1").evaluate()
					.toString());

			assertEquals("-2.4", new PumaExpression("2.0 + -4.4").evaluate()
					.toString());

			assertEquals("-7.3", new PumaExpression("-2.5 + -4.8").evaluate()
					.toString());

			assertEquals("-931612916.71956667", new PumaExpression(
					"-2873628.73682687000000000 + -000000000928739287.9827398")
					.evaluate().toString());

			assertEquals("2873281779261.07470302", new PumaExpression(
					"2873282708000.362687 + -928739.28798398").evaluate()
					.toString());

			assertEquals("9287392879809092388927227366.8", new PumaExpression(
					"9287392879809092388927227368+-000001.2").evaluate()
					.toString());

			assertEquals("-380201.956667", new PumaExpression(
					"-000000287328.682687 + -92873.273980000000000").evaluate()
					.toString());

			assertEquals(
					"100000000000000000000000001.2",
					new PumaExpression(
							"100000000000000000000000000.100000000000000000000000000 + 1.1")
							.evaluate().toString());

			assertEquals(
					"2938794873846238765823649875987234987238.378463827483274982309480928498273",
					new PumaExpression(
							"2938794873846238765823649875987234987237.278463827483274982309480928498273 + 1.1")
							.evaluate().toString());

			assertEquals(
					"3287462378523648273498723980472985687326208137498021735987509784500430938947983274983.563398768976534758973049587302985726546715672347098574584398539058398",
					new PumaExpression(
							"1.101 + 3287462378523648273498723980472985687326208137498021735987509784500430938947983274982.462398768976534758973049587302985726546715672347098574584398539058398")
							.evaluate().toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the add operation on quotients with a numerator and denominator
	 * which may be positive or negative, integer or floating-point numbers.
	 */
	public void testQuotient() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the add operation on positive or negative numbers equivalent to
	 * exactly zero or one.
	 */
	public void testZeroOne() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the add operation on positive or negative non-terminating
	 * floating-point numbers with an infinite number of decimal places.
	 */
	public void testNonTerminating() {

		try {

			assertEquals("1/1.5", new PumaExpression("(1 / 3) + (1 / 3)")
					.evaluate().toString());

			assertEquals("1", new PumaExpression("(1 / 3) + (2 / 3)")
					.evaluate().toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the add operation on positive or negative infinity.
	 */
	public void testInfinite() {

		try {

			assertEquals("1/0", new PumaExpression("(1/0) + 0").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) + -0").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) + 0").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) + -0").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("0 + (1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("0 + (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("-0 + (1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("-0 + (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) + (1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("(1/0) + (-1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("(-1/0) + (1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) + (-1/0)")
					.evaluate().toString());

			assertEquals("1/0", new PumaExpression("2 + (1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("2 + (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("-2 + (1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("-2 + (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) + 2").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) + -2").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) + 2").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) + -2").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("2.3 + (1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("2.3 + (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("-2.3 + (1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("-2.3 + (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) + 2.3").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) + -2.3").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) + 2.3").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) + -2.3").evaluate()
					.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

}