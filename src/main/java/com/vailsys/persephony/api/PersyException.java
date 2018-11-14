package com.vailsys.persephony.api;

/**
 * Base Persephony exception class off of which all other exceptions in the sDK
 * are based.
 */
public class PersyException extends Exception {
	private final static String prefix = "PersyException::";

	public PersyException(String message) {
		super(prefix+message);
	}

	public PersyException(Throwable cause) {
		super(prefix+cause.getMessage(), cause);
	}

	public PersyException(String message, Throwable cause) {
		super(prefix+message, cause);
	}
}
