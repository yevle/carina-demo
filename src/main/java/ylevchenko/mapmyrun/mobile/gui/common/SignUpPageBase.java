package ylevchenko.mapmyrun.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.mapmyrun.mobile.gui.MapmyrunAbstractPage;
import ylevchenko.mapmyrun.mobile.gui.enums.Gender;

public abstract class SignUpPageBase extends MapmyrunAbstractPage {

    public SignUpPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignUpPageBase setGender(Gender gender);

    public abstract SignUpPageBase setCountry();

}
