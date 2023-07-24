package ylevchenko.gsmarena.mobile.gui.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.IConstants;
import ylevchenko.gsmarena.mobile.gui.common.DevicePageBase;

public abstract class FavoritesItemBase extends AbstractUIObject implements IConstants, IMobileUtils, ICustomTypePageFactory {

    public FavoritesItemBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void SwipeToElement();

    public abstract DevicePageBase openFavorite();

}
