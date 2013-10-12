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
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import junit.framework.TestCase;

/**
 * Tests the sorting of big decimals in order to assert expected behaviour in
 * future versions of BigDecimal.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class SortBigDecimalTest extends TestCase {

	/**
	 * Tests the sorting of big decimals.
	 */
	public void testSort() {

		try {

			BigDecimal number01 = new BigDecimal(
					"-2873709840398409859832745983742598045");

			BigDecimal number02 = new BigDecimal("-1982.9");

			BigDecimal number03 = new BigDecimal("-1982.87326576");

			BigDecimal number04 = new BigDecimal(
					"-19.87328729837982739827987290800326576");

			BigDecimal number05 = new BigDecimal("-10");

			BigDecimal number06 = new BigDecimal("-1.0000000000001");

			BigDecimal number07 = new BigDecimal("-0.1");

			BigDecimal number08 = new BigDecimal("0");

			BigDecimal number09 = new BigDecimal("0.67");

			BigDecimal number10 = new BigDecimal("1");

			BigDecimal number11 = new BigDecimal("1.87829792787287636");

			BigDecimal number12 = new BigDecimal("20.0000000000001");

			BigDecimal number13 = new BigDecimal("20.000000001");

			BigDecimal number14 = new BigDecimal("1987987.62898");

			BigDecimal number15 = new BigDecimal(
					"2879487453658735973205987349857360987908");

			List<BigDecimal> manuallySortedNumbers = new ArrayList<BigDecimal>();
			manuallySortedNumbers.add(number01);
			manuallySortedNumbers.add(number02);
			manuallySortedNumbers.add(number03);
			manuallySortedNumbers.add(number04);
			manuallySortedNumbers.add(number05);
			manuallySortedNumbers.add(number06);
			manuallySortedNumbers.add(number07);
			manuallySortedNumbers.add(number08);
			manuallySortedNumbers.add(number09);
			manuallySortedNumbers.add(number10);
			manuallySortedNumbers.add(number11);
			manuallySortedNumbers.add(number12);
			manuallySortedNumbers.add(number13);
			manuallySortedNumbers.add(number14);
			manuallySortedNumbers.add(number15);

			SortedSet<BigDecimal> automaticallySortedNumbers = new TreeSet<BigDecimal>();
			automaticallySortedNumbers.add(number12);
			automaticallySortedNumbers.add(number10);
			automaticallySortedNumbers.add(number15);
			automaticallySortedNumbers.add(number01);
			automaticallySortedNumbers.add(number03);
			automaticallySortedNumbers.add(number04);
			automaticallySortedNumbers.add(number13);
			automaticallySortedNumbers.add(number14);
			automaticallySortedNumbers.add(number09);
			automaticallySortedNumbers.add(number02);
			automaticallySortedNumbers.add(number07);
			automaticallySortedNumbers.add(number08);
			automaticallySortedNumbers.add(number11);
			automaticallySortedNumbers.add(number05);
			automaticallySortedNumbers.add(number06);

			int index = 0;

			for (BigDecimal automaticallySortedNumber : automaticallySortedNumbers) {

				BigDecimal manuallySortedNumber = manuallySortedNumbers
						.get(index);

				assertEquals(manuallySortedNumber.toString(),
						automaticallySortedNumber.toString());

				index++;

			}

		} catch (Exception error) {

			error.printStackTrace();

		}

	}

}