package com.almashines.utils;

import org.testng.annotations.DataProvider;

public class OTPDataProvider {

    @DataProvider(name = "invalidOtps")
    public Object[][] invalidOtps() {

        return new Object[][] {
                { "111111" },
                { "abc123" },
                { "123" }
        };
    }
}