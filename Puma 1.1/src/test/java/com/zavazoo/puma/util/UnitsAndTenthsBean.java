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
 * Encapsulates a number of units and zero or more tenths.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
class UnitsAndTenthsBean {

	/** Switch used to indicate zero or more units. */
	private boolean unit;

	/** The units. */
	private char units;

	/** Switch used to indicate zero or more tenths. */
	private boolean tenth;

	/** The tenths. */
	private char tenths;

	/**
	 * Creates a UnitsAndTenthBean with the specified properties.
	 * 
	 * @param units
	 * @param tenth
	 * @param tenths
	 */
	UnitsAndTenthsBean(boolean unit, char units, boolean tenth, char tenths) {
		this.unit = unit;
		this.units = units;
		this.tenth = tenth;
		this.tenths = tenths;
	}

	/**
	 * Gets the unit property.
	 * 
	 * @return the unit property.
	 */
	boolean isUnit() {

		return unit;

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

	/**
	 * Gets the tenths property.
	 * 
	 * @return the tenths property.
	 */
	char getTenths() {

		return tenths;

	}

}