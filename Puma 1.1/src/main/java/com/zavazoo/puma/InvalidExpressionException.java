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
 * Exception used to indicate that a Puma expression is not valid.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public class InvalidExpressionException extends Exception {

	/** The serialization version unique identifier. */
	private static final long serialVersionUID = 1l;

	/** The invalid Puma expression. */
	private String expression;

	/**
	 * Creates an invalid expression exception using the specified error message
	 * and the invalid Puma expression.
	 * 
	 * @param message
	 *            the message.
	 * @param expression
	 *            the expression.
	 */
	InvalidExpressionException(String message, String expression) {

		super(message);

		this.expression = expression;

	}

	/**
	 * Gets the invalid Puma expression.
	 * 
	 * @return the expression.
	 */
	public String getExpression() {

		return expression;

	}

}