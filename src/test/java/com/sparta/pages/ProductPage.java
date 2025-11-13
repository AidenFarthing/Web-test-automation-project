package com.sparta.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class ProductPage  extends PageObject {

    @FindBy(className = "cart")
    private WebElementFacade addToCartButton;

    @FindBy(className = "fa-shopping-cart")
    private WebElementFacade cart;

    @FindBy(className = "btn-success")
    private WebElementFacade continueShopping;

    public void clickContinueShopping() {
        continueShopping.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnCart() {
        cart.click();
    }

}
