package com.vailsys.persephony.api;

/**
 * This exception is thrown when the SDK runs into problems with establishing a
 * connection with the Persephony API.
 */
public class PersyConnectionException extends PersyException {
	private final static String prefix = "APIConnection::";

	public PersyConnectionException(String message) {
		super(prefix+message);
	}

	public PersyConnectionException(Throwable cause) {
		super(prefix+cause.getMessage(), cause);
	}

	public PersyConnectionException(String message, Throwable cause) {
		super(prefix+message, cause);
	}
}
