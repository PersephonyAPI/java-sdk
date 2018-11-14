package com.vailsys.persephony.api.queue;

import com.vailsys.persephony.api.Filters;

/**
 * Represents the possible fields one can set as filters when searching for queues.
 */
public class QueuesSearchFilters extends Filters {
    /**
     * The alias of the queue.
     */
    private String alias;

    /**
     * Retrieve the value of the alias filter.
     *
     * @return The alias of the queue.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Set the alias filter for queues that match the alias.
     * @param alias The alias to filter by
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
