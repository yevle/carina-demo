package ylevchenko.gsmarena.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.common.HomePageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//*[@resource-id='com.gsmarena.android:id/tab_layout']/*/*[@content-desc='%s']")
    private ExtendedWebElement homePageTab;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened () {
        return homePageTab.format("LATEST").isElementPresent(TIMEOUT_SHORT)
    }

}
