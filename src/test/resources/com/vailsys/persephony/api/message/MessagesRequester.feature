@Mockserver
Feature: MessagesRequester

  Scenario: Can create a MessagesRequester
    Given a MessagesRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then check the MessagesRequester acting accountId is AC6789
    Then check the MessagesRequester path is /Accounts/AC6789/Messages

  Scenario: Get a message
    Given a MessagesRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then get a message by its messageId

  Scenario: Getting a list of applications
    Given a MessagesRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then get a list of messages
    Then get a list of messages with filters

  Scenario: Send a message
    Given a MessagesRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then create a message

  Scenario: Send a message with options
    Given a MessagesRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then create a message with options