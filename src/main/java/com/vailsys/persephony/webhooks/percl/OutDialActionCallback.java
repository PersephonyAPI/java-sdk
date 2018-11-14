package com.vailsys.persephony.webhooks.percl;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.webhooks.PersyRequest;
import com.vailsys.persephony.webhooks.VoiceRequest;

import static com.vailsys.persephony.json.PersyGson.gson;

public class OutDialActionCallback extends VoiceRequest {

    private String dialCallId;

    private OutDialActionCallback(){}

    public static OutDialActionCallback createFromJson(String jsonString) throws PersyException {
        try {
            return gson.fromJson(jsonString, OutDialActionCallback.class);
        } catch (JsonIOException | JsonSyntaxException je){
            throw new PersyJSONException(je);
        }
    }

    public String getDialCallId() {
        return dialCallId;
    }
}
