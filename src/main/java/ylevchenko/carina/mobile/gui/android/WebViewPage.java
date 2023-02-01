package ylevchenko.carina.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.carina.mobile.gui.common.WebViewPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(className = "android.widget.TextView")
    private ExtendedWebElement title;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementWithTextPresent("Web View", 3);
    }

}
