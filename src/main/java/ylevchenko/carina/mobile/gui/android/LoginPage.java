package ylevchenko.carina.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import ylevchenko.carina.mobile.gui.common.BaseCarinaWebViewPage;
import ylevchenko.carina.mobile.gui.common.BaseLoginPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BaseLoginPage.class)
public class LoginPage extends BaseLoginPage {
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
    public void typeName(String name) {
        nameInputField.type(name);
    }

    @Override
    public void typePassword(String password) {
        passwordInputField.type(password);
    }

    @Override
    public void selectGender(String gender) {
        genderRadioBtn.format(gender).click();
    }

    @Override
    public void checkPrivacyPolicyCheckbox() {
        privacyPolicyCheckbox.click();
    }

    @Override
    public BaseCarinaWebViewPage clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(),BaseCarinaWebViewPage.class);
    }

    @Override
    public boolean isLoginBtnActive() {
        return loginBtn.isClickable();
    }

    @Override
    public BaseCarinaWebViewPage login() {
        loginBtn.click();
        return initPage(getDriver(), BaseCarinaWebViewPage.class);
    }


    public boolean isMaleChecked() {
        return maleRadioBtn.isChecked();
    }
}
