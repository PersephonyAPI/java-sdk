package com.vailsys.persephony.api.phoneNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class IncomingPhoneNumberListTest {
    private String number = "{\"phoneNumber\" : \"+12248806207\", \"alias\" : \"Test Alias\", \"revision\" : 2, \"dateCreated\" : \"Mon, 07 Nov 2016 15:25:18 GMT\", \"dateUpdated\" : \"Wed, 07 Dec 2016 19:38:52 GMT\", \"phoneNumberId\" : \"PN8e458139313ed1fea8599e1a1d290a958d2d778e\", \"region\" : \"Illinois\", \"country\" : \"US\", \"voiceEnabled\" : true, \"smsEnabled\" : true, \"applicationId\" : \"AP427c0606920b5ad7cd97b51dd2196a398443cd8d\", \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/IncomingPhoneNumbers/PN8e458139313ed1fea8599e1a1d290a958d2d778e\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\"}";

    private String listJson = "{\"total\" : 1, \"start\" : 0, \"end\" : 1, \"page\" : 0, \"numPages\" : 1, \"pageSize\" : 100, \"nextPageUri\" : null, \"incomingPhoneNumbers\" : ["+ this.number + "]}";

    private IncomingPhoneNumberList list;

    @Given("^an IncomingPhoneNumberList object$")
    public void createList() throws Throwable {
        String accountId = "AC1234567891234569347529861234926463781734";
        String authToken = "34513124a341b44234c143e214f22c2341242d234123ee";
        list = new IncomingPhoneNumberList(accountId, authToken, listJson);
    }

    @Then("^check that the IncomingPhoneNumberList was built correctly$")
    public void checkList(){
        assertThat(list.getLocalSize(), is(1));
        assertThat(list.getTotalSize(), is(1));
        assertThat(list.get(0).getPhoneNumber(), is("+12248806207"));
    }
}
