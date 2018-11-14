package com.vailsys.persephony.webhooks.percl;

import com.vailsys.persephony.webhooks.PersyRequest;
import com.vailsys.persephony.webhooks.StatusCallback;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.api.PersyException;
import static com.vailsys.persephony.json.PersyGson.gson;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.webhooks.VoiceRequest;

public class RecordUtteranceActionCallback extends VoiceRequest {
	private String recordingId;
	private String recordingUrl;
	private Integer recordingSize;
	private String recordingFormat;
	private Integer recordingDurationSec;
	private TermReason termReason;

	private RecordUtteranceActionCallback(){}

	public static RecordUtteranceActionCallback createFromJson(String jsonString) throws PersyException {
		try {
			return gson.fromJson(jsonString, RecordUtteranceActionCallback.class);
		}
		catch(JsonIOException | JsonSyntaxException je) {
			throw new PersyJSONException(je);
		}
	}

	public String getRecordingId() { return this.recordingId; }
	public String getRecordingUrl() {return this.recordingUrl; }
	public Integer getRecordingSize() {
		return this.recordingSize;
	}
	public String getRecordingFormat() {
		return this.recordingFormat;
	}
	public Integer getRecordingDurationSec() {
		return this.recordingDurationSec;
	}
	public TermReason getTermReason() {
		return this.termReason;
	}
}
