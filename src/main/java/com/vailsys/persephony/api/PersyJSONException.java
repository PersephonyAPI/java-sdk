package com.vailsys.persephony.api;

/**
 * Raised when there is a problem interpretting JSON or converting an object to
 * JSON.
 */
public class PersyJSONException extends PersyException {
	private final static String prefix = "JSONException::";

	public PersyJSONException(String message) {
		super(prefix+message);
	}

	public PersyJSONException(Throwable cause) {
		super(prefix+cause.getMessage(), cause);
	}

	public PersyJSONException(String message, Throwable cause) {
		super(prefix+message, cause);
	}
}

