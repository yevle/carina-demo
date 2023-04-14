package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SetGenderPageBase;
import ylevchenko.gfit.mobile.gui.enums.Gender;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SetGenderPageBase.class)
public class SetGenderPage extends SetGenderPageBase {

    public SetGenderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public SetGenderPageBase setGender(Gender gender) {
        throw new NotImplementedException();
    }

    @Override
    public ProfilePageBase exit() {
        throw new NotImplementedException();
    }

}
