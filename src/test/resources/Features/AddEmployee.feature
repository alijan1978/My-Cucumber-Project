Feature: Employee

  @testcase2 @smoke
  Scenario: Adding a new Employee
#    Given Open the browser and launch HRMS application
    When User enters valid email and valid password
    And Click on login button
    When user clicks on PIM option
    And user clicks on add employee button
    And user enters firstname and middle name lastname
#    And user clicks on save button
#    And close the browser


