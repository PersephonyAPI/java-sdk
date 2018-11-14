package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.CommonFields;

/**
 * This class represents the optional fields which can be passed in when creating a CallingNumber.
 */
public class CallingNumberCreateOptions extends CommonFields {
    /**
     * The phone number of the calling number.
     */
    private String phoneNumber;
    /**
     * The alias of the calling number.
     */
    private String alias;

    /**
     * Retrieve the phone number of the create options.
     *
     * @return The phone number of the calling number to be created.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number create option to give the new calling number a phone number
     * @param phoneNumber The phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
