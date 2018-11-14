Feature: Log feature

  Scenario: Create a log object from JSON
    Given some JSON representing a log
    Then build a Log object from that JSON
    Then check the contents of the Log

  Scenario: Compare equality
    Given some JSON representing a log
    Then build a Log object from that JSON
    Then compare the Log to equal and unequal objects