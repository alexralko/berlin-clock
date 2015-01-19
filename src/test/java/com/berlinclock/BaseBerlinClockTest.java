package com.berlinclock;

import com.berlinclock.domain.TimeHolder;
import com.berlinclock.validator.BerlinTimeFormatValidator;
import com.berlinclock.validator.TimeFormatValidator;

/**
 * Base test class with number of helpful methods
 *
 */
public class BaseBerlinClockTest {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	/**
	 * Return TimeHolder object based on provided time string with predefined BerlinTimeFormatValidator
	 * @param time - time string
	 * @return initialized TimeHolder object
	 * @throws Exception
	 */
	public static TimeHolder getTime(String time) throws Exception {
		return getTime(time, new BerlinTimeFormatValidator());
	}
	
	/**
	 * Return TimeHolder object based on provided time string and provided validator mock implementation
	 * @param time - time string
	 * @param validator - time format validator
	 * @return initialized TimeHolder object
	 * @throws Exception
	 */
	public static TimeHolder getTime(String time, TimeFormatValidator validator) throws Exception {
		TimeHolder timeContainer = new TimeHolder(time, validator);
		return timeContainer;
	}
	
	/**
	 * Return number of rows in string
	 * @param string - string to calculate number of rows
	 * @return number of rows<br> 0 - if string is empty
	 */
	public static int getNumberOfRowsInString(String string) {
		return !string.isEmpty() ? string.split(LINE_SEPARATOR).length : 0;
	}
	
}
