package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.CommonFields;

/**
 * This class represents the optional fields which can be passed in when updating a Calling Number.
 */
public class CallingNumberUpdateOptions extends CommonFields {
    /**
     * The alias of the calling number.
     */
    private String alias;

    /**
     * Retrieve the alias of the update options.
     *
     * @return The alias to which the calling number alias will be updated.
     */
    public String getAlias() {
        return alias;
    }
    /**
     * Set the alias updated option to set the alias of the calling number.
     * @param alias the alias to set.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
