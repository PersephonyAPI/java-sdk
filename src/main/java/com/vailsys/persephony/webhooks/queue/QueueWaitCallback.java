package com.vailsys.persephony.webhooks.queue;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.webhooks.PersyRequest;
import com.vailsys.persephony.webhooks.VoiceRequest;

import static com.vailsys.persephony.json.PersyGson.gson;

public class QueueWaitCallback extends VoiceRequest {
    private Integer queuePosition;
    private Integer queueTime;
    private Integer averageQueueTime;
    private Integer currentQueueSize;

    private QueueWaitCallback(){}

    public static QueueWaitCallback createFromJson(String jsonString) throws PersyException {
        try {
            return gson.fromJson(jsonString, QueueWaitCallback.class);
        }
        catch (JsonIOException | JsonSyntaxException je){
            throw new PersyJSONException(je);
        }
    }

    public Integer getQueuePosition() {
        return queuePosition;
    }

    public Integer getQueueTime() {
        return queueTime;
    }

    public Integer getAverageQueueTime() {
        return averageQueueTime;
    }

    public Integer getCurrentQueueSize() {
        return currentQueueSize;
    }
}
