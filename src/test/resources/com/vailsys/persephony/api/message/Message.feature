Feature: Message

  Scenario: Create a message from JSON
    Given Some JSON representing a message.
    Then build a Message object from that JSON.
    Then check the contents of that message.

  Scenario: Compare messages for equality
    Given Some JSON representing a message.
    Then build a Message object from that JSON.
    Then compare the message with equal and unequal objects

