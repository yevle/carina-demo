package ylevchenko.gfit.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.common.components.SetTimeModalBase;
import ylevchenko.gfit.mobile.gui.service.IConstants;

import java.time.LocalDateTime;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SetTimeModalBase.class)
public class SetTimeModal extends SetTimeModalBase implements IConstants {

    public SetTimeModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void changeInputMode() {
        throw new NotImplementedException();
    }

    @Override
    public AddActivityPageBase selectTime(LocalDateTime date) {
        throw new NotImplementedException();
    }

}
