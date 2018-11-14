package com.vailsys.persephony.webhooks.percl;

import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.api.call.Direction;
import com.vailsys.persephony.webhooks.RequestType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class OutDialIfMachineCallbackTest {
    private OutDialIfMachineCallback omic;
    private static final String OMIC_JSON_fax = "{\"accountId\":\"AC766bc3fb87212042619f41ac6344feef2f1b0d00\",\"callId\":\"CA06d0eeb157c2322e3c44a19947eec2085e4be356\",\"callStatus\":\"inProgress\",\"conferenceId\":null,\"parentCallId\":\"CA694ec3a0eedfc8d62a96e3c97defc89371b1fdda\",\"direction\":\"outboundDial\",\"machineType\":\"faxMachine\",\"from\":\"+12248806205\",\"queueId\":null,\"requestType\":\"machineDetected\",\"to\":\"+18475978014\"}";

    private static final String OMIC_JSON_answering = "{\"accountId\":\"AC766bc3fb87212042619f41ac6344feef2f1b0d00\",\"callId\":\"CA06d0eeb157c2322e3c44a19947eec2085e4be356\",\"callStatus\":\"inProgress\",\"conferenceId\":null,\"parentCallId\":\"CA694ec3a0eedfc8d62a96e3c97defc89371b1fdda\",\"direction\":\"outboundDial\",\"machineType\":\"answeringMachine\",\"from\":\"+12248806205\",\"queueId\":null,\"requestType\":\"machineDetected\",\"to\":\"+18475978014\"}";

    @Given("^An OutDialIfMachineCallback object with machineType (faxMachine|answeringMachine)$")
    public void newOIMC(String machineType) throws Throwable {
        if(machineType.equals("faxMachine")){
            this.omic = OutDialIfMachineCallback.createFromJson(OMIC_JSON_fax);
        }
        else{
            this.omic = OutDialIfMachineCallback.createFromJson(OMIC_JSON_answering);
        }
    }

    @Then("^verify the OutDialIfMachineCallback's contents with machineType (faxMachine|answeringMachine)$")
    public void verifyContents(String machineType) throws Throwable {
        assertThat(this.omic.getAccountId(), is("AC766bc3fb87212042619f41ac6344feef2f1b0d00"));
        assertThat(this.omic.getCallId(), is("CA06d0eeb157c2322e3c44a19947eec2085e4be356"));
        assertThat(this.omic.getCallStatus(), is(CallStatus.IN_PROGRESS));
        assertThat(this.omic.getConferenceId(), is(nullValue()));
        assertThat(this.omic.getDirection(), is(Direction.OUTBOUND_DIAL));
        assertThat(this.omic.getFrom(), is("+12248806205"));
        if(machineType.equals("faxMachine")) {
            assertThat(this.omic.getMachineType(), is(MachineType.FAX));
        }else {
            assertThat(this.omic.getMachineType(), is(MachineType.ANSWERING));
        }
        assertThat(this.omic.getParentCallId(), is("CA694ec3a0eedfc8d62a96e3c97defc89371b1fdda"));
        assertThat(this.omic.getRequestType(), is(RequestType.MACHINE_DETECTED));
        assertThat(this.omic.getTo(), is("+18475978014"));
    }
}
