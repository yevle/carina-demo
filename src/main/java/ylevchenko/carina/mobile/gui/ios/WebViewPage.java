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
    public MainMenuBase tapMainMenuButton() {
        throw new NotImplementedException();
    }

    @Override
    public void scrollToFooter() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFooterEmailLinkPresent() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isImageSliderVisible() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFooterEmailLinkCorrect() {
        throw new NotImplementedException();
    }
}
