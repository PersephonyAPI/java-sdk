package com.vailsys.persephony.webhooks.call;

import com.vailsys.persephony.webhooks.PersyRequest;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.api.call.AnsweredBy;
import static com.vailsys.persephony.json.PersyGson.gson;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.webhooks.VoiceRequest;

public class VoiceCallback extends VoiceRequest {
	private CallStatus dialCallStatus;
	private AnsweredBy answeredBy;

	private VoiceCallback(){}

	public static VoiceCallback createFromJson(String jsonString) throws PersyException {
		try {
			return gson.fromJson(jsonString, VoiceCallback.class);
		}
		catch(JsonIOException jioe) {
			throw new PersyJSONException(jioe);
		}
		catch(JsonSyntaxException jse) {
			throw new PersyJSONException(jse);
		}
	}

	public CallStatus getDialCallStatus() {
		return this.dialCallStatus;
	}
	public AnsweredBy getAnsweredBy() {
		return this.answeredBy;
	}

}
