Feature: Queue

  Scenario: Create a queue from JSON
    Given Some JSON representing a queue
    Then build a Queue object from that JSON
    Then check the contents of the queue

  Scenario: Check the Queue equals method
    Given Some JSON representing a queue
    Then build a Queue object from that JSON
    Then check the queue is equal
    Then check the queue is not equal