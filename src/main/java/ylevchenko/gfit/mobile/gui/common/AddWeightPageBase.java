package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;

public abstract class AddWeightPageBase extends GFitAbstractPage {

    public AddWeightPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean closePage();

    public abstract void saveChanges();

}
