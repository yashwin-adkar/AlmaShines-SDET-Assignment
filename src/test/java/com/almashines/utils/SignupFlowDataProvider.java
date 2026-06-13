package com.almashines.utils;

import org.testng.annotations.DataProvider;

public class SignupFlowDataProvider {

    @DataProvider(name = "signupEmails")
    public Object[][] signupEmails() {

        return new Object[][]{
                {
                        ConfigReader.getProperty(
                                "signup.user.email")
                }
        };
    }
}