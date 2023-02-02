package ylevchenko.carina.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.carina.enums.Gender;
import ylevchenko.carina.mobile.gui.CarinaAbstractPage;

public abstract class LoginPageBase extends CarinaAbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase typeName(String name);

    public abstract LoginPageBase typePassword(String password);

    public abstract LoginPageBase selectGender(Gender gender);

    public abstract LoginPageBase checkPrivacyPolicyCheckbox(boolean check);

    public abstract WebViewPageBase clickLoginBtn();

    public abstract boolean isLoginBtnActive();

    public abstract boolean isNameFieldHasText();

    public abstract boolean isPasswordFieldHasText();

    public abstract boolean isGenderFieldChecked(Gender gender);

    public abstract boolean isGenderFieldHasText(Gender gender);

    public abstract boolean isPrivacyPolicyChecked();

    public abstract boolean isPrivacyPolicyHasText();

}
