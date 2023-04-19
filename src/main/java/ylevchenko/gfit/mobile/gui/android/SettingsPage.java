package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.SettingsPageBase;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsPageBase.class)
public class SettingsPage extends SettingsPageBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement backBtn;

    @FindBy(id = "//*[@resource-id='com.google.android.apps.fitness:id/settings_unit_container']//*[contains(@text,'%s')]//parent::*")
    private ExtendedWebElement unitsField;

    @FindBy(xpath = "//*[@resource-id='android:id/text1'][contains(@text,'%s')]")
    private ExtendedWebElement choiceRadioBtn;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

}
