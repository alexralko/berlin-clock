package com.berlinclock.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.berlinclock.BaseBerlinClockTest;
import com.berlinclock.domain.FiveHoursRow;
import com.berlinclock.domain.LampsRow;

/**
 * 
 * Unit tests for '5 hr' lamps row class
 *
 */
public class FiveHoursRowTest extends BaseBerlinClockTest {

	private FiveHoursRow fiveHoursRow = new FiveHoursRow();
	
	@Rule public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test midnight time 00:00:00
	 */
	@Test
	public void testFiveHoursRow_midnight_00() throws Exception {
		String actual = fiveHoursRow.getLampsRow(getTime("00:00:00"));
		
		assertThat(actual, is(LampsRow.LAMPS_5HR_OFF));
	}
	
	/**
	 * Test some random time 17:32:16
	 */
	@Test
	public void testFiveHoursRow_arbitrary_time() throws Exception {
		String actual = fiveHoursRow.getLampsRow(getTime("17:32:16"));
		
		assertThat(actual, is("RRRO"));
	}
	
	/**
	 * Test midnight time 24:00:00
	 */
	@Test
	public void testFiveHoursRow_midnight_24() throws Exception {
		String actual = fiveHoursRow.getLampsRow(getTime("24:00:00"));
		
		assertThat(actual, is("RRRR"));
	}
	
	/**
	 * Test invalid time 25:00:00
	 */
	@Test
	public void testFiveHoursRow_invalid_time() throws Exception {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(is("Provided time format is not correct"));
		
		fiveHoursRow.getLampsRow(getTime("25:00:00"));
	}
	
}
