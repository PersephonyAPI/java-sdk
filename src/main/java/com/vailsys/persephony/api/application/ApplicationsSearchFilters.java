package com.vailsys.persephony.api.application;

import com.vailsys.persephony.api.Filters;

/**
 * Represents the possible fields one can set as filters when searching for applications.
 */
public class ApplicationsSearchFilters extends Filters {
    /**
     * The alias of the application
     */
    private String alias;

    /**
     * Retrieve the value of the alias filter.
     *
     * @return The alias of the application.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Set the alias filter for applications that match the alias.
     * @param alias The alias to filter by.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
