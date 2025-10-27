Feature: Login functionality

  Background:
    Given the login page is opened

  @smoke @login
  Scenario Outline: Successful and unsuccessful login attempts on the-internet.herokuapp.com
    When the user attempts to login with username "<username>" and password "<password>"
    Then the login should be "<result>"

    Examples:
      | username              | password             | result       |
      | tomsmith              | SuperSecretPassword! | success      |
      | invalidUser           | badPassword          | failure      |
