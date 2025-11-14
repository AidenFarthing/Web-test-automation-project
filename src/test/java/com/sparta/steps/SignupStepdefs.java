package com.sparta.steps;

import com.sparta.pages.RegistrationPage;
import com.sparta.pages.SignupPage;
import com.sparta.utils.FormModifier;
import com.sparta.utils.SignupForm;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Managed;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SignupStepdefs {

    @Managed
    SignupPage signupPage;

    @Managed
    RegistrationPage registrationPage;

    private String uniqueEmail;

    // -----------------------------
    // SIGNUP INITIATION SECTION
    // -----------------------------

    @Given("I am on the sign up page")
    public void iAmOnTheSignUpPage() {
        signupPage.open();
        signupPage.nukeAds();
        signupPage.dismissPopups();

    }

    @When("I enter name {string} and a unique email address")
    public void iEnterNameAndAUniqueEmailAddress(String name) {
        signupPage.nukeAds();
        uniqueEmail = signupPage.generateUniqueEmail();
        signupPage.enterName(name);
        signupPage.enterEmail(uniqueEmail);
    }

    @When("I enter name {string} and email {string}")
    public void iEnterNameAndEmail(String name, String email) {
        signupPage.enterName(name);
        signupPage.enterEmail(email);
    }

    @And("I click the signup button")
    public void iClickTheSignupButton() {
        signupPage.clickSignup();
    }

    @Then("I should be redirected to the account information page")
    public void iShouldBeRedirectedToAccountInfoPage() {
        assertThat(signupPage.getDriver().getCurrentUrl(),
                containsString("/signup"));
    }

    @Then("I should remain on the signup page")
    public void iShouldRemainOnSignupPage() {
        assertThat(signupPage.isStillOnSignupPage(), is(true));
    }

    @Then("I should see an error saying the email already exists")
    public void iShouldSeeDuplicateEmailError() {
        assertThat(signupPage.isDuplicateEmailErrorVisible(), is(true));
    }

    // -----------------------------
    // FULL REGISTRATION SECTION
    // -----------------------------

    @Given("I have successfully started signup with a unique email")
    public void iHaveSuccessfullyStartedSignup() {
        signupPage.open();
        signupPage.dismissPopups();
        signupPage.nukeAds();


        uniqueEmail = signupPage.generateUniqueEmail();
        signupPage.enterName("Tester");
        signupPage.enterEmail(uniqueEmail);
        signupPage.clickSignup();
    }

    @And("I am on the account information page")
    public void iAmOnTheAccountInformationPage() {
        assertThat(signupPage.getDriver().getCurrentUrl(),
                is("https://automationexercise.com/signup"));
    }

    @When("I fill in valid account information")
    public void iFillInValidAccountInformation() {

        SignupForm form = new SignupForm(
                "Mrs",
                "Password123",
                "10",
                "May",
                "1995",
                "Jane",
                "Doe",
                "Amazon",
                "123 Testing Street",
                "",
                "Canada",
                "Ontario",
                "Toronto",
                "A1B 2C3",
                "07123456789"
        );

        registrationPage.fillForm(form);
    }

    @And("I click Create Account")
    public void iClickCreateAccount() {
        registrationPage.clickCreateAccount();
    }

    @Then("I should be taken to the Account Created confirmation page")
    public void iShouldSeeAccountCreatedPage() {
        assertThat(registrationPage.getDriver().getCurrentUrl(),
                is("https://automationexercise.com/account_created"));
    }

    @When("I fill in the account information leaving {string} blank")
    public void iFillFormLeavingFieldBlank(String field) {

        SignupForm base = FormModifier.validForm();
        SignupForm modified = FormModifier.blankField(base, field);

        registrationPage.fillFormLeavingFieldBlank(field, modified);
    }

    @When("I enter invalid value {string} into account field {string}")
    public void iEnterInvalidValueIntoAccountField(String value, String field) {

        SignupForm base = FormModifier.validForm();
        SignupForm modified = FormModifier.overrideField(base, field, value);

        registrationPage.fillForm(modified);
    }

    @Then("I should remain on the account information page")
    public void iShouldRemainOnAccountInfoPage() {
        assertThat(registrationPage.isStillOnRegistrationPage(), is(true));
    }
}