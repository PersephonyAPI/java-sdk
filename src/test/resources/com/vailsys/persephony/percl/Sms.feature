Feature: Sms

  Scenario: Create an Sms
    Given an Sms command with to +11234445768 and from +19994837465 and text Hello World
    Then check that to equals +11234445768 in Sms object
    Then check that from equals +19994837465 in Sms object
    Then check that text equals Hello World in Sms object

  Scenario: Set notificationUrl
    Given an Sms command with to +11234445678 and from +19994837365 and text Hello World
    Then set the Sms command notificationUrl to http://notification.url
    Then check that notificationUrl equals http://notification.url in Sms object