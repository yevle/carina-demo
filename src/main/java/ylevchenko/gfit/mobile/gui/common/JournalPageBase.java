package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;

public abstract class JournalPageBase extends GFitAbstractPage {

    public JournalPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPlusBtnPresent();

    public abstract JournalEntityPageBase getJournalEntity (String title);

}
