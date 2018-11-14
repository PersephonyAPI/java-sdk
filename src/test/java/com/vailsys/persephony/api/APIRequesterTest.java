package com.vailsys.persephony.api;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import static org.junit.Assert.*;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import com.vailsys.persephony.KnownSizeInputStream;
import world.Helper;

public class APIRequesterTest {

	private APIRequester req;



	@Given("^an accountId of (AC[0-9A-Fa-f]{40}) and an authToken of ([0-9A-Fa-f]{40}) to make a default APIRequester$")
	public void makeADefaultAPIRequester(String accountId, String authToken) throws Throwable {
		this.req = new APIRequester(accountId, authToken);
		assertThat(APIRequester.PERSY_URL, is("https://www.persephony.com/apiserver"));
	}

	@Given("^an accountId of (AC[0-9A-Fa-f]{40}) and an authToken of ([0-9A-Fa-f]{40}) to make a test APIRequester$")
	public void makeAnAPIRequester(String accountId, String authToken) throws Throwable {
		this.req = new APIRequester(accountId, authToken);
		this.req.setPersyUrl("http://127.0.0.1:"+ Helper.getServerPort());
	}

	@Then("^stored in the APIRequester should be the accountId (AC[0-9A-Fa-f]{40}) and the authToken ([0-9A-Fa-f]{40})$")
	public void APIRequesterStoreCorrectValues(String accountId, String authToken) throws Throwable {
		assertThat(this.req.getPersyUrl(), is(APIRequester.PERSY_URL));
		assertThat(this.req.getCredentialAccountId(), is(accountId));
		assertThat(this.req.getCredentialAuthToken(), is(authToken));
	}

	@Then("^stored in the test APIRequester should be the accountId (AC[0-9A-Fa-f]{40}) and the authToken ([0-9A-Fa-f]{40})$")
	public void testAPIRequesterStoreCorrectValues(String accountId, String authToken) throws Throwable {
		assertThat(this.req.getPersyUrl(), is("http://127.0.0.1:"+Helper.getServerPort()));
		assertThat(this.req.getCredentialAccountId(), is(accountId));
		assertThat(this.req.getCredentialAuthToken(), is(authToken));
	}

	@Then("^change the persyUrl to (http://.*)$")
	public void canChangePersyUrl(String newUrl) throws Throwable {
		this.req.setPersyUrl(newUrl);
		assertThat(this.req.getPersyUrl(), is(newUrl));
	}

	@Then("^make a successful GET Request and recieve a stream in return$")
	public void makeASuccessfulGETStreamRequest() throws Throwable {
		HashMap<String, String> realQuery = new HashMap<String,String>();
		realQuery.put("a", "1");
		realQuery.put("b", "2");
		realQuery.put("c", "3");

		HashMap<String, List<String>> listQuery = new HashMap<String,List<String>>();
		listQuery.put("a", new ArrayList<String>(Arrays.asList("1")));
		listQuery.put("b", new ArrayList<String>(Arrays.asList("2")));
		listQuery.put("c", new ArrayList<String>(Arrays.asList("3")));

		String response = "{\"value\":\"EXAMPLE\"}";

		Helper.getMockServer().when(
			request().withMethod("GET").withPath("/getSuccess").withQueryStringParameters(listQuery)
		).respond(
			response().withStatusCode(200).withBody(response)
		);

		try {
			KnownSizeInputStream ksis = this.req.GETStream("/getSuccess", realQuery);
			assertThat(ksis.size(), is(response.length()));

			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(ksis));
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}	
			br.close();

			assertThat(sb.toString(), is(response));
		}
		catch (PersyException pe) {
			fail("This request should have succeeded but it failed: "+pe.getMessage());
		}
	}

	@Then("^make a successful GET request to the API$")
	public void makeASuccessfulGETRequest() throws Throwable {
		HashMap<String, String> realQuery = new HashMap<String,String>();
		realQuery.put("a", "1");
		realQuery.put("b", "2");
		realQuery.put("c", "3");

		HashMap<String, List<String>> listQuery = new HashMap<String,List<String>>();
		listQuery.put("a", new ArrayList<String>(Arrays.asList("1")));
		listQuery.put("b", new ArrayList<String>(Arrays.asList("2")));
		listQuery.put("c", new ArrayList<String>(Arrays.asList("3")));

		Helper.getMockServer().when(
			request().withMethod("GET").withPath("/getSuccess").withQueryStringParameters(listQuery)
		).respond(
			response().withStatusCode(200).withBody("{\"value\":\"EXAMPLE\"}")
		);

		try {
			String resp = this.req.GET("/getSuccess", realQuery);
			assertThat(resp, is("{\"value\":\"EXAMPLE\"}"));
		}
		catch (PersyException pe) {
			fail("This request should have succeeded but it failed: "+pe.getMessage());
		}
	}

	@Then("^make a successful GET request to the API without a query string$")
	public void makeASuccessfulGETRequestWithoutAQueryString() throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("GET").withPath("/getSuccess")
		).respond(
			response().withStatusCode(200).withBody("{\"value\":\"EXAMPLE\"}")
		);

		try {
			String resp = this.req.GET("/getSuccess");
			assertThat(resp, is("{\"value\":\"EXAMPLE\"}"));
		}
		catch (PersyException pe) {
			fail("This request should have succeeded but it failed: "+pe.getMessage());
		}
	}

	@Then("^make an unsuccessful GET request to the API$")
	public void makeAnUnsuccessfulGETRequest() throws Throwable {
		HashMap<String, String> realQuery = new HashMap<String,String>();
		realQuery.put("a", "1");
		realQuery.put("b", "2");
		realQuery.put("c", "3");

		HashMap<String, List<String>> listQuery = new HashMap<String,List<String>>();
		listQuery.put("a", new ArrayList<String>(Arrays.asList("1")));
		listQuery.put("b", new ArrayList<String>(Arrays.asList("2")));
		listQuery.put("c", new ArrayList<String>(Arrays.asList("3")));

		Helper.getMockServer().when(
			request().withMethod("GET").withPath("/getSuccessFail").withQueryStringParameters(listQuery)
		).respond(
			response().withStatusCode(400).withBody("{\"status\": 400, \"message\": \"Bad input\"}")
		);
		
		try {
			String resp = this.req.GET("/getSuccessFail", realQuery);
			fail("This request succeeded when it should have failed. Response was: " + resp);
		}
		catch (PersyErrorResponseException pere) {
			assertThat(pere, notNullValue());
			assertThat(pere.getError(), is(notNullValue()));
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Failed wrong: " + e.getMessage());
		}
	}

	@Then("^make a successful POST request to the API$")
	public void makeASuccessfulPOSTRequest() throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("POST").withPath("/postSuccess").withBody("{}")
		).respond(
			response().withStatusCode(200).withBody("{\"value\":\"EXAMPLE\"}")
		);

		try {
			String resp = this.req.POST("/postSuccess", "{}");
			assertThat(resp, is("{\"value\":\"EXAMPLE\"}"));
		}
		catch (PersyException pe) {
			fail("This request should have succeeded but it failed: "+pe.getMessage());
		}
	}

	@Then("^make a successful POST request to the API with an empty payload$")
	public void makeASuccessfulPOSTRequestEmptyPayload() throws Throwable {
		Helper.getMockServer().when(
				request().withMethod("POST").withPath("/postSuccess")
		).respond(
				response().withStatusCode(200).withBody("{\"value\":\"EXAMPLE\"}")
		);
		try {
			String resp = this.req.POST("/postSuccess", null);
			assertThat(resp, is("{\"value\":\"EXAMPLE\"}"));
		} catch (PersyException pe) {
			fail("This request should have succeeded but it failed: "+pe.getMessage());
		}
	}

	@Then("^make an unsuccessful POST request to the API$")
	public void makeAnUnsuccessfulPOSTRequest() throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("POST").withPath("/postSuccessFail").withBody("{}")
		).respond(
			response().withStatusCode(400).withBody("{\"status\": 400, \"message\": \"BAD INPUT\"}")
		);

		try {
			String resp = this.req.POST("/postSuccessFail", "{}");
			fail("This request succeeded when it should have failed. Response was: " + resp);
		}
		catch (PersyErrorResponseException pere) {
			assertThat(pere, notNullValue());
			assertThat(pere.getError(), is(notNullValue()));
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Failed wrong: " + e.getMessage());
		}
	}

	@Then("^make an unsuccessful POST request to the API with an empty payload$")
	public void makeAnUnsuccessfulPOSTRequestEmptyPayload() throws Throwable {
		Helper.getMockServer().when(
				request().withMethod("POST").withPath("/postSuccessFail")
		).respond(
				response().withStatusCode(400).withBody("{\"status\": 400, \"message\": \"BAD INPUT\"}")
		);

		try {
			String resp = this.req.POST("/postSuccessFail", null);
			fail("This request succeeded when it should have failed. Response was: " + resp);
		}
		catch (PersyErrorResponseException pere) {
			assertThat(pere, notNullValue());
			assertThat(pere.getError(), is(notNullValue()));
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Failed wrong: " + e.getMessage());
		}
	}

	@Then("^make a successful DELETE request to the API$")
	public void makeASuccessfulDELETERequest() throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("DELETE").withPath("/deleteSuccess")
		).respond(
			response().withStatusCode(204)
		);

		try {
			this.req.DELETE("/deleteSuccess");
		}
		catch (PersyException pe) {
			fail("This request should have succeeded but it failed: "+pe.getMessage());
		}
	}

	@Then("^make an unsuccessful DELETE request to the API$")
	public void makeAnUnsuccessfulDELETERequest() throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("DELETE").withPath("/deleteSuccessFail")
		).respond(
			response().withStatusCode(400).withBody("{\"status\": 400,\"message\": \"A Message\"}")
		);

		try {
			this.req.DELETE("/deleteSuccessFail");
			fail("This request succeeded when it should have failed.");
		}
		catch (PersyErrorResponseException pere) {
			assertThat(pere, notNullValue());
			assertThat(pere.getError(), notNullValue());
		}
	}
}
