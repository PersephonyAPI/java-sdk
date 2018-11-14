package com.vailsys.persephony.api.call;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the various possible predefined values of the
 * {@code status} field inside a Persephony Call instance. It indicates
 * what current state or status of the call represented by this object is
 * in.
 */
public enum CallStatus {
	/**
	 * This value represents that the call is waiting in a Persephony
	 * Queue. This is marked in the JSON representation of a Call
	 * instance that comes from the API as {@code "queued"}.
	 */
	@SerializedName("queued")
	QUEUED,
	/**
	 * This value represents that the call is ringing and has yet to be
	 * answered. This is marked in the JSON representation of a Call
	 * instance that comes from the API as {@code "ringing"}.
	 */
	@SerializedName("ringing")
	RINGING,
	/**
	 * This value represents that the call is answered and currently in
	 * progress. This is marked in the JSON representation of a Call
	 * instance that comes from the API as {@code "inProgress"}.
	 */
	@SerializedName("inProgress")
	IN_PROGRESS,
	/**
	 * This value represents that the call was hung up while queued or
	 * ringing. This is marked in the JSON representation of a Call
	 * instance that comes from the API as {@code "canceled"}.
	 */
	@SerializedName("canceled")
	CANCELED,
	/**
	 * This value represents that the call was answered and has ended
	 * normally. This is marked in the JSON representation of a Call
	 * instance that comes from the API as {@code "completed"}.
	 */
	@SerializedName("completed")
	COMPLETED,
	/**
	 * This value represents that the call received a busy signal. This is
	 * marked in the JSON representation of a Call instance that comes from
	 * the API as {@code "busy"}.
	 */
	@SerializedName("busy")
	BUSY,
	/**
	 * This value represents that the call could not be completed as
	 * dialed, most likely because the phone number was non-existent. This
	 * is marked in the JSON representation of a Call instance that comes
	 * from the API as {@code "failed"}.
	 */
	@SerializedName("failed")
	FAILED,
	/**
	 * This value represents that the call ended without being answered.
	 * This is marked in the JSON representation of a Call instance that
	 * comes from the API as {@code "noAnswer"}.
	 */
	@SerializedName("noAnswer")
	NO_ANSWER,
	/**
	 * This value represents that the call is in progress and has joined a
	 * conference. This is marked in the JSON representation of a Call
	 * instance that comes from the API as {@code "bridged"}.
	 */
	@SerializedName("bridged")
	BRIDGED
}
