package com.vailsys.persephony.api.queue;

import com.vailsys.persephony.api.CommonFields;

/**
 * The class represents the optional fields which can be passed in when
 * creating a Queue.
 */
public class QueueCreateOptions extends CommonFields {
    /**
     * The alias of the queue.
     */
    private String alias;
    /**
     * The maximum number of calls that can be added to the queue.
     */
    private Integer maxSize;

    /**
     * Retrieve the alias option from the object.
     *
     * @return The alias of the queue to be created.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Set the alias option.
     * @param alias The alias to set.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Retrieve the maxSize option from the object.
     *
     * @return The maxSize of the queue to be created.
     */
    public Integer getMaxSize() {
        return maxSize;
    }

    /**
     * Set the maximum size option.
     * @param maxSize The maximum size of the queue.
     */
    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}
