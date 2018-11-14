Feature: MessageDeliveryCallback

  Scenario: Build a MessageDelivery object from JSON
    Given some JSON create a MessageDelivery
    Then verify the MessageDelivery's contents