package ylevchenko.gsmarena.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.common.DevicePageBase;
import ylevchenko.gsmarena.mobile.gui.common.components.SpecsItemBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SpecsItemBase.class)
public class SpecsItem extends SpecsItemBase {

    private ExtendedWebElement title;

    public SpecsItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public DevicePageBase openFavorite() {
        throw new NotImplementedException();
    }

}
