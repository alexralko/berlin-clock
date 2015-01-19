package com.berlinclock.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.berlinclock.BaseBerlinClockTest;
import com.berlinclock.domain.TimeHolder;
import com.berlinclock.validator.BerlinTimeFormatValidator;

/**
 * Unit tests for TimeHolder class
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TimeHolderTest extends BaseBerlinClockTest {

	private TimeHolder timeHolder; 
	@Mock BerlinTimeFormatValidator validator;
	@Rule public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Test that validator is called only once during TimeHolder initialization
	 */
	@Test
	public void testTimeHolder_validator_call_during_inititalization() throws Exception {
		when(validator.validate(anyString())).thenReturn(true);
		timeHolder = getTime("00:00:00", validator);
		
		verify(validator, only()).validate(anyString());
	}
	
	/**
	 * Test that if time is not validated correctly TimeHolder throws an IllegalArgumentException
	 */
	@Test
	public void testTimeHolder_thrown_exception_if_validator_fails() throws Exception {
		when(validator.validate(anyString())).thenReturn(false);
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(is("Provided time format is not correct"));
		
		timeHolder = getTime("99:99:99", validator);
	}
	
	/**
	 * Test that after initialization TimeHolder parsed hours correctly
	 * @throws Exception
	 */
	@Test
	public void testTimeHolder_separate_hours_time_units_correctly() throws Exception {
		when(validator.validate(anyString())).thenReturn(true);
		timeHolder = getTime("01:02:03", validator);
		
		assertThat(timeHolder.getHours(), is(1));
	}
	
	/**
	 * Test that after initialization TimeHolder parsed minutes correctly
	 * @throws Exception
	 */
	@Test
	public void testTimeHolder_separate_minutes_time_units_correctly() throws Exception {
		when(validator.validate(anyString())).thenReturn(true);
		timeHolder = getTime("01:02:03", validator);
		
		assertThat(timeHolder.getMinutes(), is(2));
	}
	
	/**
	 * Test that after initialization TimeHolder parsed seconds correctly
	 * @throws Exception
	 */
	@Test
	public void testTimeHolder_separate_seconds_time_units_correctly() throws Exception {
		when(validator.validate(anyString())).thenReturn(true);
		timeHolder = getTime("01:02:03", validator);
		
		assertThat(timeHolder.getSeconds(), is(3));
	}
}
