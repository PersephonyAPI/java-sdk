package com.vailsys.persephony.api.conference;

import com.vailsys.persephony.api.conference.participant.ParticipantsRequester;
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

public class ConferencesRequesterTest {
    public ConferencesRequester confR;

    private static String aTestConference = "{ \"uri\": \"/Accounts/ACee6bb387248a12e31349fa3cf71d703767ccbc2a/Conferences/CFf85f0cb5b546b737c9b807f037b008c8ab621b6e\", \"revision\":1, \"dateCreated\":\"Thu, 13 Oct 2016 18:19:39 GMT\", \"dateUpdated\":\"Thu, 13 Oct 2016 18:19:39 GMT\", \"conferenceId\":\"CFf85f0cb5b546b737c9b807f037b008c8ab621b6e\", \"accountId\":\"ACee6bb387248a12e31349fa3cf71d703767ccbc2a\", \"alias\":\"the number\", \"playBeep\":\"always\", \"record\":false, \"status\":\"empty\", \"waitUrl\":null, \"actionUrl\":null, \"statusCallbackUrl\":\"http://spv07vcs15.vail:10123/confstatuscallback\", \"subresourceUris\":{ \"participants\":\"/Accounts/ACee6bb387248a12e31349fa3cf71d703767ccbc2a/Conferences/CFf85f0cb5b546b737c9b807f037b008c8ab621b6e/Participants\", \"recordings\":\"/Accounts/ACee6bb387248a12e31349fa3cf71d703767ccbc2a/Conferences/CFf85f0cb5b546b737c9b807f037b008c8ab621b6e/Recordings\" } }";
    private static String aTestConferenceList = "{\"total\": 4, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 20, \"nextPageUri\": null, \"conferences\": [" + ConferencesRequesterTest.aTestConference + "," + ConferencesRequesterTest.aTestConference + "," + ConferencesRequesterTest.aTestConference + "," + ConferencesRequesterTest.aTestConference + "]}";
    private static String anUpdatedTestConference = "{ \"uri\": \"/Accounts/ACee6bb387248a12e31349fa3cf71d703767ccbc2a/Conferences/CFf85f0cb5b546b737c9b807f037b008c8ab621b6e\", \"revision\":1, \"dateCreated\":\"Thu, 13 Oct 2016 18:19:39 GMT\", \"dateUpdated\":\"Thu, 13 Oct 2016 18:19:39 GMT\", \"conferenceId\":\"CFf85f0cb5b546b737c9b807f037b008c8ab621b6e\", \"accountId\":\"ACee6bb387248a12e31349fa3cf71d703767ccbc2a\", \"alias\":\"the number\", \"playBeep\":\"never\", \"record\":false, \"status\":\"terminated\", \"waitUrl\":null, \"actionUrl\":null, \"statusCallbackUrl\":\"http://spv07vcs15.vail:10123/confstatuscallback\", \"subresourceUris\":{ \"participants\":\"/Accounts/ACee6bb387248a12e31349fa3cf71d703767ccbc2a/Conferences/CFf85f0cb5b546b737c9b807f037b008c8ab621b6e/Participants\", \"recordings\":\"/Accounts/ACee6bb387248a12e31349fa3cf71d703767ccbc2a/Conferences/CFf85f0cb5b546b737c9b807f037b008c8ab621b6e/Recordings\" } }";
    private static String aTestConferenceWithOptions = "{ \"uri\": \"/Accounts/ACee6bb387248a12e31349fa3cf71d703767ccbc2a/Conferences/CFf85f0cb5b546b737c9b807f037b008c8ab621b6e\", \"revision\":1, \"dateCreated\":\"Thu, 13 Oct 2016 18:19:39 GMT\", \"dateUpdated\":\"Thu, 13 Oct 2016 18:19:39 GMT\", \"conferenceId\":\"CFf85f0cb5b546b737c9b807f037b008c8ab621b6e\", \"accountId\":\"ACee6bb387248a12e31349fa3cf71d703767ccbc2a\", \"alias\":\"the number\", \"playBeep\":\"never\", \"record\":true, \"status\":\"empty\", \"waitUrl\":null, \"actionUrl\":null, \"statusCallbackUrl\":\"http://spv07vcs15.vail:10123/confstatuscallback\", \"subresourceUris\":{ \"participants\":\"/Accounts/ACee6bb387248a12e31349fa3cf71d703767ccbc2a/Conferences/CFf85f0cb5b546b737c9b807f037b008c8ab621b6e/Participants\", \"recordings\":\"/Accounts/ACee6bb387248a12e31349fa3cf71d703767ccbc2a/Conferences/CFf85f0cb5b546b737c9b807f037b008c8ab621b6e/Recordings\" } }";

    @Given("^a ConferencesRequester with the credentials (AC[0-9A-Fa-f]{40}) and ([0-9A-Fa-f]{40}) and using the accountId (AC[0-9A-Fa-f]{40})$")
    public void buildConferencesRequester(String credAccountId, String credAuthToken, String actingAccountId) throws Throwable {
        this.confR = new ConferencesRequester(credAccountId, credAuthToken, actingAccountId);
        this.confR.setPersyUrl("http://127.0.0.1:"+ Helper.getServerPort());
    }

    @Then("^check the ConferencesRequester acting accountId is (AC[0-9A-Fa-f]{40})$")
    public void checkActingAccountId(String accountId) {
        assertThat(this.confR.getActingAccountId(), is(accountId));
    }

    @Then("^check the ConferencesRequester path is (/.*/AC[0-9A-Fa-f]{40}/[^\\s]*)$")
    public void checkPath(String path) {
        assertThat(this.confR.getPath(), is(path));
    }

    @Then("^get a list of conferences$")
    public void getConferencesList() throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.confR.getPath())
        ).respond(
                response().withStatusCode(200).withBody(ConferencesRequesterTest.aTestConferenceList)
        );

        ConferenceList cl = this.confR.get();
        ConferenceList orig = new ConferenceList("ACCOUNTID", "AUTHTOKEN", ConferencesRequesterTest.aTestConferenceList);
        assertThat(cl.getTotalSize(), is(orig.getTotalSize()));
        assertThat(cl.getLocalSize(), is(orig.getLocalSize()));

    }

    @Then("^get a list of conferences with filters$")
    public void getConferencesListWithFilters() throws Throwable {
        ConferenceStatus status = ConferenceStatus.EMPTY;
        ConferencesSearchFilters csf = new ConferencesSearchFilters();
        csf.setStatus(status);

        HashMap<String, List<String>> listQuery = new HashMap<>();
        listQuery.put("status", new ArrayList<String>(Arrays.asList(status.toString())));

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.confR.getPath()).withQueryStringParameters(listQuery)
        ).respond(
                response().withStatusCode(200).withBody(ConferencesRequesterTest.aTestConferenceList)
        );

        ConferenceList cl = this.confR.get(csf);
        ConferenceList orig = new ConferenceList("ACCOUNTID", "AUTHTOKEN", ConferencesRequesterTest.aTestConferenceList);
        assertThat(cl.getTotalSize(), is(orig.getTotalSize()));
        assertThat(cl.getLocalSize(), is(orig.getLocalSize()));
    }

    @Then("^get a Conference by its conferenceId$")
    public void getConferenceWithConferenceId() throws Throwable {
        String conferenceId = "CFf85f0cb5b546b737c9b807f037b008c8ab621b6e";
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.confR.getPath() + "/" + conferenceId)
        ).respond(
                response().withStatusCode(200).withBody(ConferencesRequesterTest.aTestConference)
        );

        Conference c = this.confR.get(conferenceId);
        Conference orig = Conference.fromJson(ConferencesRequesterTest.aTestConference);
        assertTrue(c.equals(orig));
    }

    @Then("^update a conference$")
    public void updateConference() throws Throwable{
        String conferenceId = "CFf85f0cb5b546b737c9b807f037b008c8ab621b6e";
        ConferenceUpdateOptions options = new ConferenceUpdateOptions();
        options.setStatus(ConferenceStatus.TERMINATED);
        options.setPlayBeep(PlayBeep.NEVER);

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.confR.getPath() + "/" + conferenceId)
        ).respond(
                response().withStatusCode(200).withBody(ConferencesRequesterTest.anUpdatedTestConference)
        );

        Conference c = this.confR.update(conferenceId, options);
        Conference orig = Conference.fromJson(ConferencesRequesterTest.anUpdatedTestConference);
        assertTrue(c.equals(orig));


    }

    @Then("^create a conference$")
    public void createConference() throws Throwable {

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.confR.getPath())
        ).respond(
                response().withStatusCode(200).withBody(ConferencesRequesterTest.aTestConference)
        );
        Conference c = this.confR.create();
        Conference orig = Conference.fromJson(ConferencesRequesterTest.aTestConference);

        assertTrue(c.equals(orig));
    }

    @Then("^create a conference with options$")
    public void createConferenceWithOptions() throws Throwable {
        ConferenceCreateOptions options = new ConferenceCreateOptions();
        options.setPlayBeep(PlayBeep.NEVER);
        options.setRecord(true);

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.confR.getPath())
        ).respond(
                response().withStatusCode(200).withBody(ConferencesRequesterTest.aTestConferenceWithOptions)
        );

        Conference c = this.confR.create(options);
        Conference orig = Conference.fromJson(ConferencesRequesterTest.aTestConferenceWithOptions);
        assertTrue(c.equals(orig));
    }

    @Then("^create a ParticipantsRequester$")
    public void createParticipantRequester() throws Throwable {
        String conferenceId = "CFf85f0cb5b546b737c9b807f037b008c8ab621b6e";
        ParticipantsRequester pr = this.confR.getParticipantsRequester(conferenceId);
        assertThat(pr.getPath(), is(this.confR.getPath() + "/" + conferenceId + "/Participants"));
    }
}
