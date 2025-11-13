package com.sparta.steps;

import com.sparta.pages.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class LoginStepdefs {

    @Managed
    LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.open();
        loginPage.dismissPopups();
    }

    @And("I have entered the username {string}")
    public void iHaveEnteredTheUsername(String email) {
        loginPage.enterEmail(email);
    }

    @And("I have entered the password {string}")
    public void iHaveEnteredThePassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should land on the inventory page")
    public void iShouldLandOnTheInventoryPage() {
        assertThat(loginPage.getDriver().getCurrentUrl(), containsString("https://automationexercise.com"));
    }


    @Then("I should see the login error message {string}")
    public void iShouldSeeTheLoginErrorMessage(String expectedMessage) {
        assertThat(loginPage.getErrorMessage(), equalTo(expectedMessage));
    }

    @Then("I should remain on the login page")
    public void iShouldRemainOnTheLoginPage() {
        assertThat(loginPage.getDriver().getCurrentUrl(),
                containsString("/login"));
    }

    @And("the email field should be required")
    public void theEmailFieldShouldBeRequired() {
        assertThat(loginPage.isEmailRequired(), is(true));
    }

    @And("the password field should be required")
    public void thePasswordFieldShouldBeRequired() {
        assertThat(loginPage.isPasswordRequired(), is(true));
    }
}
