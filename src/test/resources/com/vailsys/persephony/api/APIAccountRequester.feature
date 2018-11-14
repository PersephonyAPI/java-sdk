Feature: APIAccountRequester

  Scenario: Create an APIAccountRequester
    Given an accountId of AC1234567890123456789012345678901234567890 and an authToken of 12eba896a69876c87697e9876d0f987123456a67 to make a APIAccountRequester
    Then stored in the APIAccountRequester should be the accountId AC1234567890123456789012345678901234567890 and the authToken 12eba896a69876c87697e9876d0f987123456a67

  Scenario: Root path
    Given an accountId of AC1234567890123456789012345678901234567890 and an authToken of 12eba896a69876c87697e9876d0f987123456a67 to make a APIAccountRequester
    Then the APIAccountRequester rootPath should be /Accounts