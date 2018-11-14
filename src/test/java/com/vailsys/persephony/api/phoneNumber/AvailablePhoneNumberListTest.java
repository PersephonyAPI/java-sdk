package com.vailsys.persephony.api.phoneNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class AvailablePhoneNumberListTest {
    private static String testNumber = "{\"phoneNumber\" : \"+13122290365\", \"alias\" : \"312-229-0365\", \"revision\" : 1, \"dateCreated\" : \"Fri, 11 Nov 2016 13:42:25 GMT\", \"dateUpdated\" : \"Fri, 11 Nov 2016 13:42:25 GMT\", \"region\" : \"Illinois\", \"country\" : \"US\", \"voiceEnabled\" : true, \"smsEnabled\" : true}";

    private static String inputJson = "{\"total\": 1, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 1, \"nextPageUri\": null, \"availablePhoneNumbers\": [" + AvailablePhoneNumberListTest.testNumber + "]}";

    private AvailablePhoneNumberList list;

    @Given("^an AvailablePhoneNumberList object$")
    public void build() throws Throwable{
        String accountId = "AC1234567891234569347529861234926463781734";
        String authToken = "34513124a341b44234c143e214f22c2341242d234123ee";
        list = new AvailablePhoneNumberList(accountId, authToken, inputJson);
    }

    @Then("^check that the AvailablePhoneNumberList was built correctly$")
    public void checkList(){
        assertThat(list.getTotalSize(), is(1));
        assertThat(list.getLocalSize(), is(1));
        assertThat(list.get(0).getPhoneNumber(), is("+13122290365"));
    }
}
