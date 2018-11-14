package com.vailsys.persephony.webhooks.percl;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.webhooks.PersyRequest;
import com.vailsys.persephony.webhooks.VoiceRequest;

import static com.vailsys.persephony.json.PersyGson.gson;

public class GetDigitsActionCallback extends VoiceRequest {
    private String digits;
    private DigitReason reason;

    private GetDigitsActionCallback(){}

    public static GetDigitsActionCallback createFromJson(String json) throws PersyException {
        try{
            return gson.fromJson(json, GetDigitsActionCallback.class);
        } catch (JsonIOException | JsonSyntaxException ex){
            throw new PersyJSONException(ex);
        }
    }

    public String getDigits() {
        return digits;
    }

    public DigitReason getReason() {
        return reason;
    }
}
