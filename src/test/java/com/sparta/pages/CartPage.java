package com.sparta.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage  extends PageObject {

    @FindBy(className = "cart_quantity")
    private WebElementFacade cartQuantity;

    @FindBy(className = "cart_quantity_delete")
    private WebElementFacade cartQuantityDelete;

    @FindBy(className = "text-center")
    private WebElementFacade textCenter;

    @FindBy(css = ".check_out")
    private WebElementFacade toCheckout;

    public String getCartQuantity() {
        return cartQuantity.getText();
    }

    public String emptyCartMessage() {
        return textCenter.getText();
    }

    public void cartQuantityDelete() {
        cartQuantityDelete.click();
    }

    public void proceedToCheckout() {
        toCheckout.click();
    }
}
