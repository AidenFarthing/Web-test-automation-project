package com.sparta.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.FindBy;

public class CartPage  extends PageObject {

    @FindBy(className = "cart_quantity")
    private WebElementFacade cartQuantity;

    @FindBy(className = "cart_quantity_delete")
    private WebElementFacade cartQuantityDelete;

    @FindBy(className = "text-center")
    private WebElementFacade textCenter;

    public String getCartQuantity() {
        return cartQuantity.getText();
    }

    public String emptyCartMessage() {
        return textCenter.getText();
    }

    public void cartQuantityDelete() {
        cartQuantityDelete.click();
    }


}
