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

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.zavazoo.puma.Puma;

import junit.framework.TestCase;

/**
 * Tests the sorting of Puma numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class SortPumaTest extends TestCase {

	/**
	 * Tests the sorting of Puma numbers.
	 */
	public void testSort() {

		try {

			Puma number00 = new Puma("-1/0"); // negative infinity

			Puma number01 = new Puma("-2873709840398409859832745983742598045");

			Puma number02 = new Puma("-1982.9");

			Puma number03 = new Puma("-1982.87326576");

			Puma number04 = new Puma("-19.87328729837982739827987290800326576");

			Puma number05 = new Puma("-10");

			Puma number06 = new Puma("-1.0000000000001");

			Puma number07 = new Puma("-2/3"); // -0.666 recurring

			Puma number08 = new Puma("-0.1");

			Puma number09 = new Puma("0");

			Puma number10 = new Puma("1/3"); // 0.333 recurring

			Puma number11 = new Puma("0.67");

			Puma number12 = new Puma("1");

			Puma number13 = new Puma("1.87829792787287636");

			Puma number14 = new Puma("20.0000000000001");

			Puma number15 = new Puma("20.000000001");

			Puma number16 = new Puma("1987987.62898");

			Puma number17 = new Puma("2879487453658735973205987349857360987908");

			Puma number18 = new Puma("1/0"); // positive infinity

			List<Puma> manuallySortedNumbers = new ArrayList<Puma>();
			manuallySortedNumbers.add(number00);
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
			manuallySortedNumbers.add(number16);
			manuallySortedNumbers.add(number17);
			manuallySortedNumbers.add(number18);

			SortedSet<Puma> automaticallySortedNumbers = new TreeSet<Puma>();
			automaticallySortedNumbers.add(number12);
			automaticallySortedNumbers.add(number10);
			automaticallySortedNumbers.add(number15);
			automaticallySortedNumbers.add(number01);
			automaticallySortedNumbers.add(number17);
			automaticallySortedNumbers.add(number03);
			automaticallySortedNumbers.add(number04);
			automaticallySortedNumbers.add(number13);
			automaticallySortedNumbers.add(number14);
			automaticallySortedNumbers.add(number09);
			automaticallySortedNumbers.add(number16);
			automaticallySortedNumbers.add(number02);
			automaticallySortedNumbers.add(number07);
			automaticallySortedNumbers.add(number08);
			automaticallySortedNumbers.add(number00);
			automaticallySortedNumbers.add(number11);
			automaticallySortedNumbers.add(number18);
			automaticallySortedNumbers.add(number05);
			automaticallySortedNumbers.add(number06);

			int index = 0;

			for (Puma automaticallySortedNumber : automaticallySortedNumbers) {

				Puma manuallySortedNumber = manuallySortedNumbers.get(index);

				assertEquals(manuallySortedNumber.toString(),
						automaticallySortedNumber.toString());

				index++;

			}

		} catch (Exception error) {

			error.printStackTrace();

		}

	}

}