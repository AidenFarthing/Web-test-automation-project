package com.sparta.pages;

import com.sparta.utils.SignupForm;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegistrationPage extends PageObject {

    @FindBy(id = "id_gender1") WebElementFacade titleMr;
    @FindBy(id = "id_gender2") WebElementFacade titleMrs;

    @FindBy(id = "password") WebElementFacade password;
    @FindBy(id = "days") WebElementFacade dayDropdown;
    @FindBy(id = "months") WebElementFacade monthDropdown;
    @FindBy(id = "years") WebElementFacade yearDropdown;

    @FindBy(id = "first_name") WebElementFacade firstName;
    @FindBy(id = "last_name") WebElementFacade lastName;
    @FindBy(id = "company") WebElementFacade company;
    @FindBy(id = "address1") WebElementFacade address;
    @FindBy(id = "address2") WebElementFacade address2;

    @FindBy(id = "country") WebElementFacade country;
    @FindBy(id = "state") WebElementFacade state;
    @FindBy(id = "city") WebElementFacade city;
    @FindBy(id = "zipcode") WebElementFacade zipcode;
    @FindBy(id = "mobile_number") WebElementFacade mobileNumber;

    @FindBy(css = "button[data-qa='create-account']")
    WebElementFacade createAccountButton;


    // ------------------------------------------------------------------
    // FILL FORM (VALID FLOW)
    // ------------------------------------------------------------------
    public void fillForm(SignupForm f) {

        nukeAds();  // Single nuke at start

        // Title
        if (f.title().equalsIgnoreCase("Mr")) titleMr.click();
        else titleMrs.click();

        // Text fields (safe — ads don't block these)
        password.type(f.password());
        firstName.type(f.firstName());
        lastName.type(f.lastName());
        company.type(f.company());
        address.type(f.address());
        address2.type(f.address2());
        state.type(f.state());
        city.type(f.city());
        zipcode.type(f.zipcode());
        mobileNumber.type(f.mobileNumber());

        // DROPDOWNS — ads always block these so clean each time
        nukeAds(); dayDropdown.selectByVisibleText(f.day());
        nukeAds(); monthDropdown.selectByVisibleText(f.month());
        nukeAds(); yearDropdown.selectByVisibleText(f.year());
        nukeAds(); country.selectByVisibleText(f.country());
    }


    // ------------------------------------------------------------------
    // FILL FORM (BLANK FIELD FLOW)
    // ------------------------------------------------------------------
    public void fillFormLeavingFieldBlank(String field, SignupForm f) {

        nukeAds();

        switch (field) {
            case "Password" -> password.clear();
            case "Address" -> address.clear();
            case "Country" -> {} // leave unselected
            case "State" -> state.clear();
            case "City" -> city.clear();
            case "Zipcode" -> zipcode.clear();
            case "MobileNumber" -> mobileNumber.clear();
            default -> throw new IllegalArgumentException("Unknown field: " + field);
        }

        // Safe text fields
        if (!field.equals("Password")) password.type(f.password());
        if (!field.equals("Address")) address.type(f.address());
        if (!field.equals("State"))   state.type(f.state());
        if (!field.equals("City"))    city.type(f.city());
        if (!field.equals("Zipcode")) zipcode.type(f.zipcode());
        if (!field.equals("MobileNumber")) mobileNumber.type(f.mobileNumber());

        // Title
        titleMr.click();

        // DROPDOWNS MUST BE SAFE
        nukeAds(); dayDropdown.selectByVisibleText(f.day());
        nukeAds(); monthDropdown.selectByVisibleText(f.month());
        nukeAds(); yearDropdown.selectByVisibleText(f.year());

        if (!field.equals("Country")) {
            nukeAds(); country.selectByVisibleText(f.country());
        }

        // Not required in form validation
        firstName.type(f.firstName());
        lastName.type(f.lastName());
        company.type(f.company());
        address2.type(f.address2());
    }


    // ------------------------------------------------------------------
    // HELPERS
    // ------------------------------------------------------------------
    public void clickCreateAccount() {
        nukeAds(); // ads appear right before clicking
        createAccountButton.click();
    }

    public boolean isStillOnRegistrationPage() {
        return password.isVisible() && firstName.isVisible();
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
}