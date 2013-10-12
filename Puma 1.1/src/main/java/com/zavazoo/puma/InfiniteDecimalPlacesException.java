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

/**
 * Exception used to indicate that a Puma number represents a value that, when
 * expressed as a floating-point number, would comprise an infinite number of
 * decimal places.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class InfiniteDecimalPlacesException extends RuntimeException {

	/** The serialization version unique identifier. */
	private static final long serialVersionUID = 1l;

	/** The Puma number. */
	private Puma number;

	/**
	 * Creates an infinite decimal places exception using the specified Puma
	 * number.
	 * 
	 * @param number
	 *            the number.
	 */
	InfiniteDecimalPlacesException(Puma number) {

		super("Puma number has an infinite number of decimal places.");

		this.number = number;

	}

	/**
	 * Gets the Puma number.
	 * 
	 * @return the number.
	 */
	public Puma getNumber() {

		return number;

	}

}