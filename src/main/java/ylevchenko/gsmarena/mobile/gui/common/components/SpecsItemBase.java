package ylevchenko.gsmarena.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractUIObject;
import ylevchenko.gsmarena.mobile.gui.common.DevicePageBase;

public abstract class SpecsItemBase extends GsmArenaAbstractUIObject {

    public SpecsItemBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract DevicePageBase openFavorite();

}
