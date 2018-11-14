@Mockserver
Feature: Incoming Phone Number Requester

  Scenario: Can create an IncomingPhoneNumberRequester
    Given an IncomingPhoneNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then check the IncomingPhoneNumberRequest acting accountId is AC1234567890123456789012345678901234567890
    Then check the IncomingPhoneNumberRequester path is /Accounts/AC1234567890123456789012345678901234567890/IncomingPhoneNumbers

    Scenario: Get the list of incoming phone numbers
      Given an IncomingPhoneNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
      Then get a list of incoming phone numbers
      Then get a list of incoming phone numbers with filters

    Scenario: Buy a phone number
      Given an IncomingPhoneNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
      Then purchase an incoming phone number

    Scenario:  Remove an incoming phone number
      Given an IncomingPhoneNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
      Then delete an incoming phone number

    Scenario: Get incoming phone number properties
      Given an IncomingPhoneNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
      Then get the properties of an incoming phone number

    Scenario:  Modify incoming phone number
      Given an IncomingPhoneNumberRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
      Then modify an incoming phone number