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

/**
 * Encapsulates the data required to perform a test of an operation on Puma
 * numbers.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
class OperationTestBean {

	/** The characters that comprise the integer part of the number. */
	private char[] integer;

	/**
	 * The characters that comprise the fractional part of the number or null if
	 * the number does not have a fractional part.
	 */
	private char[] fractional;

	/** Switch used to indicate that the number is negative. */
	private boolean negative;

	/**
	 * Creates a OperationBean with the specified properties.
	 * 
	 * @param integer
	 * @param fractional
	 * @param negative
	 */
	OperationTestBean(char[] integer, char[] fractional, boolean negative) {
		this.integer = integer;
		this.fractional = fractional;
		this.negative = negative;
	}

	/**
	 * Gets the integer property.
	 * 
	 * @return the integer property.
	 */
	char[] getInteger() {

		return integer;

	}

	/**
	 * Gets the fractional property.
	 * 
	 * @return the fractional property.
	 */
	char[] getFractional() {

		return fractional;

	}

	/**
	 * Gets the negative property.
	 * 
	 * @return the negative property.
	 */
	boolean isNegative() {

		return negative;

	}

}