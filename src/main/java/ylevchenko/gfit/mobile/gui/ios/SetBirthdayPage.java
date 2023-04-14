package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SetBirthdayPageBase;

import java.time.LocalDate;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SetBirthdayPageBase.class)
public class SetBirthdayPage extends SetBirthdayPageBase {

    public SetBirthdayPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public SetBirthdayPageBase setBirthday(LocalDate date) {
        throw new NotImplementedException();
    }

    @Override
    public ProfilePageBase saveChanges() {
        throw new NotImplementedException();
    }

}
