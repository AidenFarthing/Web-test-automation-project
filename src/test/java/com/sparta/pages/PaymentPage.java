package com.sparta.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageObject {
    @FindBy(name = "name_on_card")
    private WebElementFacade nameOnCard;

    @FindBy(className = "card-number")
    private WebElementFacade cardNumber;

    @FindBy(className = "card-cvc")
    private WebElementFacade cvc;

    @FindBy(className = "card-expiry-month")
    private WebElementFacade cardExpiryMonth;

    @FindBy(className = "card-expiry-year")
    private WebElementFacade cardExpiryYear;

    @FindBy(id = "submit")
    private WebElementFacade submit;

    @FindBy(className = "text-center")
    private WebElementFacade message;

    public void enterNameOnCard(String name) {
        nameOnCard.type(name);
    }

    public void enterCardNumber(String number) {
        cardNumber.type(number);
    }

    public void enterCVC(String cvcType) {
        cvc.type(cvcType);
    }

    public void enterCardExpiryMonth(String month) {
        cardExpiryMonth.type(month);
    }

    public void enterCardExpiryYear(String year) {
        cardExpiryYear.type(year);
    }

    public void submit() {
        submit.click();
    }

    public String getOrderPlacedMessage() {
        return message.getText();
    }
}
