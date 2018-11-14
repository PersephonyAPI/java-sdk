@Mockserver
Feature: QueuesRequester

  Scenario: Can create a QueuesRequester
    Given a QueuesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then check the QueuesRequester acting accountId is AC1234567890123456789012345678901234567890
    Then check the QueuesRequester path is /Accounts/AC1234567890123456789012345678901234567890/Queues

  Scenario: Getting a list of queues
    Given a QueuesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then get a list of queues
    Then get a list of queues with filters

  Scenario: Get a single queue by queueId
    Given a QueuesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then get a Queue by its queueId

  Scenario: Update a queue
    Given a QueuesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then update a queue

  Scenario: Create a queue
    Given a QueuesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then create a queue

  Scenario: Create a queue with options
    Given a QueuesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then create a queue with options

  Scenario: Create a MembersRequester for a queue
    Given a QueuesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then create a MembersRequester
