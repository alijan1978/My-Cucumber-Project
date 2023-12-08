Feature: Login Functionalities

  @smoke1
  Scenario: Valid Admin login
#    Given Open the browser and launch HRMS application
    When User enters valid email and valid password
    And Click on login button
    Then User is logged in successfully
#    And Close the browser

  #  This below is called Regular Expression of cucumber file to
  @smoke1
  Scenario: Valid Admin login
#    Given Open the browser and launch HRMS application
    When User enters valid "admin" and valid "Hum@nhrm123"
    And Click on login button
    Then User is logged in successfully
#    And Close the browser

    # Below we use Parameterization / Data Driven
  @scenarioOutline
  Scenario Outline: Login with Multiple Credentials using Scenario Outline

      # Given Open the browser and launch HRMS application
    When User enters valid "<username>" and valid "<password>"
    And Click on login button
    Then User is logged in successfully
#    And Close the browser

    Examples:
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | admin    | Hum@nhrm123 |


    @dataTable
    Scenario: Login with Multiple Credentials using Data Table
      When user enters username and password and verifies login
        | username | password    |
        | admin    | Hum@nhrm123 |
        | ADMIN    | Hum@nhrm123 |
        | admin    | Hum@nhrm123 |






