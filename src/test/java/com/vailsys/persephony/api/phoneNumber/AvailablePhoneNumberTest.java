package com.vailsys.persephony.api.phoneNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class AvailablePhoneNumberTest {
    private AvailablePhoneNumber apn;
    private static String availableJson = null;

    @Given("^some JSON representing an available phone number$")
    public void setupJson(){
        availableJson = "{\"phoneNumber\":\"+18474574545\", \"voiceEnabled\":true, \"smsEnabled\" : true, \"alias\":\"1 (847) 457-4545\", \"region\":\"Illinois\", \"country\":\"US\"}";
    }

    @Then("^build an availablePhoneNumber object from that JSON$")
    public void create() throws Throwable{
        apn = AvailablePhoneNumber.fromJson(availableJson);
    }

    @Then("^check the contents of the availablePhoneNumber$")
    public void checkContents(){
        assertThat(apn.getPhoneNumber(), is("+18474574545"));
        assertThat(apn.isVoiceEnabled(), is(true));
        assertThat(apn.isSmsEnabled(), is(true));
        assertThat(apn.getAlias(), is("1 (847) 457-4545"));
        assertThat(apn.getRegion(), is("Illinois"));
        assertThat(apn.getCountry(), is("US"));
    }

    @Then("^compare the availablePhoneNumber to equal and unequal objects$")
    public void checkEquals() throws Throwable {
        AvailablePhoneNumber that = AvailablePhoneNumber.fromJson(availableJson);
        assertTrue(apn.equals(that));
        that = AvailablePhoneNumber.fromJson("{\"phoneNumber\":\"+18474574545\", \"voiceEnabled\":false, \"smsEnabled\" : false, \"alias\":\"1 (847) 457-4545\", \"region\":\"Illinois\", \"country\":\"US\"}");
        assertFalse(apn.equals(that));
    }
}
