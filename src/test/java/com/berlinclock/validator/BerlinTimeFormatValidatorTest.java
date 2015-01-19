package com.berlinclock.validator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.berlinclock.validator.BerlinTimeFormatValidator;

/**
 * Unit tests for Berlin Time validator class
 *
 */
public class BerlinTimeFormatValidatorTest {

	@Rule public ExpectedException thrown = ExpectedException.none();
	
	private BerlinTimeFormatValidator validator = new BerlinTimeFormatValidator();

	@Test
	public void testTimeFormatValidator_1() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(is("Provided time is null"));
		
		validator.validate(null);
	}
	
	@Test
	public void testTimeFormatValidator_3() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(is("Provided time string is empty"));
		
		validator.validate("");
	}
	
	@Test
	public void testTimeFormatValidator_4() throws Exception {
		boolean actual = validator.validate("12:13:14");

		assertThat(actual, is(true));
	}
	
	@Test
	public void testTimeFormatValidator_5() throws Exception {
		boolean actual = validator.validate("24:00:00");

		assertThat(actual, is(true));
	}
	
	@Test
	public void testTimeFormatValidator_6() throws Exception {
		boolean actual = validator.validate("24:00:59");

		assertThat(actual, is(true));
	}
	
	@Test
	public void testTimeFormatValidator_7() throws Exception {
		boolean actual = validator.validate("00:00:00");

		assertThat(actual, is(true));
	}
	
	@Test
	public void testTimeFormatValidator_8() throws Exception {
		boolean actual = validator.validate("24:01:00");

		assertThat(actual, is(false));
	}
	
	@Test
	public void testTimeFormatValidator_9() throws Exception {
		boolean actual = validator.validate("99:99:99");

		assertThat(actual, is(false));
	}
	
}
