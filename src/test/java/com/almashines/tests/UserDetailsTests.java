package com.almashines.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.almashines.base.BaseTest;
import com.almashines.pages.OTPPage;
import com.almashines.pages.SignupPage;
import com.almashines.pages.UserDetailsPage;
import com.almashines.utils.TestDataGenerator;
import com.almashines.utils.UserDetailsDataProvider;

public class UserDetailsTests extends BaseTest {

        private UserDetailsPage page;

        @BeforeMethod
        public void navigateToUserDetailsPage() {

                SignupPage signupPage = new SignupPage(driver);

                signupPage.enterEmail(
                                TestDataGenerator.generateEmail());

                signupPage.clickNext();

                page = new UserDetailsPage(driver);
        }

        @Test(description = "Verify valid user details")
        public void verifyValidUserDetails() {

                page.enterFirstName(
                                TestDataGenerator.generateFirstName());

                page.enterLastName(
                                TestDataGenerator.generateLastName());

                String password = TestDataGenerator.generatePassword();

                page.enterPassword(password);
                page.enterConfirmPassword(password);

                page.clickSignUp();

                OTPPage otpPage = new OTPPage(driver);

                Assert.assertTrue(
                                otpPage.isOTPPageDisplayed(),
                                "OTP page was not displayed");
        }

        @Test(description = "Verify weak password validation", dataProvider = "invalidPasswords", dataProviderClass = UserDetailsDataProvider.class)
        public void verifyWeakPassword(String password) {

                page.enterFirstName(
                                TestDataGenerator.generateFirstName());

                page.enterLastName(
                                TestDataGenerator.generateLastName());

                page.enterPassword(password);
                page.enterConfirmPassword(password);

                page.clickSignUp();

                Assert.assertTrue(
                                page.isSignUpButtonDisplayed(),
                                "User should remain on User Details page");
        }

        @Test(description = "Verify password mismatch validation", dataProvider = "mismatchPasswords", dataProviderClass = UserDetailsDataProvider.class)
        public void verifyPasswordMismatch(
                        String password,
                        String confirmPassword) {

                page.enterFirstName(
                                TestDataGenerator.generateFirstName());

                page.enterLastName(
                                TestDataGenerator.generateLastName());

                page.enterPassword(password);
                page.enterConfirmPassword(confirmPassword);

                page.clickSignUp();

                Assert.assertTrue(
                                page.isSignUpButtonDisplayed(),
                                "User should remain on User Details page");
        }
}