package com.berlinclock;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.berlinclock.converter.ConverterTestSuite;
import com.berlinclock.domain.DomainTestSuite;
import com.berlinclock.validator.ValidatorTestSuite;

/**
 * Test suite for Berlin Clock unit tests
 * <br>Contains domain, converter, validator and board tests
 *
 */

@RunWith(Suite.class)
@SuiteClasses({
  DomainTestSuite.class,
  ConverterTestSuite.class,
  ValidatorTestSuite.class,
  BerlinTimeBoardTest.class
})
public class BerlinClockTestSuite {

}
