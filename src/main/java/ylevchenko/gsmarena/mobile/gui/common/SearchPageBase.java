package ylevchenko.gsmarena.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;

public abstract class SearchPageBase extends GsmArenaAbstractPage {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean checkResultContains(String keyword);

    public abstract DevicePageBase openDevicePage(String keyword);

    public abstract GsmArenaAbstractPage goBackTo(LeftMenuItems item);

}
