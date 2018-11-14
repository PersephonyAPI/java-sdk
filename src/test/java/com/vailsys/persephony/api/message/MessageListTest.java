package com.vailsys.persephony.api.message;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MessageListTest {
    private static String aTestMessage = "{\"uri\" : \"/Accounts/AC736ca2078721a9a41fb47f07bf40d9e21cb304da/Messages/SM338850f402f2bc71abe053942a0ea8ec1829c66a\", \"revision\" : 1, \"dateCreated\" : \"Thu, 23 Jun 2016 17:30:06 GMT\", \"dateUpdated\" : \"Thu, 23 Jun 2016 17:30:06 GMT\", \"messageId\" : \"SM338850f402f2bc71abe053942a0ea8ec1829c66a\", \"accountId\" : \"AC736ca2078721a9a41fb47f07bf40d9e21cb304da\", \"from\" : \"+12248806205\", \"to\" : \"+18475978014\", \"text\" : \"Hello World\", \"direction\" : \"inbound\" }";
    private static String inputJson = "{\"total\":1, \"start\":0, \"end\":0, \"page\":0,\"numPages\":1,\"pageSize\":1, \"nextPageUri\":null, \"messages\": [" + MessageListTest.aTestMessage + "]}";
    private MessageList list;

    @Given("^a MessageList object$")
    public void makeListFromJson() throws Throwable {
        this.list = new MessageList("ACCOUNTID", "AUTHTOKEN", MessageListTest.inputJson);
    }

    @Then("^check that the MessageList was built correctly$")
    public void checkList() {
        assertThat(this.list.getLocalSize(), is(1));
    }
}
