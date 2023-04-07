package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;

public abstract class TrackWorkoutPageBase extends GFitAbstractPage {

    public TrackWorkoutPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract boolean closePage();

}
