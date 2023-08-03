package ylevchenko.gfit.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractUIObject;

public abstract class SetIntensityModalBase extends GFitAbstractUIObject {

    public SetIntensityModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract int setIntensity();

}
