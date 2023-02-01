package ylevchenko.carina.mobile.gui.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.carina.mobile.gui.common.WebViewPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

}
