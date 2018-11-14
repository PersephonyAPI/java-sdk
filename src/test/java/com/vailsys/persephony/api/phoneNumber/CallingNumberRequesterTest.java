package com.vailsys.persephony.api.phoneNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import org.mockserver.verify.VerificationTimes;
import world.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CallingNumberRequesterTest {
    private CallingNumberRequester requester;

    private String newCallingNumber = "{\"phoneNumber\" : \"+18740937465\", \"alias\" : \"Created Calling Number\", \"revision\" : 5, \"dateCreated\" : \"Fri, 11 Nov 2016 13:42:22 GMT\", \"dateUpdated\" : \"Tue, 24 Jan 2017 15:58:20 GMT\", \"callingNumberId\" : \"PNf1106339f20120b3a17888e64169be5c68c70a5d\", \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/CallingNumbers/PNf1106339f20120b3a17888e64169be5c68c70a5d\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\"}";

    private String listJson = "{\"total\" : 1, \"start\" : 0, \"end\" : 1, \"page\" : 0, \"numPages\" : 1, \"pageSize\" : 100, \"nextPageUri\" : null, \"callingNumbers\" : ["+ this.newCallingNumber + "]}";

    @Given("^a CallingNumberRequester with the credentials (.*) and (.*) and using the accountId (.*)$")
    public void create(String accountId, String authToken, String actingId) throws Throwable{
        requester = new CallingNumberRequester(accountId, authToken, actingId);
        requester.setPersyUrl("http://127.0.0.1:" + Helper.getServerPort());
    }

    @Then("^check the CallingNumberRequester acting accountId is (.*)$")
    public void checkActingAcc(String actingId){
        assertThat(requester.getActingAccountId(), is(actingId));
    }

    @Then("^check the CallingNumberRequester path is (.*)$")
    public void assertPath(String path){
        assertThat(requester.getPath(), is(path));
    }

    @Then("^create a CallingNumber$")
    public void createCallingNumber() throws Throwable {
        CallingNumberCreateOptions options = new CallingNumberCreateOptions();
        options.setPhoneNumber("+18740937465");
        options.setAlias("Created Calling Number");

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(this.newCallingNumber)
        );

        CallingNumber cn = requester.create(options);
        CallingNumber orig = CallingNumber.fromJson(newCallingNumber);

        assertTrue(cn.equals(orig));
    }

    @Then("^delete a CallingNumber$")
    public void deleteCallingNumber() throws Throwable {
        String callingNumberId = "PN338850f402f2bc71abe053942a0ea8ec1829c66a";

        Helper.getMockServer().when(
                request().withMethod("DELETE").withPath(this.requester.getPath() + "/" + callingNumberId)
        ).respond(
                response().withStatusCode(204)
        );

        this.requester.delete(callingNumberId);

        Helper.getMockServer().verify(
                request().withMethod("DELETE")
                        .withPath(this.requester.getPath()+"/"+callingNumberId),
                VerificationTimes.exactly(1)
        );
    }

    @Then("^get a CallingNumber$")
    public void getCallingNumber()throws Throwable{
        String callingNumberId = "PNf1106339f20120b3a17888e64169be5c68c70a5d";

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath() + "/" + callingNumberId)
        ).respond(
                response().withStatusCode(200).withBody(newCallingNumber)
        );

        CallingNumber cn = requester.get(callingNumberId);
        CallingNumber orig = CallingNumber.fromJson(newCallingNumber);

        assertTrue(cn.equals(orig));
    }

    @Then("^update a CallingNumber$")
    public void updateCallingNumber() throws Throwable{
        String callingNumberId = "PNf1106339f20120b3a17888e64169be5c68c70a5d";

        String updatedNumber = "{\"phoneNumber\" : \"+18740937465\", \"alias\" : \"Modified Alias\", \"revision\" : 5, \"dateCreated\" : \"Fri, 11 Nov 2016 13:42:22 GMT\", \"dateUpdated\" : \"Tue, 24 Jan 2017 15:58:20 GMT\", \"callingNumberId\" : \"PNf1106339f20120b3a17888e64169be5c68c70a5d\", \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/CallingNumbers/PNf1106339f20120b3a17888e64169be5c68c70a5d\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\"}";

        CallingNumberUpdateOptions options = new CallingNumberUpdateOptions();
        options.setAlias("Modified Alias");

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(requester.getPath() + "/" + callingNumberId)
        ).respond(
                response().withStatusCode(200).withBody(updatedNumber)
        );

        CallingNumber cn = requester.update(callingNumberId, options);
        CallingNumber orig = CallingNumber.fromJson(updatedNumber);

        assertTrue(cn.equals(orig));
    }

    @Then("^get a list of calling numbers$")
    public void getList() throws Throwable{
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(listJson)
        );

        CallingNumberList list = requester.get();
        CallingNumberList orig = new CallingNumberList("ACCOUNTID", "AUTHTOKEN", listJson);
        assertThat(list.getTotalSize(), is(orig.getTotalSize()));
        assertThat(list.getLocalSize(), is(orig.getLocalSize()));
        assertThat(list.get(0).getPhoneNumber(), is(orig.get(0).getPhoneNumber()));
    }

    @Then("^get a list of calling numbers with filters$")
    public void getListFiltered() throws Throwable{
        CallingNumberSearchFilters filters = new CallingNumberSearchFilters();
        filters.setPhoneNumber("^\\+1874[0-9]{7}$");

        HashMap<String, List<String>> listQuery = new HashMap<>();
        listQuery.put("alias", new ArrayList<String>(Arrays.asList(filters.getPhoneNumber())));

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath()).withQueryStringParameters(listQuery)
        ).respond(
                response().withStatusCode(200).withBody(listJson)
        );

        CallingNumberList cl = requester.get(filters);
        CallingNumberList orig = new CallingNumberList("ACCOUNTID", "AUTHTOKEN", listJson);

        assertThat(cl.getLocalSize(), is(orig.getLocalSize()));
        assertThat(cl.getTotalSize(), is(orig.getTotalSize()));
        assertTrue(cl.get(0).equals(orig.get(0)));

    }


}
