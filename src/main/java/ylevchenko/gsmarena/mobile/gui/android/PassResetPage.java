package ylevchenko.gsmarena.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
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

}
