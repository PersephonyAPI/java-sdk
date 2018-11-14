@Mockserver
Feature: AccountRequester

  Scenario: Create an AccountRequester
    Given an AccountRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then check the AccountRequester acting accountId is AC6789
    Then check the AccountRequester path is /Accounts

  Scenario: Get an account
    Given an AccountRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then get an account

  Scenario: Modify an account
    Given an AccountRequester with the credentials AC12345 and 12345 and using the accountId AC6789
    Then modify an account