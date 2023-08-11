package ylevchenko.carina.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.carina.mobile.gui.common.WebViewPageBase;
import ylevchenko.carina.mobile.gui.common.components.MainMenuBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy (xpath = "//XCUIElementTypeOther[@name='Carina - open source test automation framework']")
    ExtendedWebElement title;

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

    public boolean isPageOpened(){
        return title.isPresent();
    }

}
