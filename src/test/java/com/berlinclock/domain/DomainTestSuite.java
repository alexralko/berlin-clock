package com.berlinclock.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for domain unit tests
 *
 */

@RunWith(Suite.class)
@SuiteClasses({
  OneSecondRowTest.class,
  OneMinuteRowTest.class,
  FiveMinutesRowTest.class,
  OneHourRowTest.class,
  FiveHoursRowTest.class,
  TimeHolderTest.class
})
public class DomainTestSuite {

}
