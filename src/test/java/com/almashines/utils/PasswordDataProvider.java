package com.almashines.utils;

import org.testng.annotations.DataProvider;

public class PasswordDataProvider {

    @DataProvider(name = "invalidPasswords")
    public Object[][] invalidPasswords() {

        return new Object[][] {

                { "123" },
                { "abc" },
                { "test" },
                { "1234567" },
                { "pass12" },
                { "abcdefg" }
        };
    }
}