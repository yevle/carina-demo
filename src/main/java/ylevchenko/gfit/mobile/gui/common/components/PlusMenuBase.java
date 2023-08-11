package ylevchenko.gfit.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.GFitAbstractUIObject;
import ylevchenko.gfit.mobile.gui.enums.PlusMenuItems;

public abstract class PlusMenuBase extends GFitAbstractUIObject {

    public PlusMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract GFitAbstractPage openPlusMenuItem(PlusMenuItems item);

    public abstract void closePlusMenu();

}
