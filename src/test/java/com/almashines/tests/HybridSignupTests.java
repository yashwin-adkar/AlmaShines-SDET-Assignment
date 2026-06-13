package com.almashines.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.almashines.base.BaseTest;
import com.almashines.pages.OTPPage;
import com.almashines.pages.RoleDetailsPage;
import com.almashines.pages.SignupPage;
import com.almashines.pages.UserDetailsPage;
import com.almashines.utils.ConfigReader;
import com.almashines.utils.RoleDataProvider;
import com.almashines.utils.TestDataGenerator;

public class HybridSignupTests extends BaseTest {

        @Test(dataProvider = "validRoleData", dataProviderClass = RoleDataProvider.class)
        public void verifyEndToEndSignupHybrid(
                        String role,
                        String joiningYear,
                        String graduationYear) {

                SignupPage signupPage = new SignupPage(driver);

                signupPage.enterEmail(
                                ConfigReader.getProperty(
                                                "signup.user.email"));

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

                OTPPage otpPage = new OTPPage(driver);

                Assert.assertTrue(
                                otpPage.isOTPPageDisplayed(),
                                "OTP Page not displayed");

                System.out.println(
                                "===================================");

                System.out.println(
                                "ENTER VALID OTP MANUALLY");

                System.out.println(
                                "CLICK VERIFY");

                System.out.println(
                                "AUTOMATION IS WAITING FOR ROLE PAGE");

                System.out.println(
                                "===================================");

                RoleDetailsPage rolePage = new RoleDetailsPage(driver);

                rolePage.waitForRolePage();

                rolePage.selectRole(role);

                rolePage.selectJoiningYear(
                                joiningYear);

                rolePage.selectGraduationYear(
                                graduationYear);

                rolePage.acceptTerms();

                rolePage.acceptConsent();

                rolePage.clickJoinNetwork();

                System.out.println(
                                "HYBRID FLOW COMPLETED");
        }
}