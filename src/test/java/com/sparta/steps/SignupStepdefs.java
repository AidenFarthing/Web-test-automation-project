package com.sparta.steps;

import com.sparta.pages.HomePage;
import com.sparta.pages.SignupPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;

public class SignupStepdefs {

    @Managed
    HomePage homePage;

    @Managed
    SignupPage signupPage;

    @Given("I am on the signup page")
    public void iAmOnTheSignupPage() {
        homePage.openHomePage();
        homePage.openLogin();
    }

    @And("I enter the name and email")
    public void iEnterTheNameAndEmail() {
        signupPage.enterName("Jane");
        signupPage.enterEmail("Jane@Jane.com");
    }

    @When("I click signup")
    public void iClickSignup() {
        signupPage.submitFirstForm();
    }

    @And("I input each field with the input")
    public void iInputEachFieldWithTheInput() {

    }

    @And("I click create account")
    public void iClickCreateAccount() {

    }

    @Then("I should be taken to the home page")
    public void iShouldBeTakenToTheHomePage() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
