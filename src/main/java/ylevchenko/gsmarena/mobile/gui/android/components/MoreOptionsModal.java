package ylevchenko.gsmarena.mobile.gui.android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.common.components.MoreOptionsModalBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MoreOptionsModalBase.class)
public class MoreOptionsModal extends MoreOptionsModalBase {


    @FindBy(xpath = "//*[@resource-id='com.gsmarena.android:id/title'][contains(@text,'Refresh')]/ancestor::*[@clickable='true']")
    private ExtendedWebElement refreshBtn;

    public MoreOptionsModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void refreshPage() {
        refreshBtn.click(TIMEOUT_SHORT);
    }

}
