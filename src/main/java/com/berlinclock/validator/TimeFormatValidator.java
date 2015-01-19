package com.berlinclock.validator;

/**
 * Validate input time string
 *
 */
public interface TimeFormatValidator {

	/**
	 * Validate input text string 
	 * @param time - string presentation of time to validate
	 * @return true - if validation is successful<br> false - otherwise
	 */
	public boolean validate(String time);
	
}
