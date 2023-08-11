package ylevchenko.carina.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.ClassChain;
import com.zebrunner.carina.webdriver.decorator.annotations.Predicate;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.carina.enums.Gender;
import ylevchenko.carina.mobile.gui.common.LoginPageBase;
import ylevchenko.carina.mobile.gui.common.WebViewPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "type = 'XCUIElementTypeTextField'")
    @Predicate
    private ExtendedWebElement nameInputField;

    @FindBy(xpath = "type = 'XCUIElementTypeSecureTextField'")
    @Predicate
    private ExtendedWebElement passwordInputField;

    @FindBy(xpath = "**/XCUIElementTypeStaticText[`label == '%s'`]")
    @ClassChain
    private ExtendedWebElement genderRadioBtn;

    @FindBy(xpath = "**/XCUIElementTypeButton[`name CONTAINS 'checkbox'`]")
    @ClassChain
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(xpath = "name = 'LOGIN'")
    @Predicate
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase typeName(String name) {
        nameInputField.type(name, TIMEOUT_SHORT);
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public LoginPageBase typePassword(String password) {
        passwordInputField.type(password, TIMEOUT_SHORT);
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public LoginPageBase selectGender(Gender gender) {
        genderRadioBtn.format(gender.getText()).click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public LoginPageBase checkPrivacyPolicyCheckbox(boolean check) {
        privacyPolicyCheckbox.click();
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
        throw new NotImplementedException();
    }

    @Override
    public boolean isPasswordFieldHasText() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isGenderFieldChecked(Gender gender) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isGenderFieldHasText(Gender gender) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPrivacyPolicyChecked() {
        throw new NotImplementedException();
    }

}
