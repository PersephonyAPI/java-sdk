package com.vailsys.persephony.api.phoneNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CallingNumberListTest {
    private CallingNumberList list;

    private String aNumber = "{\"phoneNumber\" : \"+13124706110\", \"alias\" : \"Holiday\", \"revision\" : 5, \"dateCreated\" : \"Fri, 11 Nov 2016 13:42:22 GMT\", \"dateUpdated\" : \"Tue, 24 Jan 2017 15:58:20 GMT\", \"callingNumberId\" : \"PNf1106339f20120b3a17888e64169be5c68c70a5d\", \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/CallingNumbers/PNf1106339f20120b3a17888e64169be5c68c70a5d\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\"}";

    private String listJson = "{\"total\" : 1, \"start\" : 0, \"end\" : 1, \"page\" : 0, \"numPages\" : 1, \"pageSize\" : 100, \"nextPageUri\" : null, \"callingNumbers\" : ["+ this.aNumber + "]}";

    @Given("^a CallingNumberList object$")
    public void create() throws Throwable {
        String accountId = "AC1234567891234569347529861234926463781734";
        String authToken = "34513124a341b44234c143e214f22c2341242d234123ee";
        list = new CallingNumberList(accountId, authToken, listJson);
    }

    @Then("^check that the CallingNumberList was built correctly$")
    public void checkList(){
        assertThat(list.getTotalSize(), is(1));
        assertThat(list.getLocalSize(), is(1));
        assertThat(list.get(0).getPhoneNumber(), is("+13124706110"));
    }
}
