package com.vailsys.persephony.api.account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class AccountTest {
    private String accountJson;
    private Account account;

    @Given("^some JSON representing an account$")
    public void json(){
        accountJson = "{\"metadata\" : null, \"credit\" : 0.000000, \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac\", \"revision\" : 1, \"dateCreated\" : \"Thu, 03 Nov 2016 17:24:26 GMT\", \"dateUpdated\" : \"Thu, 03 Nov 2016 17:24:26 GMT\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\", \"authToken\" : \"4213a33b7a22eb48c2b9a09d1c514d95e5e03dc17\", \"alias\" : \"Master Account\", \"label\" : null, \"type\" : \"trial\", \"status\" : \"active\", \"subresourceUris\" : {\"applications\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Applications\", \"calls\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Calls\", \"availablePhoneNumbers\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/AvailablePhoneNumbers\", \"conferences\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Conferences\", \"incomingPhoneNumbers\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/IncomingPhoneNumbers\", \"logs\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Logs\", \"callingNumbers\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/CallingNumbers\", \"recordings\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Recordings\", \"queues\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Queues\"}}";
    }

    @Then("^build an Account object from that JSON$")
    public void build() throws Throwable {
        account = Account.fromJson(accountJson);
    }

    @Then("^check the contents of that account$")
    public void checkContents(){
        assertThat(account.getAccountId(), is("AC6910fbcfaffb781e7dda33864003df692dc6c5ac"));
        assertThat(account.getAuthToken(), is("4213a33b7a22eb48c2b9a09d1c514d95e5e03dc17"));
        assertThat(account.getAlias(), is("Master Account"));
        assertThat(account.getLabel(), is(nullValue()));
        assertThat(account.getType(), is(Type.TRIAL));
        assertThat(account.getStatus(), is(Status.ACTIVE));
        assertThat(account.getSubresourceUris().get("logs"), is("/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Logs"));
    }

    @Then("^compare the account with equal and unequal objects$")
    public void compare() throws Throwable {
        assertTrue(account.equals(Account.fromJson(accountJson)));
        accountJson = "{\"metadata\" : null, \"credit\" : 0.000000, \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac\", \"revision\" : 1, \"dateCreated\" : \"Thu, 03 Nov 2016 17:24:26 GMT\", \"dateUpdated\" : \"Thu, 03 Nov 2016 17:24:26 GMT\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\", \"authToken\" : \"4213a33b7a22eb48c2b9a09d1c514d95e5e03dc17\", \"alias\" : \"Different Alias\", \"label\" : null, \"type\" : \"trial\", \"status\" : \"active\", \"subresourceUris\" : {\"applications\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Applications\", \"calls\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Calls\", \"availablePhoneNumbers\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/AvailablePhoneNumbers\", \"conferences\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Conferences\", \"incomingPhoneNumbers\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/IncomingPhoneNumbers\", \"logs\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Logs\", \"callingNumbers\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/CallingNumbers\", \"recordings\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Recordings\", \"queues\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Queues\"}}";

        assertFalse(account.equals(Account.fromJson(accountJson)));
    }
}
