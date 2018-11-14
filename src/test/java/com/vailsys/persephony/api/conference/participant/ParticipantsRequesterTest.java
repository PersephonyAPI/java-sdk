package com.vailsys.persephony.api.conference.participant;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import world.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class ParticipantsRequesterTest {
    public ParticipantsRequester partR;

    private static String aTestParticipant = "{ \"accountId\":\"ACea5735de286cb68f47e78316f647d19522b81d00\", \"conferenceId\":\"CFd0cc3ab95118aaa597039793a1692313fa9c4936\", \"callId\":\"CAef219e4e9152a4b31888620cf391adcae5b6f18c\", \"uri\":\"/Accounts/ACea5735de286cb68f47e78316f647d19522b81d00/Conferences/CFd0cc3ab95118aaa597039793a1692313fa9c4936/Participants/CAef219e4e9152a4b31888620cf391adcae5b6f18c\", \"dateCreated\":\"Thu, 13 Oct 2016 18:23:31 GMT\", \"dateUpdated\":\"Thu, 13 Oct 2016 18:23:31 GMT\", \"revision\":1, \"talk\":true, \"listen\":true, \"startConfOnEnter\":true }";

    private static String anUpdatedParticipant = "{ \"accountId\":\"ACea5735de286cb68f47e78316f647d19522b81d00\", \"conferenceId\":\"CFd0cc3ab95118aaa597039793a1692313fa9c4936\", \"callId\":\"CAef219e4e9152a4b31888620cf391adcae5b6f18c\", \"uri\":\"/Accounts/ACea5735de286cb68f47e78316f647d19522b81d00/Conferences/CFd0cc3ab95118aaa597039793a1692313fa9c4936/Participants/CAef219e4e9152a4b31888620cf391adcae5b6f18c\", \"dateCreated\":\"Thu, 13 Oct 2016 18:23:31 GMT\", \"dateUpdated\":\"Thu, 13 Oct 2016 18:23:31 GMT\", \"revision\":1, \"talk\":true, \"listen\":false, \"startConfOnEnter\":true }";

    private static String aTestParticipantList = "{\"total\": 4, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 20, \"nextPageUri\": null, \"participants\": [" + ParticipantsRequesterTest.aTestParticipant + "," + ParticipantsRequesterTest.aTestParticipant + "," + ParticipantsRequesterTest.aTestParticipant + "," + ParticipantsRequesterTest.aTestParticipant + "]}";

    @Given("^a ParticipantsRequester with the credentials (AC[0-9A-Fa-f]{40}) and ([0-9A-Fa-f]{40}) and using the accountId (AC[0-9A-Fa-f]{40}) and using the conferencePath (.*)$")
    public void buildParticipantsRequester(String credAccountId, String credAuthToken, String actingAccountId, String conferencePath) throws Throwable {
        this.partR = new ParticipantsRequester(credAccountId, credAuthToken, actingAccountId, conferencePath);
        this.partR.setPersyUrl("http://127.0.0.1:" + Helper.getServerPort());
    }

    @Then("^check the ParticipantsRequester acting accountId is (.*)$")
    public void checkActingAccountId(String accountId) { assertThat(this.partR.getActingAccountId(), is(accountId));}

    @Then("^check the ParticipantsRequester path is (.*)$")
    public void checkPath(String path) {
        assertThat(this.partR.getPath(), is(path));
    }

    @Then("^get a list of participants$")
    public void getParticipantsList() throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.partR.getPath())
        ).respond(
                response().withStatusCode(200).withBody(ParticipantsRequesterTest.aTestParticipantList)
        );

        ParticipantList pl = this.partR.get();
        ParticipantList orig = new ParticipantList("ACCOUNTID", "AUTHTOKEN", ParticipantsRequesterTest.aTestParticipantList);
        assertThat(pl.getTotalSize(), is(orig.getTotalSize()));
        assertThat(pl.getLocalSize(), is(orig.getLocalSize()));

    }

    @Then("^get a list of participants with filters$")
    public void getParticipantsListWithFilters() throws Throwable {
        ParticipantsSearchFilters psf = new ParticipantsSearchFilters();
        psf.setTalk(false);

        HashMap<String, List<String>> listQuery = new HashMap<>();
        listQuery.put("talk", new ArrayList<String>(Arrays.asList(psf.getTalk().toString())));

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.partR.getPath()).withQueryStringParameters(listQuery)
        ).respond(
                response().withStatusCode(200).withBody(ParticipantsRequesterTest.aTestParticipantList)
        );

        ParticipantList pl = this.partR.get(psf);
        ParticipantList orig = new ParticipantList("ACCOUNTID", "AUTHTOKEN", ParticipantsRequesterTest.aTestParticipantList);
        assertThat(pl.getTotalSize(), is(orig.getTotalSize()));
        assertThat(pl.getLocalSize(), is(orig.getLocalSize()));
    }

    @Then("^get a Participant by its participantId$")
    public void getParticipantWithParticipantId() throws Throwable {
        String participantId = "CAef219e4e9152a4b31888620cf391adcae5b6f18c";
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.partR.getPath() + "/" + participantId)
        ).respond(
                response().withStatusCode(200).withBody(ParticipantsRequesterTest.aTestParticipant)
        );

        Participant p = this.partR.get(participantId);
        Participant orig = Participant.fromJson(ParticipantsRequesterTest.aTestParticipant);
        assertTrue(p.equals(orig));
    }

    @Then("^update a participant$")
    public void updateParticipant() throws Throwable {
        String participantId = "CAef219e4e9152a4b31888620cf391adcae5b6f18c";
        ParticipantUpdateOptions options = new ParticipantUpdateOptions();
        options.setListen(false);
        options.setRequestId("RQ1111111111111111111111111111111111111111");

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.partR.getPath() + "/" + participantId).withBody("{\"listen\":false,\"requestId\":\"RQ1111111111111111111111111111111111111111\"}")
        ).respond(
                response().withStatusCode(200).withBody(ParticipantsRequesterTest.anUpdatedParticipant)
        );

        Participant p = this.partR.update(participantId, options);
        Participant orig = Participant.fromJson(ParticipantsRequesterTest.anUpdatedParticipant);
        assertTrue(p.equals(orig));
    }

    @Then("^remove a participant$")
    public void removeParticipant() throws Throwable {
        String participantId = "CAef219e4e9152a4b31888620cf391adcae5b6f18c";
        Helper.getMockServer().when(
                request().withMethod("DELETE").withPath(this.partR.getPath() + "/" + participantId)
        ).respond(
                response().withStatusCode(204)
        );
        this.partR.remove(participantId);
    }
}
