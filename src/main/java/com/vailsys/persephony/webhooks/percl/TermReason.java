package com.vailsys.persephony.webhooks.percl;

import com.google.gson.annotations.SerializedName;

public enum TermReason
{
	@SerializedName("finishKey")
	FINISH_KEY,
	@SerializedName("timeout")
	TIMEOUT,
	@SerializedName("hangup")
	HANGUP,
	@SerializedName("maxLength")
	MAX_LENGTH
}
