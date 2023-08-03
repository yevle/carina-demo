package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.android.components.MoreOptionsModal;
import ylevchenko.gfit.mobile.gui.common.JournalEntityPageBase;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;

import java.time.LocalDateTime;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = JournalEntityPageBase.class)
public class JournalEntityPage extends JournalEntityPageBase {

    public JournalEntityPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        throw new NotImplementedException();
    }

    public int getEnergy() {
        throw new NotImplementedException();
    }

    public String getDuration() {
        throw new NotImplementedException();
    }

    @Override
    public MoreOptionsModal openMoreOptionsMenu() {
        throw new NotImplementedException();
    }

    @Override
    public JournalPageBase delete() {
        throw new NotImplementedException();
    }

    @Override
    public int getIntensity() {
        throw new NotImplementedException();
    }

    @Override
    public LocalDateTime getDateTime() {
        throw new NotImplementedException();
    }

    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

}

