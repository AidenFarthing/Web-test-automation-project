package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class SignupPage  extends PageObject {

    @FindBy(className = "name")
    private WebElementFacade signupName;

    @FindBy(className = "email")
    private WebElementFacade signupEmail;

    @FindBy(className = "btn")
    private WebElementFacade submit;


    public void enterName(String name) {
        signupName.type(name);
    }

    public void enterEmail(String email) {
        signupEmail.type(email);
    }

    public void submitFirstForm() {
        submit.click();
    }




}
