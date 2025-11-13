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

    public String getCartQuantity() {
        return cartQuantity.getText();
    }

    public String emptyCartMessage() {
        return textCenter.getText();
    }

    public void cartQuantityDelete() {
        cartQuantityDelete.click();
    }

    public void automationExercisePopup() {
        getDriver().get("https://automationexercise.com/");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Try to find the consent button without throwing if it is not there
        List<WebElement> consentButtons =
                getDriver().findElements(By.cssSelector("button.fc-cta-consent"));

        if (!consentButtons.isEmpty() && consentButtons.get(0).isDisplayed()) {
            consentButtons.get(0).click();
            System.out.println("Consent popup appeared – clicked Accept.");

            // Optional: wait until popup disappears
            wait.until(ExpectedConditions.invisibilityOf(consentButtons.get(0)));
        } else {
            System.out.println("Consent popup not present – continuing normally.");
        }

    }


}
