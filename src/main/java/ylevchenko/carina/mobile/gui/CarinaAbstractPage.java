package ylevchenko.carina.mobile.gui;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import ylevchenko.carina.mobile.gui.service.IConstants;

public abstract class CarinaAbstractPage extends AbstractPage implements IMobileUtils, IConstants {

    public CarinaAbstractPage(WebDriver driver) {
        super(driver);
    }

}
