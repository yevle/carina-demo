package ylevchenko.gfit.mobile.gui;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.service.IConstants;

public class GFitAbstractPage extends AbstractPage implements IMobileUtils, IConstants {

    public GFitAbstractPage(WebDriver driver) {
        super(driver);
    }

}
