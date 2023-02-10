package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.AboutYouPageBase;
import ylevchenko.gfit.mobile.gui.common.TrackActivitiesPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AboutYouPageBase.class)
public class AboutYouPage extends AboutYouPageBase {

    public AboutYouPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    public TrackActivitiesPageBase clickNextBtn() {
        throw new NotImplementedException();
    }

}
