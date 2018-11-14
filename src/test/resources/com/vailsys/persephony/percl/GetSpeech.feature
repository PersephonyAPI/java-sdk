Feature: GetSpeech

  Scenario: Create a GetSpeech
    Given a GetSpeech command with actionUrl http://action.url/end/point, grammarFile /path/to/grammar/File
    Then check all optional fields in GetSpeech are null
    Then check that actionUrl equals http://action.url/end/point in GetSpeech object
    Then check that grammarFile equals /path/to/grammar/File in GetSpeech object

  Scenario: Create an non-empty GetSpeech
    Given a GetSpeech command with actionUrl http://action.url/end/point, grammarFile /path/to/grammar/File
    Then set GetSpeech actionUrl to http://get.speech.action.url/end/point
    Then check that actionUrl equals http://get.speech.action.url/end/point in GetSpeech object
    Then set GetSpeech grammarType to URL
    Then check that grammarType equals URL in GetSpeech object
    Then set GetSpeech grammarFile to /tmp/grammarFile.gf
    Then check that grammarFile equals /tmp/grammarFile.gf in GetSpeech object
    Then set GetSpeech grammarRule to "I don't know what a grammar rule looks like"
    Then check that grammarRule equals "I don't know what a grammar rule looks like" in GetSpeech object
    Then set GetSpeech playBeep to true
    Then check that playBeep equals true in GetSpeech object
    Then set GetSpeech noInputTimeoutMs to 1000
    Then check that noInputTimeoutMs equals 1000 in GetSpeech object
    Then set GetSpeech recognitionTimeoutMs to 1000
    Then check that recognitionTimeoutMs equals 1000 in GetSpeech object
    Then set GetSpeech confidenceThreshold to 1.1
    Then check that confidenceThreshold equals 1.1 in GetSpeech object
    Then set GetSpeech nBestListLength to 10
    Then check that nBestListLength equals 10 in GetSpeech object
    Then set GetSpeech sensitivityLevel to 2.4
    Then check that sensitivityLevel equals 2.4 in GetSpeech object
    Then set GetSpeech speechCompleteTimeoutMs to 1500
    Then check that speechCompleteTimeoutMs equals 1500 in GetSpeech object
    Then set GetSpeech speechIncompleteTimeoutMs to 1500
    Then check that speechIncompleteTimeoutMs equals 1500 in GetSpeech object
    Then set GetSpeech prompts to an empty list
    Then check that prompts equals an empty list in GetSpeech object

  Scenario: Check that GetSpeech serializes properly
    Given a GetSpeech command with actionUrl http://action.url/end/point, grammarFile /path/to/grammar/File
    Then set GetSpeech prompts to a Say and Pause list
    Then check that the GetSpeech command serializes properly