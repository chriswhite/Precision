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
 * Tests the power operation on Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class PowerPumaTest extends AbstractPumaTest {

	/**
	 * Tests the power operation on positive or negative integers.
	 */
	public void testInteger() {

		try {

			assertEquals("4", new PumaExpression("2 ^ 2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("1", new PumaExpression("1 ^ 10").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("9", new PumaExpression("3 ^ 2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-8", new PumaExpression("-2 ^ 3").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-16", new PumaExpression("-2 ^ 4").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-4", new PumaExpression("-2 ^ 2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-1", new PumaExpression("-1 ^ 10").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-9", new PumaExpression("-3 ^ 2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0.25", new PumaExpression("2 ^ -2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("1", new PumaExpression("1 ^ -10").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0.1111111111", new PumaExpression("3 ^ -2")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("1000000000000000000000000", new PumaExpression(
					"1000000000000 ^ 2").evaluate().createRoundedDecorator()
					.toRoundedString());

			assertEquals("1000000000000000000000000000000000000",
					new PumaExpression("1000000000000 ^ 3").evaluate()
							.createRoundedDecorator().toRoundedString());

			assertEquals("-1000000000000000000000000", new PumaExpression(
					"-1000000000000 ^ 2").evaluate().createRoundedDecorator()
					.toRoundedString());

			assertEquals("-1000000000000000000000000000000000000",
					new PumaExpression("-1000000000000 ^ 3").evaluate()
							.createRoundedDecorator().toRoundedString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the power operation on positive or negative floating-point numbers.
	 */
	public void testFloatingPoint() {

		try {

			assertEquals("0.0000000001", new PumaExpression("0.00001 ^ 2")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.25", new PumaExpression("0.5 ^ 2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0.53085796", new PumaExpression("0.7286 ^ 2")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.99980001", new PumaExpression("0.9999 ^ 2")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("3", new PumaExpression("9 ^ 0.5").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("98.01", new PumaExpression("9.9 ^ 2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("2.6304653924", new PumaExpression("1.4723567 ^ 2.5")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-0.0000000001", new PumaExpression("-0.00001 ^ 2")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-0.25", new PumaExpression("-0.5 ^ 2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-0.53085796", new PumaExpression("-0.7286 ^ 2")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-0.99980001", new PumaExpression("-0.9999 ^ 2")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-3", new PumaExpression("-9 ^ 0.5").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-98.01", new PumaExpression("-9.9 ^ 2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-2.6304653924",
					new PumaExpression("-1.4723567 ^ 2.5").evaluate()
							.createRoundedDecorator().toRoundedString());

			assertEquals("0.3333333333", new PumaExpression("9 ^ -0.5")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.0102030405", new PumaExpression("9.9 ^ -2")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.3801608654", new PumaExpression("1.4723567 ^ -2.5")
					.evaluate().createRoundedDecorator().toRoundedString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the power operation on quotients with a numerator and denominator
	 * which may be positive or negative, integer or floating-point numbers.
	 */
	public void testQuotient() {

		try {

			assertEquals("0.0031622777", new PumaExpression("0.00001 ^ (1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.7071067812", new PumaExpression("0.5 ^ (1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.8535806933", new PumaExpression("0.7286 ^ (1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.9999499987", new PumaExpression("0.9999 ^ (1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("1", new PumaExpression("1 ^ (1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("1", new PumaExpression("1 ^ (1.45/2.873)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("1.7320508076", new PumaExpression("3 ^ (1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("2", new PumaExpression("4 ^ (1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0.3333333333", new PumaExpression(
					"0.11111111111111111111 ^ (1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("3", new PumaExpression("9 ^ (1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("3.1464265445", new PumaExpression("9.9 ^ (1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("3.7062473221", new PumaExpression("9.9 ^ (4/7)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("2.3400008781",
					new PumaExpression("(9.8/0.5) ^ (2/7)").evaluate()
							.createRoundedDecorator().toRoundedString());

			assertEquals("1.4723567002", new PumaExpression("15 ^ (1/7)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-0.0031622777",
					new PumaExpression("-0.00001 ^ (1/2)").evaluate()
							.createRoundedDecorator().toRoundedString());

			assertEquals("-0.7071067812", new PumaExpression("-0.5 ^ (1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-0.8535806933", new PumaExpression("-0.7286 ^ (1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-0.9999499987", new PumaExpression("-0.9999 ^ (1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-1.7320508076", new PumaExpression("-3 ^ (1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-2", new PumaExpression("-4 ^ (1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-3", new PumaExpression("-9 ^ (1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-3.1464265445", new PumaExpression("-9.9 ^ (1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-3.7062473221", new PumaExpression("-9.9 ^ (4/7)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-2.3400008781", new PumaExpression(
					"(-9.8/0.5) ^ (2/7)").evaluate().createRoundedDecorator()
					.toRoundedString());

			assertEquals("-1.4723567002", new PumaExpression("-15 ^ (1/7)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.5773502692", new PumaExpression("3 ^ (-1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.5", new PumaExpression("4 ^ (-1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0.6299605249", new PumaExpression("4 ^ (-1/3)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.3333333333", new PumaExpression("9 ^ (-1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.3178208631", new PumaExpression("9.9 ^ (-1/2)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.2698146975", new PumaExpression("9.9 ^ (-4/7)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("0.427350267",
					new PumaExpression("(9.8/0.5) ^ (-2/7)").evaluate()
							.createRoundedDecorator().toRoundedString());

			assertEquals("0.679183244", new PumaExpression("15 ^ (-1/7)")
					.evaluate().createRoundedDecorator().toRoundedString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the power operation on positive or negative numbers equivalent to
	 * exactly zero or one.
	 */
	public void testZeroOne() {

		try {

			assertEquals("0", new PumaExpression("0 ^ 0").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("1", new PumaExpression("1 ^ 0").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("1", new PumaExpression("2 ^ 0").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-1", new PumaExpression("-1 ^ 0").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-1", new PumaExpression("-2 ^ 0").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("0 ^ 2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("0 ^ (1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("-0 ^ 2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("-0 ^ (1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-1", new PumaExpression("-1 ^ (1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-1", new PumaExpression("-1 ^ (1.45/2.873)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("1/0", new PumaExpression("0 ^ -2").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("0 ^ (-1/2)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("-0 ^ -2").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("-0 ^ (-1/2)").evaluate()
					.toString());

			assertEquals("1", new PumaExpression("1 ^ (-1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("1", new PumaExpression("1 ^ (-1.45/2.873)")
					.evaluate().createRoundedDecorator().toRoundedString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the power operation on positive or negative non-terminating
	 * floating-point numbers with an infinite number of decimal places.
	 */
	public void testNonTerminating() {

		try {

			assertEquals("1.587401052", new PumaExpression("4 ^ (1/3)")
					.evaluate().createRoundedDecorator().toRoundedString());

			assertEquals("-1.587401052", new PumaExpression("-4 ^ (1/3)")
					.evaluate().createRoundedDecorator().toRoundedString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

	/**
	 * Tests the power operation on positive or negative infinity.
	 */
	public void testInfinite() {

		try {

			assertEquals("0", new PumaExpression("0 ^ (1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("1", new PumaExpression("1 ^ (1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("1/0", new PumaExpression("2 ^ (1/0)").evaluate()
					.toString());

			assertEquals("-1", new PumaExpression("-1 ^ (1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-1/0", new PumaExpression("-2 ^ (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("0 ^ (-1/0)").evaluate()
					.toString());

			assertEquals("1", new PumaExpression("1 ^ (-1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("2 ^ (-1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-1", new PumaExpression("-1 ^ (-1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("-2 ^ (-1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("0.5 ^ (1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("1/0", new PumaExpression("1.5 ^ (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("2.5 ^ (1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-0.5 ^ (1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-1/0", new PumaExpression("-1.5 ^ (1/0)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("-2.5 ^ (1/0)").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("0.5 ^ (-1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("1.5 ^ (-1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("2.5 ^ (-1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("-1/0", new PumaExpression("-0.5 ^ (-1/0)").evaluate()
					.toString());

			assertEquals("0", new PumaExpression("-1.5 ^ (-1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("-2.5 ^ (-1/0)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("1/0", new PumaExpression("(1/0) ^ 2").evaluate()
					.toString());

			assertEquals("1/0", new PumaExpression("(1/0) ^ (1/2)").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) ^ 2").evaluate()
					.toString());

			assertEquals("-1/0", new PumaExpression("(-1/0) ^ (1/2)")
					.evaluate().toString());

			assertEquals("0", new PumaExpression("(1/0) ^ -2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("(1/0) ^ (-1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("(-1/0) ^ -2").evaluate()
					.createRoundedDecorator().toRoundedString());

			assertEquals("0", new PumaExpression("(-1/0) ^ (-1/2)").evaluate()
					.createRoundedDecorator().toRoundedString());

		} catch (Throwable error) {

			error.printStackTrace();

		}

	}

}