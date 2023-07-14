package ylevchenko.gsmarena.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.common.ForgotPassPageBase;
import ylevchenko.gsmarena.mobile.gui.common.PassResetPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ForgotPassPageBase.class)
public class ForgotPassPage extends ForgotPassPageBase {

    @FindBy(xpath = "//android.widget.EditText[@resource-id='email']")
    ExtendedWebElement emailTextField;

    @FindBy(xpath = "//android.widget.Button[@resource-id='nick-submit']")
    ExtendedWebElement submitBtn;

    public ForgotPassPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PassResetPageBase submitPassReset(String email) {
        emailTextField.type(email);
        submitBtn.click();
        return initPage(getDriver(), PassResetPageBase.class);
    }

}
