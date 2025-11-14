package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


@DefaultUrl("https://automationexercise.com/")
public class HomePage extends PageObject {
    static {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
    }

    // Navigation Link
    @FindBy(css = "a[href='/']")
    private WebElementFacade homeLink;

    @FindBy(css = "a[href='/products']")
    private WebElementFacade InventoryLink;

    @FindBy(css = "a[href='/view_cart']")
    private WebElementFacade cartLink;

    @FindBy(css = "a[href='/login']")
    private WebElementFacade loginLink;

    @FindBy(css = "a[href='/contact_us']")
    private WebElementFacade contactUsLink;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElementFacade productLink;
    // Main
    @FindBy(css = "#slider .carousel-inner")
    private WebElementFacade slider;

    @FindBy(css = ".features_items")
    private WebElementFacade featuredItemsSection;

    public void openHomePage() {
        this.open();        // Call Serenity's built-in final method
        dismissPopups();
    }

    /** Navigate to the Products page */
    public void viewProduct() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", productLink);
        productLink.click();
    }

    public void openInventory() {
        InventoryLink.click();
    }

    public void openCart() {
        cartLink.click();
    }

    public void openLogin() {
        loginLink.click();
    }

    public void openContactUs() {
        contactUsLink.click();
    }
    public void dismissPopups() {

        // REMOVE GOOGLE ADS IFRAMES
        try {
            getDriver().findElements(By.cssSelector("iframe[id^='aswift_']")).forEach(f -> {
                try { evaluateJavascript("arguments[0].remove();", f); } catch (Exception ignored) {}
            });
        } catch (Exception ignored) {}

        // REMOVE GOOGLE ADS HOST DIVS
        try {
            getDriver().findElements(By.cssSelector("div[id^='aswift_'][id$='_host']")).forEach(d -> {
                try { evaluateJavascript("arguments[0].remove();", d); } catch (Exception ignored) {}
            });
        } catch (Exception ignored) {}

        // DISMISS CONSENT POPUP
        try {
            WebElementFacade popup = find(By.cssSelector(".fc-consent-root"));
            if (popup.isVisible()) {
                try {
                    WebElementFacade btn = popup.find(By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button"));
                    if (btn.isVisible() && btn.isClickable()) btn.click();
                    else evaluateJavascript("arguments[0].click();", btn);
                } catch (Exception ignored) {}
                try { evaluateJavascript("arguments[0].remove();", popup); } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}
    }


    //visibility tests

    public boolean isHomePageLoaded() {
        return slider.isVisible() && featuredItemsSection.isVisible();
    }

    public boolean isNavigationVisible() {
        return homeLink.isVisible() &&
                productLink.isVisible() &&
                cartLink.isVisible() &&
                loginLink.isVisible() &&
                contactUsLink.isVisible();
    }

    public boolean isFeatureSectionVisible() {
        return featuredItemsSection.isVisible();
    }
}
