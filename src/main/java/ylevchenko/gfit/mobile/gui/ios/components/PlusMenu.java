package ylevchenko.gfit.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.components.PlusMenuBase;
import ylevchenko.gfit.mobile.gui.enums.PlusMenuItems;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PlusMenuBase.class)
public class PlusMenu extends PlusMenuBase {

    public PlusMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public GFitAbstractPage openPlusMenuItem(PlusMenuItems item) {
        throw new NotImplementedException();
    }

    @Override
    public void closePlusMenu() {
        throw new NotImplementedException();
    }

}
