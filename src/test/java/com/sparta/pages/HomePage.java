package com.sparta.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@DefaultUrl("https://automationexercise.com/")
public class HomePage extends PageObject {

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


    /** Navigate to the Products page */
    public void viewProduct() {
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
