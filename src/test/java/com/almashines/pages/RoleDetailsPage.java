package com.almashines.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.almashines.utils.WaitUtils;

public class RoleDetailsPage {

        private WaitUtils wait;

        public RoleDetailsPage(WebDriver driver) {

                this.wait = new WaitUtils(driver);
        }

        private final By roleDropdown = By.name("role");
        private final By joiningYearDropdown = By.name("yoj");
        private final By graduationYearDropdown = By.name("yop");

        private final By joinButton = By.id("btn3_sgnup");

        private final By termsCheckbox = By.xpath("//label[@for='privacy-terms']");
        private final By consentCheckbox = By.xpath("//label[@for='consent-form']");

        private void selectDropdown(By locator, String value) {

                Select select = new Select(
                                wait.waitForVisibility(locator));

                select.selectByVisibleText(value);
        }

        public void selectRole(String role) {
                selectDropdown(roleDropdown, role);
        }

        public void selectJoiningYear(String year) {
                selectDropdown(joiningYearDropdown, year);
        }

        public void selectGraduationYear(String year) {
                selectDropdown(graduationYearDropdown, year);
        }

        public void clickJoinNetwork() {
                wait.waitForClickable(joinButton).click();
        }

        public void acceptTerms() {
                wait.waitForClickable(termsCheckbox).click();
        }

        public void acceptConsent() {
                wait.waitForClickable(consentCheckbox).click();
        }

        public void waitForRolePage() {
                wait.waitForVisibility(joinButton);
        }
}