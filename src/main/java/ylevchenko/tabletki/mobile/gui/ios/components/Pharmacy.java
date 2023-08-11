package ylevchenko.tabletki.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.common.components.PharmacyBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PharmacyBase.class)
public class Pharmacy extends PharmacyBase {

    ExtendedWebElement orderBtn;

    ExtendedWebElement priceText;

    public Pharmacy(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean reserve() {
        throw new NotImplementedException();
    }

}
