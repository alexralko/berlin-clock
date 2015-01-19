package com.berlinclock.domain;

/**
 * Presentation of lamps row where every lamp define 5min interval 
 * Every 5 min defined by yellow lamp. Every 15 min intervals are marked by RED lamp
 * 
 * <br>
 * Example:
 * <ul>
 * <li> 00:00:00 -> 'OOOOOOOOOOO' </li>
 * <li> 00:01:00 -> 'OOOOOOOOOOO' </li>
 * <li> 00:05:00 -> 'YOOOOOOOOOO' </li>
 * <li> 00:47:00 -> 'YYRYYRYYROO' </li>
 * <li> 00:59:00 -> 'YYRYYRYYRYY' </li>
 * </ul>
 */
public class FiveMinutesRow implements LampsRow {

	@Override
	public String getLampsRow(TimeHolder time) {
		
		StringBuilder result = new StringBuilder(LAMPS_5MIN_OFF);
		int min = time.getMinutes();

		for (int i = 0; i < (min / 5); i++) {
			if ((i + 1) % 3 == 0) {
				result.replace(i, (i + 1), LAMP_RED);
			} else {
				result.replace(i, (i + 1), LAMP_YELLOW);
			}
		}
		
		return result.toString();
	}
}
