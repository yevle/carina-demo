package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.enums.Gender;

public abstract class SetGenderPageBase extends GFitAbstractPage {

    public SetGenderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SetGenderPageBase setGender(Gender gender);

    public abstract ProfilePageBase exit();

}
