package com.vailsys.persephony.api.conference;

import java.util.HashMap;
import java.lang.reflect.Type;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.FieldPosition;

import static com.vailsys.persephony.json.PersyGson.gson;
import com.vailsys.persephony.api.conference.ConferenceStatus;

import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ConferenceTest {
	private String origJSON;
	private String otherJSON = "{\"uri\" : \"/Accounts/AC5c60401972d2a2cfeb35fce3901af375c3c1e981/Conferences/CF6af689f06309b29e9f0c91cec4691147661de97e\", \"revision\" : 1, \"dateCreated\" : \"Mon, 31 Oct 2016 19:12:33 GMT\", \"dateUpdated\" : \"Mon, 31 Oct 2016 19:12:33 GMT\", \"conferenceId\" : \"CF6af689f06309b29e9f0c91cec4691147661de97e\", \"accountId\" : \"AC5c60401972d2a2cfeb35fce3901af375c3c1e981\", \"alias\" : \"53870ac2\", \"playBeep\" : \"always\", \"record\" : true, \"status\" : \"empty\", \"waitUrl\" : \"http://6f4f.40ab1f12.8d.9f/eea393a0\", \"actionUrl\" : \"http://4c9f.bc57ab94.98.f2/5022ed9c\", \"statusCallbackUrl\" : \"http://2f81.08143fe1.d0.f3/2c2bf957\", \"subresourceUris\" : {\"participants\" : \"/Accounts/AC5c60401972d2a2cfeb35fce3901af375c3c1e981/Conferences/CF6af689f06309b29e9f0c91cec4691147661de97e/Participants\", \"recordings\" : \"/Accounts/AC5c60401972d2a2cfeb35fce3901af375c3c1e981/Conferences/CF6af689f06309b29e9f0c91cec4691147661de97e/Recordings\"}}";
	private Conference theConference;

	@Given("^Some JSON representing a conference.$")
	public void storeJSON() {
		this.origJSON = "{\"uri\" : \"/Accounts/AC5c60401972d2a2cfeb35fce3901af375c3c1e981/Conferences/CF6af689f06309b29e9f0c91cec4691147661de97e\", \"revision\" : 1, \"dateCreated\" : \"Mon, 31 Oct 2016 19:12:33 GMT\", \"dateUpdated\" : \"Mon, 31 Oct 2016 19:12:33 GMT\", \"conferenceId\" : \"CF6af689f06309b29e9f0c91cec4691147661de97e\", \"accountId\" : \"AC5c60401972d2a2cfeb35fce3901af375c3c1e981\", \"alias\" : \"53870ac2\", \"playBeep\" : \"always\", \"record\" : false, \"status\" : \"terminated\", \"waitUrl\" : \"http://6f4f.40ab1f12.8d.9f/eea393a0\", \"actionUrl\" : \"http://4c9f.bc57ab94.98.f2/5022ed9c\", \"statusCallbackUrl\" : \"http://2f81.08143fe1.d0.f3/2c2bf957\", \"subresourceUris\" : {\"participants\" : \"/Accounts/AC5c60401972d2a2cfeb35fce3901af375c3c1e981/Conferences/CF6af689f06309b29e9f0c91cec4691147661de97e/Participants\", \"recordings\" : \"/Accounts/AC5c60401972d2a2cfeb35fce3901af375c3c1e981/Conferences/CF6af689f06309b29e9f0c91cec4691147661de97e/Recordings\"}}";
	}

	@Then("^build a Conference object from that JSON.$")
	public void buildConference() throws Throwable {
		this.theConference = Conference.fromJson(origJSON);
	}

	@Then("^check the contents of that conference.$")
	public void checkConferenceAgainstJson() {
		Type t = new TypeToken<HashMap<String, Object>>(){}.getType();
		HashMap<String, Object> jsonMap = gson.fromJson(this.origJSON, t);

		assertThat((String)jsonMap.get("conferenceId"), is(this.theConference.getConferenceId()));
		assertThat((String)jsonMap.get("accountId"), is(this.theConference.getAccountId()));
		assertThat((String)jsonMap.get("alias"), is(this.theConference.getAlias()));
		assertThat((Boolean)jsonMap.get("record"), is(this.theConference.getRecord()));
		assertThat((String)jsonMap.get("waitUrl"), is(this.theConference.getWaitUrl()));
		assertThat((String)jsonMap.get("statusCallBackUrl"), is(this.theConference.getStatusCallBackUrl()));

		assertThat((String)jsonMap.get("playBeep"), is("always"));
		assertThat(PlayBeep.ALWAYS, is(this.theConference.getPlayBeep()));
		assertThat((String)jsonMap.get("status"), is("terminated"));
		assertThat(ConferenceStatus.TERMINATED, is(this.theConference.getStatus()));

		com.google.gson.internal.LinkedTreeMap mmm = ((com.google.gson.internal.LinkedTreeMap)jsonMap.get("subresourceUris"));
		assertThat((String)mmm.get("recordings"), is(this.theConference.getSubresourceUris().get("recordings")));
		assertThat((String)mmm.get("participants"), is(this.theConference.getSubresourceUris().get("participants")));
	}

	@Then("^check the conference is( not)? equal$")
	public void checkEqual(String not) throws Throwable {
		if(not == null){
			assertTrue(this.theConference.equals(Conference.fromJson(origJSON)));
		} else {
			assertFalse(this.theConference.equals(Conference.fromJson(otherJSON)));
		}
	}
}
