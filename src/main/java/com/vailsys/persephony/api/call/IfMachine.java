package com.vailsys.persephony.api.call;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the predefined values for the {@code ifMachine}
 * field when creating a call. It is used to describe the desired behavior
 * should Persephony detect that the call was answered by an answering
 * machine.
 */
public enum IfMachine {
	/**
	 * Tells Persephony to continue as normal if detecting that a machine
	 * has answered the call.
	 */
	@SerializedName("continue")
	CONTINUE,
	/**
	 * Tells Persephony to hangup the call if detecting that a machine has
	 * answered the call.
	 */
	@SerializedName("hangup")
	HANGUP
}
