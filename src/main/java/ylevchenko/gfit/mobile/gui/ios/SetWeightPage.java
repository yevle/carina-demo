package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SetWeightPageBase;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SetWeightPageBase.class)
public class SetWeightPage extends SetWeightPageBase {

    public SetWeightPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public SetWeightPageBase setUnits(String units) {
        throw new NotImplementedException();
    }

    @Override
    public SetWeightPageBase setWeight(double weight) {
        throw new NotImplementedException();
    }

    @Override
    public double getWeight(String units) {
        throw new NotImplementedException();
    }

    @Override
    public ProfilePageBase saveChanges() {
        throw new NotImplementedException();
    }

}
