package com.almashines.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.almashines.base.BaseTest;
import com.almashines.pages.SignupPage;
import com.almashines.utils.ExistingUserDataProvider;

public class ExistingUserTests extends BaseTest {

        @Test(description = "Verify existing user is redirected to login flow", dataProvider = "existingEmails", dataProviderClass = ExistingUserDataProvider.class)
        public void verifyExistingUser(String email) {

                SignupPage signupPage = new SignupPage(driver);

                signupPage.enterEmail(email);

                signupPage.clickNext();

                Assert.assertTrue(
                                driver.getCurrentUrl().toLowerCase().contains("login")
                                                || driver.getPageSource().contains("Login"),
                                "Existing user flow not triggered");
        }

}
