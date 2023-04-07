package ylevchenko.gfit.mobile.gui.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class SelectTimeModalBase extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {
    public SelectTimeModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void changeInputMode();

    public abstract AddActivityPageBase selectTime(LocalDateTime date);
}
