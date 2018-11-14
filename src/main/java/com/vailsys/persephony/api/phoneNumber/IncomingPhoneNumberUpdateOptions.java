package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.CommonFields;

/**
 * This class represents the optional fields which can be passed in when updating an IncomingPhoneNumber.
 */
public class IncomingPhoneNumberUpdateOptions extends CommonFields {
    /**
     * The alias of the incoming phone number.
     */
    private String alias;
    /**
     * The id of the application to use when a call is placed to this incoming phone number.
     */
    private String applicationId;

    /**
     * Retrieve the alias of the update options.
     * @return The alias of the phone number.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Set the alias update option to set the alias of the incoming phone number.
     * @param alias The alias to set on the phone number.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Retrieve the applicationId of the update option.
     * @return The id of the application.
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Set the applicationId of the update option to set the applicationId of the incoming phone number.
     * @param applicationId The ID of the application to assign to the phone number.
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}
