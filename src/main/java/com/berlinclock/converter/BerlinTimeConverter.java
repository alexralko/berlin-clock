package com.berlinclock.converter;

import static com.google.common.base.Preconditions.checkArgument;

import com.berlinclock.BerlinTimeBoard;
import com.berlinclock.domain.FiveHoursRow;
import com.berlinclock.domain.FiveMinutesRow;
import com.berlinclock.domain.OneHourRow;
import com.berlinclock.domain.OneMinuteRow;
import com.berlinclock.domain.OneSecondRow;
import com.berlinclock.domain.TimeHolder;
import com.berlinclock.validator.BerlinTimeFormatValidator;

/**
 * Implementation of Berlin Time converter
 */
public class BerlinTimeConverter implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		checkArgument(aTime != null, "Input time string cannot be null");
		checkArgument(aTime.length() != 0, "Input time string cannot be empty");
		
		TimeHolder time = new TimeHolder(aTime, new BerlinTimeFormatValidator());
		
		BerlinTimeBoard timeBoard = new BerlinTimeBoard(time);
		timeBoard
			.addLampsRow(new OneSecondRow())	//	[O]
			.addLampsRow(new FiveHoursRow())	//	[OOOO]
			.addLampsRow(new OneHourRow())		//	[OOOO]
			.addLampsRow(new FiveMinutesRow())	//	[OOOOOOOOOOO]
			.addLampsRow(new OneMinuteRow());	//	[OOOO]
		
		return timeBoard.showTime();
	}
}
