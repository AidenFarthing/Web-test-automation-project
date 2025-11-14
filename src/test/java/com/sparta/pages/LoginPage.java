package com.sparta.pages;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

@DefaultUrl("https://automationexercise.com/login")
public class LoginPage extends PageObject {

    @FindBy(name = "email")
    private WebElementFacade emailField;

    @FindBy(name = "password")
    private WebElementFacade passwordField;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElementFacade loginButton;

    @FindBy(css = "p[style='color: red;']")
    private WebElementFacade errorMessage;

    @FindBy(className = "fa-home")
    private WebElementFacade home;

    public void enterEmail(String email) {
        emailField.type(email);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void dismissPopups() {

        try {
            // Look for ANY known cookie banner root container
            List<WebElementFacade> popups = findAll(
                    By.cssSelector(".fc-consent-root, #onetrust-banner-sdk, .cookie-banner")
            );

            if (popups.isEmpty()) return;   // No banners → done

            WebElementFacade popup = popups.get(0);
            if (!popup.isDisplayed()) return;

            // Try all common “accept” buttons
            List<WebElementFacade> buttons = popup.thenFindAll(
                    By.cssSelector(
                            "button.fc-cta-consent, " +
                                    "button.fc-button.fc-cta-consent.fc-primary-button, " +
                                    "#onetrust-accept-btn-handler, " +
                                    "button.accept-cookie"
                    )
            );

            if (buttons.isEmpty()) return;

            WebElementFacade btn = buttons.get(0);

            // Prefer standard click
            try {
                if (btn.isVisible() && btn.isClickable()) {
                    btn.click();
                } else {
                    evaluateJavascript("arguments[0].click();", btn);
                }
            } catch (Exception ignore) {
                // JS fallback
                evaluateJavascript("arguments[0].click();", btn);
            }

            // Optional wait until popup disappears
            withTimeoutOf(Duration.ofSeconds(5))
                    .waitFor(ExpectedConditions.invisibilityOf(btn));

        } catch (Exception ignored) {
            // Popup didn't exist — no problem
        }
    }

    public boolean isEmailRequired() {
        return emailField.getAttribute("required") != null;
    }

    public boolean isPasswordRequired() {
        return passwordField.getAttribute("required") != null;
    }

    public void clickHome() {
        home.click();
    }


}