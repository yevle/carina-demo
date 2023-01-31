package ylevchenko.carina.mobile.gui.ios;

import ylevchenko.carina.mobile.gui.common.BaseCarinaWebViewPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.carina.enums.Gender;
import ylevchenko.carina.mobile.gui.common.BaseLoginPage;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BaseLoginPage.class)
public class LoginPage extends BaseLoginPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public void typePassword(String password) {
        throw new NotImplementedException();
    }

    @Override
    public void selectGender(String gender) {
        throw new NotImplementedException();
    }

    @Override
    public void checkPrivacyPolicyCheckbox() {
        throw new NotImplementedException();
    }

    @Override
    public BaseCarinaWebViewPage clickLoginBtn() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLoginBtnActive() {
        throw new NotImplementedException();
    }

    @Override
    public BaseCarinaWebViewPage login() {
        throw new NotImplementedException();
    }

    public boolean isMaleChecked() {
        throw new NotImplementedException();
    }

    public void selectGender(Gender gender) {
        throw new NotImplementedException();
    }
}
