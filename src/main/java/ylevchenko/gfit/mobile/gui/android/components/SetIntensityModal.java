package ylevchenko.gfit.mobile.gui.android.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.components.SetIntensityModalBase;
import ylevchenko.gfit.mobile.gui.service.IConstants;
import ylevchenko.gfit.mobile.gui.utils.CoordinatesUtils;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SetIntensityModalBase.class)
public class SetIntensityModal extends SetIntensityModalBase implements IConstants {

    @FindBy(id = "seek_bar")
    private ExtendedWebElement seekBarContainer;

    @FindBy(id = "heart_points_estimate")
    private ExtendedWebElement heartPoints;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/buttonPanel']//*[contains(@resource-id,'android:id/button1')]")
    private ExtendedWebElement okButton;

    public SetIntensityModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public int setIntensity() {
        Point topLeft = seekBarContainer.getLocation();
        Point bottomRight = new Point(topLeft.x + seekBarContainer.getSize().width, topLeft.y + seekBarContainer.getSize().height);
        Point random = CoordinatesUtils.randomPointInsideRect(topLeft, bottomRight);
        tap(random.x, random.y);
        int heartPts = Integer.parseInt(heartPoints.getText().replace(",",""));
        okButton.click();
        return heartPts;
    }

}

