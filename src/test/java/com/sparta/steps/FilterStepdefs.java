package com.sparta.steps;


import com.sparta.pages.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Assertions;

public class FilterStepdefs {
    @Managed
    InventoryPage inventoryPage;

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
        Assertions.assertEquals(4,inventoryPage.getInventory());
    }


}
