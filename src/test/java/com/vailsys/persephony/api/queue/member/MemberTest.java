package com.vailsys.persephony.api.queue.member;

import com.google.common.reflect.TypeToken;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.lang.reflect.Type;
import java.text.FieldPosition;
import java.util.Date;
import java.util.HashMap;

import static com.vailsys.persephony.json.PersyGson.PersyDateFormat;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

import static com.vailsys.persephony.json.PersyGson.gson;
import static org.junit.Assert.assertTrue;

public class MemberTest {
    private String origJSON;
    private String otherJSON = "{\"uri\":\"/Accounts/AC3109606ad01a4f367ea2e54f1e44d5c187b7c837/Queues/QUeda341f1fba015aa029a3342f23a3ae0c45e302b/Members/CAb933917ae0d3547bd65da77a4aa50e0329850401\",\"callId\":\"CAb933917ae0d3547bd65da77a4aa50e0329850401\",\"waitTime\":4,\"position\":3,\"dateEnqueued\":\"Thu, 13 Oct 2016 18:28:58 GMT\"}";
    private Member member;

    @Given("^Some JSON representing a Member$")
    public void createJson(){
        this.origJSON = "{\"uri\":\"/Accounts/AC3109606ad01a4f367ea2e54f1e44d5c187b7c837/Queues/QUeda341f1fba015aa029a3342f23a3ae0c45e302b/Members/CAb933917ae0d3547bd65da77a4aa50e0329850401\",\"callId\":\"CAb933917ae0d3547bd65da77a4aa50e0329850401\",\"waitTime\":0,\"position\":1,\"dateEnqueued\":\"Thu, 13 Oct 2016 18:28:58 GMT\"}";
    }

    @Then("^build a Member object from that JSON$")
    public void createMember() throws Throwable {
        this.member = Member.fromJson(origJSON);
    }

    @Then("^check the contents of the Member$")
    public void checkContents() {
        Type t = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String, Object> jsonMap = gson.fromJson(this.origJSON, t);

        assertThat(jsonMap.get("uri").toString(), is(member.getUri()));
        assertThat(jsonMap.get("callId").toString(), is(member.getCallId()));
        assertThat((Integer) ((Double) jsonMap.get("waitTime")).intValue(), is(member.getWaitTime()));
        assertThat((Integer) ((Double) jsonMap.get("position")).intValue(), is(member.getPosition()));
        StringBuffer dateString = new StringBuffer();
        PersyDateFormat.format(this.member.getDateEnqueued(), dateString, new FieldPosition(0));
        assertThat((String) jsonMap.get("dateEnqueued"), is(dateString.toString()));
    }

    @Then("^check the Member is( not)? equal$")
    public void checkEqual(String not) throws Throwable {
        if(not == null){
            assertTrue(this.member.equals(Member.fromJson(origJSON)));
        } else {
            assertFalse(this.member.equals(Member.fromJson(otherJSON)));
        }

    }
}
