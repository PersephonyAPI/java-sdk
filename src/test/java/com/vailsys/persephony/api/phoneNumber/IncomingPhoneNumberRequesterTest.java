package com.vailsys.persephony.api.phoneNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.mockserver.verify.VerificationTimes;
import world.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class IncomingPhoneNumberRequesterTest {
    private IncomingPhoneNumberRequester requester;

    private String incomingJson = "{\"phoneNumber\" : \"+12248806207\", \"alias\" : \"Test Alias\", \"revision\" : 2, \"dateCreated\" : \"Mon, 07 Nov 2016 15:25:18 GMT\", \"dateUpdated\" : \"Wed, 07 Dec 2016 19:38:52 GMT\", \"phoneNumberId\" : \"PN8e458139313ed1fea8599e1a1d290a958d2d778e\", \"region\" : \"Illinois\", \"country\" : \"US\", \"voiceEnabled\" : true, \"smsEnabled\" : true, \"applicationId\" : \"AP427c0606920b5ad7cd97b51dd2196a398443cd8d\", \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/IncomingPhoneNumbers/PN8e458139313ed1fea8599e1a1d290a958d2d778e\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\"}";

    private String listJson = "{\"total\" : 1, \"start\" : 0, \"end\" : 1, \"page\" : 0, \"numPages\" : 1, \"pageSize\" : 100, \"nextPageUri\" : null, \"incomingPhoneNumbers\" : ["+ this.incomingJson + "]}";

    @Given("^an IncomingPhoneNumberRequester with the credentials (.*) and (.*) and using the accountId (.*)$")
    public void create(String accountId, String authToken, String actingId) throws Throwable{
        requester = new IncomingPhoneNumberRequester(accountId, authToken, actingId);
        requester.setPersyUrl("http://127.0.0.1:" + Helper.getServerPort());
    }

    @Then("^check the IncomingPhoneNumberRequest acting accountId is (.*)$")
    public void assertActingId(String id){
     assertThat(requester.getActingAccountId(), is(id));
    }

    @Then("^check the IncomingPhoneNumberRequester path is (.*)$")
    public void assertPath(String path){
        assertThat(requester.getPath(), is(path));
    }

    @Then("^get a list of incoming phone numbers$")
    public void getList() throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(requester.getPath())
        ).respond(
                response().withStatusCode(200)
.withBody(listJson)
        );

        IncomingPhoneNumberList il = requester.get();
        IncomingPhoneNumberList orig = new IncomingPhoneNumberList("ACCOUNTID", "AUTHTOKEN", listJson);

        assertThat(il.getLocalSize(), is(orig.getLocalSize()));
        assertThat(il.getTotalSize(), is(orig.getTotalSize()));
        assertTrue(il.get(0).equals(orig.get(0)));
    }

    @Then("^get a list of incoming phone numbers with filters$")
    public void getFilteredList() throws Throwable {
        IncomingPhoneNumberSearchFilters filters = new IncomingPhoneNumberSearchFilters();
        filters.setPhoneNumber("^\\+1224[0-9]{7}$");
        filters.setAlias("Test Alias");

        HashMap<String, List<String>> listQuery = new HashMap<>();
        listQuery.put("phoneNumber", new ArrayList<String>(Arrays.asList(filters.getPhoneNumber())));
        listQuery.put("alias", new ArrayList<String>(Arrays.asList(filters.getAlias())));

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(requester.getPath()).withQueryStringParameters(listQuery)
        ).respond(
                response().withStatusCode(200).withBody(listJson)
        );

        IncomingPhoneNumberList il = requester.get(filters);
        IncomingPhoneNumberList orig = new IncomingPhoneNumberList("ACCOUNTID", "AUTHTOKEN", listJson);

        assertThat(il.getLocalSize(), is(orig.getLocalSize()));
        assertThat(il.getTotalSize(), is(orig.getTotalSize()));
        assertTrue(il.get(0).equals(orig.get(0)));
    }

    @Then("^purchase an incoming phone number$")
    public void purchase() throws Throwable {
        String phoneNumber = "+12248806207";
        IncomingPhoneNumberCreateOptions options = new IncomingPhoneNumberCreateOptions(phoneNumber);
        options.setAlias("Test Alias");
        options.setApplicationId("AP427c0606920b5ad7cd97b51dd2196a398443cd8d");

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(incomingJson)
        );

        IncomingPhoneNumber in = requester.create(options);
        IncomingPhoneNumber orig = IncomingPhoneNumber.fromJson(incomingJson);

        assertTrue(in.equals(orig));
    }

    @Then("^delete an incoming phone number$")
    public void delete() throws Throwable{
        String id = "PN8e458139313ed1fea8599e1a1d290a958d2d778e";

        Helper.getMockServer().when(
                request().withMethod("DELETE").withPath(requester.getPath() + "/" + id)
        ).respond(response().withStatusCode(204));

        requester.delete(id);

        Helper.getMockServer().verify(
                request().withMethod("DELETE").withPath(requester.getPath() + "/" + id),
                VerificationTimes.exactly(1)
        );
    }

    @Then("^get the properties of an incoming phone number$")
    public void get() throws Throwable{
        String id = "PN8e458139313ed1fea8599e1a1d290a958d2d778e";

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(requester.getPath() + "/" + id)
        ).respond(
                response().withStatusCode(200).withBody(incomingJson)
        );

        IncomingPhoneNumber in = requester.get(id);
        IncomingPhoneNumber orig = IncomingPhoneNumber.fromJson(incomingJson);

        assertTrue(in.equals(orig));
    }

    @Then("^modify an incoming phone number$")
    public void modify()throws Throwable {
        String id = "PN8e458139313ed1fea8599e1a1d290a958d2d778e";
        IncomingPhoneNumberUpdateOptions options = new IncomingPhoneNumberUpdateOptions();
        options.setAlias("Test Alias");
        options.setApplicationId("PN8e458139313ed1fea8599e1a1d290a958d2d778e");

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(requester.getPath() + "/" + id)
        ).respond(
                response().withStatusCode(200).withBody(incomingJson)
        );

        IncomingPhoneNumber in = requester.update(id, options);
        IncomingPhoneNumber orig = IncomingPhoneNumber.fromJson(incomingJson);
        assertTrue(in.equals(orig));
    }
}
