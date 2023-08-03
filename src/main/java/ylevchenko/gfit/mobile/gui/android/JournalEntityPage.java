package ylevchenko.gfit.mobile.gui.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.android.components.DialogModal;
import ylevchenko.gfit.mobile.gui.android.components.MoreOptionsModal;
import ylevchenko.gfit.mobile.gui.common.JournalEntityPageBase;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;
import ylevchenko.gfit.mobile.gui.enums.PlusMenuItems;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.regex.Matcher;

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

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/toolbar']//*[@content-desc='{L10N:moreOptions}']")
    private ExtendedWebElement moreOptionsBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/content']//*[@text='{L10N:delete}']/ancestor::*[position()=5]")
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
        return Integer.parseInt(text.substring(0, text.indexOf(SPACE)).replace(COMMA, EMPTY_STRING).replace(POINT, EMPTY_STRING));
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
        return Integer.parseInt(heartPoints.getText().replace(COMMA, EMPTY_STRING).replace(POINT, EMPTY_STRING));
    }

    @Override
    public LocalDateTime getDateTime() {
        String locale = R.CONFIG.get("locale");
        if (locale.equalsIgnoreCase("en_US")) {
            String[] dateTime = dateTimeField.getText().split("–");
            Matcher matcher = FOUR_DIGIT_NUM.matcher(dateTime[0]);
            if (!matcher.find()) {
                dateTime[0] = dateTime[0].replaceFirst(dateTime[0].substring(0, dateTime[0].indexOf(COMMA) + 1), dateTime[0].substring(0, dateTime[0].indexOf(COMMA) + 1) + CURRENT_YEAR);
            }
            if (dateTime[0].contains("PM") || dateTime[0].contains("AM")) {
                return LocalDateTime.parse(dateTime[0].strip(), EN_FORMATTER);
            }
            return LocalDateTime.parse(dateTime[0] + dateTime[1].substring(dateTime[1].lastIndexOf(SPACE) + 1), EN_FORMATTER);
        }
        if (locale.equalsIgnoreCase("de_DE")) {
            String dateTime = dateTimeField.getText().substring(0, dateTimeField.getText().indexOf("–") - 1);
            Matcher matcher = FOUR_DIGIT_NUM.matcher(dateTime);
            if (!matcher.find()) {
                dateTime = dateTime.replaceFirst(dateTime.substring(0, dateTime.indexOf(COMMA)), dateTime.substring(0, dateTime.indexOf(COMMA)) + CURRENT_YEAR);
            }
            return LocalDateTime.parse(dateTime, DE_FORMATTER);
        } else throw new DateTimeException("No formatter found for defined locale");
    }

    public boolean isPageOpened() {
        return isElementWithTextPresent(mainTitle, PlusMenuItems.ADD_ACTIVITY.getText());
    }

}

