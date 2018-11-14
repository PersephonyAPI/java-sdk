Feature: MessagesSearchFilters

  Scenario: Create a MessagesSearchFilters object
    Given an empty MessagesSearchFilters object
    Then check that all fields in MessagesSearchFilters are null

  Scenario: Can set the to number
    Given an empty MessagesSearchFilters object
    Then set the MessagesSearchFilters to number to +13125551234
    Then check that the MessagesSearchFilters to number is +13125551234

  Scenario: Can set the from number
    Given an empty MessagesSearchFilters object
    Then set the MessagesSearchFilters from number to +13125554321
    Then check that the MessagesSearchFilters from number is +13125554321

  Scenario: Can set the beginTime
    Given an empty MessagesSearchFilters object
    Then set the MessagesSearchFilters beginTime to 2018-01-02 14:31:10
    Then check that the MessagesSearchFilters beginTime is 2018-01-02 14:31:10

  Scenario: Can set the endTime
    Given an empty MessagesSearchFilters object
    Then set the MessagesSearchFilters endTime to 2018-01-02 14:31:10
    Then check that the MessagesSearchFilters endTime is 2018-01-02 14:31:10

  Scenario: Can set the direction
    Given an empty MessagesSearchFilters object
    Then set the MessagesSearchFilters direction to outbound
    Then check that the MessagesSearchFilters direction is outbound