package com.almashines.utils;

import org.testng.annotations.DataProvider;

public class ExistingUserDataProvider {

    @DataProvider(name = "existingEmails")
    public Object[][] existingEmails() {

        return new Object[][] {
                {
                        ConfigReader.getProperty(
                                "existing.user.email")
                }
        };
    }
}