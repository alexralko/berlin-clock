package com.berlinclock.domain;

/**
 * Presentation of lamps row where every lamp define 1hr interval (within 4 hr interval)
 * <br>
 * Example:
 * <ul>
 * <li> 00:00:00 -> 'OOOO' </li>
 * <li> 17:32:16 -> 'RRRO' </li>
 * <li> 24:00:00 -> 'RRRR' </li>
 * </ul>
 */
public class OneHourRow implements LampsRow {

	@Override
	public String getLampsRow(TimeHolder time) {
		
		StringBuilder result = new StringBuilder(LAMPS_1HR_OFF);
		int hr = time.getHours();

	    for (int i = 0; i < (hr % 5); i++) {
	    	result.replace(i, (i + 1), LAMP_RED);
	    }
	    
	    return result.toString();
	}
}
