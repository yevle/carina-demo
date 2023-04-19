package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SetHeightPageBase;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SetHeightPageBase.class)
public class SetHeightPage extends SetHeightPageBase {

    public SetHeightPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public SetHeightPageBase setUnits(String units) {
        throw new NotImplementedException();
    }

    @Override
    public SetHeightPageBase setHeight(int height) {
        throw new NotImplementedException();
    }

    @Override
    public int getHeight() {
        throw new NotImplementedException();
    }

    @Override
    public String getHeightFt() {
        throw new NotImplementedException();
    }

    @Override
    public ProfilePageBase saveChanges() {
        throw new NotImplementedException();
    }

}
