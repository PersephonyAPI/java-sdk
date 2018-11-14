Feature: Enqueue

  Scenario: Create an Enqueue Object
    Given an Enqueue object with queueId QU123456 and actionUrl http://some.url/path
    Then check that the Enqueue queueId is QU123456
    Then check that the Enqueue actionUrl is http://some.url/path
    Then check all optional fields in Enqueue are null

  Scenario: Set and check values
    Given an Enqueue object with queueId QU123456 and actionUrl http://some.url/path
    Then set the Enqueue queueId to QU789012
    Then check that the Enqueue queueId is QU789012
    Then set the Enqueue actionUrl to http://test.url
    Then check that the Enqueue actionUrl is http://test.url
    Then set the Enqueue waitUrl to http://wait.url
    Then check that the Enqueue waitUrl is http://wait.url
    Then set the Enqueue notificationUrl to http://notification.url
    Then check that the Enqueue notificationUrl is http://notification.url