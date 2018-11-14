Feature: QueueCreateOptions

  Scenario: The QueueCreateOptions constructor should ensure all the fields are null.
    Given An empty QueueCreateOptions object.
    Then check that all QueueCreateOptions fields are null.

  Scenario: The QueueCreateOptions getters and setters should work.
    Given An empty QueueCreateOptions object.
    Then set alias to queueAlias in QueueCreateOptions
    Then check that alias is queueAlias in QueueCreateOptions
    Then set maxSize to 11 in QueueCreateOptions
    Then check that maxSize is 11 in QueueCreateOptions
