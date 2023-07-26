package ylevchenko.gsmarena.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;

public abstract class DevicePageBase extends GsmArenaAbstractPage {

    public DevicePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract DevicePageBase addToFavourites();

    public abstract SearchPageBase goBackToSearch();

    public abstract DevicePageBase removeFromFavourites();

    public abstract ProfilePageBase goBackToProfile();

}
