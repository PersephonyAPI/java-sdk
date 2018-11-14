package com.vailsys.persephony.api.call;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the various possible predefined values of the
 * {@code direction} field inside a Persephony Call instance. It indicates
 * whether the call was an inbound or outbound call and, if an outbound
 * call, where it originated.
 */
public enum Direction {
	/**
	 * This value represents an inbound call that came into your
	 * application. This is marked in the JSON representation of a Call
	 * instance that comes from the API as {@code "inbound"}.
	 */
	@SerializedName("inbound")
	INBOUND,
	/**
	 * This value represents an outbound call that was placed with your
	 * account through an API request. This is marked in the JSON
	 * representation of a Call instance that comes from the API as {@code
	 * "outboundAPI"}.
	 */
	@SerializedName("outboundAPI")
	OUTBOUND_API,
	/**
	 * This value represents an outbound call that was placed through an
	 * OutDial PerCL command from an applciation. This is marked in the
	 * JSON representation of a Call instance that comes from the API as
	 * {@code "outboundDial"}.
	 */
	@SerializedName("outboundDial")
	OUTBOUND_DIAL
}
