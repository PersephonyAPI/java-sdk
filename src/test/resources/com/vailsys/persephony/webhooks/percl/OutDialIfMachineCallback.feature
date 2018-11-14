Feature: OutDialIfMachineCallback

  Scenario: Create an OutDialIfMachineCallback with machineType faxMachine
    Given An OutDialIfMachineCallback object with machineType faxMachine
    Then verify the OutDialIfMachineCallback's contents with machineType faxMachine

  Scenario: Create an OutDialIfMachineCallback with machineType answeringMachine
    Given An OutDialIfMachineCallback object with machineType answeringMachine
    Then verify the OutDialIfMachineCallback's contents with machineType answeringMachine