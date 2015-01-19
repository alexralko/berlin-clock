package com.berlinclock;

import java.util.ArrayList;
import java.util.List;

import com.berlinclock.domain.LampsRow;
import com.berlinclock.domain.TimeHolder;

/**
 * Represent Berlin Time board as set of lamp rows
 */
public class BerlinTimeBoard {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	private TimeHolder time;
	private List<LampsRow> rows = new ArrayList<LampsRow>();
	
	public BerlinTimeBoard(TimeHolder time) {
		this.time = time;
	}
	
	/**
	 * Add row of lamps to the board
	 * @param lampsRow - row of lamps to be added to the board
	 * @return updated board
	 */
	public BerlinTimeBoard addLampsRow(LampsRow lampsRow) {
		rows.add(lampsRow);
		return this;
	}

	/**
	 * Show Berlin Time as string
	 * @return string representation of Berlin Time
	 */
	public String showTime() {
		StringBuffer lampsArray = new StringBuffer();
		
		for(LampsRow row: rows) {
			if(lampsArray.length() != 0) {
				lampsArray.append(LINE_SEPARATOR);
			}
			lampsArray.append(row.getLampsRow(time));
		}
		
		return lampsArray.toString();
	}

	
}
