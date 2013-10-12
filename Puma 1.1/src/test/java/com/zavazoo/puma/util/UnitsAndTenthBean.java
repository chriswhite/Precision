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
 * Encapsulates a number of units and one or zero tenths.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
class UnitsAndTenthBean {

	/** The units. */
	private char units;

	/** Switch used to indicate one tenth. */
	private boolean tenth;

	/**
	 * Creates a UnitsAndTenthBean with the specified properties.
	 * 
	 * @param units
	 * @param tenth
	 */
	UnitsAndTenthBean(char units, boolean tenth) {
		this.units = units;
		this.tenth = tenth;
	}

	/**
	 * Gets the units property.
	 * 
	 * @return the units property.
	 */
	char getUnits() {

		return units;

	}

	/**
	 * Gets the tenth property.
	 * 
	 * @return the tenth property.
	 */
	boolean isTenth() {

		return tenth;

	}

}