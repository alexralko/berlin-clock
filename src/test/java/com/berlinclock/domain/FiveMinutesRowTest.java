package com.berlinclock.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.berlinclock.BaseBerlinClockTest;
import com.berlinclock.domain.FiveMinutesRow;
import com.berlinclock.domain.LampsRow;

/**
 * 
 * Unit tests for '5 min' lamps row class
 *
 */
public class FiveMinutesRowTest extends BaseBerlinClockTest {

	private FiveMinutesRow fiveMinutesRow = new FiveMinutesRow();
	
	@Rule public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test midnight time 00:00:00
	 */
	@Test
	public void testFiveMinutesRow_midnight_00() throws Exception {
		String actual = fiveMinutesRow.getLampsRow(getTime("00:00:00"));
		
		assertThat(actual, is(LampsRow.LAMPS_5MIN_OFF));
	}
	
	/**
	 * Test some random time 14:18:56
	 */
	@Test
	public void testFiveMinutesRow_arbitrary_time() throws Exception {
		String actual = fiveMinutesRow.getLampsRow(getTime("14:47:56"));
		
		assertThat(actual, is("YYRYYRYYROO"));
	}
	
	/**
	 * Test second 15 min of the hour 
	 */
	@Test
	public void testFiveMinutesRow_arbitrary_time_second_15_min() throws Exception {
		String actual = fiveMinutesRow.getLampsRow(getTime("00:30:00"));
		
		assertThat(actual, is("YYRYYROOOOO"));
	}
	
	/**
	 * Test first 5 min of the hour 
	 */
	@Test
	public void testFiveMinutesRow_arbitrary_time_first_5_min() throws Exception {
		String actual = fiveMinutesRow.getLampsRow(getTime("00:03:00"));
		
		assertThat(actual, is(LampsRow.LAMPS_5MIN_OFF));
	}
	
	/**
	 * Test last 5 min of the hour 
	 */
	@Test
	public void testFiveMinutesRow_arbitrary_time_last_5_min() throws Exception {
		String actual = fiveMinutesRow.getLampsRow(getTime("00:59:00"));
		
		assertThat(actual, is("YYRYYRYYRYY"));
	}
	
	/**
	 * Test midnight time 24:00:00
	 */
	@Test
	public void testFiveMinutesRow_midnight_24() throws Exception {
		String actual = fiveMinutesRow.getLampsRow(getTime("24:00:00"));
		
		assertThat(actual, is(LampsRow.LAMPS_5MIN_OFF));
	}
	
	/**
	 * Test invalid time 00:60:00
	 */
	@Test
	public void testFiveMinutesRow_invalid_time() throws Exception {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(is("Provided time format is not correct"));
		
		fiveMinutesRow.getLampsRow(getTime("00:60:00"));
	}
	
}
