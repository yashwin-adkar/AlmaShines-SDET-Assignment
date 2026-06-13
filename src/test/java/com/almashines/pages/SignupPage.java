package com.almashines.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.almashines.utils.WaitUtils;

public class SignupPage {

    private WebDriver driver;
    private WaitUtils wait;

    public SignupPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    private final By emailTxt = By.id("email");

    private final By nextBtn = By.id("emailBtn");

    private final By emailValidationMsg = By.cssSelector("span.mdl-textfield__error");

    public void enterEmail(String email) {

        var emailField = wait.waitForVisibility(emailTxt);

        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickNext() {

        wait.waitForClickable(nextBtn)
                .click();
    }

    public String getEmailValue() {

        return wait.waitForVisibility(emailTxt)
                .getAttribute("value");
    }

    public String getEmailValidationMessage() {

        return wait.waitForVisibility(
                emailValidationMsg)
                .getText()
                .trim();
    }

    public boolean isEmailDisplayed() {

        return wait.waitForVisibility(emailTxt)
                .isDisplayed();
    }

    public boolean isNextButtonDisplayed() {

        return wait.waitForClickable(nextBtn)
                .isDisplayed();
    }

    public String getRequiredValidationMessage() {

        return wait.waitForVisibility(emailTxt)
                .getAttribute("validationMessage");
    }

    public String getEmailFieldClass() {

        return wait.waitForVisibility(
                emailTxt)
                .getAttribute("class");
    }
}