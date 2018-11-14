@Mockserver
Feature: Calling Number Requester

  Scenario: Can create a CallingNumberRequester
    Given a CallingNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then check the CallingNumberRequester acting accountId is AC1234567890123456789012345678901234567890
    Then check the CallingNumberRequester path is /Accounts/AC1234567890123456789012345678901234567890/CallingNumbers

  Scenario: Create a calling number
    Given a CallingNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then create a CallingNumber

  Scenario: Delete a calling number
    Given a CallingNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then delete a CallingNumber

  Scenario: Get the properties of a calling number
    Given a CallingNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then get a CallingNumber


  Scenario: Modify the properties of a calling number
    Given a CallingNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then update a CallingNumber

  Scenario: Get a list of calling numbers (with and without filters)
    Given a CallingNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then get a list of calling numbers
    Then get a list of calling numbers with filters

