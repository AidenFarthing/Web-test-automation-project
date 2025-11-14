package com.sparta.pages;

import net.serenitybdd.core.pages.ClickStrategy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

@DefaultUrl("https://automationexercise.com/products")


public class InventoryPage extends PageObject {

    @FindBy(className = "single-products")
    private List<WebElementFacade> inventoryItems;

    @FindBy(css=".panel:nth-child(1) > .panel-heading a")
    private WebElementFacade womensFliter;

    @FindBy(css="#Women li:nth-child(1) > a")
    private WebElementFacade dressFliter;

    @FindBy(id="search_product")
    private WebElementFacade searchField;

    @FindBy(id="submit_search")
    private WebElementFacade searchButton;

    @FindBy (css= ".panel:nth-child(2) > .panel-heading a")
    private WebElementFacade menFilter;

    @FindBy(css="#Men li:nth-child(1) > a")
    private WebElementFacade tshirtFliter;




    public void setMenFilter(){
        menFilter.click();
    }
    public void setTshirtFliter(){
        tshirtFliter.click();
    }

    public void clickSearchField(){
        searchField.type("frozen tops for kids");
    }
    public void clickSearchbutton(){
        searchButton.click();
    }
    public void clickSearchFieldwithemptystring(){
        searchField.type("");
    }

    public int getInventory(){
        return inventoryItems.size();
    }

    public void setWomenFliter(){
        womensFliter.click();
    }

    public void setDressFliter(){
        dressFliter.click();
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




}
