package ylevchenko.gfit.mobile.gui.android.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.components.SelectIntensityModalBase;
import ylevchenko.gfit.mobile.gui.common.components.SelectTimeModalBase;
import ylevchenko.gfit.mobile.gui.service.IConstants;
import ylevchenko.gfit.mobile.gui.utils.DateTimeFormat;

import java.time.LocalDateTime;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SelectIntensityModalBase.class)
public class SelectIntensityModal extends SelectIntensityModalBase implements IConstants {

    @FindBy(id = "seek_bar")
    private ExtendedWebElement seekBarContainer;

    @FindBy(id = "heart_points_estimate")
    private ExtendedWebElement heartPoints;

    @FindBy(id = "material_timepicker_ok_button")
    private ExtendedWebElement okButton;

    public SelectIntensityModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void selectIntensity() {

    }

}

