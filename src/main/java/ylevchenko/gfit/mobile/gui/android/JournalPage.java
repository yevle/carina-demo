package ylevchenko.gfit.mobile.gui.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.android.components.MainMenu;
import ylevchenko.gfit.mobile.gui.common.JournalEntityPageBase;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = JournalPageBase.class)
public class JournalPage extends JournalPageBase {

    @FindBy(id = "add_entry_fab")
    private ExtendedWebElement plusBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/card_title'][@text='%s']")
    private MainMenu mainMenu;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/workout_list']//*[@resource-id='com.google.android.apps.fitness:id/session_title'][contains(@text,'%s')]")
    private ExtendedWebElement activityEntity;

    public JournalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPlusBtnPresent() {
        return plusBtn.isElementPresent(TIMEOUT_SHORTEST);
    }

    @Override
    public JournalEntityPageBase getJournalEntity(String title) {
        activityEntity.format(title).click();
        return initPage(getDriver(), JournalEntityPageBase.class);
    }

}
