package com.vailsys.persephony.api.application;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ApplicationListTest {
    private static String testApplication = "{ \"uri\": \"/Accounts/ACd2a7073cc2f27f1347321881bdecc940843b0f71/Applications/AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"revision\": 1, \"dateCreated\": \"Tue, 15 Nov 2016 16:42:20 GMT\", \"dateUpdated\": \"Tue, 15 Nov 2016 16:42:20 GMT\", \"applicationId\": \"AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"accountId\": \"ACd2a7073cc2f27f1347321881bdecc940843b0f71\", \"alias\": \"test alias\", \"voiceUrl\": \"http://voice.url\",\"callConnectUrl\": \"http://connect.url\",\"voiceFallbackUrl\": \"http://fallback.url\",\"statusCallbackUrl\": \"http://callback.url\"}";
    private static String inputJson = "{\"total\":1, \"start\":0, \"end\":0, \"page\":0,\"numPages\":1,\"pageSize\":1, \"nextPageUri\":null, \"applications\": [" + ApplicationListTest.testApplication + "]}";
    private ApplicationList list;

    @Given("^an ApplicationList object$")
    public void makeListFromJson() throws Throwable {
        this.list = new ApplicationList("ACCOUNTID", "AUTHTOKEN", ApplicationListTest.inputJson);
    }

    @Then("^check that the ApplicationList was built correctly$")
    public void checkList() {
        assertThat(this.list.getLocalSize(), is(1));
    }

}
