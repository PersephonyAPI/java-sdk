## Introduction
The Persephony Java SDK will allow you to easily use the Persephony API in a Java application.

[![Release](https://jitpack.io/v/PersephonyAPI/java-sdk.svg)](https://jitpack.io/#PersephonyAPI/java-sdk)
[![Build Status](https://travis-ci.com/PersephonyAPI/java-sdk.svg?branch=master)](https://travis-ci.com/PersephonyAPI/java-sdk)
[![Maintainability](https://api.codeclimate.com/v1/badges/5db37830ae23321e9150/maintainability)](https://codeclimate.com/github/PersephonyAPI/java-sdk/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/5db37830ae23321e9150/test_coverage)](https://codeclimate.com/github/PersephonyAPI/java-sdk/test_coverage)
[Docs](https://jitpack.io/com/github/persephonyapi/java-sdk/latest/javadoc/)

### SDK Installation

To include the SDK in your build, follow the instructions on [Jitpack](https://jitpack.io/#PersephonyAPI/java-sdk)

## Testing your Installation

Test the SDK is working by sending yourself a text message.

```java
public class Example {

    public static final String accountId = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static final String authToken = "your_auth_token";
    public static final String To = "your_phone_number";
    public static final String From = "a_persephony_phone_number_in_your_account";

    public static void main(String[] args) throws PersyException {
        PersyClient client = new PersyClient(accountId, authToken);

        client.messages.create(From, To, "Welcome to Persephony!");
    }
}
```

When you run this code you should get a text message.

### Running Unit Tests

You can run `gradle test` to run the full test suite.

You can also specify cucumber tags with the usual boolean inclusion / exclusion, specific feature files, or the line of the scenario or scenario outline example to run.

```bash
gradle -Dcucumber.options=src/test/resources/com/vailsys/persephony/api/call/Call.feature:5 test
```

```bash
gradle -Dcucumber.options="--tags @Calls" test
```

You can generate a Cobertura coverage report by running `gradle cobertura`. The report will be found at build/cobertura.

## Documentation

The [Persephony documentation](https://www.persephony.com/docs) has guides on [getting started](https://www.persephony.com/docs/getting-started/) with Persephony, as well as the [API reference](https://www.persephony.com/docs/api/), [PerCL reference](https://www.persephony.com/docs/percl/), and several useful [tutorials.](https://www.persephony.com/docs/tutorials/).

## Getting Help

If you are experiencing difficulties, contact our support team at [support@persephony.com](mailto:support@persephony.com).

## Dependencies
This SDK targets Java 7.

Import these dependencies:
  
- com.google.code.gson:gson:2.6.2
