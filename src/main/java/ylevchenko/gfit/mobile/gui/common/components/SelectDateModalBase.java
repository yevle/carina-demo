package ylevchenko.gfit.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractUIObject;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;

import java.time.LocalDateTime;

public abstract class SelectDateModalBase extends GFitAbstractUIObject {
    public SelectDateModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void changeInputMode();

    public abstract AddActivityPageBase selectDate(LocalDateTime date);

}
