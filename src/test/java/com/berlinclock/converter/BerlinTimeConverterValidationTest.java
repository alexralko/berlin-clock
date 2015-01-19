package com.berlinclock.converter;

import static org.hamcrest.Matchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.berlinclock.converter.BerlinTimeConverter;

/**
 * Berlin time converter test class
 *
 */
public class BerlinTimeConverterValidationTest {

	@Rule public ExpectedException thrown = ExpectedException.none();
	private BerlinTimeConverter converter = new BerlinTimeConverter();
	
	/**
	 * Test that BerlinTimeConverter throw IllegalArgumentException if input time is null
	 */
	@Test
	public void testBerlinTimeConverter_thows_exception_if_time_null() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(is("Input time string cannot be null"));
		
		converter.convertTime(null);
	}
	
	/**
	 * Test that BerlinTimeConverter throw IllegalArgumentException if input time is empty
	 */
	@Test
	public void testBerlinTimeConverter_thows_exception_if_time_empty() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(is("Input time string cannot be empty"));
		
		converter.convertTime("");
	}
}
