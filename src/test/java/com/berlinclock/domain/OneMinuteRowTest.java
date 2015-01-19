package com.berlinclock.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.berlinclock.BaseBerlinClockTest;
import com.berlinclock.domain.LampsRow;
import com.berlinclock.domain.OneMinuteRow;

/**
 * 
 * Unit tests for '1 min' lamps row class
 *
 */
public class OneMinuteRowTest extends BaseBerlinClockTest {

	private OneMinuteRow oneMinuteRow = new OneMinuteRow();
	
	@Rule public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test midnight time 00:00:00
	 */
	@Test
	public void testOneMinuteRow_midnight_00() throws Exception {
		String actual = oneMinuteRow.getLampsRow(getTime("00:00:00"));
		
		assertThat(actual, is(LampsRow.LAMPS_1MIN_OFF));
	}
	
	/**
	 * Test some random time 17:32:16
	 */
	@Test
	public void testOneMinuteRow_arbitrary_time() throws Exception {
		String actual = oneMinuteRow.getLampsRow(getTime("18:38:02"));
		
		assertThat(actual, is("YYYO"));
	}
	
	/**
	 * Test some random time, within first 1 min time
	 */
	@Test
	public void testOneMinuteRow_arbitrary_time_fist_hour() throws Exception {
		String actual = oneMinuteRow.getLampsRow(getTime("00:00:28"));
		
		assertThat(actual, is(LampsRow.LAMPS_1MIN_OFF));
	}
	
	/**
	 * Test midnight time 24:00:00
	 */
	@Test
	public void testOneMinuteRow_midnight_24() throws Exception {
		String actual = oneMinuteRow.getLampsRow(getTime("24:00:00"));
		
		assertThat(actual, is("OOOO"));
	}
	
	/**
	 * Test invalid time 00:60:00
	 */
	@Test
	public void testOneMinuteRow_invalid_time() throws Exception {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(is("Provided time format is not correct"));
		
		oneMinuteRow.getLampsRow(getTime("00:60:00"));
	}
}
