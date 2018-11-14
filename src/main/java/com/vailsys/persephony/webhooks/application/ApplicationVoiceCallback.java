package com.vailsys.persephony.webhooks.application;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.webhooks.PersyRequest;
import com.vailsys.persephony.webhooks.VoiceRequest;

import static com.vailsys.persephony.json.PersyGson.gson;

public class ApplicationVoiceCallback extends VoiceRequest {

    private ApplicationVoiceCallback(){}

    public static ApplicationVoiceCallback createFromJson(String jsonString) throws PersyException {
        try {
            return gson.fromJson(jsonString, ApplicationVoiceCallback.class);
        }
        catch(JsonIOException jioe) {
            throw new PersyJSONException(jioe);
        }
        catch(JsonSyntaxException jse) {
            throw new PersyJSONException(jse);
        }
    }

}
