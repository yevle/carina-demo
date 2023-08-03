package ylevchenko.gfit.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractUIObject;
import ylevchenko.gfit.mobile.gui.android.AddActivityPage;

import java.time.LocalDate;

public abstract class SelectDurationModalBase extends GFitAbstractUIObject {

    public SelectDurationModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void changeInputMode();

    public abstract AddActivityPage selectDuration(LocalDate date);

}
