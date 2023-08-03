package ylevchenko.gsmarena.mobile.gui.ios.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.common.DevicePageBase;
import ylevchenko.gsmarena.mobile.gui.common.components.FavoritesItemBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = FavoritesItemBase.class)
public class FavoritesItem extends FavoritesItemBase {

    private ExtendedWebElement title;

    public FavoritesItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        throw new NotImplementedException();
    }

    public void swipeToElement() {
        throw new NotImplementedException();
    }

    public DevicePageBase openFavorite() {
        throw new NotImplementedException();
    }

}
