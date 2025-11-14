Feature: Signup Initiation

  Background:
    Given I am on the sign up page

  @SignupInitiation
  Scenario: User successfully begins the signup process
    When I enter name "Jane" and a unique email address
    And I click the signup button
    Then I should be redirected to the account information page

  @DuplicateEmail
  Scenario: Cannot signup with an email that already exists
    When I enter name "TestUser" and email "test@gmail.com"
    And I click the signup button
    Then I should see an error saying the email already exists
    And I should remain on the signup page

  @MissingFields
  Scenario Outline: Missing name or email prevents signup
    When I enter name "<name>" and email "<email>"
    And I click the signup button
    Then I should remain on the signup page

    Examples:
      | name | email          |
      |      | test@gmail.com |
      | John |                |

  @InvalidEmailFormat
  Scenario Outline: Invalid email format is rejected (expected behaviour)
    When I enter name "Test" and email "<email>"
    And I click the signup button
    Then I should remain on the signup page

    Examples:
      | email       |
      | abcdef      |
      | test@.com   |
      | hello@@com  |