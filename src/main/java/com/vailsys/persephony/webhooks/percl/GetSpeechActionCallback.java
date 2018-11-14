package com.vailsys.persephony.webhooks.percl;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.webhooks.PersyRequest;
import com.vailsys.persephony.webhooks.VoiceRequest;

import static com.vailsys.persephony.json.PersyGson.gson;

public class GetSpeechActionCallback extends VoiceRequest {
    private SpeechReason reason;
    private String recognitionResult;
    private Integer confidence;

    private GetSpeechActionCallback(){}

    public static GetSpeechActionCallback createFromJson(String jsonString) throws PersyException {
        try{
            return gson.fromJson(jsonString, GetSpeechActionCallback.class);
        } catch(JsonIOException | JsonSyntaxException je){
            throw new PersyJSONException(je);
        }
    }

    public SpeechReason getReason() {
        return reason;
    }

    public String getRecognitionResult() {
        return recognitionResult;
    }

    public Integer getConfidence() {
        return confidence;
    }
}
