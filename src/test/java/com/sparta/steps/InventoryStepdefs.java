package com.sparta.steps;


import com.sparta.pages.CartPage;
import com.sparta.pages.InventoryPage;
import com.sparta.pages.ProductPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Assertions;

public class InventoryStepdefs {
    @Managed
    InventoryPage inventoryPage;
    ProductPage productPage;
    CartPage cartPage;

    @Given("I am on the inventory page")
    public void iAmOnTheInventoryPage() {
        inventoryPage.open();
        inventoryPage.dismissPopups();

    }

    @When("I can filter them by category \\(e.g.Women)")
    public void iCanFilterThemByCategoryEGWomen() {
        inventoryPage.setWomenFliter();
        inventoryPage.setDressFliter();
    }

    @Then("I can easily find the type of items I'm interested in.")
    public void iCanEasilyFindTheTypeOfItemsIMInterestedIn() {
        Assertions.assertEquals(3, inventoryPage.getInventory());
    }

    @When("I want to search for specific products using a search bar")
    public void iWantToSearchForSpecificProductsUsingASearchBar() {
        inventoryPage.clickSearchField();
        inventoryPage.clickSearchbutton();
    }

    @Then("I can quickly find a particular item without manual browsing.")
    public void iCanQuicklyFindAParticularItemWithoutManualBrowsing() {
        Assertions.assertEquals(1, inventoryPage.getInventory());
    }


    @And("I want to search for invalid product using a search bar")
    public void iWantToSearchForInvalidProductUsingASearchBar() {
        inventoryPage.clickSearchFieldwithemptystring();
        inventoryPage.clickSearchbutton();
    }

    @Then("I should get message stating item does not exist.")
    public void iShouldGetMessageStatingItemDoesNotExist() {
        Assertions.assertEquals(0, inventoryPage.getInventory());
    }

    @When("I can filter them by category \\(e.g. Man)")
    public void iCanFilterThemByCategoryEGMan() {
        inventoryPage.setMenFilter();
        inventoryPage.setTshirtFliter();

    }

    @Then("I can easily find the type of T shrits I'm interested in.")
    public void iCanEasilyFindTheTypeOfTShritsIMInterestedIn() {
        Assertions.assertEquals(6, inventoryPage.getInventory());
    }

    @When("I click on a product to see its detailed information, including price, description, availability, and images.")
    public void iClickOnAProductToSeeItsDetailedInformationIncludingPriceDescriptionAvailabilityAndImages() {
        inventoryPage.detialedProductView();
    }

    @Then("Then I can make an informed decision before purchasing.")
    public void thenICanMakeAnInformedDecisionBeforePurchasing() {
        productPage.clickAddToCartButton();
        productPage.clickContinueShopping();
        productPage.clickOnCart();

        Assertions.assertEquals("1",cartPage.getCartQuantity());
    }
}
