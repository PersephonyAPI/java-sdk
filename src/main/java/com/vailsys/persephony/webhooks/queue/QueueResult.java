package com.vailsys.persephony.webhooks.queue;

import com.google.gson.annotations.SerializedName;

public enum QueueResult {

    @SerializedName("queueFull")
    QUEUE_FULL,
    @SerializedName("dequeued")
    DEQUEUED,
    @SerializedName("hangup")
    HANGUP,
    @SerializedName("error")
    ERROR,
    @SerializedName("systemError")
    SYSTEM_ERROR
}
