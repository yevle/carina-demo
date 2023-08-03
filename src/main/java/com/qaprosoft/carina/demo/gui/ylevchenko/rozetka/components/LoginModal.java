package com.qaprosoft.carina.demo.gui.ylevchenko.rozetka.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.ylevchenko.rozetka.IConstants;
import com.qaprosoft.carina.demo.gui.ylevchenko.rozetka.pages.HomePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginModal extends AbstractUIObject implements IConstants {

    @FindBy(xpath = "//input[@id='auth_email']")
    private ExtendedWebElement inputEmailLogin;

    @FindBy(xpath = "//input[@id='auth_pass']")
    private ExtendedWebElement inputPasswordLogin;

    @FindBy(xpath = "//input[@id='remember_me']")
    private ExtendedWebElement checkboxRememberMe;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    private ExtendedWebElement checkboxCaptcha;

    @FindBy(xpath = "//button[contains(@class,'auth-modal__submit')]")
    private ExtendedWebElement buttonLogin;

    public LoginModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage login() {
        inputEmailLogin.type(LOGIN, TIMEOUT_FIVE);
        inputPasswordLogin.type(PASSWORD, TIMEOUT_FIVE);
        if (!checkboxRememberMe.isChecked()) {
            checkboxRememberMe.check();
        }
        buttonLogin.click();
//        if (checkboxCaptcha.isElementPresent(TIMEOUT_FIVE)) {
//            try {
//                driver.wait(15L);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            checkboxCaptcha.click();
//            try {
//                driver.wait(15L);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            buttonLogin.click();
//        }
        try {
            Thread.sleep(90000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        buttonLogin.click();
        return new HomePage(getDriver());
    }

}
