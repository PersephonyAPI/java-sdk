package com.vailsys.persephony.webhooks.message;

import com.vailsys.persephony.api.message.Direction;
import com.vailsys.persephony.api.message.Status;
import com.vailsys.persephony.webhooks.RequestType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MessageStatusCallbackTest {
    private MessageStatus callback;
    private static String json = "{\n" +
            "\t\"accountId\": \"ACc5063b1754c9d720a304d37b7018a17cf705afd3\",\n" +
            "\t\"messageId\": \"SM96e658c1389cfea5350e09abc08f4a8add499aad\",\n" +
            "\t\"callId\": \"CA9f163b0b22aeef3b168aeaedcefcb0f83259a10a\",\n" +
            "\t\"from\": \"+11759483726\",\n" +
            "\t\"to\": \"+32734637485\",\n" +
            "\t\"text\": \"Check Balance\",\n" +
            "\t\"direction\": \"outbound\",\n" +
            "\t\"applicationId\": \"APb4bc74f00ebf7f872cb92fd12c957898486fb682\",\n" +
            "\t\"requestType\": \"messageStatus\",\n" +
            "\t\"status\": \"rejected\",\n" +
            "\t\"phoneNumberId\": \"PN7c93a49cef79d2c11732f3bd24602ae4add2facc\"\n" +
            "}";

    @Given("^some JSON create a MessageStatus$")
    public void createCallback() throws Throwable {
        callback = MessageStatus.createFromJson(json);
    }

    @Then("^verify the MessageStatus's contents$")
    public void verifyContents() {
        assertThat(this.callback.getAccountId(), is("ACc5063b1754c9d720a304d37b7018a17cf705afd3"));
        assertThat(this.callback.getMessageId(), is("SM96e658c1389cfea5350e09abc08f4a8add499aad"));
        assertThat(this.callback.getCallId(), is("CA9f163b0b22aeef3b168aeaedcefcb0f83259a10a"));
        assertThat(this.callback.getFrom(), is("+11759483726"));
        assertThat(this.callback.getTo(), is("+32734637485"));
        assertThat(this.callback.getText(), is("Check Balance"));
        assertThat(this.callback.getDirection(), is(Direction.OUTBOUND));
        assertThat(this.callback.getApplicationId(), is("APb4bc74f00ebf7f872cb92fd12c957898486fb682"));
        assertThat(this.callback.getRequestType(), is(RequestType.MESSAGE_STATUS));
        assertThat(this.callback.getStatus(), is(Status.REJECTED));
        assertThat(this.callback.getPhoneNumberId(), is("PN7c93a49cef79d2c11732f3bd24602ae4add2facc"));
    }
}
