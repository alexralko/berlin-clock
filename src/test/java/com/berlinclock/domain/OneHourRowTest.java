package com.berlinclock.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.berlinclock.BaseBerlinClockTest;
import com.berlinclock.domain.LampsRow;
import com.berlinclock.domain.OneHourRow;

/**
 * 
 * Unit tests for '1 hr' lamps row class
 *
 */
public class OneHourRowTest extends BaseBerlinClockTest {

	private OneHourRow oneHoursRow = new OneHourRow();
	
	@Rule public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test midnight time 00:00:00
	 */
	@Test
	public void testOneHourRow_midnight_00() throws Exception {
		String actual = oneHoursRow.getLampsRow(getTime("00:00:00"));
		
		assertThat(actual, is(LampsRow.LAMPS_1HR_OFF));
	}
	
	/**
	 * Test some random time 17:32:16
	 */
	@Test
	public void testOneHourRow_arbitrary_time() throws Exception {
		String actual = oneHoursRow.getLampsRow(getTime("18:38:02"));
		
		assertThat(actual, is("RRRO"));
	}
	
	/**
	 * Test some random time, within first hour time
	 */
	@Test
	public void testOneHourRow_arbitrary_time_fist_hour() throws Exception {
		String actual = oneHoursRow.getLampsRow(getTime("00:10:02"));
		
		assertThat(actual, is(LampsRow.LAMPS_1HR_OFF));
	}
	
	/**
	 * Test midnight time 24:00:00
	 */
	@Test
	public void testOneHourRow_midnight_24() throws Exception {
		String actual = oneHoursRow.getLampsRow(getTime("24:00:00"));
		
		assertThat(actual, is("RRRR"));
	}
	
	/**
	 * Test invalid time 25:00:00
	 */
	@Test
	public void testOneHourRow_invalid_time() throws Exception {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(is("Provided time format is not correct"));
		
		oneHoursRow.getLampsRow(getTime("25:00:00"));
	}
	
}

