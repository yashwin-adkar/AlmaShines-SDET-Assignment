package com.almashines.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.almashines.base.BaseTest;
import com.almashines.pages.SignupPage;
import com.almashines.utils.ExistingUserDataProvider;

public class ExistingUserTests extends BaseTest {

        @Test(description = "Verify existing user is redirected to login page", dataProvider = "existingEmails", dataProviderClass = ExistingUserDataProvider.class)
        public void verifyExistingUser(String email) {

                SignupPage signupPage = new SignupPage(driver);

                signupPage.enterEmail(email);

                signupPage.clickNext();

                Assert.assertTrue(
                                signupPage.isLoginPageDisplayed(),
                                "Existing user was not redirected to login page");
        }
}