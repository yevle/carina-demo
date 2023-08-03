package ylevchenko.gfit.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractUIObject;
import ylevchenko.gfit.mobile.gui.common.JournalEntityPageBase;

public abstract class MoreOptionsModalBase extends GFitAbstractUIObject {

    public MoreOptionsModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract JournalEntityPageBase deleteEntity();

}
