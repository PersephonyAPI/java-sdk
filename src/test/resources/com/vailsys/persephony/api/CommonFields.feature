Feature: CommonFields

  Scenario: The CommonFields constructor should ensure all the fields are null
    Given an empty CommonFields object
    Then check that all CommonFields fields are null

    Scenario: The CommonFields getters and setters should work
      Given an empty CommonFields object
      When requestId is set to RQ1234567890123456789012345678901234567890 in CommonFields
      Then check that requestId is RQ1234567890123456789012345678901234567890 in CommonFields
