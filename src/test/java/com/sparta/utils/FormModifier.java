package com.sparta.utils;

public class FormModifier {

    // Create a fully valid form
    public static SignupForm validForm() {
        return new SignupForm(
                "Mrs",
                "Password123",
                "10",
                "May",
                "1995",
                "Jane",
                "Doe",
                "Amazon",
                "123 Testing Street",
                "",
                "Canada",
                "Ontario",
                "Toronto",
                "A1B 2C3",
                "07123456789"
        );
    }

    // Create form with ONE blank field
    public static SignupForm blankField(SignupForm f, String field) {

        return overrideField(f, field, "");
    }

    // Override any single field in the record
    public static SignupForm overrideField(SignupForm f, String field, String value) {

        return switch (field) {
            case "Title" -> new SignupForm(value, f.password(), f.day(), f.month(), f.year(),
                    f.firstName(), f.lastName(), f.company(), f.address(),
                    f.address2(), f.country(), f.state(), f.city(),
                    f.zipcode(), f.mobileNumber());

            case "Password" -> new SignupForm(f.title(), value, f.day(), f.month(), f.year(),
                    f.firstName(), f.lastName(), f.company(), f.address(),
                    f.address2(), f.country(), f.state(), f.city(),
                    f.zipcode(), f.mobileNumber());

            case "Address" -> new SignupForm(f.title(), f.password(), f.day(), f.month(), f.year(),
                    f.firstName(), f.lastName(), f.company(), value,
                    f.address2(), f.country(), f.state(), f.city(),
                    f.zipcode(), f.mobileNumber());

            case "Country" -> new SignupForm(f.title(), f.password(), f.day(), f.month(), f.year(),
                    f.firstName(), f.lastName(), f.company(), f.address(),
                    f.address2(), value, f.state(), f.city(),
                    f.zipcode(), f.mobileNumber());

            case "State" -> new SignupForm(f.title(), f.password(), f.day(), f.month(), f.year(),
                    f.firstName(), f.lastName(), f.company(), f.address(),
                    f.address2(), f.country(), value,
                    f.city(), f.zipcode(), f.mobileNumber());

            case "City" -> new SignupForm(f.title(), f.password(), f.day(), f.month(), f.year(),
                    f.firstName(), f.lastName(), f.company(), f.address(),
                    f.address2(), f.country(), f.state(), value,
                    f.zipcode(), f.mobileNumber());

            case "Zipcode" -> new SignupForm(f.title(), f.password(), f.day(), f.month(), f.year(),
                    f.firstName(), f.lastName(), f.company(), f.address(),
                    f.address2(), f.country(), f.state(), f.city(),
                    value, f.mobileNumber());

            case "MobileNumber" -> new SignupForm(f.title(), f.password(), f.day(), f.month(), f.year(),
                    f.firstName(), f.lastName(), f.company(), f.address(),
                    f.address2(), f.country(), f.state(), f.city(),
                    f.zipcode(), value);

            default -> f;
        };
    }
}