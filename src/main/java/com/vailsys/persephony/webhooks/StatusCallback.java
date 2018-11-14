package com.vailsys.persephony.webhooks;

import com.vailsys.persephony.api.PersyJSONException;

import static com.vailsys.persephony.json.PersyGson.gson;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * The StatusCallback class represents the JSON object that is sent to the
 * statusCallbackUrl webhook of Persephony applications. StatusCallback is a
 * subclass of the PersyRequest and contains all the fields that it does.
 *
 * @see PersyRequest
 */
public class StatusCallback extends VoiceRequest {

    public static StatusCallback fromJson(String rawJson) throws PersyJSONException {
        try {
            return gson.fromJson(rawJson, StatusCallback.class);
        } catch (JsonIOException | JsonSyntaxException je) {
            throw new PersyJSONException(je);
        }
    }

    private String parentCallId;
    private Integer callDuration;
    private String recordingUrl;
    private String recordingId;
    private Integer recordingDurationSec;

    public String getParentCallId() {
        return this.parentCallId;
    }

    public Integer getCallDuration() {
        return this.callDuration;
    }

    public String getRecordingUrl() {
        return this.recordingUrl;
    }

    public String getRecordingId() {
        return this.recordingId;
    }

    public Integer getRecordingDurationSec() {
        return this.recordingDurationSec;
    }
}
