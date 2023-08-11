package ylevchenko.gsmarena.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.common.components.MoreOptionsModalBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MoreOptionsModalBase.class)
public class MoreOptionsModal extends MoreOptionsModalBase {

    private ExtendedWebElement refreshBtn;

    public MoreOptionsModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void refreshPage() {
        throw new NotImplementedException();
    }

}
