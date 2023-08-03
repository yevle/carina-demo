package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.common.TrackActivitiesPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = TrackActivitiesPageBase.class)
public class TrackActivitiesPage extends TrackActivitiesPageBase {

    public TrackActivitiesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    public MainPageBase clickSkipBtn() {
        throw new NotImplementedException();
    }

}
