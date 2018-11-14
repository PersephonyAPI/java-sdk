package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.CommonFields;

/**
 * This class represents the optional fields which can be passed in when purchasing an IncomingPhoneNumber.
 */
public class IncomingPhoneNumberCreateOptions extends CommonFields {
    /**
     * The E.164 formatted phone number of the available number to purchase.
     *
     * @see com.vailsys.persephony.api.phoneNumber.AvailablePhoneNumber
     */
    private String phoneNumber;
    /**
     * The alias of the incoming phone number.
     */
    private String alias;
    /**
     * The id of the application Persephony will use to handle incoming calls to this number.
     */
    private String applicationId;

    public IncomingPhoneNumberCreateOptions(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * Retrieve the alias of the create option.
     *
     * @return The alias of the incoming phone number to be created.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Set the alias create option to give the new incoming phone number an alias.
     * @param alias the alias of the phone number.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Retrieve the applicationId of the create option.
     *
     * @return The applicationId to assign to the new incoming phone number.
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Set the applicationId create option to set on the new incoming phone number .
     * @param applicationId The Id of the application to assign the newly purchased number to.
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Retrieve the phone number of the create option.
     *
     * @return The phone number of the incoming phone number to purchase.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number of the create option.
     * @param phoneNumber the phone number to purchase.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
