Feature: MessageOptions

	Scenario: The MessageOptions constructor should ensure all the fields are null.
		Given An empty MessageOptions object.
		Then check that all MessageOptions fields are null.
	
	Scenario: The MessageOptions getters and setters should work.
		Given An empty MessageOptions object.
		Then check that setNotificationUrl() and getNotificationUrl() are setting and retrieving the correct value.