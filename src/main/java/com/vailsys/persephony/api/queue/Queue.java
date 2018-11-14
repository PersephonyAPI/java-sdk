package com.vailsys.persephony.api.queue;

import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyCommon;
import com.vailsys.persephony.api.PersyJSONException;

import java.util.HashMap;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents a Persphony Queue instance. Queue objects are created
 * by the SDK whenever a queue instance would be returned by the API; these
 * primarily come from {@link com.vailsys.persephony.api.queue.QueuesRequester}
 * inside a {@link com.vailsys.persephony.api.PersyClient} instance. <br>
 * <br>
 * Queues are immutable and intended only to be used to read information
 * returned from the API in a language accessible way.
 *
 * @see com.vailsys.persephony.api.queue.QueuesRequester
 * @see com.vailsys.persephony.api.PersyClient
 */
public class Queue extends PersyCommon {
    /**
     * The queueId for this queue instance.
     */
    private String queueId;
    /**
     * The alias for this queue.
     */
    private String alias;
    /**
     * The current number of calls in this queue.
     */
    private Integer currentSize;
    /**
     * The maximum number of calls allowed in this queue.
     */
    private Integer maxSize;
    /**
     * The average time calls in this queue are waiting before being dequeued.
     */
    private Integer averageWaitTime;
    /**
     * The list of subresources for this queue. Includes members.
     */
    private HashMap<String, String> subresourceUris;

    /**
     * Converts the provided JSON string into a Queue object.
     *
     * @param json a JSON string representing a Persephony Queue instance.
     *
     * @return A Queue object equivalent to the JSON string passed in.
     * @throws PersyJSONException when the syntax is not valid JSON.
     */
    public static Queue fromJson(String json) throws PersyJSONException {
        try {
            return gson.fromJson(json, Queue.class);
        }
        catch (JsonSyntaxException jse){
            throw new PersyJSONException(jse);
        }
    }

    /**
     * Retrieve the queueId for this queue from the object.
     *
     * @return The queueId for this queue.
     */
    public String getQueueId() {
        return queueId;
    }

    /**
     * Retrieve the alias for this queue from the object.
     *
     * @return The alias for this queue.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Retrieve the current size of this queue from the object.
     *
     * @return The current size of this queue.
     */
    public Integer getCurrentSize() {
        return currentSize;
    }

    /**
     * Retrieve the maximum size of this queue from the object.
     *
     * @return The maximum size of this queue.
     */
    public Integer getMaxSize() {
        return maxSize;
    }

    /**
     * Retrieve the average wait time of this queue from the object.
     *
     * @return The average wait time of this queue.
     */
    public Integer getAverageWaitTime() {
        return averageWaitTime;
    }

    /**
     * Retrieve the subresourceUris for this queue from the object.
     *
     * @return The subresourcesUris for this queue.
     */
    public HashMap<String, String> getSubresourceUris() {
        return subresourceUris;
    }

    /**
     * Check if this queue equals another. This is done by comparing all fields in the queue for equality.
     *
     * @param that The Queue object for comparison.
     * @return {@code true} if queues are equal, {@code false} otherwise.
     */
    public boolean equals(Queue that){
        boolean result = super.equals(that);

        if(this.queueId != null){
            result = result && that.queueId.equals(this.queueId);
        } else {
            result = result && that.queueId == null;
        }

        if(this.alias != null){
            result = result && that.alias.equals(this.alias);
        } else {
            result = result && that.alias == null;
        }

        if(this.currentSize != null){
            result = result && that.currentSize.equals(this.currentSize);
        } else {
            result = result && that.currentSize == null;
        }

        if(this.maxSize != null){
            result = result && that.maxSize.equals(this.maxSize);
        } else {
            result = result && that.maxSize == null;
        }

        if(this.averageWaitTime != null){
            result = result && that.averageWaitTime.equals(this.averageWaitTime);
        } else {
            result = result && that.averageWaitTime == null;
        }

        if(this.subresourceUris != null){
            result = result && that.subresourceUris.equals(this.subresourceUris);
        } else {
            result = result && that.subresourceUris == null;
        }

        return result;

    }
}
