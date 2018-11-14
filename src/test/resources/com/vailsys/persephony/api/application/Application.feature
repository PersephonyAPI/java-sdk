Feature: Application

  Scenario: Create an application from JSON
    Given some JSON representing an application
    Then build an Application object from that JSON
    Then check the contents of that application

    Scenario: Check application equals method
      Given some JSON representing an application
      Then build an Application object from that JSON
      Then check the application is equal
      Then check the application is not equal