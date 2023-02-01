package ylevchenko.carina.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import ylevchenko.carina.enums.Gender;
import ylevchenko.carina.mobile.gui.common.LoginPageBase;
import ylevchenko.carina.mobile.gui.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    @FindBy(id = "name")
    private ExtendedWebElement nameInputField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInputField;

    @FindBy(id = "radio_%s")
    private ExtendedWebElement genderRadioBtn;

    @FindBy(id = "radio_male")
    private ExtendedWebElement maleRadioBtn;

    @FindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(id = "login_button")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase typeName(String name) {
        nameInputField.type(name);
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public LoginPageBase typePassword(String password) {
        passwordInputField.type(password);
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public LoginPageBase selectGender(Gender gender) {
        genderRadioBtn.format(gender.getIdName()).check();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public LoginPageBase checkPrivacyPolicyCheckbox() {
        privacyPolicyCheckbox.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public WebViewPageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }

    @Override
    public boolean isLoginBtnActive() {
        return loginBtn.isClickable(3);
    }

    @Override
    public boolean isNameFieldHasText() {
        return nameInputField.isElementWithTextPresent("Name", 2);
    }

    @Override
    public boolean isPasswordFieldHasText() {
        return passwordInputField.isElementWithTextPresent("Password", 2);
    }

    @Override
    public boolean isGenderFieldHasTextAndUnchecked(Gender gender) {
        return genderRadioBtn.format(gender.getIdName()).isElementWithTextPresent(gender.getText(), 2) && !genderRadioBtn.format(gender.getIdName()).isChecked();
    }

    @Override
    public boolean isPrivacyPolicyHasTextAndUnchecked() {
        return privacyPolicyCheckbox.isElementWithTextPresent("I agree to the Privacy Policy", 2) && !privacyPolicyCheckbox.isChecked();
    }

    @Override
    public WebViewPageBase login() {
        loginBtn.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }

}
