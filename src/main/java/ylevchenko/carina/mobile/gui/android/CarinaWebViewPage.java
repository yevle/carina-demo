package ylevchenko.carina.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.carina.CarinaAbstractPage;
import ylevchenko.carina.mobile.gui.common.BaseCarinaWebViewPage;
import ylevchenko.carina.mobile.gui.common.BaseLoginPage;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BaseCarinaWebViewPage.class)
public class CarinaWebViewPage extends BaseCarinaWebViewPage {

    @FindBy (xpath = "*//android.widget.TextView")
    private ExtendedWebElement title;

    public CarinaWebViewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened () {
        return title.isElementPresent();
    };
}
