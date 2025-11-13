package com.sparta.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage  extends PageObject {
    @FindBy(className = "check_out")
    private WebElementFacade checkoutButton;

    public void clickCheckout() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
        checkoutButton.click();
    }



}
