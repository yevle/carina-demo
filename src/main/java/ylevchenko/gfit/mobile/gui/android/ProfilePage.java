package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.MainMenu;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SettingsPageBase;
import ylevchenko.gfit.mobile.gui.enums.AboutYouItems;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/toolbar']/parent::*[contains(@content-desc,'Profile')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Settings']")
    private ExtendedWebElement settingsBtn;

    @FindBy(id = "bottom_navigation")
    private MainMenu mainMenu;

    @FindBy(id = "%s_field")
    private ExtendedWebElement aboutYouField;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public SettingsPageBase openSettings() {
        settingsBtn.click();
        return initPage(getDriver(), SettingsPageBase.class);
    }

    @Override
    public GFitAbstractPage editAboutYouField(AboutYouItems field) {
        aboutYouField.format(field.getText()).click();
        return initPage(getDriver(), field.getClassType());
    }

    @Override
    public String getText(AboutYouItems field) {
        return aboutYouField.format(field.getText()).getText();
    }

}
