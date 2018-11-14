package com.vailsys.persephony.api.conference.participant;

import com.google.common.reflect.TypeToken;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.lang.reflect.Type;
import java.util.HashMap;

import static com.vailsys.persephony.json.PersyGson.gson;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ParticipantTest {

    private String origJSON;
    private String otherJSON = "{ \"accountId\":\"ACea5735de286cb68f47e78316f647d19522b81d00\", \"conferenceId\":\"CFd0cc3ab95118aaa597039793a1692313fa9c4936\", \"callId\":\"CAef219e4e9152a4b31888620cf391adcae5b6f18c\", \"uri\":\"/Accounts/ACea5735de286cb68f47e78316f647d19522b81d00/Conferences/CFd0cc3ab95118aaa597039793a1692313fa9c4936/Participants/CAef219e4e9152a4b31888620cf391adcae5b6f18c\", \"dateCreated\":\"Thu, 13 Oct 2016 18:23:31 GMT\", \"dateUpdated\":\"Thu, 13 Oct 2016 18:23:31 GMT\", \"revision\":1, \"talk\":true, \"listen\":true, \"startConfOnEnter\":false }";
    private Participant theParticipant;

    @Given("^Some JSON representing a participant$")
    public void storeJSON(){
        this.origJSON = "{ \"accountId\":\"ACea5735de286cb68f47e78316f647d19522b81d00\", \"conferenceId\":\"CFd0cc3ab95118aaa597039793a1692313fa9c4936\", \"callId\":\"CAef219e4e9152a4b31888620cf391adcae5b6f18c\", \"uri\":\"/Accounts/ACea5735de286cb68f47e78316f647d19522b81d00/Conferences/CFd0cc3ab95118aaa597039793a1692313fa9c4936/Participants/CAef219e4e9152a4b31888620cf391adcae5b6f18c\", \"dateCreated\":\"Thu, 13 Oct 2016 18:23:31 GMT\", \"dateUpdated\":\"Thu, 13 Oct 2016 18:23:31 GMT\", \"revision\":1, \"talk\":true, \"listen\":true, \"startConfOnEnter\":true }";

    }

    @When("^a Participant object is built from that JSON$")
    public void buildParticipant() throws Throwable {
        this.theParticipant = Participant.fromJson(origJSON);
    }

    @Then("^check the contents of that participant$")
    public void checkParticipantAgainstJson(){
        Type t = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String,Object> jsonMap = gson.fromJson(this.origJSON, t);

        assertTrue(jsonMap.get("accountId").equals(this.theParticipant.getAccountId()));
        assertTrue(jsonMap.get("conferenceId").equals(this.theParticipant.getConferenceId()));
        assertTrue(jsonMap.get("callId").equals(this.theParticipant.getCallId()));
        assertTrue(jsonMap.get("talk").equals(this.theParticipant.getTalk()));
        assertTrue(jsonMap.get("listen").equals(this.theParticipant.getListen()));
        assertTrue(jsonMap.get("startConfOnEnter").equals(this.theParticipant.getStartConfOnEnter()));
    }

    @Then("^check the participant is( not)? equal$")
    public void checkEqual(String not) throws Throwable {
        if(not == null){
            assertTrue(this.theParticipant.equals(Participant.fromJson(origJSON)));
        }else {
            assertFalse(this.theParticipant.equals(Participant.fromJson(otherJSON)));
        }
    }
}
