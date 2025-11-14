Feature: Checkout
  In order to be able to buy items
  As visitor of the automation exercise website
  I want to be able add and remove items from the cart

  @Happy
  Scenario: Checkout by buying an item already logged in
    Given I am on the home page
    And I am logged in
    And have added an item to the cart
    When I click proceed to checkout
    And I click place order
    And I enter the card details and click submit
    Then I should see confirmation of purchase


  @Happy
  Scenario: Checkout by buying an item not yet logged in
    Given I am on the home page and logged out
    And have added an item to the cart
    When I click proceed to checkout
    And I click login
    And I login
    When I click proceed to checkout again
    And I click place order
    And I enter the card details and click submit
    Then I should see confirmation of purchase

  @Sad
  Scenario: Checkout does not fill in details
    Given I am on the home page
    And I am logged in
    And have added an item to the cart
    When I click proceed to checkout
    And I click place order
    And I click submit without filling details
    Then I should not progress to the next page