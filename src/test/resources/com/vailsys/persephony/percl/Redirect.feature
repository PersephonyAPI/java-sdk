Feature: Redirect

  Scenario: Create a Redirect
    Given a Redirect object with actionUrl http://action.url/end/point
    Then check that the Redirect actionUrl is http://action.url/end/point

    Scenario: Set actionUrl
      Given a Redirect object with actionUrl http://action.url/end/point
      Then set the Redirect actionUrl to http://test.url
      Then check that the Redirect actionUrl is http://test.url