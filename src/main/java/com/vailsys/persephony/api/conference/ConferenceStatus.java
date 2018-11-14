package com.vailsys.persephony.api.conference;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the predefined values for the {@code status} field
 * inside a Persephony Conference instance. It indicates whether the conference
 * is active and whether there are any callers in the conference.
 */
public enum ConferenceStatus {
	/**
	 * This value represents the state of the conference where
	 * it can be used but there are currently no calls in it.
	 */
	@SerializedName("empty")
	EMPTY,
	/**
	 * This value represents the state of the conference where
	 * there are calls in the conference, but the conference hasn't started yet.
	 */
	@SerializedName("populated")
	POPULATED,
	/**
	 * This value represents the state of the conference where
	 * there are calls in the conference and the conference has started.
	 */
	@SerializedName("inProgress")
	IN_PROGRESS,
	/**
	 * This value represents the state of the conference where
	 * the conference has been ended and can no longer be used.
	 */
	@SerializedName("terminated")
	TERMINATED
}
