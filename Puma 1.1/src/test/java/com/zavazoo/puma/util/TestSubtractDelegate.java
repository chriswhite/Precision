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
 * Delegates between Puma numbers and the application on the subject of
 * subtraction using an alternative algorithm that is slower but guarantees
 * accuracy.
 * 
 * @author Chris White <chriswhitelondon@gmail.com>
 * @since JDK6
 */
public abstract class TestSubtractDelegate extends AbstractPumaProxy {

	/** The matrix of data used to perform subtractions. */
	private static Map<Character, Map<Character, UnitsAndTenthBean>> SUBTRACTION_MATRIX;

	static {

		SUBTRACTION_MATRIX = new HashMap<Character, Map<Character, UnitsAndTenthBean>>();

		Map<Character, UnitsAndTenthBean> entryZero = new HashMap<Character, UnitsAndTenthBean>();
		entryZero.put('0', new UnitsAndTenthBean('0', false));
		entryZero.put('1', new UnitsAndTenthBean('9', true));
		entryZero.put('2', new UnitsAndTenthBean('8', true));
		entryZero.put('3', new UnitsAndTenthBean('7', true));
		entryZero.put('4', new UnitsAndTenthBean('6', true));
		entryZero.put('5', new UnitsAndTenthBean('5', true));
		entryZero.put('6', new UnitsAndTenthBean('4', true));
		entryZero.put('7', new UnitsAndTenthBean('3', true));
		entryZero.put('8', new UnitsAndTenthBean('2', true));
		entryZero.put('9', new UnitsAndTenthBean('1', true));

		Map<Character, UnitsAndTenthBean> entryOne = new HashMap<Character, UnitsAndTenthBean>();
		entryOne.put('0', new UnitsAndTenthBean('1', false));
		entryOne.put('1', new UnitsAndTenthBean('0', false));
		entryOne.put('2', new UnitsAndTenthBean('9', true));
		entryOne.put('3', new UnitsAndTenthBean('8', true));
		entryOne.put('4', new UnitsAndTenthBean('7', true));
		entryOne.put('5', new UnitsAndTenthBean('6', true));
		entryOne.put('6', new UnitsAndTenthBean('5', true));
		entryOne.put('7', new UnitsAndTenthBean('4', true));
		entryOne.put('8', new UnitsAndTenthBean('3', true));
		entryOne.put('9', new UnitsAndTenthBean('2', true));

		Map<Character, UnitsAndTenthBean> entryTwo = new HashMap<Character, UnitsAndTenthBean>();
		entryTwo.put('0', new UnitsAndTenthBean('2', false));
		entryTwo.put('1', new UnitsAndTenthBean('1', false));
		entryTwo.put('2', new UnitsAndTenthBean('0', false));
		entryTwo.put('3', new UnitsAndTenthBean('9', true));
		entryTwo.put('4', new UnitsAndTenthBean('8', true));
		entryTwo.put('5', new UnitsAndTenthBean('7', true));
		entryTwo.put('6', new UnitsAndTenthBean('6', true));
		entryTwo.put('7', new UnitsAndTenthBean('5', true));
		entryTwo.put('8', new UnitsAndTenthBean('4', true));
		entryTwo.put('9', new UnitsAndTenthBean('3', true));

		Map<Character, UnitsAndTenthBean> entryThree = new HashMap<Character, UnitsAndTenthBean>();
		entryThree.put('0', new UnitsAndTenthBean('3', false));
		entryThree.put('1', new UnitsAndTenthBean('2', false));
		entryThree.put('2', new UnitsAndTenthBean('1', false));
		entryThree.put('3', new UnitsAndTenthBean('0', false));
		entryThree.put('4', new UnitsAndTenthBean('9', true));
		entryThree.put('5', new UnitsAndTenthBean('8', true));
		entryThree.put('6', new UnitsAndTenthBean('7', true));
		entryThree.put('7', new UnitsAndTenthBean('6', true));
		entryThree.put('8', new UnitsAndTenthBean('5', true));
		entryThree.put('9', new UnitsAndTenthBean('4', true));

		Map<Character, UnitsAndTenthBean> entryFour = new HashMap<Character, UnitsAndTenthBean>();
		entryFour.put('0', new UnitsAndTenthBean('4', false));
		entryFour.put('1', new UnitsAndTenthBean('3', false));
		entryFour.put('2', new UnitsAndTenthBean('2', false));
		entryFour.put('3', new UnitsAndTenthBean('1', false));
		entryFour.put('4', new UnitsAndTenthBean('0', false));
		entryFour.put('5', new UnitsAndTenthBean('9', true));
		entryFour.put('6', new UnitsAndTenthBean('8', true));
		entryFour.put('7', new UnitsAndTenthBean('7', true));
		entryFour.put('8', new UnitsAndTenthBean('6', true));
		entryFour.put('9', new UnitsAndTenthBean('5', true));

		Map<Character, UnitsAndTenthBean> entryFive = new HashMap<Character, UnitsAndTenthBean>();
		entryFive.put('0', new UnitsAndTenthBean('5', false));
		entryFive.put('1', new UnitsAndTenthBean('4', false));
		entryFive.put('2', new UnitsAndTenthBean('3', false));
		entryFive.put('3', new UnitsAndTenthBean('2', false));
		entryFive.put('4', new UnitsAndTenthBean('1', false));
		entryFive.put('5', new UnitsAndTenthBean('0', false));
		entryFive.put('6', new UnitsAndTenthBean('9', true));
		entryFive.put('7', new UnitsAndTenthBean('8', true));
		entryFive.put('8', new UnitsAndTenthBean('7', true));
		entryFive.put('9', new UnitsAndTenthBean('6', true));

		Map<Character, UnitsAndTenthBean> entrySix = new HashMap<Character, UnitsAndTenthBean>();
		entrySix.put('0', new UnitsAndTenthBean('6', false));
		entrySix.put('1', new UnitsAndTenthBean('5', false));
		entrySix.put('2', new UnitsAndTenthBean('4', false));
		entrySix.put('3', new UnitsAndTenthBean('3', false));
		entrySix.put('4', new UnitsAndTenthBean('2', false));
		entrySix.put('5', new UnitsAndTenthBean('1', false));
		entrySix.put('6', new UnitsAndTenthBean('0', false));
		entrySix.put('7', new UnitsAndTenthBean('9', true));
		entrySix.put('8', new UnitsAndTenthBean('8', true));
		entrySix.put('9', new UnitsAndTenthBean('7', true));

		Map<Character, UnitsAndTenthBean> entrySeven = new HashMap<Character, UnitsAndTenthBean>();
		entrySeven.put('0', new UnitsAndTenthBean('7', false));
		entrySeven.put('1', new UnitsAndTenthBean('6', false));
		entrySeven.put('2', new UnitsAndTenthBean('5', false));
		entrySeven.put('3', new UnitsAndTenthBean('4', false));
		entrySeven.put('4', new UnitsAndTenthBean('3', false));
		entrySeven.put('5', new UnitsAndTenthBean('2', false));
		entrySeven.put('6', new UnitsAndTenthBean('1', false));
		entrySeven.put('7', new UnitsAndTenthBean('0', false));
		entrySeven.put('8', new UnitsAndTenthBean('9', true));
		entrySeven.put('9', new UnitsAndTenthBean('8', true));

		Map<Character, UnitsAndTenthBean> entryEight = new HashMap<Character, UnitsAndTenthBean>();
		entryEight.put('0', new UnitsAndTenthBean('8', false));
		entryEight.put('1', new UnitsAndTenthBean('7', false));
		entryEight.put('2', new UnitsAndTenthBean('6', false));
		entryEight.put('3', new UnitsAndTenthBean('5', false));
		entryEight.put('4', new UnitsAndTenthBean('4', false));
		entryEight.put('5', new UnitsAndTenthBean('3', false));
		entryEight.put('6', new UnitsAndTenthBean('2', false));
		entryEight.put('7', new UnitsAndTenthBean('1', false));
		entryEight.put('8', new UnitsAndTenthBean('0', false));
		entryEight.put('9', new UnitsAndTenthBean('9', true));

		Map<Character, UnitsAndTenthBean> entryNine = new HashMap<Character, UnitsAndTenthBean>();
		entryNine.put('0', new UnitsAndTenthBean('9', false));
		entryNine.put('1', new UnitsAndTenthBean('8', false));
		entryNine.put('2', new UnitsAndTenthBean('7', false));
		entryNine.put('3', new UnitsAndTenthBean('6', false));
		entryNine.put('4', new UnitsAndTenthBean('5', false));
		entryNine.put('5', new UnitsAndTenthBean('4', false));
		entryNine.put('6', new UnitsAndTenthBean('3', false));
		entryNine.put('7', new UnitsAndTenthBean('2', false));
		entryNine.put('8', new UnitsAndTenthBean('1', false));
		entryNine.put('9', new UnitsAndTenthBean('0', false));

		SUBTRACTION_MATRIX.put('0', entryZero);
		SUBTRACTION_MATRIX.put('1', entryOne);
		SUBTRACTION_MATRIX.put('2', entryTwo);
		SUBTRACTION_MATRIX.put('3', entryThree);
		SUBTRACTION_MATRIX.put('4', entryFour);
		SUBTRACTION_MATRIX.put('5', entryFive);
		SUBTRACTION_MATRIX.put('6', entrySix);
		SUBTRACTION_MATRIX.put('7', entrySeven);
		SUBTRACTION_MATRIX.put('8', entryEight);
		SUBTRACTION_MATRIX.put('9', entryNine);

	}

	/**
	 * Subtracts the specified compared Puma number from the specified subject
	 * Puma number and yields a new Puma number that encapsulates the result. <br/>
	 * Both numbers must represent a value with a terminating decimal expansion;
	 * a finite number of decimal places, otherwise this method will yield an
	 * exception.
	 * 
	 * @param subject
	 *            the subject number.
	 * @param compared
	 *            the compared number.
	 * @return the result.
	 * @exception InfiniteDecimalPlacesException
	 *                if either number represents a value with infinite decimal
	 *                places.
	 */
	public static Puma subtract(Puma subject, Puma compared)
			throws InfiniteDecimalPlacesException {

		OperationTestBean subjectData = createOperationData(subject);
		OperationTestBean comparedData = createOperationData(compared);

		boolean subjectNegative = subjectData.isNegative();
		boolean comparedNegative = comparedData.isNegative();

		boolean subjectAndComparedNegative = false;

		if (subjectNegative && comparedNegative) {

			subjectAndComparedNegative = true;

		} else if (subjectNegative) {

			Puma subjectAbsoluteNumber = subject.absolute();
			Puma comparedAbsoluteNumber = compared.absolute();

			Puma addedNumber = TestAddDelegate.add(subjectAbsoluteNumber,
					comparedAbsoluteNumber);

			Puma subtractedNumber = addedNumber.negate();

			return subtractedNumber;

		} else if (comparedNegative) {

			Puma subjectAbsoluteNumber = subject.absolute();
			Puma comparedAbsoluteNumber = compared.absolute();

			return TestAddDelegate.add(subjectAbsoluteNumber,
					comparedAbsoluteNumber);

		}

		char[] subjectIntegerCharacters = subjectData.getInteger();
		char[] comparedIntegerCharacters = comparedData.getInteger();

		int subjectIntegerCharactersLength = subjectIntegerCharacters.length;
		int comparedIntegerCharactersLength = comparedIntegerCharacters.length;

		if (subjectIntegerCharactersLength > comparedIntegerCharactersLength) {

			comparedIntegerCharacters = TestArrayUtils
					.extendCharacterArrayCapacityAtStart(
							comparedIntegerCharacters,
							subjectIntegerCharactersLength, '0');

		} else if (comparedIntegerCharactersLength > subjectIntegerCharactersLength) {

			subjectIntegerCharacters = TestArrayUtils
					.extendCharacterArrayCapacityAtStart(
							subjectIntegerCharacters,
							comparedIntegerCharactersLength, '0');

		}

		char[] subjectFractionalCharacters = subjectData.getFractional();
		char[] comparedFractionalCharacters = comparedData.getFractional();

		if (subjectFractionalCharacters == null) {

			subjectFractionalCharacters = new char[0];

		}

		if (comparedFractionalCharacters == null) {

			comparedFractionalCharacters = new char[0];

		}

		int subjectFractionalCharactersLength = subjectFractionalCharacters.length;
		int comparedFractionalCharactersLength = comparedFractionalCharacters.length;

		if (subjectFractionalCharactersLength > comparedFractionalCharactersLength) {

			comparedFractionalCharacters = TestArrayUtils
					.extendCharacterArrayCapacity(comparedFractionalCharacters,
							subjectFractionalCharactersLength, '0');

		} else if (comparedFractionalCharactersLength > subjectFractionalCharactersLength) {

			subjectFractionalCharacters = TestArrayUtils
					.extendCharacterArrayCapacity(subjectFractionalCharacters,
							comparedFractionalCharactersLength, '0');

		}

		char[] subjectCharacters = TestArrayUtils.joinCharacterArrays(
				subjectIntegerCharacters, subjectFractionalCharacters);
		char[] comparedCharacters = TestArrayUtils.joinCharacterArrays(
				comparedIntegerCharacters, comparedFractionalCharacters);

		boolean comparedGreaterThanSubject = false;

		Puma subjectNumber = new Puma(subjectCharacters);

		Puma comparedNumber = new Puma(comparedCharacters);

		if (comparedNumber.greaterThan(subjectNumber)) {

			comparedGreaterThanSubject = true;

			char[] temporarySubjectCharacters = subjectCharacters;
			subjectCharacters = comparedCharacters;
			comparedCharacters = temporarySubjectCharacters;

		}

		char[] reversedSubjectCharacters = TestArrayUtils
				.copyAndReverseCharacterArray(subjectCharacters);
		char[] reversedComparedCharacters = TestArrayUtils
				.copyAndReverseCharacterArray(comparedCharacters);

		char[] reversedSubtractedCharacters = subtractReversedRecursively(
				reversedSubjectCharacters, reversedComparedCharacters);

		subjectFractionalCharactersLength = subjectFractionalCharacters.length;

		char[] reversedSubtractedFractionalCharacters = new char[subjectFractionalCharactersLength];

		for (int index = 0; index < subjectFractionalCharactersLength; index++) {

			reversedSubtractedFractionalCharacters[index] = reversedSubtractedCharacters[index];

		}

		int reversedSubtractedCharactersLength = reversedSubtractedCharacters.length;

		char[] reversedSubtractedIntegerCharacters = new char[reversedSubtractedCharactersLength
				- subjectFractionalCharactersLength];

		for (int subtractedIndex = subjectFractionalCharactersLength, subtractedIntegerIndex = 0; subtractedIndex < reversedSubtractedCharactersLength; subtractedIndex++, subtractedIntegerIndex++) {

			reversedSubtractedIntegerCharacters[subtractedIntegerIndex] = reversedSubtractedCharacters[subtractedIndex];

		}

		TestArrayUtils
				.reverseCharacterArray(reversedSubtractedIntegerCharacters);
		TestArrayUtils
				.reverseCharacterArray(reversedSubtractedFractionalCharacters);

		char[] subtractedIntegerCharacters = reversedSubtractedIntegerCharacters;
		char[] subtractedFractionalCharacters = reversedSubtractedFractionalCharacters;

		boolean negative = subjectAndComparedNegative;

		if (comparedGreaterThanSubject) {

			negative = !negative;

		}

		Puma subtractedNumber = createPuma(new OperationTestBean(
				subtractedIntegerCharacters, subtractedFractionalCharacters,
				negative));

		return subtractedNumber;

	}

	/**
	 * Recursively subtracts the Puma number represented by the specified
	 * reversed compared array of characters from the Puma number represented by
	 * the specified reversed subject array of characters and yields a new
	 * reversed array of characters that encapsulates the result.
	 * 
	 * @param reversedSubjectCharacters
	 *            the reversed subject characters.
	 * @param reversedComparedCharacters
	 *            the reversed compared characters.
	 * @return the reversed result.
	 */
	private static char[] subtractReversedRecursively(
			char[] reversedSubjectCharacters, char[] reversedComparedCharacters) {

		int reversedSubjectCharactersLength = reversedSubjectCharacters.length;
		int reversedComparedCharactersLength = reversedComparedCharacters.length;

		char[] reversedSubtractedCharacters = new char[reversedSubjectCharactersLength];

		for (int index = 0; index < reversedSubjectCharactersLength; index++) {

			char subjectCharacter = reversedSubjectCharacters[index];
			char comparedCharacter = '0';

			if (index < reversedComparedCharactersLength) {

				comparedCharacter = reversedComparedCharacters[index];

			}

			UnitsAndTenthBean unitsAndTenth = SUBTRACTION_MATRIX.get(
					subjectCharacter).get(comparedCharacter);

			char units = unitsAndTenth.getUnits();
			boolean tenth = unitsAndTenth.isTenth();

			reversedSubtractedCharacters[index] = units;

			if (tenth) {

				char[] reversedTenthCharacters = new char[] { '1' };

				int reversedTenthCharactersLength = index + 2;

				reversedTenthCharacters = TestArrayUtils
						.extendCharacterArrayCapacityAtStart(
								reversedTenthCharacters,
								reversedTenthCharactersLength, '0');

				reversedSubjectCharacters = subtractReversedRecursively(
						reversedSubjectCharacters, reversedTenthCharacters);

				reversedSubjectCharactersLength = reversedSubjectCharacters.length;

				reversedSubtractedCharacters = TestArrayUtils
						.extendCharacterArrayCapacity(
								reversedSubtractedCharacters,
								reversedSubjectCharactersLength, '0');

			}

		}

		return reversedSubtractedCharacters;

	}

}