package ylevchenko.carina.mobile.gui.common;

import ylevchenko.carina.mobile.gui.common.BaseCarinaWebViewPage;
import org.openqa.selenium.WebDriver;
import ylevchenko.carina.CarinaAbstractPage;

public abstract class BaseLoginPage extends CarinaAbstractPage {
    public BaseLoginPage(WebDriver driver) {
        super(driver);
    }
    public abstract void typeName(String name);

    public abstract void typePassword(String password);

    public abstract void selectGender(String gender);

    public abstract void checkPrivacyPolicyCheckbox();

    public abstract BaseCarinaWebViewPage clickLoginBtn();

    public abstract BaseCarinaWebViewPage login();

    public abstract boolean isLoginBtnActive();
}
