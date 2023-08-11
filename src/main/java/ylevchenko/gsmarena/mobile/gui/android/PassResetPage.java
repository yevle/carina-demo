package ylevchenko.gsmarena.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.common.PassResetPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PassResetPageBase.class)
public class PassResetPage extends PassResetPageBase {

    @FindBy(xpath = "//*[@resource-id='content']/*[contains(@text,'')][3]")
    ExtendedWebElement resultText;

    public PassResetPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getResultMessage() {
        return resultText.getText();
    }

    @Override
    public boolean isPassResetSucceed() {
        return resultText.getText().equals(SUCCESS_PASS_RESET);
    }

}
