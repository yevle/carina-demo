package ylevchenko.gfit.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.GFitAbstractUIObject;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;

public abstract class MainMenuBase extends GFitAbstractUIObject {

    public MainMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract GFitAbstractPage openMainMenuItem(MainMenuItems item);

    public abstract String getMenuItemColor(MainMenuItems item);

}
