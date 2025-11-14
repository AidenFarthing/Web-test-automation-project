package com.sparta.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

@DefaultUrl("https://automationexercise.com/login")
public class SignupPage extends PageObject {

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElementFacade signupName;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElementFacade signupEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElementFacade signupButton;

    @FindBy(css = "p[style='color: red;']")
    private WebElementFacade duplicateEmailError;

    public void enterName(String name) {
        nukeAds();
        signupName.type(name);
    }

    public void enterEmail(String email) {
        nukeAds();
        signupEmail.type(email);
    }

    public void clickSignup() {
        nukeAds();
        signupButton.click();
    }

    public boolean isStillOnSignupPage() {
        return signupName.isVisible() && signupEmail.isVisible();
    }

    public boolean isDuplicateEmailErrorVisible() {
        return duplicateEmailError.isVisible()
                && duplicateEmailError.getText().contains("already exist");
    }

    public String generateUniqueEmail() {
        return "user_" + System.currentTimeMillis() + "@mail.com";
    }
    public void nukeAds() {
        try {
            evaluateJavascript("""
            document.querySelectorAll(
                'iframe, .adsbygoogle, [id^="aswift_"], [id^="google_ads"], [id^="google"], .grippy-host'
            ).forEach(el => el.remove());
        """);
        } catch (Exception ignored) {}
    }

    public void dismissPopups() {

        nukeAds();

        try {
            List<WebElementFacade> popups = findAll(
                    By.cssSelector(".fc-consent-root, #onetrust-banner-sdk, .cookie-banner")
            );

            if (popups.isEmpty()) return;   // No banners → done

            WebElementFacade popup = popups.get(0);
            if (!popup.isDisplayed()) return;

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
            try {
                if (btn.isVisible() && btn.isClickable()) {
                    btn.click();
                } else {
                    evaluateJavascript("arguments[0].click();", btn);
                }
            } catch (Exception ignore) {
                evaluateJavascript("arguments[0].click();", btn);
            }

            withTimeoutOf(Duration.ofSeconds(5))
                    .waitFor(ExpectedConditions.invisibilityOf(btn));

        } catch (Exception ignored) {

        }

    }
}