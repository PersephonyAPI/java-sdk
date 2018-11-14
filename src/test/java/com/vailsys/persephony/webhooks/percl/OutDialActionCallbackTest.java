package com.vailsys.persephony.webhooks.percl;

import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.api.call.Direction;
import com.vailsys.persephony.webhooks.RequestType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

public class OutDialActionCallbackTest {
    private OutDialActionCallback odac;
    private static final String ODAC_JSON = "{\"accountId\":\"AC766bc3fb87212042619f41ac6344feef2f1b0d00\",\"callId\":\"CA06d0eeb157c2322e3c44a19947eec2085e4be356\",\"callStatus\":\"inProgress\",\"conferenceId\":null,\"dialCallId\":\"CA694ec3a0eedfc8d62a96e3c97defc89371b1fdda\",\"direction\":\"outboundDial\",\"from\":\"+12248806205\",\"queueId\":null,\"requestType\":\"outDialStart\",\"to\":\"+18475978014\"}";


    @Given("^An OutDialActionCallback object$")
    public void newODAC() throws Throwable {
        this.odac = OutDialActionCallback.createFromJson(ODAC_JSON);
    }

    @Then("^verify the OutDialActionCallback's contents$")
    public void verifyContents() throws Throwable {
        assertThat(this.odac.getAccountId(), is("AC766bc3fb87212042619f41ac6344feef2f1b0d00"));
        assertThat(this.odac.getCallId(), is("CA06d0eeb157c2322e3c44a19947eec2085e4be356"));
        assertThat(this.odac.getCallStatus(), is(CallStatus.IN_PROGRESS));
        assertThat(this.odac.getConferenceId(), is(nullValue()));
        assertThat(this.odac.getDirection(), is(Direction.OUTBOUND_DIAL));
        assertThat(this.odac.getFrom(), is("+12248806205"));
        assertThat(this.odac.getDialCallId(), is("CA694ec3a0eedfc8d62a96e3c97defc89371b1fdda"));
        assertThat(this.odac.getRequestType(), is(RequestType.OUT_DIAL_START));
        assertThat(this.odac.getTo(), is("+18475978014"));
    }
}
