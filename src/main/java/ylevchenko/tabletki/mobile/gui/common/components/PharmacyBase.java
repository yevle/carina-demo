package ylevchenko.tabletki.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractUIObject;

public abstract class PharmacyBase extends TabletkiAbstractUIObject {

    public PharmacyBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract boolean reserve();

}
