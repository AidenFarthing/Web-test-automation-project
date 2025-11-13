package com.sparta.pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://automationexercise.com/products")


public class InventoryPage extends PageObject {

    @FindBy(className = "col-sm-4")
    private List<WebElementFacade> inventoryItems;


}
