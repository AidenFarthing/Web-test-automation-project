package com.sparta.steps;

import com.sparta.pages.CartPage;
import com.sparta.pages.HomePage;
import com.sparta.pages.ProductPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;

public class CartStepdefs  extends PageObject {
    @Managed
    HomePage homePage;

    @Managed
    ProductPage productPage;

    @Managed
    CartPage cartPage;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        homePage.open();
        cartPage.automationExercisePopup();
    }

    @When("I add an item to cart")
    public void iAddAnItemToCart() {
        homePage.viewProduct();
        productPage.clickAddToCartButton();
        productPage.clickContinueShopping();
    }

    @Then("there should an item in my cart")
    public void thereShouldAnItemInMyCart() {
        productPage.clickOnCart();
        Assertions.assertEquals("1",cartPage.getCartQuantity());

    }

    @And("I have only one item in the cart")
    public void iHaveOnlyOneItemInTheCart() {
        productPage.clickOnCart();
        Assertions.assertEquals("1",cartPage.getCartQuantity());
    }

    @When("I remove the item from cart")
    public void removeTheItemFromCart() {
        cartPage.cartQuantityDelete();
    }

    @Then("there should no items in my cart")
    public void thereShouldNoItemsInMyCart() {
        productPage.clickOnCart();
        Assertions.assertEquals("Cart is empty! Click here to buy products.",cartPage.emptyCartMessage());
    }
}
