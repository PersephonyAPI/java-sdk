Feature: MessageStatusCallback

  Scenario: Build a MessageStatus object from JSON
    Given some JSON create a MessageStatus
    Then verify the MessageStatus's contents