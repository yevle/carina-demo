package ylevchenko.carina.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.lang3.RandomStringUtils;
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
    public LoginPageBase checkPrivacyPolicyCheckbox(boolean check) {
        if (check) {
            privacyPolicyCheckbox.check();
        } else {
            privacyPolicyCheckbox.uncheck();
        }
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public WebViewPageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }

    @Override
    public WebViewPageBase login() {
        String loginPass = RandomStringUtils.randomAlphanumeric(LOGIN_SYMBOL_COUNT);
        typeName(loginPass).typePassword(loginPass).selectGender(Gender.MALE).checkPrivacyPolicyCheckbox(true);
        return clickLoginBtn();
    }

    @Override
    public boolean isLoginBtnActive() {
        return loginBtn.isClickable(TIMEOUT_SHORT);
    }

    @Override
    public boolean isNameFieldHasText() {
        return nameInputField.isElementWithTextPresent(NAME_FIELD_TEXT, TIMEOUT_SHORT);
    }

    @Override
    public boolean isPasswordFieldHasText() {
        return passwordInputField.isElementWithTextPresent(PASSWORD_FIELD_TEXT, TIMEOUT_SHORT);
    }

    @Override
    public boolean isGenderFieldChecked(Gender gender) {
        return genderRadioBtn.format(gender.getIdName()).isChecked();
    }

    @Override
    public boolean isGenderFieldHasText(Gender gender) {
        return genderRadioBtn.format(gender.getIdName()).isElementWithTextPresent(gender.getText(), TIMEOUT_SHORT);
    }

    @Override
    public boolean isPrivacyPolicyChecked() {
        return privacyPolicyCheckbox.isChecked();
    }

}
