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

import java.util.HashMap;
import java.util.Map;

import com.zavazoo.puma.InfiniteDecimalPlacesException;
import com.zavazoo.puma.Puma;

/**
 * Delegates between Puma numbers and the application on the subject of addition
 * using an alternative algorithm that is slower but guarantees accuracy.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public abstract class TestAddDelegate extends AbstractPumaProxy {

	/** The matrix of data used to perform additions. */
	private static Map<Character, Map<Character, UnitsAndTenthBean>> ADDITION_MATRIX;

	static {

		ADDITION_MATRIX = new HashMap<Character, Map<Character, UnitsAndTenthBean>>();

		Map<Character, UnitsAndTenthBean> entryZero = new HashMap<Character, UnitsAndTenthBean>();
		entryZero.put('0', new UnitsAndTenthBean('0', false));
		entryZero.put('1', new UnitsAndTenthBean('1', false));
		entryZero.put('2', new UnitsAndTenthBean('2', false));
		entryZero.put('3', new UnitsAndTenthBean('3', false));
		entryZero.put('4', new UnitsAndTenthBean('4', false));
		entryZero.put('5', new UnitsAndTenthBean('5', false));
		entryZero.put('6', new UnitsAndTenthBean('6', false));
		entryZero.put('7', new UnitsAndTenthBean('7', false));
		entryZero.put('8', new UnitsAndTenthBean('8', false));
		entryZero.put('9', new UnitsAndTenthBean('9', false));

		Map<Character, UnitsAndTenthBean> entryOne = new HashMap<Character, UnitsAndTenthBean>();
		entryOne.put('0', new UnitsAndTenthBean('1', false));
		entryOne.put('1', new UnitsAndTenthBean('2', false));
		entryOne.put('2', new UnitsAndTenthBean('3', false));
		entryOne.put('3', new UnitsAndTenthBean('4', false));
		entryOne.put('4', new UnitsAndTenthBean('5', false));
		entryOne.put('5', new UnitsAndTenthBean('6', false));
		entryOne.put('6', new UnitsAndTenthBean('7', false));
		entryOne.put('7', new UnitsAndTenthBean('8', false));
		entryOne.put('8', new UnitsAndTenthBean('9', false));
		entryOne.put('9', new UnitsAndTenthBean('0', true));

		Map<Character, UnitsAndTenthBean> entryTwo = new HashMap<Character, UnitsAndTenthBean>();
		entryTwo.put('0', new UnitsAndTenthBean('2', false));
		entryTwo.put('1', new UnitsAndTenthBean('3', false));
		entryTwo.put('2', new UnitsAndTenthBean('4', false));
		entryTwo.put('3', new UnitsAndTenthBean('5', false));
		entryTwo.put('4', new UnitsAndTenthBean('6', false));
		entryTwo.put('5', new UnitsAndTenthBean('7', false));
		entryTwo.put('6', new UnitsAndTenthBean('8', false));
		entryTwo.put('7', new UnitsAndTenthBean('9', false));
		entryTwo.put('8', new UnitsAndTenthBean('0', true));
		entryTwo.put('9', new UnitsAndTenthBean('1', true));

		Map<Character, UnitsAndTenthBean> entryThree = new HashMap<Character, UnitsAndTenthBean>();
		entryThree.put('0', new UnitsAndTenthBean('3', false));
		entryThree.put('1', new UnitsAndTenthBean('4', false));
		entryThree.put('2', new UnitsAndTenthBean('5', false));
		entryThree.put('3', new UnitsAndTenthBean('6', false));
		entryThree.put('4', new UnitsAndTenthBean('7', false));
		entryThree.put('5', new UnitsAndTenthBean('8', false));
		entryThree.put('6', new UnitsAndTenthBean('9', false));
		entryThree.put('7', new UnitsAndTenthBean('0', true));
		entryThree.put('8', new UnitsAndTenthBean('1', true));
		entryThree.put('9', new UnitsAndTenthBean('2', true));

		Map<Character, UnitsAndTenthBean> entryFour = new HashMap<Character, UnitsAndTenthBean>();
		entryFour.put('0', new UnitsAndTenthBean('4', false));
		entryFour.put('1', new UnitsAndTenthBean('5', false));
		entryFour.put('2', new UnitsAndTenthBean('6', false));
		entryFour.put('3', new UnitsAndTenthBean('7', false));
		entryFour.put('4', new UnitsAndTenthBean('8', false));
		entryFour.put('5', new UnitsAndTenthBean('9', false));
		entryFour.put('6', new UnitsAndTenthBean('0', true));
		entryFour.put('7', new UnitsAndTenthBean('1', true));
		entryFour.put('8', new UnitsAndTenthBean('2', true));
		entryFour.put('9', new UnitsAndTenthBean('3', true));

		Map<Character, UnitsAndTenthBean> entryFive = new HashMap<Character, UnitsAndTenthBean>();
		entryFive.put('0', new UnitsAndTenthBean('5', false));
		entryFive.put('1', new UnitsAndTenthBean('6', false));
		entryFive.put('2', new UnitsAndTenthBean('7', false));
		entryFive.put('3', new UnitsAndTenthBean('8', false));
		entryFive.put('4', new UnitsAndTenthBean('9', false));
		entryFive.put('5', new UnitsAndTenthBean('0', true));
		entryFive.put('6', new UnitsAndTenthBean('1', true));
		entryFive.put('7', new UnitsAndTenthBean('2', true));
		entryFive.put('8', new UnitsAndTenthBean('3', true));
		entryFive.put('9', new UnitsAndTenthBean('4', true));

		Map<Character, UnitsAndTenthBean> entrySix = new HashMap<Character, UnitsAndTenthBean>();
		entrySix.put('0', new UnitsAndTenthBean('6', false));
		entrySix.put('1', new UnitsAndTenthBean('7', false));
		entrySix.put('2', new UnitsAndTenthBean('8', false));
		entrySix.put('3', new UnitsAndTenthBean('9', false));
		entrySix.put('4', new UnitsAndTenthBean('0', true));
		entrySix.put('5', new UnitsAndTenthBean('1', true));
		entrySix.put('6', new UnitsAndTenthBean('2', true));
		entrySix.put('7', new UnitsAndTenthBean('3', true));
		entrySix.put('8', new UnitsAndTenthBean('4', true));
		entrySix.put('9', new UnitsAndTenthBean('5', true));

		Map<Character, UnitsAndTenthBean> entrySeven = new HashMap<Character, UnitsAndTenthBean>();
		entrySeven.put('0', new UnitsAndTenthBean('7', false));
		entrySeven.put('1', new UnitsAndTenthBean('8', false));
		entrySeven.put('2', new UnitsAndTenthBean('9', false));
		entrySeven.put('3', new UnitsAndTenthBean('0', true));
		entrySeven.put('4', new UnitsAndTenthBean('1', true));
		entrySeven.put('5', new UnitsAndTenthBean('2', true));
		entrySeven.put('6', new UnitsAndTenthBean('3', true));
		entrySeven.put('7', new UnitsAndTenthBean('4', true));
		entrySeven.put('8', new UnitsAndTenthBean('5', true));
		entrySeven.put('9', new UnitsAndTenthBean('6', true));

		Map<Character, UnitsAndTenthBean> entryEight = new HashMap<Character, UnitsAndTenthBean>();
		entryEight.put('0', new UnitsAndTenthBean('8', false));
		entryEight.put('1', new UnitsAndTenthBean('9', false));
		entryEight.put('2', new UnitsAndTenthBean('0', true));
		entryEight.put('3', new UnitsAndTenthBean('1', true));
		entryEight.put('4', new UnitsAndTenthBean('2', true));
		entryEight.put('5', new UnitsAndTenthBean('3', true));
		entryEight.put('6', new UnitsAndTenthBean('4', true));
		entryEight.put('7', new UnitsAndTenthBean('5', true));
		entryEight.put('8', new UnitsAndTenthBean('6', true));
		entryEight.put('9', new UnitsAndTenthBean('7', true));

		Map<Character, UnitsAndTenthBean> entryNine = new HashMap<Character, UnitsAndTenthBean>();
		entryNine.put('0', new UnitsAndTenthBean('9', false));
		entryNine.put('1', new UnitsAndTenthBean('0', true));
		entryNine.put('2', new UnitsAndTenthBean('1', true));
		entryNine.put('3', new UnitsAndTenthBean('2', true));
		entryNine.put('4', new UnitsAndTenthBean('3', true));
		entryNine.put('5', new UnitsAndTenthBean('4', true));
		entryNine.put('6', new UnitsAndTenthBean('5', true));
		entryNine.put('7', new UnitsAndTenthBean('6', true));
		entryNine.put('8', new UnitsAndTenthBean('7', true));
		entryNine.put('9', new UnitsAndTenthBean('8', true));

		ADDITION_MATRIX.put('0', entryZero);
		ADDITION_MATRIX.put('1', entryOne);
		ADDITION_MATRIX.put('2', entryTwo);
		ADDITION_MATRIX.put('3', entryThree);
		ADDITION_MATRIX.put('4', entryFour);
		ADDITION_MATRIX.put('5', entryFive);
		ADDITION_MATRIX.put('6', entrySix);
		ADDITION_MATRIX.put('7', entrySeven);
		ADDITION_MATRIX.put('8', entryEight);
		ADDITION_MATRIX.put('9', entryNine);

	}

	/**
	 * Adds the specified subject Puma number to the specified candidate Puma
	 * number and yields a new Puma number that encapsulates the result. <br/>
	 * Both numbers must represent a value with a terminating decimal expansion;
	 * a finite number of decimal places, otherwise this method will yield an
	 * exception.
	 * 
	 * @param subject
	 *            the subject number.
	 * @param candidate
	 *            the candidate number.
	 * @return the result.
	 * @exception InfiniteDecimalPlacesException
	 *                if either number represents a value with infinite decimal
	 *                places.
	 */
	public static Puma add(Puma subject, Puma candidate)
			throws InfiniteDecimalPlacesException {

		OperationTestBean subjectData = createOperationData(subject);
		OperationTestBean candidateData = createOperationData(candidate);

		boolean subjectNegative = subjectData.isNegative();
		boolean candidateNegative = candidateData.isNegative();

		boolean subjectAndCandidateNegative = false;

		if (subjectNegative && candidateNegative) {

			subjectAndCandidateNegative = true;

		} else if (subjectNegative) {

			Puma subjectAbsoluteNumber = subject.absolute();
			Puma candidateAbsoluteNumber = candidate.absolute();

			return TestSubtractDelegate.subtract(candidateAbsoluteNumber,
					subjectAbsoluteNumber);

		} else if (candidateNegative) {

			Puma subjectAbsoluteNumber = subject.absolute();
			Puma candidateAbsoluteNumber = candidate.absolute();

			return TestSubtractDelegate.subtract(subjectAbsoluteNumber,
					candidateAbsoluteNumber);

		}

		char[] subjectIntegerCharacters = subjectData.getInteger();
		char[] candidateIntegerCharacters = candidateData.getInteger();

		int subjectIntegerCharactersLength = subjectIntegerCharacters.length;
		int candidateIntegerCharactersLength = candidateIntegerCharacters.length;

		if (subjectIntegerCharactersLength > candidateIntegerCharactersLength) {

			candidateIntegerCharacters = TestArrayUtils
					.extendCharacterArrayCapacityAtStart(
							candidateIntegerCharacters,
							subjectIntegerCharactersLength, '0');

		} else if (candidateIntegerCharactersLength > subjectIntegerCharactersLength) {

			subjectIntegerCharacters = TestArrayUtils
					.extendCharacterArrayCapacityAtStart(
							subjectIntegerCharacters,
							candidateIntegerCharactersLength, '0');

		}

		char[] subjectFractionalCharacters = subjectData.getFractional();
		char[] candidateFractionalCharacters = candidateData.getFractional();

		if (subjectFractionalCharacters == null) {

			subjectFractionalCharacters = new char[0];

		}

		if (candidateFractionalCharacters == null) {

			candidateFractionalCharacters = new char[0];

		}

		int subjectFractionalCharactersLength = subjectFractionalCharacters.length;
		int candidateFractionalCharactersLength = candidateFractionalCharacters.length;

		if (subjectFractionalCharactersLength > candidateFractionalCharactersLength) {

			candidateFractionalCharacters = TestArrayUtils
					.extendCharacterArrayCapacity(
							candidateFractionalCharacters,
							subjectFractionalCharactersLength, '0');

		} else if (candidateFractionalCharactersLength > subjectFractionalCharactersLength) {

			subjectFractionalCharacters = TestArrayUtils
					.extendCharacterArrayCapacity(subjectFractionalCharacters,
							candidateFractionalCharactersLength, '0');

		}

		char[] subjectCharacters = TestArrayUtils.joinCharacterArrays(
				subjectIntegerCharacters, subjectFractionalCharacters);
		char[] candidateCharacters = TestArrayUtils.joinCharacterArrays(
				candidateIntegerCharacters, candidateFractionalCharacters);

		char[] reversedSubjectCharacters = TestArrayUtils
				.copyAndReverseCharacterArray(subjectCharacters);
		char[] reversedCandidateCharacters = TestArrayUtils
				.copyAndReverseCharacterArray(candidateCharacters);

		char[] reversedAddedCharacters = addReversedRecursively(
				reversedSubjectCharacters, reversedCandidateCharacters);

		subjectFractionalCharactersLength = subjectFractionalCharacters.length;

		char[] reversedAddedFractionalCharacters = new char[subjectFractionalCharactersLength];

		for (int index = 0; index < subjectFractionalCharactersLength; index++) {

			reversedAddedFractionalCharacters[index] = reversedAddedCharacters[index];

		}

		int reversedAddedCharactersLength = reversedAddedCharacters.length;

		char[] reversedAddedIntegerCharacters = new char[reversedAddedCharactersLength
				- subjectFractionalCharactersLength];

		for (int addedIndex = subjectFractionalCharactersLength, addedIntegerIndex = 0; addedIndex < reversedAddedCharactersLength; addedIndex++, addedIntegerIndex++) {

			reversedAddedIntegerCharacters[addedIntegerIndex] = reversedAddedCharacters[addedIndex];

		}

		TestArrayUtils.reverseCharacterArray(reversedAddedIntegerCharacters);
		TestArrayUtils.reverseCharacterArray(reversedAddedFractionalCharacters);

		char[] addedIntegerCharacters = reversedAddedIntegerCharacters;
		char[] addedFractionalCharacters = reversedAddedFractionalCharacters;

		Puma addedNumber = createPuma(new OperationTestBean(
				addedIntegerCharacters, addedFractionalCharacters,
				subjectAndCandidateNegative));

		return addedNumber;

	}

	/**
	 * Recursively adds the Puma number represented by the specified reversed
	 * longer array of characters to the Puma number represented by the
	 * specified reversed shorter array of characters and yields a new reversed
	 * array of characters that encapsulates the result.
	 * 
	 * @param reversedLongerCharacters
	 *            the reversed longer characters.
	 * @param reversedShorterCharacters
	 *            the reversed shorter characters.
	 * @return the reversed result.
	 */
	static char[] addReversedRecursively(char[] reversedLongerCharacters,
			char[] reversedShorterCharacters) {

		int reversedLongerCharactersLength = reversedLongerCharacters.length;
		int reversedShorterCharactersLength = reversedShorterCharacters.length;

		char[] reversedAddedCharacters = new char[reversedLongerCharactersLength];

		for (int index = 0; index < reversedLongerCharactersLength; index++) {

			char longerCharacter = reversedLongerCharacters[index];
			char shorterCharacter = '0';

			if (index < reversedShorterCharactersLength) {

				shorterCharacter = reversedShorterCharacters[index];

			}

			UnitsAndTenthBean unitsAndTenth = ADDITION_MATRIX.get(
					longerCharacter).get(shorterCharacter);

			char units = unitsAndTenth.getUnits();
			boolean tenth = unitsAndTenth.isTenth();

			reversedAddedCharacters[index] = units;

			if (tenth) {

				char[] reversedTenthCharacters = new char[] { '1' };

				int reversedTenthCharactersLength = index + 2;

				reversedTenthCharacters = TestArrayUtils
						.extendCharacterArrayCapacityAtStart(
								reversedTenthCharacters,
								reversedTenthCharactersLength, '0');

				if (reversedTenthCharactersLength > reversedLongerCharactersLength) {

					reversedLongerCharacters = addReversedRecursively(
							reversedTenthCharacters, reversedLongerCharacters);

				} else {

					reversedLongerCharacters = addReversedRecursively(
							reversedLongerCharacters, reversedTenthCharacters);

				}

				reversedLongerCharactersLength = reversedLongerCharacters.length;

				reversedAddedCharacters = TestArrayUtils
						.extendCharacterArrayCapacity(reversedAddedCharacters,
								reversedLongerCharactersLength, '0');

			}

		}

		return reversedAddedCharacters;

	}

}