package com.vailsys.persephony.api;

/**
 * Thrown by Persephony SDK componenets when they fail to parse a date string.
 */
public class PersyDateException extends PersyException {
	/**
	 * @param date The offending date string
	 * @param index The index in the string where the first problem is noticed.
	 */
	public PersyDateException(String date, int index) {
		super("Poorly formatted date::`"+date.substring(0,index)+">>>>"+date.charAt(index)+"<<<<"+date.substring(index+1)+"`");
	}
}

