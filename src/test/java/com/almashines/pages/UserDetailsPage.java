package com.almashines.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.almashines.utils.WaitUtils;

public class UserDetailsPage {

    private WaitUtils wait;

    public UserDetailsPage(WebDriver driver) {
        this.wait = new WaitUtils(driver);
    }

    private final By firstNameTxt = By.id("fname");
    private final By lastNameTxt = By.id("lname");
    private final By passwordTxt = By.id("password");
    private final By confirmPasswordTxt = By.id("re-password");
    private final By signUpBtn = By.xpath("//span[text()='Sign Up']/parent::button");

    private void enterText(By locator, String value) {

        WebElement element = wait.waitForVisibility(locator);

        element.clear();
        element.sendKeys(value);
    }

    public void enterFirstName(String firstName) {
        enterText(firstNameTxt, firstName);
    }

    public void enterLastName(String lastName) {
        enterText(lastNameTxt, lastName);
    }

    public void enterPassword(String password) {
        enterText(passwordTxt, password);
    }

    public void enterConfirmPassword(String password) {
        enterText(confirmPasswordTxt, password);
    }

    public void clickSignUp() {
        wait.waitForClickable(signUpBtn).click();
    }

    public boolean isSignUpButtonDisplayed() {
        return wait.waitForVisibility(signUpBtn).isDisplayed();
    }
}