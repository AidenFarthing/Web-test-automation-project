package com.sparta.steps;

import com.sparta.pages.HomePage;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Step;
import org.junit.jupiter.api.Assertions;

public class HomeStepdefs {

    HomePage homePage;

    // ------------------------------------------------------------
    // Navigation
    // ------------------------------------------------------------

    @Given("I am on the homepage")
    @Step("Open the AutomationExercise homepage")
    public void iAmOnTheHomepage() {
        homePage.openHomePage();
        Assertions.assertTrue(homePage.isHomePageLoaded(),
                "Homepage did not load correctly.");
    }

    @When("I navigate to the products page")
    @Step("Navigate to the Products page")
    public void iNavigateToTheProductsPage() {
        homePage.openInventory();
    }

    @When("I navigate to the cart page")
    @Step("Navigate to the Cart page")
    public void iNavigateToTheCartPage() {
        homePage.openCart();
    }

    @When("I navigate to the login page")
    @Step("Navigate to the Login page")
    public void iNavigateToTheLoginPage() {
        homePage.openLogin();
    }

    @When("I navigate to the contact us page")
    @Step("Navigate to the Contact Us page")
    public void iNavigateToTheContactUsPage() {
        homePage.openContactUs();
    }

    // ------------------------------------------------------------
    // Visibility Tests
    // ------------------------------------------------------------

    @Then("the homepage slider should be visible")
    @Step("Check homepage slider is visible")
    public void homepageSliderVisible() {
        Assertions.assertTrue(homePage.isHomePageLoaded(),
                "Homepage slider or featured items section is not visible.");
    }

    @Then("the navigation bar should be visible")
    @Step("Check navigation bar is visible")
    public void navigationBarVisible() {
        Assertions.assertTrue(homePage.isNavigationVisible(),
                "Navigation bar is not visible.");
    }

    @Then("the featured items section should be visible")
    @Step("Check featured items section is visible")
    public void featuredItemsVisible() {
        Assertions.assertTrue(homePage.isFeatureSectionVisible(),
                "Featured items section is not visible.");
    }

    // ------------------------------------------------------------
    // Functionality Assertions
    // ------------------------------------------------------------

    @Then("I should be on the products page")
    @Step("Verify user is on the products page")
    public void verifyProductsPage() {
        String url = homePage.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains("/products"),
                "Did not navigate to Products page.");
    }

    @Then("I should be on the cart page")
    @Step("Verify user is on the cart page")
    public void verifyCartPage() {
        String url = homePage.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains("/view_cart"),
                "Did not navigate to Cart page.");
    }

    @Then("I should be on the login page")
    @Step("Verify user is on the login page")
    public void verifyLoginPage() {
        String url = homePage.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains("/login"),
                "Did not navigate to Login page.");
    }

    @Then("I should be on the contact us page")
    @Step("Verify user is on the Contact Us page")
    public void verifyContactUsPage() {
        String url = homePage.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains("/contact_us"),
                "Did not navigate to Contact Us page.");
    }
}

