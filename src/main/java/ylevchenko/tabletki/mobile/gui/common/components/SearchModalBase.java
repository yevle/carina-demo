package ylevchenko.tabletki.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractUIObject;

public abstract class SearchModalBase extends TabletkiAbstractUIObject {

    public SearchModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
