package ylevchenko.gfit.android;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ylevchenko.gfit.mobile.gui.common.*;
import ylevchenko.gfit.mobile.gui.enums.*;
import ylevchenko.gfit.mobile.gui.perfomance.IPerformanceTest;
import ylevchenko.gfit.mobile.gui.utils.DateTimeUtils;

import java.time.LocalDateTime;


public class PerformanceTest extends BaseTest implements IPerformanceTest {

    @Test(description = "Added activity test with performance")
    @MethodOwner(owner = "ylevchenko")
    public void addActivityTestWithPerf() {

        SoftAssert softAssert = new SoftAssert();

        LocalDateTime dateTime = LocalDateTime.now().minusDays(RandomUtils.nextInt(0, 500));
        int energyExpended = RandomUtils.nextInt(0, 999);

        MainPageBase mainPage = initPage(getDriver(), MainPageBase.class);
        AddActivityPageBase addActivityPage = (AddActivityPageBase) mainPage.openPlusMenu().openPlusMenuItem(PlusMenuItems.ADD_ACTIVITY);
        Assert.assertTrue(addActivityPage.isPageOpened(), "Add Activity page isn't opened");

        String activity = ActivityTypeItems.VOLLEYBALL.getText();

        addActivityPage.inputTextField(AddActivityTextFields.TITLE, activity);
        addActivityPage.openActivityTypeModal().setActivityType(ActivityTypeItems.VOLLEYBALL);
        addActivityPage.openSetDateModal().selectDate(dateTime);
        addActivityPage.openSetStartTimeModal().selectTime(dateTime);
        addActivityPage.openSetDurationModal().selectTime(dateTime);
        addActivityPage.inputTextField(AddActivityTextFields.ENERGY_EXPENDED, String.valueOf(energyExpended));

        int intensity = addActivityPage.openSetIntensityModal().setIntensity();

        mainPage = (MainPageBase) addActivityPage.saveChanges(MainPageBase.class);

        JournalPageBase journalPage = (JournalPageBase) mainPage.openMainMenuItem(MainMenuItems.JOURNAL);
        JournalEntityPageBase journalEntityPage = journalPage.getJournalEntity(activity);

        softAssert.assertEquals(journalEntityPage.getTitle(), activity, "Activity title is inappropriate");
        softAssert.assertEquals(journalEntityPage.getDateTime().toString(), dateTime.format(ISO_FORMAT), "Activity start date or time is inappropriate");
        softAssert.assertEquals(journalEntityPage.getDuration(), DateTimeUtils.timeParser(dateTime), "Activity duration is inappropriate");
        softAssert.assertEquals(journalEntityPage.getEnergy(), energyExpended, "Energy expended is inappropriate");
        softAssert.assertEquals(journalEntityPage.getIntensity(), intensity, "Activity intensity is inappropriate");

        journalEntityPage.openMoreOptionsMenu().deleteEntity().delete();

        softAssert.assertAll();
    }

}
