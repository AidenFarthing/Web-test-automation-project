package com.sparta.steps;

import com.sparta.pages.CartPage;
import com.sparta.pages.HomePage;
import com.sparta.pages.PaymentPage;
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
        homePage.openHomePage();
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
        cartPage.cartQuantityDelete();

    }

    @And("I have only one item in the cart")
    public void iHaveOnlyOneItemInTheCart() {
        homePage.viewProduct();
        productPage.clickAddToCartButton();
        productPage.clickContinueShopping();
        productPage.clickOnCart();
        Assertions.assertEquals("1",cartPage.getCartQuantity());
    }

    @When("I remove the item from cart")
    public void removeTheItemFromCart() {
        cartPage.cartQuantityDelete();
    }

    @Then("there should be no items in my cart")
    public void thereShouldNoItemsInMyCart() {
        productPage.clickOnCart();
        Assertions.assertEquals("Cart is empty! Click here to buy products.",cartPage.emptyCartMessage());
    }

    @When("I add two of an item to cart")
    public void iAddTwoOfAnItemToCart() {
        homePage.viewProduct();
        productPage.increaseQuantity("2");
        productPage.clickAddToCartButton();
        productPage.clickContinueShopping();
    }

    @Then("there should {int} of that item in my cart")
    public void thereShouldOfThatItemInMyCart(int arg0) {
        productPage.clickOnCart();
        Assertions.assertEquals("2",cartPage.getCartQuantity());
        cartPage.cartQuantityDelete();
    }

    @And("I have only two items in the cart")
    public void iHaveOnlyTwoItemsInTheCart() {
        homePage.viewProduct();
        productPage.increaseQuantity("2");
        productPage.clickAddToCartButton();
        productPage.clickContinueShopping();
        productPage.clickOnCart();
        Assertions.assertEquals("2",cartPage.getCartQuantity());
    }

    @When("I remove the items from cart")
    public void iRemoveTheItemsFromCart() {
        cartPage.cartQuantityDelete();
    }

}
