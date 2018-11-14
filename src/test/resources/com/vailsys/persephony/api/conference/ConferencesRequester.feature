@Mockserver
Feature: ConferencesRequester

  Scenario: Can create a ConferencesRequester
    Given a ConferencesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then check the ConferencesRequester acting accountId is AC1234567890123456789012345678901234567890
    Then check the ConferencesRequester path is /Accounts/AC1234567890123456789012345678901234567890/Conferences

  Scenario: Getting a list of conferences
    Given a ConferencesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then get a list of conferences
    Then get a list of conferences with filters

    Scenario: Get a single conference by conferenceId
      Given a ConferencesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
      Then get a Conference by its conferenceId

    Scenario: Update a conference
      Given a ConferencesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
      Then update a conference

    Scenario: Create a conference
      Given a ConferencesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
      Then create a conference

  Scenario: Create a conference with options
    Given a ConferencesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then create a conference with options

  Scenario: Create a ParticipantsRequester for a conference
    Given a ConferencesRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
    Then create a ParticipantsRequester
