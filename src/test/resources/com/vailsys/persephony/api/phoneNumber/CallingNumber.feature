Feature: Calling Number

  Scenario: Create a calling number from JSON
    Given some JSON representing a calling number
    Then build a callingNumber object from that JSON
    Then check the contents of the callingNumber

  Scenario: Compare calling numbers for equality
    Given some JSON representing a calling number
    Then build a callingNumber object from that JSON
    Then compare the callingNumber to equal and unequal objects