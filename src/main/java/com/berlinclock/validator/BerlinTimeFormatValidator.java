package com.berlinclock.validator;

import static com.google.common.base.Preconditions.checkArgument;
import java.util.regex.Pattern;

/**
 * Class to validate input time string against the set of patterns 
 *
 */
public class BerlinTimeFormatValidator implements TimeFormatValidator {

	private static final Pattern PATTERN_24H_TIME = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
	private static final Pattern PATTERN_MIDNIGHT = Pattern.compile("24:00:[0-5][0-9]");
	
	@Override
	public boolean validate(String time) {
		checkArgument(time != null, "Provided time is null");
		checkArgument(time.length() != 0, "Provided time string is empty");
		
		if(PATTERN_24H_TIME.matcher(time).matches()) {
			return true;
		}
		
		if(PATTERN_MIDNIGHT.matcher(time).matches()) {
			return true;
		}
		
		return false;
		
	}
}
