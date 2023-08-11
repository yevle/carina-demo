package ylevchenko.tabletki.mobile.gui;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class TabletkiAbstractPage extends AbstractPage implements IMobileUtils, IConstants {
    public TabletkiAbstractPage(WebDriver driver) {
        super(driver);
    }

}
