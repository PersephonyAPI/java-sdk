package com.vailsys.persephony.api.phoneNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class CallingNumberTest {
    private String inputJson = null;
    private CallingNumber number;

    @Given("^some JSON representing a calling number$")
    public void createJson(){
        inputJson = "{\"phoneNumber\" : \"+13124706110\", \"alias\" : \"Holiday\", \"revision\" : 5, \"dateCreated\" : \"Fri, 11 Nov 2016 13:42:22 GMT\", \"dateUpdated\" : \"Tue, 24 Jan 2017 15:58:20 GMT\", \"callingNumberId\" : \"PNf1106339f20120b3a17888e64169be5c68c70a5d\", \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/CallingNumbers/PNf1106339f20120b3a17888e64169be5c68c70a5d\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\"}";
    }

    @Then("^build a callingNumber object from that JSON$")
    public void create() throws Throwable {
        number = CallingNumber.fromJson(inputJson);
    }

    @Then("^check the contents of the callingNumber$")
    public void checkContents(){
        assertThat(number.getPhoneNumber(), is("+13124706110"));
        assertThat(number.getAlias(), is("Holiday"));
        assertThat(number.getCallingNumberId(), is("PNf1106339f20120b3a17888e64169be5c68c70a5d"));
        assertThat(number.getAccountId(), is("AC6910fbcfaffb781e7dda33864003df692dc6c5ac"));
    }

    @Then("^compare the callingNumber to equal and unequal objects$")
    public void checkEquality() throws Throwable {
        assertTrue(number.equals(CallingNumber.fromJson(inputJson)));
        inputJson = "{\"phoneNumber\" : \"+13124706110\", \"alias\" : \"Different Alias\", \"revision\" : 5, \"dateCreated\" : \"Fri, 11 Nov 2016 13:42:22 GMT\", \"dateUpdated\" : \"Tue, 24 Jan 2017 15:58:20 GMT\", \"callingNumberId\" : \"PNf1106339f20120b3a17888e64169be5c68c70a5d\", \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/CallingNumbers/PNf1106339f20120b3a17888e64169be5c68c70a5d\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\"}";
        assertFalse(number.equals(CallingNumber.fromJson(inputJson)));
    }
}
