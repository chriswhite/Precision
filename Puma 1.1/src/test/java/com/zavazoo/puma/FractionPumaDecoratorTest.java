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
 * Tests the representation of Puma numbers using a fraction Puma decorator.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class FractionPumaDecoratorTest extends TestCase {

	/**
	 * Tests the representation of Puma numbers expressed as the most concise
	 * fraction possible.
	 */
	public void testFractionString() {

		try {

			assertEquals("0/1", new Puma("0").createFractionDecorator()
					.toFractionString());

			assertEquals("1/0", new Puma("1/0").createFractionDecorator()
					.toFractionString());

			assertEquals("-1/0", new Puma("-1/0").createFractionDecorator()
					.toFractionString());

			assertEquals("1/1", new Puma("1").createFractionDecorator()
					.toFractionString());

			assertEquals("-1/1", new Puma("-1").createFractionDecorator()
					.toFractionString());

			assertEquals("5/7", new Puma("5/7").createFractionDecorator()
					.toFractionString());

			assertEquals("1/3", new Puma("1/3").createFractionDecorator()
					.toFractionString());

			assertEquals("3/1", new Puma("3/1").createFractionDecorator()
					.toFractionString());

			assertEquals("3/2", new Puma("3/2").createFractionDecorator()
					.toFractionString());

			assertEquals("4/1", new Puma("12/3").createFractionDecorator()
					.toFractionString());

			assertEquals("1/4", new Puma("3/12").createFractionDecorator()
					.toFractionString());

			assertEquals("1/4", new Puma("0.25").createFractionDecorator()
					.toFractionString());

			assertEquals("3/10", new Puma("0.3").createFractionDecorator()
					.toFractionString());

			assertEquals("2/5", new Puma("0.4").createFractionDecorator()
					.toFractionString());

			assertEquals("1/2", new Puma("0.5").createFractionDecorator()
					.toFractionString());

			assertEquals("9/13", new Puma("13104/18928")
					.createFractionDecorator().toFractionString());

			assertEquals("5/7", new Puma("3947280615/5526192861")
					.createFractionDecorator().toFractionString());

			assertEquals("5/7", new Puma("1973640307.5/2763096430.5")
					.createFractionDecorator().toFractionString());

			assertEquals("-5/7", new Puma("-5/7").createFractionDecorator()
					.toFractionString());

			assertEquals("-1/3", new Puma("-1/3").createFractionDecorator()
					.toFractionString());

			assertEquals("-3/1", new Puma("-3/1").createFractionDecorator()
					.toFractionString());

			assertEquals("-3/2", new Puma("-3/2").createFractionDecorator()
					.toFractionString());

			assertEquals("-4/1", new Puma("-12/3").createFractionDecorator()
					.toFractionString());

			assertEquals("-1/4", new Puma("-3/12").createFractionDecorator()
					.toFractionString());

			assertEquals("-1/4", new Puma("-0.25").createFractionDecorator()
					.toFractionString());

			assertEquals("-3/10", new Puma("-0.3").createFractionDecorator()
					.toFractionString());

			assertEquals("-2/5", new Puma("-0.4").createFractionDecorator()
					.toFractionString());

			assertEquals("-1/2", new Puma("-0.5").createFractionDecorator()
					.toFractionString());

			assertEquals("-9/13", new Puma("-13104/18928")
					.createFractionDecorator().toFractionString());

			assertEquals("-5/7", new Puma("-3947280615/5526192861")
					.createFractionDecorator().toFractionString());

			assertEquals("-5/7", new Puma("-1973640307.5/2763096430.5")
					.createFractionDecorator().toFractionString());

			assertEquals("5/7", new Puma("-1973640307.5/-2763096430.5")
					.createFractionDecorator().toFractionString());

			assertEquals("-5/7", new Puma("1973640307.5/-2763096430.5")
					.createFractionDecorator().toFractionString());

		} catch (Exception error) {

			error.printStackTrace();

		}

	}

}