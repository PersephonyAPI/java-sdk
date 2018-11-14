package com.vailsys.persephony.webhooks.application;

import com.vailsys.persephony.api.message.Direction;
import com.vailsys.persephony.webhooks.RequestType;
import com.vailsys.persephony.api.message.Status;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.hamcrest.core.Is;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MessageDeliveryCallbackTest {
    private MessageDelivery callback;
    private static String json = "{\n" +
            "\t\"requestId\": \"RQ2392d343c8f298e5858b4baeb2dcd8492488c9fb\",\n" +
            "\t\"accountId\": \"ACc5063b1754c9d720a304d37b7018a17cf705afd3\",\n" +
            "\t\"messageId\": \"SM96e658c1389cfea5350e09abc08f4a8add499aad\",\n" +
            "\t\"from\": \"+11759483726\",\n" +
            "\t\"to\": \"+12734637485\",\n" +
            "\t\"text\": \"Check Balance\",\n" +
            "\t\"direction\": \"inbound\",\n" +
            "\t\"applicationId\": \"APb4bc74f00ebf7f872cb92fd12c957898486fb682\",\n" +
            "\t\"requestType\": \"messageDelivery\",\n" +
            "\t\"status\": \"received\",\n" +
            "\t\"phoneNumberId\": \"PN7c93a49cef79d2c11732f3bd24602ae4add2facc\"\n" +
            "}";

    @Given("^some JSON create a MessageDelivery$")
    public void createCallback() throws Throwable {
        callback = MessageDelivery.createFromJson(json);
    }

    @Then("^verify the MessageDelivery's contents$")
    public void verifyContents(){
        assertThat(this.callback.getRequestId(), is("RQ2392d343c8f298e5858b4baeb2dcd8492488c9fb"));
        assertThat(this.callback.getAccountId(), is("ACc5063b1754c9d720a304d37b7018a17cf705afd3"));
        assertThat(this.callback.getMessageId(), is("SM96e658c1389cfea5350e09abc08f4a8add499aad"));
        assertThat(this.callback.getFrom(), is("+11759483726"));
        assertThat(this.callback.getTo(), is("+12734637485"));
        assertThat(this.callback.getText(), is("Check Balance"));
        assertThat(this.callback.getDirection(), is(Direction.INBOUND));
        assertThat(this.callback.getApplicationId(), is("APb4bc74f00ebf7f872cb92fd12c957898486fb682"));
        assertThat(this.callback.getRequestType(), is(RequestType.MESSAGE_DELIVERY));
        assertThat(this.callback.getStatus(), Is.is(Status.RECEIVED));
        assertThat(this.callback.getPhoneNumberId(), is("PN7c93a49cef79d2c11732f3bd24602ae4add2facc"));
    }
}
