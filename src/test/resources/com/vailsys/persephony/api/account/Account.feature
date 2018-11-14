Feature: Account

  Scenario: Create account from JSON
    Given some JSON representing an account
    Then build an Account object from that JSON
    Then check the contents of that account

  Scenario: Compare accounts for equality
    Given some JSON representing an account
    Then build an Account object from that JSON
    Then compare the account with equal and unequal objects