package com.vailsys.persephony.webhooks.conference;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.api.conference.ConferenceStatus;
import com.vailsys.persephony.webhooks.StatusCallback;

import static com.vailsys.persephony.json.PersyGson.gson;

public class ConferenceStatusCallback extends StatusCallback {
    private ConferenceStatus status;

    private ConferenceStatusCallback(){}
    public static ConferenceStatusCallback createFromJson(String jsonString) throws PersyException {
        try{
            return gson.fromJson(jsonString, ConferenceStatusCallback.class);
        } catch(JsonIOException | JsonSyntaxException ex){
            throw new PersyJSONException(ex);
        }
    }

    public ConferenceStatus getStatus() {
        return status;
    }
}
