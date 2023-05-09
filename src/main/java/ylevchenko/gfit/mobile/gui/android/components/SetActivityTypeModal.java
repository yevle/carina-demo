package ylevchenko.gfit.mobile.gui.android.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.common.components.SetActivityTypeModalBase;
import ylevchenko.gfit.mobile.gui.enums.ActivityTypeItems;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SetActivityTypeModalBase.class)
public class SetActivityTypeModal extends SetActivityTypeModalBase {

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/select_dialog_listview']/*[contains(@text, '%s')]")
    private ExtendedWebElement activityField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/select_dialog_listview']/*")
    private List<ExtendedWebElement> partialElemList;

    private List<String> fullElemList;

    public SetActivityTypeModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public AddActivityPageBase setActivityType(ActivityTypeItems activityType) {
        activityField.format(activityType.getText()).click();
        return initPage(getDriver(), AddActivityPageBase.class);
    }

    public AddActivityPageBase setActivityType(String activityType) {
        Direction direction = fullElemList.indexOf(partialElemList.get(0).getText()) > fullElemList.indexOf(activityType) ?
                Direction.DOWN : Direction.UP;
        ExtendedWebElement activity = activityField.format(activityType);
        swipe(activity, direction, ATTEMPTS_TWENTY, SWIPE_DURATION_LONG);
        activity.click();
        return initPage(getDriver(), AddActivityPageBase.class);
    }

    public List<String> fillElemList() {
        swipeDown(SWIPE_DURATION_SHORTEST);
        HashSet<String> seen = partialElemList.stream().map(ExtendedWebElement::getText).collect(Collectors.toCollection(LinkedHashSet::new));
        int counter = 0;
        while (!seen.contains(LAST_ACTIVITY_ELEM)) {
            swipeUp(SWIPE_DURATION_LONG);
            seen.addAll(partialElemList.stream().map(ExtendedWebElement::getText).collect(Collectors.toList()).subList(1, partialElemList.size()));
            counter++;
            if (counter > ATTEMPTS_TWENTY) {
                System.out.println("break");
                break;
            }
        }
        navigateBack();
        return fullElemList = List.copyOf(seen);
    }

}
