package com.vailsys.persephony.api.message;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.mockserver.model.JsonBody;
import org.mockserver.verify.VerificationTimes;
import world.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class MessageRequesterTest {
    private MessagesRequester requester;

    private static String aTestMessage = "{\"uri\" : \"/Accounts/AC736ca2078721a9a41fb47f07bf40d9e21cb304da/Messages/SM338850f402f2bc71abe053942a0ea8ec1829c66a\", \"revision\" : 1, \"dateCreated\" : \"Thu, 23 Jun 2016 17:30:06 GMT\", \"dateUpdated\" : \"Thu, 23 Jun 2016 17:30:06 GMT\", \"messageId\" : \"SM338850f402f2bc71abe053942a0ea8ec1829c66a\", \"accountId\" : \"AC736ca2078721a9a41fb47f07bf40d9e21cb304da\", \"from\" : \"+12248806205\", \"to\" : \"+18475978014\", \"text\" : \"Hello World\", \"direction\" : \"inbound\", \"notificationUrl\": null }";
    private static String aTestMessageWithNotificationUrl = "{\"uri\" : \"/Accounts/AC736ca2078721a9a41fb47f07bf40d9e21cb304da/Messages/SM338850f402f2bc71abe053942a0ea8ec1829c66a\", \"revision\" : 1, \"dateCreated\" : \"Thu, 23 Jun 2016 17:30:06 GMT\", \"dateUpdated\" : \"Thu, 23 Jun 2016 17:30:06 GMT\", \"messageId\" : \"SM338850f402f2bc71abe053942a0ea8ec1829c66a\", \"accountId\" : \"AC736ca2078721a9a41fb47f07bf40d9e21cb304da\", \"from\" : \"+12248806205\", \"to\" : \"+18475978014\", \"text\" : \"Hello World\", \"direction\" : \"outbound\", \"notificationUrl\": \"http://myapp.com/notification-url\" }";

    private static String aTestMessageList = "{\"total\": 4, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 20, \"nextPageUri\": null, \"messages\": [" + MessageRequesterTest.aTestMessage + "," + MessageRequesterTest.aTestMessage + "," + MessageRequesterTest.aTestMessage + "," + MessageRequesterTest.aTestMessage + "]}";

    @Given("^a MessagesRequester with the credentials (.*) and (.*) and using the accountId (.*)$")
    public void create(String accountId, String authToken, String actingId) throws Throwable {
        requester = new MessagesRequester(accountId, authToken, actingId);
        requester.setPersyUrl("http://127.0.0.1:" + Helper.getServerPort());
    }

    @Then("^check the MessagesRequester acting accountId is (.*)$")
    public void checkActingAccountId(String acting) {
        assertThat(requester.getActingAccountId(), is(acting));
    }

    @Then("^check the MessagesRequester path is (.*)$")
    public void checkPath(String path) {
        assertThat(requester.getPath(), is(path));
    }

    @Then("^get a message by its messageId$")
    public void getMessage() throws Throwable {
        String messageId = "SM338850f402f2bc71abe053942a0ea8ec1829c66a";

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath() + "/" + messageId)
        ).respond(
                response().withStatusCode(200).withBody(MessageRequesterTest.aTestMessage)
        );

        Message m = this.requester.get(messageId);
        Message orig = Message.fromJson(MessageRequesterTest.aTestMessage);
        assertTrue(m.equals(orig));
    }

    @Then("^get a list of messages$")
    public void getMessageList() throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(MessageRequesterTest.aTestMessageList)
        );

        MessageList ml = this.requester.get();
        MessageList orig = new MessageList("ACCOUNTID", "AUTHTOKEN", MessageRequesterTest.aTestMessageList);
        assertThat(ml.getTotalSize(), is(orig.getTotalSize()));
        assertThat(ml.getLocalSize(), is(orig.getLocalSize()));
    }

    @Then("^get a list of messages with filters$")
    public void getMessageListWithFilters() throws Throwable {
        MessagesSearchFilters msf = new MessagesSearchFilters();
        msf.setTo("+12223334444");
        msf.setFrom("+14443332222");
        msf.setBeginTime("2018-01-02 09:33:22");
        msf.setEndTime("2018-01-03 09:33:22");
        msf.setDirection(Direction.OUTBOUND);

        HashMap<String, List<String>> listQuery = new HashMap<>();
        listQuery.put("to", new ArrayList<String>(Arrays.asList("+12223334444")));
        listQuery.put("from", new ArrayList<String>(Arrays.asList("+14443332222")));
        listQuery.put("beginTime", new ArrayList<String>(Arrays.asList("2018-01-02 09:33:22")));
        listQuery.put("endTime", new ArrayList<String>(Arrays.asList("2018-01-03 09:33:22")));
        listQuery.put("direction", new ArrayList<String>(Arrays.asList(Direction.OUTBOUND.toString())));

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath()).withQueryStringParameters(listQuery)
        ).respond(
                response().withStatusCode(200).withBody(MessageRequesterTest.aTestMessageList)
        );

        MessageList ml = this.requester.get(msf);
        MessageList orig = new MessageList("ACCOUNTID", "AUTHTOKEN", MessageRequesterTest.aTestMessageList);
        assertThat(ml.getLocalSize(), is(orig.getLocalSize()));
        assertThat(ml.getTotalSize(), is(orig.getTotalSize()));
    }

    @Then("^create a message$")
    public void createMessage() throws Throwable {
        String from = "+12343647485";
        String to = "+13454567584";
        String text = "Your account balance is low.";
        JsonBody json = new JsonBody("{\"from\":\"" + from + "\", \"to\":\"" + to + "\", \"text\":\"" + text + "\"}");

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.requester.getPath()).withBody(json)
        ).respond(
                response().withStatusCode(201).withBody(MessageRequesterTest.aTestMessage)
        );

        Message m = this.requester.create(from, to, text);

        Helper.getMockServer().verify(request().withMethod("POST").withPath(this.requester.getPath()).withBody(json), VerificationTimes.once());

    }

    @Then("^create a message with options$")
    public void createMessageWithOptions() throws Throwable {
        String from = "+12343647485";
        String to = "+13454567584";
        String text = "Your account balance is low.";
        String notificationUrl = "http://myapp.com/notification-url";
        JsonBody json = new JsonBody("{\"from\":\"" + from + "\", \"to\":\"" + to + "\", \"text\":\"" + text + "\", \"notificationUrl\":\"" + notificationUrl + "\"}");

        Helper.getMockServer().when(
            request().withMethod("POST").withPath(this.requester.getPath()).withBody(json)
        ).respond(
            response().withStatusCode(201).withBody(MessageRequesterTest.aTestMessageWithNotificationUrl)
        );

        MessageOptions options = new MessageOptions();
        options.setNotificationUrl(notificationUrl);
        Message m = this.requester.create(from, to, text, options);

        Helper.getMockServer().verify(request().withMethod("POST").withPath(this.requester.getPath()).withBody(json), VerificationTimes.once());

    }
}
