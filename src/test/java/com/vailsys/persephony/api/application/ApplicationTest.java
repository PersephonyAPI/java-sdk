package com.vailsys.persephony.api.application;

import com.google.gson.reflect.TypeToken;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.lang.reflect.Type;
import java.util.HashMap;

import static com.vailsys.persephony.json.PersyGson.gson;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class ApplicationTest {
    private String origJSON;
    private String otherJSON = "{ \"uri\": \"/Accounts/ACd2a7073cc2f27f1347321881bdecc940843b0f71/Applications/AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"revision\": 2, \"dateCreated\": \"Tue, 15 Nov 2016 16:42:20 GMT\", \"dateUpdated\": \"Tue, 15 Nov 2016 16:42:20 GMT\", \"applicationId\": \"AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"accountId\": \"ACd2a7073cc2f27f1347321881bdecc940843b0f71\", \"alias\": \"updated alias\", \"voiceUrl\": \"http://other.url\",\"callConnectUrl\": \"http://connect.url\",\"voiceFallbackUrl\": \"http://fallback.url\",\"statusCallbackUrl\": \"http://callback.url\",\"smsUrl\": \"http://sms.url\",\"smsFallbackUrl\": \"http://sms-fallback.url\"}";
    private Application theApplication;

    @Given("^some JSON representing an application$")
    public void storeJSON(){
        this.origJSON = "{ \"uri\": \"/Accounts/ACd2a7073cc2f27f1347321881bdecc940843b0f71/Applications/AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"revision\": 1, \"dateCreated\": \"Tue, 15 Nov 2016 16:42:20 GMT\", \"dateUpdated\": \"Tue, 15 Nov 2016 16:42:20 GMT\", \"applicationId\": \"AP338850f402f2bc71abe053942a0ea8ec1829c66a\", \"accountId\": \"ACd2a7073cc2f27f1347321881bdecc940843b0f71\", \"alias\": \"test alias\", \"voiceUrl\": \"http://voice.url\",\"callConnectUrl\": \"http://connect.url\",\"voiceFallbackUrl\": \"http://fallback.url\",\"statusCallbackUrl\": \"http://callback.url\",\"smsUrl\": \"http://sms.url\",\"smsFallbackUrl\": \"http://sms-fallback.url\"}";
    }

    @Then("^build an Application object from that JSON$")
    public void buildApplication() throws Throwable {
        this.theApplication = Application.fromJson(origJSON);
    }

    @Then("^check the contents of that application$")
    public void checkApplicationAgainstJson(){
        Type t = new TypeToken<HashMap<String, Object>>() {}.getType();
        HashMap<String, Object> jsonMap = gson.fromJson(this.origJSON, t);

        assertThat((String)jsonMap.get("applicationId"), is(this.theApplication.getApplicationId()));
        assertThat((String)jsonMap.get("accountId"), is(this.theApplication.getAccountId()));
        assertThat((String) jsonMap.get("alias"), is(this.theApplication.getAlias()));
        assertThat((String) jsonMap.get("voiceUrl"), is(this.theApplication.getVoiceUrl()));
        assertThat((String) jsonMap.get("voiceFallbackUrl"), is(this.theApplication.getVoiceFallbackUrl()));
        assertThat((String) jsonMap.get("callConnectUrl"), is(this.theApplication.getCallConnectUrl()));
        assertThat((String) jsonMap.get("statusCallbackUrl"), is(this.theApplication.getStatusCallbackUrl()));
        assertThat((String) jsonMap.get("smsUrl"), is(this.theApplication.getSmsUrl()));
        assertThat((String) jsonMap.get("smsFallbackUrl"), is(this.theApplication.getSmsFallbackUrl()));
    }

    @Then("^check the application is( not)? equal$")
    public void checkEqual(String not) throws Throwable {
        if(not == null){
            assertTrue(this.theApplication.equals(Application.fromJson(origJSON)));
        } else {
            assertFalse(this.theApplication.equals(Application.fromJson(otherJSON)));
        }
    }

}
