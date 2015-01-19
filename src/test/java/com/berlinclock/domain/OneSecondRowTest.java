package com.berlinclock.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.berlinclock.BaseBerlinClockTest;
import com.berlinclock.domain.LampsRow;
import com.berlinclock.domain.OneSecondRow;

/**
 * 
 * Unit tests for '1 sec' lamps row class
 *
 */
public class OneSecondRowTest extends BaseBerlinClockTest {

	private OneSecondRow oneSecondRow = new OneSecondRow();
	
	@Rule public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Test midnight time 00:00:00
	 */
	@Test
	public void testOneSecondRow_midnight_00() throws Exception {
		String actual = oneSecondRow.getLampsRow(getTime("00:00:00"));
		
		assertThat(actual, is(LampsRow.LAMP_YELLOW));
	}
	
	/**
	 * Test midnight time 24:00:00
	 */
	@Test
	public void testOneSecondRow_midnight_24() throws Exception {
		String actual = oneSecondRow.getLampsRow(getTime("24:00:00"));
		
		assertThat(actual, is(LampsRow.LAMP_YELLOW));
	}
	
	/**
	 * Test seconds lamp for 1 sec time
	 */
	@Test
	public void testOneSecondRow_one_sec_time() throws Exception {
		String actual = oneSecondRow.getLampsRow(getTime("00:00:01"));
		
		assertThat(actual, is(LampsRow.LAMP_OFF));
	}
	
	/**
	 * Test seconds lamp for some random time
	 */
	@Test
	public void testOneSecondRow_arbitrary_time() throws Exception {
		String actual = oneSecondRow.getLampsRow(getTime("00:00:36"));
		
		assertThat(actual, is(LampsRow.LAMP_YELLOW));
	}
	
	/**
	 * Test seconds lamp for 59 sec time
	 */
	@Test
	public void testOneSecondRow_last_sec_time() throws Exception {
		String actual = oneSecondRow.getLampsRow(getTime("00:00:59"));
		
		assertThat(actual, is(LampsRow.LAMP_OFF));
	}
	
	/**
	 * Test invalid time 00:00:60
	 */
	@Test
	public void testFiveHoursRow_invalid_time() throws Exception {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(is("Provided time format is not correct"));
		
		oneSecondRow.getLampsRow(getTime("00:00:60"));
	}
	
}
