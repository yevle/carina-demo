package ylevchenko.gsmarena.mobile.gui.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class SpecsItemBase extends AbstractUIObject {
    public SpecsItemBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
