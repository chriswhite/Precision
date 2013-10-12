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
import java.math.MathContext;
import java.math.RoundingMode;

import junit.framework.TestCase;

/**
 * Tests the divide operation on big decimals in order to assert expected
 * behaviour in future versions of BigDecimal.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class DivideBigDecimalTest extends TestCase {

	/**
	 * Tests the divide operation on big decimals.
	 */
	public void testDivide() {

		try {

			BigDecimal subject = new BigDecimal("1");
			BigDecimal divisor = new BigDecimal("3");

			BigDecimal divide = null;

			try {

				divide = subject.divide(divisor);

				assertNull(divide);

			} catch (ArithmeticException error) {

				assertNull(divide);

			}

			BigDecimal divideToIntegralValue = subject
					.divideToIntegralValue(divisor);

			assertEquals("0", divideToIntegralValue.toPlainString());

			BigDecimal remainder = subject.remainder(divisor);

			assertEquals("1", remainder.toPlainString());

			BigDecimal[] dividedAndRemainder = subject
					.divideAndRemainder(divisor);

			assertEquals("0", dividedAndRemainder[0].toPlainString());
			assertEquals("1", dividedAndRemainder[1].toPlainString());

			MathContext context = new MathContext(5, RoundingMode.CEILING);

			BigDecimal divideWithContext = null;

			try {

				divideWithContext = subject.divide(divisor, context);

				assertEquals("0.33334", divideWithContext.toPlainString());

			} catch (ArithmeticException error) {

				error.printStackTrace();

				assertNotNull(divideWithContext);

			}

			BigDecimal divideToIntegralValueWithContext = subject
					.divideToIntegralValue(divisor, context);

			assertEquals("0", divideToIntegralValueWithContext.toPlainString());

			BigDecimal remainderWithContext = subject.remainder(divisor,
					context);

			assertEquals("1", remainderWithContext.toPlainString());

			BigDecimal[] dividedAndRemainderWithContext = subject
					.divideAndRemainder(divisor, context);

			assertEquals("0", dividedAndRemainderWithContext[0].toPlainString());
			assertEquals("1", dividedAndRemainderWithContext[1].toPlainString());

		} catch (Exception error) {

			error.printStackTrace();

		}

	}

}