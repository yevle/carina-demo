package ylevchenko.gsmarena.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractUIObject;

public abstract class LeftMenuModalBase extends GsmArenaAbstractUIObject {

    public LeftMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
