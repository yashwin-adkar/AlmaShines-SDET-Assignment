package com.almashines.utils;

import org.testng.annotations.DataProvider;

public class UserDetailsDataProvider {

    @DataProvider(name = "invalidPasswords")
    public Object[][] invalidPasswords() {

        return new Object[][] {

                { "123" }, // too short
                { "abcd" }, // only lowercase
                { "abcdefg" }, // no uppercase, no number
                { "1234567" }, // only numbers
                { "pass123" }, // no uppercase, no special char
                { "weakpwd" }, // only lowercase
                { "Password" }, // no number, no special char
                { "Password123" } // no special char
        };
    }

    @DataProvider(name = "mismatchPasswords")
    public Object[][] mismatchPasswords() {

        return new Object[][] {

                { "Test@123", "Test@456" },
                { "Admin@123", "Admin@999" }
        };
    }
}
