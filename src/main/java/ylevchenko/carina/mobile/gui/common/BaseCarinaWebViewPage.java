package ylevchenko.carina.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.carina.CarinaAbstractPage;

public abstract class BaseCarinaWebViewPage extends CarinaAbstractPage {
    public BaseCarinaWebViewPage(WebDriver driver) {
        super(driver);
    }

}
