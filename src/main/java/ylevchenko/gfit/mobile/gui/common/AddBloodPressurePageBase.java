package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;

public abstract class TrackActivitiesPageBase extends GFitAbstractPage {

    public TrackActivitiesPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract MainPageBase clickSkipBtn ();

}
