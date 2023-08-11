package ylevchenko.gfit.mobile.gui;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.service.IConstants;

public class GFitAbstractPage extends AbstractPage implements IMobileUtils, IConstants {

    public GFitAbstractPage(WebDriver driver) {
        super(driver);
    }

}
