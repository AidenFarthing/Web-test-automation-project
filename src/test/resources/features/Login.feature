Feature: Login functionality

  Background:
    Given I am on the login page

  @Happy
  Scenario: Login with valid username and valid password
    And I have entered the username "spartatester@gmail.com"
    And I have entered the password "test"
    When I click the login button
    Then I should land on the inventory page


  @Unhappy
  Scenario Outline: Unsuccessful login attempts show error message
    And I have entered the username "<username>"
    And I have entered the password "<password>"
    When I click the login button
    Then I should see the login error message "Your email or password is incorrect!"

    Examples:
      | username               | password     |
      | spartatester@gmail.com | wrongpass    |
      | wrong@user.com         | wrongpass    |
      | wrong@user.com         | test         |

  @Blank
  Scenario Outline: Required fields cannot be left blank
    And I have entered the username "<username>"
    And I have entered the password "<password>"
    When I click the login button
    Then I should remain on the login page
    And the email field should be required
    And the password field should be required

    Examples:
      | username | password |
      |          | test     |
      | test@gmail.com |       |
      |          |          |

  @CaseSensitivity @Defect
  Scenario Outline: Login with wrong email case should NOT work (Defect)
    And I have entered the username "<username>"
    And I have entered the password "test"
    When I click the login button
    Then I should see the login error message "Your email or password is incorrect!"

    Examples:
      | username                  |
      | SPARTAtester@gmail.com    |
      | spartatester@GMAIL.COM    |
      | SpartaTester@gmail.com     |
      | SPARTATESTER@gmail.com     |
