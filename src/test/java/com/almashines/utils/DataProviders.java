package com.almashines.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "invalidEmails")
    public Object[][] invalidEmails() {

        return new Object[][] {

                { "abc" },
                { "abc@" },
                { "abc.com" },
                { "@gmail.com" },
                { "test@@gmail.com" },
                { "test#gmail.com" },
                { "test gmail@gmail.com" },
                { "test..user@gmail.com" },
                { "test@gmail..com" }
        };
    }
}