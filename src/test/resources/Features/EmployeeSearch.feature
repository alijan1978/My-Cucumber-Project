Feature: Searching the Employee

  Background:
    When User enters valid email and valid password
    And Click on login button
    When user clicks on PIM option

  @smoke1
  Scenario: Search Employee by Id
#    Given Open the browser and launch HRMS application
#    When User enters valid email and valid password
#    And Click on login button
#    When user clicks on PIM option
    When user enters valid employee id
    And clicks on search button
    And user see employee information is displayed
#    And Close the browser

    @smoke1
    Scenario: Search Employee by Job Title
#      Given Open the browser and launch HRMS application
#      When User enters valid email and valid password
#      And Click on login button
#      When user clicks on PIM option
      When user select Job Title
      And clicks on search button
      And user see employee information is displayed
#  And Close the browser

#   Background: This is used to define all the Common steps that multiple scenarios
#   have in the same feature file, until the time flow/sequence is not broken