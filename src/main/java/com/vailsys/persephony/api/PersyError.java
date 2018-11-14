package com.vailsys.persephony.api;

/**
 * The PersyError represents the error messages that the Persephony API often
 * replies with.
 */
public class PersyError {
	private Integer status;
	private String message;
	private Integer code;
	private String info;

	/**
	 * @param status The HTTP status code for the response.
	 * @param message A descriptive message about the error.
	 * @param code A Persephony specific code about the error.
	 * @param info A URL to the relevant Persephony documentation
	 */
	public PersyError(int status, String message, int code, String info) {
		this.status = status;
		this.message = message;
		this.code = code;
		this.info = info;
	}

	public Integer getStatus() {
		return this.status;
	}
	public String getMessage() {
		return this.message;
	}
	public Integer getCode() {
		return this.code;
	}
	public String getInfo() {
		return this.info;
	}
}
