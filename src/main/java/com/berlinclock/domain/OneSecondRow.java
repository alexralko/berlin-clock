package com.berlinclock.domain;

/**
 * Represents lamp state for '1 sec'
 * <br>
 * Example:
 * <ul>
 * <li> 00:00:00 -> 'Y' </li>
 * <li> 00:00:01 -> 'O' </li>
 * </ul>
 */
public class OneSecondRow implements LampsRow {

	@Override
	public String getLampsRow(TimeHolder time) {
		int sec = time.getSeconds();
		
		return (sec % 2 == 0) ? LAMP_YELLOW : LAMP_OFF;
	}
}
