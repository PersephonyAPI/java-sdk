package com.vailsys.persephony.api.conference;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the various possible predefined values of the
 * {@code playBeep} field instead a Persephony Conference instance. It indicates
 * whether the conference will play a beep when a participant enters
 * or leaves the conference.
 */
public enum PlayBeep {

	/**
	 * This value represents the setting where the conference will beep
	 * when a participant enters or leaves the conference.
	 */
	@SerializedName("always")
	ALWAYS,
	/**
	 * This value represents the setting where the conference will not beep
	 * regardless of a participant entering or leaving the conference.
	 */
	@SerializedName("never")
	NEVER,
	/**
	 * This value represents the setting where the conference will sound a tone
	 * when a participant enters the conference, but not on leaving.
	 */
	@SerializedName("entryOnly")
	ENTRY_ONLY,
	/**
	 * This value represents the setting where the conference will sound a tone
	 * when a participant leaves the conference, but not on entering.
	 */
	@SerializedName("exitOnly")
	EXIT_ONLY
}
