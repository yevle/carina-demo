package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.android.components.DialogModal;
import ylevchenko.gfit.mobile.gui.android.components.MoreOptionsModal;
import ylevchenko.gfit.mobile.gui.common.JournalEntityPageBase;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;
import ylevchenko.gfit.mobile.gui.enums.PlusMenuItems;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = JournalEntityPageBase.class)
public class JournalEntityPage extends JournalEntityPageBase {

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/sessions_title_view']//*[@resource-id='com.google.android.apps.fitness:id/title']")
    private ExtendedWebElement mainTitle;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/sessions_title_view']//*[@resource-id='com.google.android.apps.fitness:id/subtitle']")
    private ExtendedWebElement dateTimeField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/session_coaching_metrics']//*[@resource-id='com.google.android.apps.fitness:id/heart_points_view']")
    private ExtendedWebElement heartPoints;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/session_coaching_metrics']//*[@resource-id='com.google.android.apps.fitness:id/steps_view']")
    private ExtendedWebElement stepsField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/active_time']//*[@content-desc]")
    private ExtendedWebElement durationField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/distance']//*[@content-desc]")
    private ExtendedWebElement distanceField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/energy']//*[@resource-id='com.google.android.apps.fitness:id/metric_value']")
    private ExtendedWebElement energyField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/active_minutes']//*[@content-desc]")
    private ExtendedWebElement activeMinutesField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/toolbar']//*[@content-desc='More options']")
    private ExtendedWebElement moreOptionsBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/content']//*[@text='Delete']/ancestor::*[position()=5]")
    private MoreOptionsModal moreOptionsMenu;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/action_bar_root']//*[@resource-id='com.google.android.apps.fitness:id/parentPanel']")
    DialogModal dialogModal;

    public JournalEntityPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return mainTitle.getText();
    }

    public int getEnergy() {
        String text = energyField.getText();
        return Integer.parseInt(text.substring(0, text.indexOf(" ")).replace(",",""));
    }

    public String getDuration() {
        return durationField.getText();
    }

    @Override
    public MoreOptionsModal openMoreOptionsMenu() {
        moreOptionsBtn.click();
        return moreOptionsMenu;
    }

    @Override
    public JournalPageBase delete() {
        return dialogModal.delete();
    }

    @Override
    public int getIntensity() {
        return Integer.parseInt(heartPoints.getText().replace(",", ""));
    }

    @Override
    public LocalDateTime getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy, h:mm a", Locale.ENGLISH);
        String[] dateTime = dateTimeField.getText().split("–");
        Pattern pattern = Pattern.compile("\\b\\d{4}\\b"); // match a 4-digit number surrounded by word boundaries
        Matcher matcher = pattern.matcher(dateTime[0]);
        if (!matcher.find()) {
            dateTime[0] = dateTime[0].replaceFirst(dateTime[0].substring(0, dateTime[0].indexOf(',') + 1), dateTime[0].substring(0, dateTime[0].indexOf(',') + 1) + " 2023,");
        }
        if (dateTime[0].contains("PM") || dateTime[0].contains("AM")) {
            return LocalDateTime.parse(dateTime[0].strip(), formatter);
        }
        return LocalDateTime.parse(dateTime[0] + dateTime[1].substring(dateTime[1].lastIndexOf(" ") + 1), formatter);
    }

    public boolean isPageOpened() {
        return isElementWithTextPresent(mainTitle, PlusMenuItems.ADD_ACTIVITY.getText());
    }

}

