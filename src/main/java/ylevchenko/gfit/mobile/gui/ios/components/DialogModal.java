package ylevchenko.gfit.mobile.gui.ios.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;
import ylevchenko.gfit.mobile.gui.common.components.DialogModalBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DialogModalBase.class)
public class DialogModal extends DialogModalBase {

    public DialogModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public JournalPageBase delete() {
        throw new NotImplementedException();
    }

}
