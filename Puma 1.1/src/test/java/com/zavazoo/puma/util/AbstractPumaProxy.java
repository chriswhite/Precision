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

package com.zavazoo.puma.util;

import com.zavazoo.puma.Puma;

/**
 * Proxies between an operation delegate and a Puma number.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
abstract class AbstractPumaProxy {

	/**
	 * Creates the data required to perform an operation using the specified
	 * Puma number. <br/>
	 * The number must represent a value with a terminating decimal expansion; a
	 * finite number of decimal places, otherwise this method will yield null.
	 * 
	 * @return the data.
	 */
	protected static OperationTestBean createOperationData(Puma number) {

		if (number.infiniteDecimalPlaces()) {

			return null;

		}

		String representation = number.toString();

		int representationLength = representation.length();

		int minusSignIndex = representation.indexOf('-');
		int decimalPointIndex = representation.indexOf('.');

		int integerStartIndex = 1;
		int integerEndIndex = decimalPointIndex;

		boolean negative = true;

		if (minusSignIndex == -1) {

			integerStartIndex = 0;

			negative = false;

		}

		boolean decimalPoint = true;

		if (decimalPointIndex == -1) {

			integerEndIndex = representationLength;

			decimalPoint = false;

		}

		char[] fractional = null;

		if (decimalPoint) {

			int fractionalStartIndex = decimalPointIndex + 1;
			int fractionalEndIndex = representationLength;

			fractional = representation.substring(fractionalStartIndex,
					fractionalEndIndex).toCharArray();

		}

		char[] integer = representation.substring(integerStartIndex,
				integerEndIndex).toCharArray();

		return new OperationTestBean(integer, fractional, negative);

	}

	/**
	 * Creates a Puma number using the specified data required to perform an
	 * operation.
	 * 
	 * @param data
	 *            the data.
	 * @return the number.
	 */
	protected static Puma createPuma(OperationTestBean data) {

		StringBuilder representation = new StringBuilder();

		if (data.isNegative()) {

			representation.append('-');

		}

		representation.append(data.getInteger());

		char[] fractional = data.getFractional();

		if (fractional != null) {

			representation.append('.');
			representation.append(fractional);

		}

		return new Puma(representation.toString());

	}

}