package com.sparta.steps;

import com.sparta.pages.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Assertions;

public class CheckoutStepdefs {
    @Managed
    LoginPage loginPage;

    @Managed
    HomePage homePage;

    @Managed
    CartPage cartPage;

    @Managed
    ProductPage productPage;

    @Managed
    CheckoutPage checkoutPage;

    @Managed
    PaymentPage paymentPage;

    @When("I click proceed to checkout")
    public void iClickProceedToCheckout() {
        productPage.clickOnCart();
        cartPage.proceedToCheckout();

    }

    @Then("I should see confirmation of purchase")
    public void iShouldSeeConfirmationOfPurchase() {
        Assertions.assertEquals("ORDER PLACED!",paymentPage.getOrderPlacedMessage());
    }

    @And("I am logged in")
    public void iAmLoggedIn() {
        homePage.openHomePage();
        homePage.openLogin();
        loginPage.enterEmail("spartatester@gmail.com");
        loginPage.enterPassword("test");
        loginPage.clickLoginButton();
    }

    @And("have added an item to the cart")
    public void haveAddedAnItemToTheCart() {
        homePage.viewProduct();
        productPage.clickAddToCartButton();
        productPage.clickContinueShopping();
    }

    @And("I click place order")
    public void iClickPlaceOrder() {
        checkoutPage.clickCheckout();
    }

    @And("I enter the card details and click submit")
    public void iEnterTheCardDetails() {
        paymentPage.enterNameOnCard("Jane");
        paymentPage.enterCardNumber("123456789");
        paymentPage.enterCVC("202");
        paymentPage.enterCardExpiryMonth("01");
        paymentPage.enterCardExpiryYear("2030");
        paymentPage.submit();
    }
}
