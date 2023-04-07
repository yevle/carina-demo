package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.MoreOptionsModal;

import java.time.LocalDateTime;

public abstract class JournalEntityPageBase extends GFitAbstractPage {

    public JournalEntityPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTitle();

    public abstract LocalDateTime getDateTime();

    public abstract int getEnergy();

    public abstract String getDuration();

    public abstract MoreOptionsModal openMoreOptionsMenu();

    public abstract int getIntensity();

    public abstract JournalPageBase delete();

}
