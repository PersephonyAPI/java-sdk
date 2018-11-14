package com.vailsys.persephony.api.account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import world.Helper;

import static com.vailsys.persephony.json.PersyGson.gson;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class AccountRequesterTest {
    private AccountRequester requester;
    private String accountJson = "{\"metadata\" : null, \"credit\" : 0.000000, \"uri\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac\", \"revision\" : 1, \"dateCreated\" : \"Thu, 03 Nov 2016 17:24:26 GMT\", \"dateUpdated\" : \"Thu, 03 Nov 2016 17:24:26 GMT\", \"accountId\" : \"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\", \"authToken\" : \"4213a33b7a22eb48c2b9a09d1c514d95e5e03dc17\", \"alias\" : \"Master Account\", \"label\" : null, \"type\" : \"trial\", \"status\" : \"active\", \"subresourceUris\" : {\"applications\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Applications\", \"calls\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Calls\", \"availablePhoneNumbers\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/AvailablePhoneNumbers\", \"conferences\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Conferences\", \"incomingPhoneNumbers\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/IncomingPhoneNumbers\", \"logs\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Logs\", \"callingNumbers\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/CallingNumbers\", \"recordings\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Recordings\", \"queues\" : \"/Accounts/AC6910fbcfaffb781e7dda33864003df692dc6c5ac/Queues\"}}";

    @Given("^an AccountRequester with the credentials (.*) and (.*) and using the accountId (.*)$")
    public void create(String accountId, String authToken, String actingId) throws Throwable{
        requester = new AccountRequester(accountId, authToken, actingId);
        requester.setPersyUrl("http://127.0.0.1:" + Helper.getServerPort());
    }

    @Then("^check the AccountRequester acting accountId is (.*)$")
    public void assertActing(String acting){
        assertThat(requester.getActingAccountId(), is(acting));
    }

    @Then("^check the AccountRequester path is (.*)$")
    public void assertPath(String path){
        assertThat(requester.getPath(), is(path));
    }

    @Then("^get an account$")
    public void getAcc() throws Throwable {
        String accId = "AC6910fbcfaffb781e7dda33864003df692dc6c5ac";
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(requester.getPath() + "/" + accId)
        ).respond(
                response().withStatusCode(200).withBody(accountJson)
        );

        Account acc = requester.get(accId);
        Account orig = Account.fromJson(accountJson);

        assertTrue(acc.equals(orig));
    }

    @Then("^modify an account$")
    public void modifyAcc() throws Throwable {
        String accId = "AC6910fbcfaffb781e7dda33864003df692dc6c5ac";
        AccountUpdateOptions options = new AccountUpdateOptions();
        options.setAlias("Master Account");

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(requester.getPath() + "/" + accId).withBody(gson.toJson(options))
        ).respond(
                response().withStatusCode(200).withBody(accountJson)
        );

        Account acc = requester.update(accId, options);
        Account orig = Account.fromJson(accountJson);

        assertTrue(acc.equals(orig));
    }




}
