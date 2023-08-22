package ylevchenko.mapmyrun.mobile.gui;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class MapmyrunAbstractPage extends AbstractPage implements IMobileUtils, IConstants {
    public MapmyrunAbstractPage(WebDriver driver) {
        super(driver);
    }

}
