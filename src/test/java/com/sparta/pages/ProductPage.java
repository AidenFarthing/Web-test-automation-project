package com.sparta.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class ProductPage  extends PageObject {

    @FindBy(className = "btn")
    private WebElementFacade addToCartButton;

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

}
