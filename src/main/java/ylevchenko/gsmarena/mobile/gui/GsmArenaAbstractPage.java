package ylevchenko.gsmarena.mobile.gui;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GsmArenaAbstractPage extends AbstractPage implements IConstants {

    public GsmArenaAbstractPage(WebDriver driver) {
        super(driver);
    }

}
