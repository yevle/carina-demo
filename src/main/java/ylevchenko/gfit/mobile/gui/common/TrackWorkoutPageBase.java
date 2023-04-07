package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;

public abstract class AddBloodPressurePageBase extends GFitAbstractPage {

    public AddBloodPressurePageBase(WebDriver driver) {
        super(driver);
    }
    public abstract boolean closePage();

}
