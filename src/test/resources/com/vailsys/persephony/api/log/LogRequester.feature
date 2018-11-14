@Mockserver
Feature: Log Requester

  Scenario: Create a Log Requester
    Given a LogRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then check the LogRequester acting accountId is AC1234567890123456789012345678901234567890
    And check the LogRequester path is /Accounts/AC1234567890123456789012345678901234567890/Logs

  Scenario: List logs without query
    Given a LogRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then list logs without a query

  Scenario: List logs with query
    Given a LogRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then list logs with a query

  Scenario: List logs with query and requestId
    Given a LogRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then list logs with a query and requestId RQ1234567890123456789012345678901234567890