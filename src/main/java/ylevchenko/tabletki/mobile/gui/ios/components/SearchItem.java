package ylevchenko.tabletki.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.common.components.SearchItemBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SearchItemBase.class)
public class SearchItem extends SearchItemBase {

    ExtendedWebElement title;

    ExtendedWebElement price;

    public SearchItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getTitle() {
        throw new NotImplementedException();
    }

    public double getPrice() {
        throw new NotImplementedException();
    }

}
