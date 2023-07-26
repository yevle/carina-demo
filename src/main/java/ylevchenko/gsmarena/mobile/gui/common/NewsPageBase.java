package ylevchenko.gsmarena.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;

public abstract class NewsPageBase extends GsmArenaAbstractPage {

    public NewsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract GsmArenaAbstractPage openLeftMenuItem(LeftMenuItems item);

}
