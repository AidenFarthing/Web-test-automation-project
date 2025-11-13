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

    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
        homePage.open();
        homePage.viewProduct();
    }

    @When("I add an item to cart")
    public void iAddAnItemToCart() {
        productPage.clickAddToCartButton();
        productPage.clickContinueShopping();
    }

    @Then("there should an item in my cart")
    public void thereShouldAnItemInMyCart() {
        productPage.clickOnCart();

    }

    @And("I have only one item in the cart")
    public void iHaveOnlyOneItemInTheCart() {
        Assertions.assertEquals("1",cartPage.getCartQuantity());
    }

    @When("remove the item from cart")
    public void removeTheItemFromCart() {
        cartPage.cartQuantityDelete();
    }

    @Then("there should no items in my cart")
    public void thereShouldNoItemsInMyCart() {
        Assertions.assertEquals("Cart is empty!",cartPage.emptyCartMessage());
    }
}
