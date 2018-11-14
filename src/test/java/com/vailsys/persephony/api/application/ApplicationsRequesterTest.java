package com.vailsys.persephony.api.application;

import com.twitter.app.App;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.mockserver.integration.ClientAndServer;
import world.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockserver.configuration.ConfigurationProperties.overrideLogLevel;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class ApplicationsRequesterTest {
    public ApplicationsRequester requester;

    private static String aTestApplication = "{ \"uri\": \"/Accounts/ACd2a7073cc2f27f1347321881bdecc940843b0f71/Applications/AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"revision\": 1, \"dateCreated\": \"Tue, 15 Nov 2016 16:42:20 GMT\", \"dateUpdated\": \"Tue, 15 Nov 2016 16:42:20 GMT\", \"applicationId\": \"AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"accountId\": \"ACd2a7073cc2f27f1347321881bdecc940843b0f71\", \"alias\": \"test alias\", \"voiceUrl\": \"http://voice.url\",\"callConnectUrl\": \"http://connect.url\",\"voiceFallbackUrl\": \"http://fallback.url\",\"statusCallbackUrl\": \"http://callback.url\"}";

    private static String aTestApplicationList = "{\"total\": 4, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 20, \"nextPageUri\": null, \"applications\": [" + ApplicationsRequesterTest.aTestApplication + "," + ApplicationsRequesterTest.aTestApplication + "," + ApplicationsRequesterTest.aTestApplication + "," + ApplicationsRequesterTest.aTestApplication + "]}";

    private static String anUpdatedTestApplication = "{ \"uri\": \"/Accounts/ACd2a7073cc2f27f1347321881bdecc940843b0f71/Applications/AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"revision\": 1, \"dateCreated\": \"Tue, 15 Nov 2016 16:42:20 GMT\", \"dateUpdated\": \"Tue, 15 Nov 2016 16:42:20 GMT\", \"applicationId\": \"AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"accountId\": \"ACd2a7073cc2f27f1347321881bdecc940843b0f71\", \"alias\": \"updated alias\", \"voiceUrl\": \"http://updated.url\",\"callConnectUrl\": \"http://connect.url\",\"voiceFallbackUrl\": \"http://fallback.url\",\"statusCallbackUrl\": \"http://callback.url\"}";

    private static String aTestApplicationWithOptions = "{ \"uri\": \"/Accounts/ACd2a7073cc2f27f1347321881bdecc940843b0f71/Applications/AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"revision\": 1, \"dateCreated\": \"Tue, 15 Nov 2016 16:42:20 GMT\", \"dateUpdated\": \"Mon, 14 Nov 2016 16:42:20 GMT\", \"applicationId\": \"AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"accountId\": \"ACd2a7073cc2f27f1347321881bdecc940843b0f71\", \"alias\": \"options alias\", \"voiceUrl\": \"http://options.url\",\"callConnectUrl\": \"http://connect.url\",\"voiceFallbackUrl\": \"http://fallback.url\",\"statusCallbackUrl\": \"http://callback.url\"}";

    @Given("^an ApplicationsRequester with the credentials (.*) and (.*) and using the accountId (.*)$")
    public void createApplicationsRequester(String accId, String token, String acting) throws Throwable {
        this.requester = new ApplicationsRequester(accId, token, acting);
        this.requester.setPersyUrl("http://127.0.0.1:" + Helper.getServerPort());
    }

    @Then("^check the ApplicationsRequester acting accountId is (.*)$")
    public void checkActingAccountId(String acting){
        assertThat(requester.getActingAccountId(), is(acting));
    }

    @Then("^check the ApplicationsRequester path is (.*)$")
    public void checkPath(String path){
        assertThat(this.requester.getPath(), is(path));
    }

    @Then("^get a list of applications$")
    public void getApplicationList() throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(ApplicationsRequesterTest.aTestApplicationList)
        );

        ApplicationList al = this.requester.get();
        ApplicationList orig = new ApplicationList("ACCOUNTID", "AUTHTOKEN", ApplicationsRequesterTest.aTestApplicationList);
        assertThat(al.getTotalSize(), is(orig.getTotalSize()));
        assertThat(al.getLocalSize(), is(orig.getLocalSize()));
    }

    @Then("^get a list of applications with filters$")
    public void getApplicationListWithFilters() throws Throwable {
        ApplicationsSearchFilters asf = new ApplicationsSearchFilters();
        asf.setAlias("test alias");

        HashMap<String, List<String>> listQuery = new HashMap<>();
        listQuery.put("alias", new ArrayList<String>(Arrays.asList("test alias")));

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath()).withQueryStringParameters(listQuery)
        ).respond(
                response().withStatusCode(200).withBody(ApplicationsRequesterTest.aTestApplicationList)
        );

        ApplicationList al = this.requester.get(asf);
        ApplicationList orig = new ApplicationList("ACCOUNTID", "AUTHTOKEN", ApplicationsRequesterTest.aTestApplicationList);
        assertThat(al.getLocalSize(), is(orig.getLocalSize()));
        assertThat(al.getTotalSize(), is(orig.getTotalSize()));
    }

    @Then("^get an application by its applicationId$")
    public void getApplication() throws Throwable {
        String applicationId = "AP338850f402f2bc71abe053942a0ea8ec1829c66a";

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath() + "/" + applicationId)
        ).respond(
                response().withStatusCode(200).withBody(ApplicationsRequesterTest.aTestApplication)
        );

        Application a = this.requester.get(applicationId);
        Application orig = Application.fromJson(ApplicationsRequesterTest.aTestApplication);
        assertTrue(a.equals(orig));
    }

    @Then("^update an application$")
    public void updateApplication() throws Throwable {
        String applicationId = "AP338850f402f2bc71abe053942a0ea8ec1829c66a";
        ApplicationUpdateOptions options = new ApplicationUpdateOptions();
        options.setAlias("updated alias");
        options.setVoiceUrl("http://updated.url");

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.requester.getPath() + "/" + applicationId)
        ).respond(
                response().withStatusCode(200).withBody(ApplicationsRequesterTest.anUpdatedTestApplication)
        );

        Application a = this.requester.update(applicationId, options);
        Application orig = Application.fromJson(ApplicationsRequesterTest.anUpdatedTestApplication);
        assertTrue(a.equals(orig));

    }

    @Then("^create an application$")
    public void createApplication() throws Throwable {

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(ApplicationsRequesterTest.aTestApplication)
        );

        Application a = this.requester.create();
        Application orig = Application.fromJson(ApplicationsRequesterTest.aTestApplication);
        assertTrue(a.equals(orig));
    }

    @Then("^create an application with options$")
    public void createApplicationWithOptions() throws Throwable {
        ApplicationCreateOptions options = new ApplicationCreateOptions();
        options.setAlias("test alias");
        options.setVoiceUrl("http://voice.url");

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(ApplicationsRequesterTest.aTestApplication)
        );

        Application a = this.requester.create(options);
        Application orig = Application.fromJson(ApplicationsRequesterTest.aTestApplication);
        assertTrue(a.equals(orig));
    }

    @Then("^delete an application$")
    public void deleteApplication() throws Throwable {
        String applicationId = "AP338850f402f2bc71abe053942a0ea8ec1829c66a";

        Helper.getMockServer().when(
                request().withMethod("DELETE").withPath(this.requester.getPath() + "/" + applicationId)
        ).respond(
                response().withStatusCode(204)
        );

        this.requester.delete(applicationId);

    }


}
