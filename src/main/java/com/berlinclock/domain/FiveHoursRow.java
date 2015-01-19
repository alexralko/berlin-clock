package com.berlinclock.domain;

/**
 * Presentation of lamps row where every lamp define 5hr interval 
 * <br>
 * Example:
 * <ul>
 * <li> 03:00:00 -> 'OOOO' </li>
 * <li> 06:00:00 -> 'ROOO' </li>
 * <li> 10:00:00 -> 'RROO' </li>
 * <li> 15:00:00 -> 'RRRO' </li>
 * <li> 21:00:00 -> 'RRRR' </li>
 * </ul>
 */
public class FiveHoursRow implements LampsRow {

	@Override
	public String getLampsRow(TimeHolder timeContainer) {
		
		StringBuilder result = new StringBuilder(LAMPS_5HR_OFF);
		int hr = timeContainer.getHours();
		
		for (int i = 0; i < (hr / 5); i++) {
			result.replace(i, (i + 1), LAMP_RED);
		}
		
	    return result.toString();
	}
}
