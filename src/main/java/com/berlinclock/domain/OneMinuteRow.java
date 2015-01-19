package com.berlinclock.domain;

/**
 * Presentation of lamps row where every lamp define 1min interval (within 5 min interval)
 * <br>
 * Example:
 * <ul>
 * <li> 00:00:00 -> 'OOOO' </li>
 * <li> 17:32:16 -> 'RRRO' </li>
 * <li> 24:00:00 -> 'RRRR' </li>
 * </ul>
 */
public class OneMinuteRow implements LampsRow {

	@Override
	public String getLampsRow(TimeHolder time) {
		
		StringBuilder result = new StringBuilder(LAMPS_1MIN_OFF);
		int min = time.getMinutes();

	    for (int i = 0; i < (min % 5); i++) {
	    	result.replace(i, (i + 1), LAMP_YELLOW);
	    }
	    
	    return result.toString();
	}
}
