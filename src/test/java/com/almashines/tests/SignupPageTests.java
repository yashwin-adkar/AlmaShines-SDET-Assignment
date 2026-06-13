package com.almashines.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.almashines.base.BaseTest;
import com.almashines.pages.SignupPage;
import com.almashines.utils.DataProviders;
import com.almashines.utils.TestDataGenerator;

public class SignupPageTests extends BaseTest {

        private SignupPage signupPage;

        @BeforeMethod
        public void initializePage() {
                signupPage = new SignupPage(driver);
        }

        @Test(description = "Verify email field is displayed")
        public void verifyEmailFieldDisplayed() {

                Assert.assertTrue(
                                signupPage.isEmailDisplayed(),
                                "Email field not displayed");
        }

        @Test(description = "Verify next button is displayed")
        public void verifyNextButtonDisplayed() {

                Assert.assertTrue(
                                signupPage.isNextButtonDisplayed(),
                                "Next button not displayed");
        }

        @Test(description = "Verify email field accepts valid email")
        public void verifyValidEmail() {

                String email = TestDataGenerator.generateEmail();

                signupPage.enterEmail(email);

                Assert.assertEquals(
                                signupPage.getEmailValue(),
                                email,
                                "Email mismatch");
        }

        @Test(description = "Verify blank email validation")
        public void verifyBlankEmail() {

                signupPage.clickNext();

                Assert.assertTrue(
                                signupPage.getEmailFieldClass().contains("ng-invalid"),
                                "Email field should be invalid for blank input");
        }

        @Test(description = "Verify invalid email formats", dataProvider = "invalidEmails", dataProviderClass = DataProviders.class)
        public void verifyInvalidEmails(String email) {

                signupPage.enterEmail(email);

                signupPage.clickNext();

                Assert.assertEquals(
                                signupPage.getEmailValidationMessage(),
                                "Please enter a valid E-mail Address",
                                "Validation message mismatch");
        }

        @Test(description = "Verify email field accepts uppercase email")
        public void verifyUpperCaseEmail() {

                String email = "TESTUSER@GMAIL.COM";

                signupPage.enterEmail(email);

                Assert.assertEquals(
                                signupPage.getEmailValue(),
                                email,
                                "Uppercase email not accepted");
        }
}