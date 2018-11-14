Feature: Member

  Scenario: Create a Member from JSON
    Given Some JSON representing a Member
    Then build a Member object from that JSON
    Then check the contents of the Member

  Scenario: Check the Member equals method
    Given Some JSON representing a Member
    Then build a Member object from that JSON
    Then check the Member is equal
    Then check the Member is not equal