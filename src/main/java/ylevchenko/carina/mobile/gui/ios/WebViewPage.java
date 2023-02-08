package ylevchenko.carina.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.carina.mobile.gui.common.WebViewPageBase;
import ylevchenko.carina.mobile.gui.common.components.MainMenuBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainMenuBase openMainMenu() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFooterEmailLinkPresent() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSliderVisibleAfterSwipe() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFooterEmailLinkCorrect(String name, String domain) {
        throw new NotImplementedException();
    }

}
