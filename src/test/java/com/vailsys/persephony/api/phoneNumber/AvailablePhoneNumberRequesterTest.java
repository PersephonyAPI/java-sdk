package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.PersyException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import world.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class AvailablePhoneNumberRequesterTest {
    private AvailablePhoneNumberRequester requester;

    private static String testNumber = "{\"phoneNumber\" : \"+13122290365\", \"alias\" : \"312-229-0365\", \"revision\" : 1, \"dateCreated\" : \"Fri, 11 Nov 2016 13:42:25 GMT\", \"dateUpdated\" : \"Fri, 11 Nov 2016 13:42:25 GMT\", \"region\" : \"Illinois\", \"country\" : \"US\", \"voiceEnabled\" : true, \"smsEnabled\" : true}";

    private static String numberList = "{\"total\": 1, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 1, \"nextPageUri\": null, \"availablePhoneNumbers\": [" + AvailablePhoneNumberRequesterTest.testNumber + "]}";

    @Given("^an AvailablePhoneNumberRequester with the credentials (.*) and (.*) and using the accountId (.*)$")
    public void create(String accountId, String authToken, String actingAccountId) throws PersyException {
        requester = new AvailablePhoneNumberRequester(accountId, authToken, actingAccountId);
        this.requester.setPersyUrl("http://127.0.0.1:"+ Helper.getServerPort());
    }

    @Then("^check the AvailablePhoneNumberRequester acting accountId is (.*)$")
    public void checkActingId(String actingId){
        assertThat(requester.getActingAccountId(), is(actingId));
    }

    @Then("^check the AvailablePhoneNumberRequester path is (.*)$")
    public void checkPath(String path){
        assertThat(requester.getPath(), is(path));
    }

    @Then("^get a list of available phone numbers$")
    public void getList() throws PersyException {
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(AvailablePhoneNumberRequesterTest.numberList)
        );

       AvailablePhoneNumberList al = requester.get();
       AvailablePhoneNumberList orig = new AvailablePhoneNumberList("ACCOUNTID","AUTHTOKEN", numberList);

       assertThat(al.getTotalSize(), is(orig.getTotalSize()));
       assertThat(al.getLocalSize(), is(orig.getLocalSize()));
       assertThat(al.get(0).getPhoneNumber(), is(orig.get(0).getPhoneNumber()));
    }

    @Then("^get a list of available phone numbers with filters$")
    public void getListFiltered() throws Throwable {
        AvailablePhoneNumberSearchFilters filters = new AvailablePhoneNumberSearchFilters();
        filters.setAlias("312-229-0365");

        HashMap<String, List<String>> listQuery = new HashMap<>();
        listQuery.put("alias", new ArrayList<String>(Arrays.asList(filters.getAlias())));

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(requester.getPath()).withQueryStringParameters(listQuery)
        ).respond(
                response().withStatusCode(200).withBody(AvailablePhoneNumberRequesterTest.numberList)
        );

        AvailablePhoneNumberList al = requester.get(filters);
        AvailablePhoneNumberList orig = new AvailablePhoneNumberList("ACCOUNTID","AUTHTOKEN", numberList);

        assertThat(al.getTotalSize(), is(orig.getTotalSize()));
        assertThat(al.getLocalSize(), is(orig.getLocalSize()));
        assertThat(al.get(0).getPhoneNumber(), is(orig.get(0).getPhoneNumber()));
    }

}
