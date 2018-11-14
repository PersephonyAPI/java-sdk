@Mockserver
Feature: ApplicationsRequester

  Scenario: Can create an ApplicationsRequester
    Given an ApplicationsRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then check the ApplicationsRequester acting accountId is AC6789
    Then check the ApplicationsRequester path is /Accounts/AC6789/Applications

  Scenario: Getting a list of applications
    Given an ApplicationsRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then get a list of applications
    Then get a list of applications with filters

  Scenario: Get a single application by applicationId
    Given an ApplicationsRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then get an application by its applicationId

  Scenario: Update an application
    Given an ApplicationsRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then update an application

  Scenario: Create an application
    Given an ApplicationsRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then create an application

  Scenario: Create an application with options
    Given an ApplicationsRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then create an application with options

    Scenario: Delete an application
      Given an ApplicationsRequester with the credentials AC12345 and 12345 and using the accountId AC6789
      Then delete an application