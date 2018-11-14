package com.vailsys.persephony.webhooks;

import com.vailsys.persephony.api.PersyJSONException;

import static com.vailsys.persephony.json.PersyGson.gson;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.api.call.Direction;

/**
 * A PersyRequest represents the JSON object that is sent to the webhooks
 * (voiceUrl, voiceFallbackUrl, etc.) of Persephony applications. All webhooks
 * except the statusCallbackUrl will receive a payload in this form.
 */
public class PersyRequest {
    private String requestId;
    private String accountId;
    private RequestType requestType;
    private String from;
    private String to;

    /**
     * Helper method to build a PersyRequest object from the JSON string sent
     * to your application by Persephony
     * @param rawJson The JSON string to parse into a PersyRequest.
     * @return the PersyRequest object representing the provided JSON.
     * @throws PersyJSONException when the JSON is invalid.
     */
    public static PersyRequest fromJson(String rawJson) throws PersyJSONException {
        try {
            return gson.fromJson(rawJson, PersyRequest.class);
        } catch (JsonIOException | JsonSyntaxException je) {
            throw new PersyJSONException(je);
        }
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }
}
