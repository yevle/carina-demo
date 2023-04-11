package ylevchenko.gfit.mobile.gui.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.android.components.MainMenu;
import ylevchenko.gfit.mobile.gui.common.JournalEntityPageBase;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = JournalPageBase.class)
public class JournalPage extends JournalPageBase {

    public JournalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPlusBtnPresent() {
        throw new NotImplementedException();
    }

    @Override
    public JournalEntityPageBase getJournalEntity(String title) {
        throw new NotImplementedException();
    }

}
