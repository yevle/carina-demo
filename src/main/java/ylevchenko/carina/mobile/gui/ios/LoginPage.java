package ylevchenko.carina.mobile.gui.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import ylevchenko.carina.mobile.gui.CarinaAbstractPage;
import ylevchenko.carina.mobile.gui.common.LoginPageBase;
import ylevchenko.carina.mobile.gui.common.WebViewPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import org.openqa.selenium.WebDriver;
import ylevchenko.carina.enums.Gender;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase typeName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public LoginPageBase typePassword(String password) {
        throw new NotImplementedException();
    }

    @Override
    public LoginPageBase selectGender(Gender gender) {
        throw new NotImplementedException();
    }

    @Override
    public LoginPageBase checkPrivacyPolicyCheckbox() { throw new NotImplementedException();}

    @Override
    public WebViewPageBase clickLoginBtn() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLoginBtnActive() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isNameFieldHasText() {
        return false;
    }

    @Override
    public boolean isPasswordFieldHasText() {
        return false;
    }

    @Override
    public boolean isGenderFieldHasTextAndUnchecked(Gender gender) {
        return false;
    }

    @Override
    public boolean isPrivacyPolicyHasTextAndUnchecked() {
        return false;
    }

    @Override
    public WebViewPageBase login() {
        throw new NotImplementedException();
    }

    public boolean isMaleChecked() {
        throw new NotImplementedException();
    }

}
