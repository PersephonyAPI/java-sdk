package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.PersyCommon;

/**
 * PhoneNumber is the base class from which all phone number classes that are built to represent objects returned from the Persephony API are built upon. A user of the SDK should never directly interact with a PhoneNumber object.
 */
public class PhoneNumber extends PersyCommon{
    /**
     * The E.164 formatted phone number.
     */
    private String phoneNumber;
    /**
     * The alias of this phone number.
     */
    private String alias;

    protected PhoneNumber() {}

    /**
     * @return The phone number of this resource.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return The alias of this resource.
     */
    public String getAlias() {
        return alias;
    }

    public boolean equals(PhoneNumber that) {
        boolean result = super.equals(that);

        if(this.phoneNumber != null){
            result = result && that.phoneNumber.equals(this.phoneNumber);
        } else {
            result = result && that.phoneNumber == null;
        }

        if(this.alias != null){
            result = result && that.alias.equals(this.alias);
        } else {
            result = result && that.alias == null;
        }
        return result;
    }
}
