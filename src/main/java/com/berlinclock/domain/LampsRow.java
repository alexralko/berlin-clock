package com.berlinclock.domain;

/**
 *  Define conversion method to get lamps string presentation of time
 */
public interface LampsRow {

	// individual states of every particular lamp
	static final String LAMP_OFF = "O";
	static final String LAMP_YELLOW = "Y";
	static final String LAMP_RED = "R";
	
	// initial states of lamp rows
	static final String LAMPS_5HR_OFF = "OOOO";
	static final String LAMPS_1HR_OFF = "OOOO";
	static final String LAMPS_5MIN_OFF = "OOOOOOOOOOO";
	static final String LAMPS_1MIN_OFF = "OOOO";
	
	
	/**
	 * Return row of lamps depending on provided time 
	 * <br>Every lamp may have the following states:
	 * <ul>
	 * <li>On RED - <b>R</b></li>
	 * <li>On YELLOW - <b>Y</b></li>
	 * <li>Off - <b>O</b></li>
     * </ul>
	 * 
	 * @param timeContainer - presentation of time 
	 * @return string of lamps
	 */
	String getLampsRow(TimeHolder time);
}
