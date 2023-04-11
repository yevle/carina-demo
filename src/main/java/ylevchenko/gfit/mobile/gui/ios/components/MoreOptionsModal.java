package ylevchenko.gfit.mobile.gui.ios.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.JournalEntityPageBase;
import ylevchenko.gfit.mobile.gui.common.components.MoreOptionsModalBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MoreOptionsModalBase.class)
public class MoreOptionsModal extends MoreOptionsModalBase {

    public MoreOptionsModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public JournalEntityPageBase deleteEntity() {
        throw new NotImplementedException();
    }

}
