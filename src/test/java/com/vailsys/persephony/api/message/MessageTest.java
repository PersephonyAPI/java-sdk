package com.vailsys.persephony.api.message;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MessageTest {
    private String origJSON;
    private Message message;

    @Given("^Some JSON representing a message.$")
    public void storeJSON() {
        this.origJSON = "{\"uri\" : \"/Accounts/AC736ca2078721a9a41fb47f07bf40d9e21cb304da/Messages/SM16ac1bcbd6f4895c89a798571e89e1e715892924\", \"revision\" : 1, \"dateCreated\" : \"Thu, 23 Jun 2016 17:30:06 GMT\", \"dateUpdated\" : \"Thu, 23 Jun 2016 17:30:06 GMT\", \"messageId\" : \"SM16ac1bcbd6f4895c89a798571e89e1e715892924\", \"accountId\" : \"AC736ca2078721a9a41fb47f07bf40d9e21cb304da\", \"from\" : \"+12248806205\", \"to\" : \"+18475978014\", \"text\" : \"Hello World\", \"direction\" : \"outbound\", \"notificationUrl\" : \"http://myapp.com/notification-url\", \"status\": \"sending\" }";
    }

    @Then("^build a Message object from that JSON.$")
    public void buildMessage() throws Throwable {
        this.message = Message.fromJson(origJSON);
    }

    @Then("^check the contents of that message.$")
    public void checkMessageAgainstJson() {
        assertThat(message.getUri(), is("/Accounts/AC736ca2078721a9a41fb47f07bf40d9e21cb304da/Messages/SM16ac1bcbd6f4895c89a798571e89e1e715892924"));
        assertThat(message.getRevision(), is(1));
        assertThat(message.getMessageId(), is("SM16ac1bcbd6f4895c89a798571e89e1e715892924"));
        assertThat(message.getAccountId(), is("AC736ca2078721a9a41fb47f07bf40d9e21cb304da"));
        assertThat(message.getTo(), is("+18475978014"));
        assertThat(message.getFrom(), is("+12248806205"));
        assertThat(message.getText(), is("Hello World"));
        assertTrue(message.getDirection().equals(Direction.OUTBOUND));
        assertThat(message.getNotificationUrl(), is("http://myapp.com/notification-url"));
        assertThat(message.getStatus(), is(Status.SENDING));
    }

    @Then("^compare the message with equal and unequal objects$")
    public void compare() throws Throwable {
        assertTrue(message.equals(Message.fromJson(origJSON)));
        String differentMessageJson = "{\"uri\" : \"/Accounts/AC736ca2078721a9a41fb47f07bf40d9e21cb304da/Messages/SM16ac1bcbd6f4895c89a798571e89e1e715892924\", \"revision\" : 1, \"dateCreated\" : \"Thu, 23 Jun 2016 17:30:06 GMT\", \"dateUpdated\" : \"Thu, 23 Jun 2016 17:30:06 GMT\", \"messageId\" : \"SM16ac1bcbd6f4895c89a798571e89e1e715892924\", \"accountId\" : \"AC736ca2078721a9a41fb47f07bf40d9e21cb304da\", \"from\" : \"+12248806205\", \"to\" : \"+18475978014\", \"text\" : \"Goodbye World\", \"direction\" : \"inbound\", \"notificationUrl\" : null, \"status\" : \"rejected\" }";
        assertFalse(message.equals(Message.fromJson(differentMessageJson)));
    }
}
