package ylevchenko.gfit.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.components.SetIntensityModalBase;
import ylevchenko.gfit.mobile.gui.service.IConstants;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SetIntensityModalBase.class)
public class SetIntensityIntensityModal extends SetIntensityModalBase implements IConstants {

    public SetIntensityIntensityModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public int setIntensity() {
        throw new NotImplementedException();
    }

}

