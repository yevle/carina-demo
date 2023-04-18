package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;

import java.time.LocalDate;

public abstract class SetBirthdayPageBase extends GFitAbstractPage {

    public SetBirthdayPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SetBirthdayPageBase setBirthday(LocalDate date);

    public abstract ProfilePageBase saveChanges();

    public abstract int selectedMonthIndex();

}
