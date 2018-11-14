package com.vailsys.persephony.webhooks.queue;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.webhooks.PersyRequest;
import com.vailsys.persephony.webhooks.VoiceRequest;

import static com.vailsys.persephony.json.PersyGson.gson;

public class QueueActionCallback extends VoiceRequest {
    private QueueResult queueResult;
    private Integer queueTime;

    private QueueActionCallback(){}
    public static QueueActionCallback createFromJson(String jsonString) throws PersyException {
        try{
            return gson.fromJson(jsonString, QueueActionCallback.class);
        }
        catch (JsonIOException | JsonSyntaxException je){
            throw new PersyJSONException(je);
        }
    }

    public QueueResult getQueueResult() {
        return queueResult;
    }

    public Integer getQueueTime() {
        return queueTime;
    }
}
