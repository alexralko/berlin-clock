package com.berlinclock.domain;

import java.util.StringTokenizer;

import com.berlinclock.validator.TimeFormatValidator;

/**
 *	Hold the time information as set of hour, min and sec
 *
 */
public class TimeHolder {

    private Integer hours;
	private Integer minutes;
    private Integer seconds;
    
    /**
     * Build TimeHolder object
     * 
     * @param time - string presentation of time
     * @param validator - time format validator to check time format against the pattern
     * 
     * @throws IllegalArgumentException - if validation fail
     */
    public TimeHolder(String time, TimeFormatValidator validator) {
    	if(!validator.validate(time)) {
    		throw new IllegalArgumentException("Provided time format is not correct");
    	}
    	
    	initialize(time);
	}
    
    /**
     * Initialize holder object based on string representation of time
     * 
     * @param time - string with time separated by ':' (e.g. 12:48:52)
     */
	private void initialize(String time) {
        StringTokenizer stringTokenizer = new StringTokenizer(time, ":");
        
        this.hours = Integer.parseInt(stringTokenizer.nextToken());
        this.minutes = Integer.parseInt(stringTokenizer.nextToken());
        this.seconds = Integer.parseInt(stringTokenizer.nextToken());
    }
	
	/**
	 * Return hours 
	 * @return number of hours
	 */
    public Integer getHours() {
		return hours;
	}
    
	/**
	 * Return minutes 
	 * @return number of hours
	 */
	public Integer getMinutes() {
		return minutes;
	}

	/**
	 * Return seconds 
	 * @return number of seconds
	 */
	public Integer getSeconds() {
		return seconds;
	}

}
