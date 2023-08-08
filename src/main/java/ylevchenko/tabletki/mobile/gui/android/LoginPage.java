package ylevchenko.tabletki.mobile.gui.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.common.LoginPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProfilePageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/editText'][@text='Email']")
    ExtendedWebElement emailTextField;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/editText'][@text='Пароль']")
    ExtendedWebElement passTextField;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/btn_layout_log_in']")
    ExtendedWebElement loginBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.gms:id/title' or @resource-id='com.google.android.gms:id/header_text'][contains(@text,'Sign')]")
    ExtendedWebElement googleSignSuggest;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProfilePageBase loginWithCreds(String email, String pass) {
        if (googleSignSuggest.isVisible(TIMEOUT_LONG)) {navigateBack();}
        if (!emailTextField.isVisible(TIMEOUT_SHORTEST)&&!passTextField.isVisible(TIMEOUT_SHORTEST)){
            navigateBack();
        }
        emailTextField.type(email);
        passTextField.type(pass);
        loginBtn.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }

}
