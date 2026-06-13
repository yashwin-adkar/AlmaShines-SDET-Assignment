package com.almashines.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.almashines.utils.WaitUtils;

public class OTPPage {

    private WaitUtils wait;

    public OTPPage(WebDriver driver) {

        this.wait = new WaitUtils(driver);
    }

    private final By otpTxt = By.id("otp_input");
    private final By verifyBtn = By.xpath("//span[text()='Verify']/parent::button");
    private final By resendOtp = By.xpath("//a[contains(text(),'Resend OTP')]");
    private final By popupMessage = By.cssSelector("div.swal-text");
    private final By okBtn = By.cssSelector("button.swal-button--confirm");
    private final By backBtn = By.xpath("//button[contains(text(),'BACK')]");

    public void enterOTP(String otp) {

        var otpField = wait.waitForVisibility(otpTxt);

        otpField.clear();
        otpField.sendKeys(otp);
    }

    public void clickVerify() {

        wait.waitForClickable(verifyBtn).click();
    }

    public void clickResendOTP() {

        wait.waitForClickable(resendOtp).click();
    }

    public String getPopupMessage() {

        return wait.waitForVisibility(popupMessage).getText();
    }

    public void clickPopupOK() {

        wait.waitForClickable(okBtn).click();
    }

    public boolean isOTPPageDisplayed() {

        return wait.waitForVisibility(otpTxt).isDisplayed();
    }

    public boolean isBackButtonDisplayed() {

        return wait.waitForVisibility(backBtn).isDisplayed();
    }
}