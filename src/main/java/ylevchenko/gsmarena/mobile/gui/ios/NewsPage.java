package ylevchenko.gsmarena.mobile.gui.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;
import ylevchenko.gsmarena.mobile.gui.common.NewsPageBase;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;
import ylevchenko.gsmarena.mobile.gui.ios.components.LeftMenuModal;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {

    private ExtendedWebElement homePageTab;

    private ExtendedWebElement leftMenuBtn;

    private LeftMenuModal leftMenu;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public GsmArenaAbstractPage openLeftMenuItem(LeftMenuItems item) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

}
