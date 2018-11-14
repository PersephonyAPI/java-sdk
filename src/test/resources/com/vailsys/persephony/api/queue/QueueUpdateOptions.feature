Feature: QueueUpdateOptions

  Scenario: The QueueUpdateOptions constructor should ensure all the fields are null.
    Given An empty QueueUpdateOptions object.
    Then check that all QueueUpdateOptions fields are null.

  Scenario: The QueueUpdateOptions getters and setters should work.
    Given An empty QueueUpdateOptions object.
    Then set alias to queueAlias in QueueUpdateOptions
    Then check that alias is queueAlias in QueueUpdateOptions
    Then set maxSize to 22 in QueueUpdateOptions
    Then check that maxSize is 22 in QueueUpdateOptions
