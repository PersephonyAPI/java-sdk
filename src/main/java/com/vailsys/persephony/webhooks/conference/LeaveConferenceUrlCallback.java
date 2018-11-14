package com.vailsys.persephony.webhooks.conference;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.webhooks.PersyRequest;
import com.vailsys.persephony.webhooks.VoiceRequest;

import static com.vailsys.persephony.json.PersyGson.gson;

public class LeaveConferenceUrlCallback extends VoiceRequest {
    public LeaveConferenceUrlCallback(){}
    public static LeaveConferenceUrlCallback createFromJson(String jsonString) throws PersyException {
        try {
           return gson.fromJson(jsonString, LeaveConferenceUrlCallback.class);
        } catch (JsonIOException | JsonSyntaxException ex){
            throw new PersyJSONException(ex);
        }
    }
}
