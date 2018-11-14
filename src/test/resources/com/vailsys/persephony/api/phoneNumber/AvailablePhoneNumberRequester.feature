@Mockserver
Feature: Available Phone Number Requester

  Scenario: Can create an AvailablePhoneNumberRequester
    Given an AvailablePhoneNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then check the AvailablePhoneNumberRequester acting accountId is AC1234567890123456789012345678901234567890
    Then check the AvailablePhoneNumberRequester path is /AvailablePhoneNumbers

    Scenario: Getting a list of available phone numbers
      Given an AvailablePhoneNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
      Then get a list of available phone numbers
      Then get a list of available phone numbers with filters