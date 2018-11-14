Feature: CreateConference

  Scenario: Create a CreateConference
    Given a CreateConference command with actionUrl http://action.url/end/point
    Then check that actionUrl equals http://action.url/end/point in CreateConference object
    Then check all options fields in CreateConference are null

    Scenario: Create a non-empty CreateConference
      Given a CreateConference command with actionUrl http://action.url/end/point
      Then set CreateConference actionUrl to http://different.url/end/point
      Then check that actionUrl equals http://different.url/end/point in CreateConference object
      Then set CreateConference optional properties
      Then check CreateConference optional properties