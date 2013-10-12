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

import java.util.Map;

/**
 * Provides utilities which operate on arrays used for testing.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
abstract class TestArrayUtils {

	/**
	 * Reverses the specified array of characters.
	 * 
	 * @param characters
	 *            the characters.
	 */
	static void reverseCharacterArray(char[] characters) {

		for (int leftIndex = 0, rightIndex = characters.length - 1; leftIndex < rightIndex; leftIndex++, rightIndex--) {

			char character = characters[leftIndex];

			characters[leftIndex] = characters[rightIndex];

			characters[rightIndex] = character;

		}

	}

	/**
	 * Makes a reverse copy of the specified array of characters.
	 * 
	 * @param characters
	 *            the characters.
	 * @return the reversed characters.
	 */
	static char[] copyAndReverseCharacterArray(char[] characters) {

		int charactersLength = characters.length;

		char[] reversed = new char[charactersLength];

		for (int reversedIndex = 0, charactersIndex = charactersLength - 1; reversedIndex < charactersLength; reversedIndex++, charactersIndex--) {

			reversed[reversedIndex] = characters[charactersIndex];

		}

		return reversed;

	}

	/**
	 * Joins the specified arrays of characters by appending the specified
	 * second array of characters to the end of the specified first array of
	 * characters.
	 * 
	 * @param first
	 *            the first characters.
	 * @param second
	 *            the second characters.
	 * @return the joined array.
	 */
	static char[] joinCharacterArrays(char[] first, char[] second) {

		int firstLength = first.length;
		int secondLength = second.length;

		char[] joined = new char[firstLength + secondLength];

		for (int index = 0; index < firstLength; index++) {

			joined[index] = first[index];

		}

		for (int secondIndex = 0, joinedIndex = firstLength; secondIndex < secondLength; secondIndex++, joinedIndex++) {

			joined[joinedIndex] = second[secondIndex];

		}

		return joined;

	}

	/**
	 * Extends the capacity of the specified array of characters by one at the
	 * beginning of the array.
	 * 
	 * @param characters
	 *            the characters.
	 * @return the extended array.
	 */
	static char[] incrementCharacterArrayCapacityAtStart(char[] characters) {

		int length = characters.length;

		char[] extended = new char[length + 1];

		for (int charactersIndex = 0, extendedIndex = 1; charactersIndex < length; charactersIndex++, extendedIndex++) {

			extended[extendedIndex] = characters[charactersIndex];

		}

		return extended;

	}

	/**
	 * Extends the capacity of the specified array of characters to the
	 * specified length at the end of the array and fills the new array elements
	 * with the specified character.
	 * 
	 * @param characters
	 *            the characters.
	 * @param length
	 *            the extended length.
	 * @param character
	 *            the fill character.
	 * @return the extended array.
	 */
	static char[] extendCharacterArrayCapacity(char[] characters, int length,
			char character) {

		int charactersLength = characters.length;

		char[] extended = new char[length];

		for (int index = 0; index < charactersLength; index++) {

			extended[index] = characters[index];

		}

		for (int index = charactersLength; index < length; index++) {

			extended[index] = character;

		}

		return extended;

	}

	/**
	 * Extends the capacity of the specified array of characters to the
	 * specified length at the beginning of the array and fills the new array
	 * elements with the specified character.
	 * 
	 * @param characters
	 *            the characters.
	 * @param length
	 *            the extended length.
	 * @param character
	 *            the fill character.
	 * @return the extended array.
	 */
	static char[] extendCharacterArrayCapacityAtStart(char[] characters,
			int length, char character) {

		int charactersLength = characters.length;

		char[] extended = new char[length];

		int offset = length - charactersLength;

		for (int charactersIndex = 0, extendedIndex = offset; charactersIndex < charactersLength; charactersIndex++, extendedIndex++) {

			extended[extendedIndex] = characters[charactersIndex];

		}

		for (int index = 0; index < offset; index++) {

			extended[index] = character;

		}

		return extended;

	}

	/**
	 * Reduces the capacity of the specified array of characters by one at the
	 * end of the array.
	 * 
	 * @param characters
	 *            the characters.
	 * @return the reduced array.
	 */
	static char[] decrementCharacterArrayCapacity(char[] characters) {

		int reducedLength = characters.length - 1;

		char[] reduced = new char[reducedLength];

		for (int index = 0; index < reducedLength; index++) {

			reduced[index] = characters[index];

		}

		return reduced;

	}

	/**
	 * Reduces the capacity of the specified array of characters by one at the
	 * beginning of the array.
	 * 
	 * @param characters
	 *            the characters.
	 * @return the reduced array.
	 */
	static char[] decrementCharacterArrayCapacityAtStart(char[] characters) {

		int charactersLength = characters.length;

		int reducedLength = charactersLength - 1;

		char[] reduced = new char[reducedLength];

		for (int charactersIndex = 1, reducedIndex = 0; charactersIndex < charactersLength; charactersIndex++, reducedIndex++) {

			reduced[reducedIndex] = characters[charactersIndex];

		}

		return reduced;

	}

	/**
	 * Asserts that the specified first array of characters is identical to the
	 * specified second array of characters.
	 * 
	 * @param first
	 *            the first characters.
	 * @param second
	 *            the second characters.
	 * @return true if the arrays are equal, false otherwise.
	 */
	static boolean assertCharacterArraysEqual(char[] first, char[] second) {

		int firstLength = first.length;
		int secondLength = second.length;

		if (firstLength != secondLength) {

			return false;

		}

		for (int index = 0; index < firstLength; index++) {

			char firstCharacter = first[index];
			char secondCharacter = second[index];

			if (firstCharacter != secondCharacter) {

				return false;

			}

		}

		return true;

	}

	/**
	 * Replaces each instance of any character in the specified map with its
	 * corresponding replacement character in a new array of characters that is
	 * otherwise equivalent to the specified array of characters.
	 * 
	 * @param characters
	 *            the characters.
	 * @param replacements
	 *            the character map.
	 * @return the array with replacements.
	 */
	static char[] replaceCharactersInArray(char[] characters,
			Map<Character, Character> replacements) {

		int charactersLength = characters.length;

		char[] replaced = new char[charactersLength];

		for (int index = 0; index < charactersLength; index++) {

			char character = characters[index];

			Character replacement = replacements.get(character);

			if (replacement == null) {

				replaced[index] = character;

			} else {

				replaced[index] = replacement;

			}

		}

		return replaced;

	}

}