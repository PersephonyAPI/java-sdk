package com.vailsys.persephony.api.phoneNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class IncomingPhoneNumberTest {
    private String json;
    private IncomingPhoneNumber number;

    @Given("^some JSON representing an incoming phone number$")
    public void createjson(){
        json = "{\"phoneNumber\" : \"+12248806207\", \"alias\" : \"Test Alias\", \"revision\" : 2, \"dateCreated\" : \"Mon, 07 Nov 2016 15:25:18 GMT\", \"dateUpdated\" : \"Wed, 07 Dec 2016 19:38:52 GMT\", \"phoneNumberId\" : \"PN8e458139313ed1fea8599e1a1d290a958d2d778e\", \"region\" : \"Illinois\", \"country\" : \"US\", \"voiceEnabled\" : true, \"smsEnabled\" : true, \"applicationId\" : \"AP427c0606920b5ad7cd97b51dd2196a398443cd8d\", \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/IncomingPhoneNumbers/PN8e458139313ed1fea8599e1a1d290a958d2d778e\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\"}";
    }

    @Then("^build an IncomingPhoneNumber object from that JSON$")
    public void create() throws Throwable {
        number = IncomingPhoneNumber.fromJson(json);
    }

    @Then("^check the contents of the IncomingPhoneNumber$")
    public void checkDefault() {
        assertThat(number.getPhoneNumber(), is("+12248806207"));
        assertThat(number.getAlias(), is("Test Alias"));
        assertThat(number.getPhoneNumberId(), is("PN8e458139313ed1fea8599e1a1d290a958d2d778e"));
        assertThat(number.getRegion(), is("Illinois"));
        assertThat(number.getCountry(), is("US"));
        assertTrue(number.isVoiceEnabled());
        assertTrue(number.isSmsEnabled());
        assertThat(number.getApplicationId(), is("AP427c0606920b5ad7cd97b51dd2196a398443cd8d"));
        assertThat(number.getAccountId(), is("AC6910fbcfaffb781e7dda33864003df692dc6c5ac"));
    }

    @Then("^compare the IncomingPhoneNumber to equal and unequal objects$")
    public void checkEquality() throws Throwable {
        assertTrue(number.equals(IncomingPhoneNumber.fromJson(json)));
        json = "{\"phoneNumber\" : \"+12248806207\", \"alias\" : \"Different Alias\", \"revision\" : 2, \"dateCreated\" : \"Mon, 07 Nov 2016 15:25:18 GMT\", \"dateUpdated\" : \"Wed, 07 Dec 2016 19:38:52 GMT\", \"phoneNumberId\" : \"PN8e458139313ed1fea8599e1a1d290a958d2d778e\", \"region\" : \"Illinois\", \"country\" : \"US\", \"voiceEnabled\" : true, \"smsEnabled\" : true, \"applicationId\" : \"AP427c0606920b5ad7cd97b51dd2196a398443cd8d\", \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/IncomingPhoneNumbers/PN8e458139313ed1fea8599e1a1d290a958d2d778e\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\"}";
        assertFalse(number.equals(IncomingPhoneNumber.fromJson(json)));
    }

}
