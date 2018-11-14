package com.vailsys.persephony.api.call;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static com.vailsys.persephony.json.PersyGson.gson;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.mockserver.model.JsonBody;
import org.mockserver.verify.VerificationTimes;
import world.Helper;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class CallsRequesterTest {
		private static String aTestCall = "{ \"uri\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CA42ed11f93dc08b952027ffbc406d0868\", \"dateCreated\": \"Tue, 12 Aug 2014 08:02:17 GMT\", \"dateUpdated\": \"Tue, 12 Aug 2014 08:02:47 GMT\", \"revision\": 1, \"callId\": \"CA42ed11f93dc08b952027ffbc406d0868\", \"parentcallId\": null, \"accountId\": \"AC142c48f2ee663e214c19ea459516068c\", \"to\": \"+14153855708\", \"from\": \"+14158141819\", \"phoneNumberId\": null, \"status\": \"completed\", \"startTime\": \"Tue, 12 Aug 2014 08:02:31 GMT\", \"endTime\": \"Tue, 12 Aug 2014 08:02:47 GMT\", \"duration\": \"16\", \"direction\": \"outboundAPI\", \"answeredBy\": null, \"callerName\": null, \"subresourceUris\": { \t\"notifications\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CAe1644a7eed5088b159577c5802d8be38/Notifications\", \t\"recordings\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CAe1644a7eed5088b159577c5802d8be38/Recordings\" } }";
		private static String aTestCallList = "{\"total\": 4, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 20, \"nextPageUri\": null, \"calls\": ["+CallsRequesterTest.aTestCall+","+CallsRequesterTest.aTestCall+","+CallsRequesterTest.aTestCall+","+CallsRequesterTest.aTestCall+"]}";

	public CallsRequester callsR;

	@Given("^a CallsRequester with the credentials (AC[0-9A-Fa-f]{40}) and ([0-9A-Fa-f]{40}) and using the accountId (AC[0-9A-Fa-f]{40})$")
	public void buildCallsRequester(String credAccountId, String credAuthToken, String actingAccountId) throws Throwable {
		this.callsR = new CallsRequester(credAccountId, credAuthToken, actingAccountId);
		this.callsR.setPersyUrl("http://127.0.0.1:"+ Helper.getServerPort());
	}
	
	@Then("^check the acting accountId is (AC[0-9A-Fa-f]{40})$")
	public void checkActingAccountId(String accountId) {
		assertThat(this.callsR.getActingAccountId(), is(accountId));
	}
	
	@Then("^check the path is (/.*/AC[0-9A-Fa-f]{40}/[^\\s]*)$")
	public void checkPath(String path) {
		assertThat(this.callsR.getPath(), is(path));
	}

	@Then("^place a call from (\\+?[1-9]\\d{1,14}) to (\\+?[1-9]\\d{1,14}) using application (AP[0-9A-Fa-f]{40})$")
	public void placeApplicationCall(String from, String to, String applicationId) throws Throwable {
		CreateCallRequest query = new CreateCallRequest(from, to, applicationId, null);

		Helper.getMockServer().when(
			request().withMethod("POST").withPath(this.callsR.getPath()).withBody(query.toJson())
		).respond(
			response().withStatusCode(200).withBody(CallsRequesterTest.aTestCall)
		);

		assertTrue(this.callsR.create(from,to,applicationId).equals(Call.fromJson(CallsRequesterTest.aTestCall)));
	}

	@Then("^place a call from (\\+?[1-9]\\d{1,14}) to (\\+?[1-9]\\d{1,14}) using application (AP[0-9A-Fa-f]{40}) with options$")
	public void placeApplicationCallWithOptions(String from, String to, String applicationId) throws Throwable {
		Integer timeout = 55;

		CallOptions options = new CallOptions();
		options.setTimeout(timeout);

		CreateCallRequest query = new CreateCallRequest(from, to, applicationId, options);

		Helper.getMockServer().when(
			request().withMethod("POST").withPath(this.callsR.getPath()).withBody(query.toJson())
		).respond(
			response().withStatusCode(200).withBody(CallsRequesterTest.aTestCall)
		);

		assertTrue(this.callsR.create(from, to, applicationId, options).equals(Call.fromJson(CallsRequesterTest.aTestCall)));
	}

	@Then("^place a call from (\\+?[1-9]\\d{1,14}) to (\\+?[1-9]\\d{1,14}) using callConnectUrl$")
	public void placeCallConnectUrlCall(String from, String to) throws Throwable {
		String callConnectUrl = "http://vailsys.com/callConnect";
		CreateCallRequest query = new CreateCallRequest(from, to, callConnectUrl, (String)null, null);

		Helper.getMockServer().when(
			request().withMethod("POST").withPath(this.callsR.getPath()).withBody(query.toJson())
		).respond(
			response().withStatusCode(200).withBody(CallsRequesterTest.aTestCall)
		);

		assertTrue(this.callsR.create(from, to, callConnectUrl, (String)null).equals(Call.fromJson(CallsRequesterTest.aTestCall)));
	}

	@Then("^place a call from (\\+?[1-9]\\d{1,14}) to (\\+?[1-9]\\d{1,14}) using callConnectUrl with options$")
	public void placeCallConnectUrlCallWithOptions(String from, String to) throws Throwable {
		Integer timeout = 55;
		String callConnectUrl = "http://vailsys.com/callConnect";

		CallOptions options = new CallOptions();
		options.setTimeout(timeout);

		CreateCallRequest query = new CreateCallRequest(to, from, callConnectUrl, (String)null, options);

		Helper.getMockServer().when(
			request().withMethod("POST").withPath(this.callsR.getPath()).withBody(query.toJson())
		).respond(
			response().withStatusCode(200).withBody(CallsRequesterTest.aTestCall)
		);

		assertTrue(this.callsR.create(to, from, callConnectUrl, (String)null, options).equals(Call.fromJson(CallsRequesterTest.aTestCall)));
	}

	@Then("^place a call from (\\+?[1-9]\\d{1,14}) to (\\+?[1-9]\\d{1,14}) using callConnectUrl with requestId (.*)")
	public void placeCallConnectUrlCallWithRequestId(String from, String to, String requestId) throws Throwable {
		String callConnectUrl = "http://vailsys.com/callConnect";

		CallOptions options = new CallOptions();
		options.setTimeout(10);
		options.setRequestId(requestId);

		CreateCallRequest query = new CreateCallRequest(to, from, callConnectUrl, (String)null, options);


		Helper.getMockServer().when(
				request().withMethod("POST").withPath(this.callsR.getPath()).withBody(query.toJson())
		).respond(
				response().withStatusCode(200).withBody(CallsRequesterTest.aTestCall)
		);

		this.callsR.create(to, from, callConnectUrl, (String)null, options);

		Helper.getMockServer().verify(
				request().withMethod("POST").withPath(this.callsR.getPath()).withBody(new JsonBody("{from:'" + from + "',to:'" + to + "', callConnectUrl:'" + callConnectUrl + "',timeout:10,requestId:'" +requestId + "'}")),
				VerificationTimes.exactly(1)
		);
	}

	@Then("^place a call from (\\+?[1-9]\\d{1,14}) to (\\+?[1-9]\\d{1,14}) using callConnectUrl and statusCallbackUrl$")
	public void placeCallConnectUrlCallWithStatusCallbackUrl(String from, String to) throws Throwable {
		String callConnectUrl = "http://vailsys.com/call";
		String statusCallbackUrl = "http://vailsys.com/status";
		CreateCallRequest query = new CreateCallRequest(from, to, callConnectUrl, statusCallbackUrl, null);

		Helper.getMockServer().when(
			request().withMethod("POST").withPath(this.callsR.getPath()).withBody(query.toJson())
		).respond(
			response().withStatusCode(200).withBody(CallsRequesterTest.aTestCall)
		);

		assertTrue(this.callsR.create(from, to, callConnectUrl, statusCallbackUrl).equals(Call.fromJson(CallsRequesterTest.aTestCall)));
	}

	@Then("^place a call from (\\+?[1-9]\\d{1,14}) to (\\+?[1-9]\\d{1,14}) using callConnectUrl and statusCallbackUrl with options$")
	public void placeCallConnectUrlCallAndStatusCallbackUrlWithOptions(String from, String to) throws Throwable {
		Integer timeout = 55;
		String callConnectUrl = "http://vailsys.com/call";
		String statusCallbackUrl = "http://vailsys.com/status";

		CallOptions options = new CallOptions();
		options.setTimeout(timeout);

		CreateCallRequest query = new CreateCallRequest(from, to, callConnectUrl, statusCallbackUrl, options);

		Helper.getMockServer().when(
			request().withMethod("POST").withPath(this.callsR.getPath()).withBody(query.toJson())
		).respond(
			response().withStatusCode(200).withBody(CallsRequesterTest.aTestCall)
		);

		assertTrue(this.callsR.create(from, to, callConnectUrl, statusCallbackUrl, options).equals(Call.fromJson(CallsRequesterTest.aTestCall)));
	}

	
	@Then("^get a list of calls$")
	public void getCallsList() throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("GET").withPath(this.callsR.getPath())
		).respond(
			response().withStatusCode(200).withBody(CallsRequesterTest.aTestCallList)
		);

		CallList cl = this.callsR.get();
		CallList orig = new CallList("ACCOUNTID", "AUTHTOKEN", CallsRequesterTest.aTestCallList);
		assertThat(cl.getTotalSize(), is(orig.getTotalSize()));
		assertThat(cl.getLocalSize(), is(orig.getLocalSize()));
	}

	@Then("^get a list of calls with filters$")
	public void getCallsListWithFilters() throws Throwable {
		String from = "+13125551234";
		Date endTime = (new Date());
		CallsSearchFilters csf = new CallsSearchFilters();
		csf.setFrom(from);
		csf.setEndTime(endTime);

		HashMap<String, List<String>> listQuery = new HashMap<String,List<String>>();
		listQuery.put("from", new ArrayList<String>(Arrays.asList(from)));
		listQuery.put("endTime", new ArrayList<String>(Arrays.asList(((Long)(endTime.getTime()/1000)).toString())));

		Helper.getMockServer().when(
			request().withMethod("GET").withPath(this.callsR.getPath()).withQueryStringParameters(listQuery)
		).respond(
			response().withStatusCode(200).withBody(CallsRequesterTest.aTestCallList)
		);

		CallList cl = this.callsR.get(csf);
		CallList orig = new CallList("ACCOUNTID", "AUTHTOKEN", CallsRequesterTest.aTestCallList);
		assertThat(cl.getTotalSize(), is(orig.getTotalSize()));
		assertThat(cl.getLocalSize(), is(orig.getLocalSize()));
	}
	@Then("^get a call by it's callId$")
	public void getCallWithCallId() throws Throwable {
		String callId = "CAe1644a7eed5088b159577c5802d8be38";
		Helper.getMockServer().when(
			request().withMethod("GET").withPath(this.callsR.getPath()+"/"+callId)
		).respond(
			response().withStatusCode(200).withBody(CallsRequesterTest.aTestCallList)
		);

		Call c = this.callsR.get(callId);
		Call orig = Call.fromJson(CallsRequesterTest.aTestCallList); 

		assertTrue(c.equals(orig));
	}

	@Then("^update a call with id (.*) to status (canceled|completed)$")
	public void updateCall(String callId, String status) throws Throwable {
		CallsUpdateOptions updates = new CallsUpdateOptions();
		if(status.equals("canceled")) {
			updates.setStatus(CallStatus.CANCELED);
		} else {
			updates.setStatus(CallStatus.COMPLETED);
		}

		Helper.getMockServer().when(
				request().withMethod("POST").withPath(this.callsR.getPath()+"/"+callId).withBody(gson.toJson(updates))
		).respond(
				response().withStatusCode(200).withBody(CallsRequesterTest.aTestCall)
		);

		this.callsR.update(callId, updates);

		Helper.getMockServer().verify(
				request().withMethod("POST")
						.withPath(this.callsR.getPath()+"/"+callId)
						.withBody(gson.toJson(updates)),
				VerificationTimes.exactly(1)
		);
	}

	@Then("^update a call with id (.*) to status (canceled|completed) with requestId (.*)$")
	public void updateCall(String callId, String status, String requestId) throws Throwable {
		CallsUpdateOptions updates = new CallsUpdateOptions();
		updates.setRequestId(requestId);
		if(status.equals("canceled")) {
			updates.setStatus(CallStatus.CANCELED);
		} else {
			updates.setStatus(CallStatus.COMPLETED);
		}

		Helper.getMockServer().when(
				request().withMethod("POST").withPath(this.callsR.getPath() + "/" + callId).withBody(new JsonBody("{status:'" + status + "', requestId:'" + requestId + "'}"))
		).respond(
				response().withStatusCode(200).withBody(CallsRequesterTest.aTestCall)
		);

		this.callsR.update(callId, updates);

		Helper.getMockServer().verify(
				request().withMethod("POST").withPath(this.callsR.getPath() + "/" + callId)
				.withBody(new JsonBody("{status:'"+ status + "', requestId:'" + requestId + "'}")),
				VerificationTimes.exactly(1)
		);
	}
}
