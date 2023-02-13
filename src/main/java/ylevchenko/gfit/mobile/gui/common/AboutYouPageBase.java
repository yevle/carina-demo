package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;

public abstract class AboutYouPageBase extends GFitAbstractPage {

    public AboutYouPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TrackActivitiesPageBase clickNextBtn();

}
