Feature: Homepage visibility and functionality
  As a user of AutomationExercise
  I want to verify that the homepage loads correctly
  And all navigation links function as expected

  @Visibility
  Scenario: Verify homepage elements are visible
    Given I am on the homepage
    Then the homepage slider should be visible
    And the navigation bar should be visible
    And the featured items section should be visible

  @NavigationProducts
  Scenario: Navigate to Products page
    Given I am on the homepage
    When I navigate to the products page
    Then I should be on the products page

  @NavigationCart
  Scenario: Navigate to Cart page
    Given I am on the homepage
    When I navigate to the cart page
    Then I should be on the cart page

  @NavigationLogin
  Scenario: Navigate to Login page
    Given I am on the homepage
    When I navigate to the login page
    Then I should be on the login page

  @NavigationContact
  Scenario: Navigate to Contact Us page
    Given I am on the homepage
    When I navigate to the contact us page
    Then I should be on the contact us page
