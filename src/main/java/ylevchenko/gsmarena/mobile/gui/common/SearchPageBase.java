package ylevchenko.gsmarena.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;

public abstract class SearchPageBase extends GsmArenaAbstractPage {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean checkResultContains(String keyword);

}
