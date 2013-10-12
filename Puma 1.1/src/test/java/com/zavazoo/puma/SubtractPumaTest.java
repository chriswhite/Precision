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
 * Tests the subtract operation on Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class SubtractPumaTest extends AbstractPumaTest {

	/**
	 * Tests the subtract operation on positive or negative integers.
	 */
	public void testInteger() {

		try {

			assertEquals("2", new PumaExpression("4 - 2").evaluate().toString());

			assertEquals("-2", new PumaExpression("2 - 4").evaluate()
					.toString());

			assertEquals("-6", new PumaExpression("-4 - 2").evaluate()
					.toString());

			assertEquals("6", new PumaExpression("4 - -2").evaluate()
					.toString());

			assertEquals("-2", new PumaExpression("-4 - -2").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("12045 - 00012045").evaluate()
					.toString());

			assertEquals("10", new PumaExpression("20 - 10").evaluate()
					.toString());

			assertEquals("-10", new PumaExpression("10 - 20").evaluate()
					.toString());

			assertEquals("12", new PumaExpression("23 - 11").evaluate()
					.toString());

			assertEquals("18", new PumaExpression("32 - 14").evaluate()
					.toString());

			assertEquals("1855", new PumaExpression("3287 - 1432").evaluate()
					.toString());

			assertEquals("7018348985", new PumaExpression(
					"0007033332287 - 14983302").evaluate().toString());

			assertEquals("-7018348985", new PumaExpression(
					"14983302 - 0007033332287").evaluate().toString());

			assertEquals(
					"1498323984653575145248183642492402908323694425015",
					new PumaExpression(
							"1498323984723908478235682374983274908327458657302 - 00070333332987498732490872000003764232287")
							.evaluate().toString());

			assertEquals(
					"1498323984723908478235682374983274362378547325823000982370984732894601786783126812368709327590873589643758658764908327458657235",
					new PumaExpression(
							"1498323984723908478235682374983274362378547325823000982370984732894601786783126812368709327590873589643758658764908327458657358 - 123")
							.evaluate().toString());

			assertEquals("-42367798048643583929758", new PumaExpression(
					"-42387827428937482903740 - -20029380293898973982")
					.evaluate().toString());

			assertEquals(
					"-423878274289374823987209837209870987280936821763873640289314274092174852903770",
					new PumaExpression(
							"-423878274289374823987209837209870987280936821763873640289314274092174852903749 - 21")
							.evaluate().toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the subtract operation on positive or negative floating-point
	 * numbers.
	 */
	public void testFloatingPoint() {

		try {

			assertEquals("2.2", new PumaExpression("4.4 - 2.2").evaluate()
					.toString());

			assertEquals("-2.2", new PumaExpression("2.2 - 4.4").evaluate()
					.toString());

			assertEquals("0.36", new PumaExpression("12045.57 - 00012045.2100")
					.evaluate().toString());

			assertEquals("10.1", new PumaExpression("20.2 - 10.1").evaluate()
					.toString());

			assertEquals("-10.1", new PumaExpression("0010.1 - 20.20000")
					.evaluate().toString());

			assertEquals("11.48", new PumaExpression("23.38 - 11.9").evaluate()
					.toString());

			assertEquals("17.3", new PumaExpression("32.2 - 14.9").evaluate()
					.toString());

			assertEquals("1855.0126668", new PumaExpression(
					"3287.3 - 1432.2873332").evaluate().toString());

			assertEquals("1854.7126968", new PumaExpression(
					"3287.00003 - 1432.2873332").evaluate().toString());

			assertEquals("-12614.762767897", new PumaExpression(
					"0002287.999999783 - 14902.76276768").evaluate().toString());

			assertEquals("-12615.999991938", new PumaExpression(
					"0002287.00000783 - 14902.999999768").evaluate().toString());

			assertEquals("-7.4", new PumaExpression("-4.5 - 2.9").evaluate()
					.toString());

			assertEquals("6.872", new PumaExpression("4.87 - -2.002")
					.evaluate().toString());

			assertEquals("-1.793032", new PumaExpression(
					"-0004.78236 - -2.9893280000").evaluate().toString());

			assertEquals("-328762844551.793032", new PumaExpression(
					"-000328762876874.78236 - -32322.9893280000").evaluate()
					.toString());

			assertEquals(
					"-328762876892384092834902739847247875.88236239878216489127489274092817482",
					new PumaExpression(
							"-000328762876892384092834902739847247874.78236239878216489127489274092817482 - 1.1")
							.evaluate().toString());

			assertEquals(
					"1498323984723908478235682374983274362378547325823000982370984732894601786783126812368709327590873589643758658764908327458657235.1643648723648723648792634876298429376910982734897009284790274092874",
					new PumaExpression(
							"1498323984723908478235682374983274362378547325823000982370984732894601786783126812368709327590873589643758658764908327458657358.2873648723648723648792634876298429376910982734897009284790274092874 - 123.123")
							.evaluate().toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the subtract operation on quotients with a numerator and
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
	 * Tests the subtract operation on positive or negative numbers equivalent
	 * to exactly zero or one.
	 */
	public void testZeroOne() {

		try {

			assertEquals("0", new PumaExpression("0 - 0").evaluate().toString());

			assertEquals("-1234", new PumaExpression("0 - 1234").evaluate()
					.toString());

			assertEquals("1234", new PumaExpression("1234 - 0").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("0.00000 - 00000.0")
					.evaluate().toString());

			assertEquals("-1234.5678", new PumaExpression("0 - 1234.5678")
					.evaluate().toString());

			assertEquals("1234.5678", new PumaExpression("1234.5678 - 0")
					.evaluate().toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the subtract operation on positive or negative non-terminating
	 * floating-point numbers with an infinite number of decimal places.
	 */
	public void testNonTerminating() {

		try {

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the subtract operation on positive or negative infinity.
	 */
	public void testInfinite() {

		try {

			assertEquals("1/0", new PumaExpression("(1/0) - 0").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) - -0").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) - 0").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) - -0").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("0 - (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("0 - (-1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("-0 - (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("-0 - (-1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("(1/0) - (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) - (-1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) - (1/0)")
					.evaluate().toString());

			assertEquals("0", new PumaExpression("(-1/0) - (-1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("2 - (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("2 - (-1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("-2 - (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("-2 - (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) - 2").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) - -2").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) - 2").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) - -2").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("2.3 - (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("2.3 - (-1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("-2.3 - (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("-2.3 - (-1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) - 2.3").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) - -2.3").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) - 2.3").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) - -2.3").evaluate()
					.toString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

}