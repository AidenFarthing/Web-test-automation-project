Feature: Inventory
In order to be able to browse items
As a site vistor of the automation exercise website
I want to be able to see all of the products

  Background:
    Given I am on the inventory page

  @Happy
  Scenario: Being able to filter the inventory on the product page.
  When I can filter them by category (e.g.Women)
  Then  I can easily find the type of items I'm interested in.

  @Happy
  Scenario: Being able to filter the inventory on the product page.
  When I can filter them by category (e.g. Man)
  Then  I can easily find the type of T shrits I'm interested in.

  @Happy
  Scenario: Being able to search the inventory on the product page.
  When  I want to search for specific products using a search bar
  Then I can quickly find a particular item without manual browsing.

  @Happy
    Scenario: In order to decide what to buy I want to be able to see the product details before buying.
    When  I click on a product to see its detailed information, including price, description, availability, and images.
    Then  Then I can make an informed decision before purchasing.

  @Defect
    Scenario: I want to be able to search for products but if I type the a wrong item I do not get feedback
    And I want to search for invalid product using a search bar
    Then I should get message stating item does not exist.