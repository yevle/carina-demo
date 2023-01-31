package ylevchenko.carina.mobile.gui.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.carina.mobile.gui.common.BaseCarinaWebViewPage;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BaseCarinaWebViewPage.class)
public class CarinaWebViewPage extends BaseCarinaWebViewPage {
    public CarinaWebViewPage(WebDriver driver) {
        super(driver);
    }
}
