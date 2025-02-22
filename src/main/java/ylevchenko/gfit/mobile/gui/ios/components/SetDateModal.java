package ylevchenko.gfit.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.common.components.SelectDateModalBase;
import ylevchenko.gfit.mobile.gui.service.IConstants;

import java.time.LocalDateTime;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SelectDateModalBase.class)
public class SetDateModal extends SelectDateModalBase implements IConstants {

    public SetDateModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void changeInputMode() {
        throw new NotImplementedException();
    }

    @Override
    public AddActivityPageBase selectDate(LocalDateTime date) {
        throw new NotImplementedException();
    }

}
