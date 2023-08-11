package ylevchenko.gsmarena.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;
import ylevchenko.gsmarena.mobile.gui.common.components.LeftMenuModalBase;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LeftMenuModalBase.class)
public class LeftMenuModal extends LeftMenuModalBase {

    private ExtendedWebElement menuItem;

    public LeftMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public GsmArenaAbstractPage openMenuItem (LeftMenuItems item) {
        throw new NotImplementedException();
    }


}
