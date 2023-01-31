package ylevchenko.carina;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class CarinaAbstractPage extends AbstractPage implements IMobileUtils {
    public CarinaAbstractPage(WebDriver driver) {
        super(driver);
    }
}
