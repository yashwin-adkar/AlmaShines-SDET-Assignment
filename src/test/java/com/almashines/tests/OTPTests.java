package com.almashines.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.almashines.base.BaseTest;
import com.almashines.pages.OTPPage;
import com.almashines.pages.SignupPage;
import com.almashines.pages.UserDetailsPage;
import com.almashines.utils.OTPDataProvider;
import com.almashines.utils.TestDataGenerator;

public class OTPTests extends BaseTest {
        private OTPPage otpPage;

        @BeforeMethod
        public void navigateToOTPPage() {

                SignupPage signupPage = new SignupPage(driver);

                String email = TestDataGenerator.generateEmail();

                signupPage.enterEmail(email);
                signupPage.clickNext();

                UserDetailsPage userDetailsPage = new UserDetailsPage(driver);

                userDetailsPage.enterFirstName(
                                TestDataGenerator.generateFirstName());

                userDetailsPage.enterLastName(
                                TestDataGenerator.generateLastName());

                String password = TestDataGenerator.generatePassword();

                userDetailsPage.enterPassword(password);
                userDetailsPage.enterConfirmPassword(password);

                userDetailsPage.clickSignUp();

                otpPage = new OTPPage(driver);
        }

        @Test(description = "Verify OTP page is displayed")
        public void verifyOTPPageDisplayed() {

                Assert.assertTrue(
                                otpPage.isOTPPageDisplayed(),
                                "OTP page is not displayed");
        }

        @Test(description = "Verify validation message for blank OTP")
        public void verifyBlankOTP() {

                otpPage.clickVerify();

                Assert.assertEquals(
                                otpPage.getPopupMessage(),
                                "Please enter OTP code",
                                "Incorrect validation message displayed");

                otpPage.clickPopupOK();
        }

        @Test(description = "Verify invalid OTP formats", dataProvider = "invalidOtps", dataProviderClass = OTPDataProvider.class)
        public void verifyInvalidOTP(String otp) {

                otpPage.enterOTP(otp);

                otpPage.clickVerify();

                Assert.assertFalse(
                                otpPage.getPopupMessage().isEmpty(),
                                "Validation message not displayed");

                otpPage.clickPopupOK();
        }

        @Test(description = "Verify resend OTP functionality")
        public void verifyOTPResendLimit() {

                otpPage.clickResendOTP();

                String message = otpPage.getPopupMessage();

                Assert.assertTrue(
                                message.contains("OTP"),
                                "Unexpected resend OTP response");

                otpPage.clickPopupOK();
        }

}
