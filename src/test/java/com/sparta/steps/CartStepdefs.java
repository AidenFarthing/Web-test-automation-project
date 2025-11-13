package com.sparta.steps;

import com.sparta.pages.HomePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;

public class CartStepdefs  extends PageObject {
    @Managed
    HomePage homePage;

    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
        homePage.open();
        homePage.viewProduct();
    }

    @When("I add an item to cart")
    public void iAddAnItemToCart() {

    }

    @Then("there should an item in my cart")
    public void thereShouldAnItemInMyCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("I have only one item in the cart")
    public void iHaveOnlyOneItemInTheCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("remove the item from cart")
    public void removeTheItemFromCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("there should no items in my cart")
    public void thereShouldNoItemsInMyCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
