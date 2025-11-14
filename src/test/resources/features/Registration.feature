Feature: Full Registration

  The user must complete the full registration form to create an account.
  This feature covers all behaviour on the account information page, including:
  - Successful form submission
  - Missing required fields
  - Invalid field formats

  Background:
    Given I have successfully started signup with a unique email
    And I am on the account information page

  @FullFormHappy
  Scenario: User completes the full signup form successfully
    When I fill in valid account information
    And I click Create Account
    Then I should be taken to the Account Created confirmation page

  @FullFormMissingFields
  Scenario Outline: Required fields cannot be left blank
    When I fill in the account information leaving "<field>" blank
    And I click Create Account
    Then I should remain on the account information page

    Examples:
      | field        |
      | Password     |
      | Address      |
      | State        |
      | City         |
      | Zipcode      |
      | MobileNumber |

  @InvalidPassword @Defect
  Scenario: System allows extremely weak password
    When I enter invalid value "a" into account field "Password"
    And I click Create Account
    Then I should remain on the account information page

  @InvalidMobile
  Scenario: System allows mobile number with letters
    When I enter invalid value "abcdefg" into account field "MobileNumber"
    And I click Create Account
    Then I should remain on the account information page