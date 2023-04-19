package ylevchenko.gfit.android;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ylevchenko.gfit.mobile.gui.common.*;
import ylevchenko.gfit.mobile.gui.enums.ActivityTypeItems;
import ylevchenko.gfit.mobile.gui.enums.AddActivityTextFields;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;
import ylevchenko.gfit.mobile.gui.enums.PlusMenuItems;
import ylevchenko.gfit.mobile.gui.service.IConstants;
import ylevchenko.gfit.mobile.gui.utils.DateTimeUtils;

import java.time.LocalDateTime;

public class AddedActivityTest implements IAbstractTest, IMobileUtils, IConstants {

    @BeforeTest
    public void loginApp() {
        initPage(getDriver(), LoginPageBase.class).login().clickNextBtn().clickSkipBtn();
    }

    @Test(description = "Comparing inserted data to new activity with one which saved in journal")
    @MethodOwner(owner = "ylevchenko")
    public void addActivityTest() {

        SoftAssert softAssert = new SoftAssert();

        ActivityTypeItems activity = ActivityTypeItems.values()[RandomUtils.nextInt(0, ActivityTypeItems.values().length - 1)];
        LocalDateTime dateTime = LocalDateTime.now().minusDays(RandomUtils.nextInt(0, 500));
        int energyExpended = RandomUtils.nextInt(0, 999);

        MainPageBase mainPage = initPage(getDriver(), MainPageBase.class);
        AddActivityPageBase addActivityPage = (AddActivityPageBase) mainPage.openPlusMenu().openPlusMenuItem(PlusMenuItems.ADD_ACTIVITY);
        Assert.assertTrue(addActivityPage.isPageOpened(), "Add Activity page isn't opened");

        addActivityPage.inputTextField(AddActivityTextFields.TITLE, activity.getText());
        addActivityPage.openActivityTypeModal().setActivityType(activity);
        addActivityPage.openSetDateModal().selectDate(dateTime);
        addActivityPage.openSetStartTimeModal().selectTime(dateTime);
        addActivityPage.openSetDurationModal().selectTime(dateTime);
        addActivityPage.inputTextField(AddActivityTextFields.ENERGY_EXPENDED, String.valueOf(energyExpended));

        int intensity = addActivityPage.openSetIntensityModal().setIntensity();

        mainPage = (MainPageBase) addActivityPage.saveChanges(MainPageBase.class);

        JournalPageBase journalPage = (JournalPageBase) mainPage.openMainMenuItem(MainMenuItems.JOURNAL);
        JournalEntityPageBase journalEntityPage = journalPage.getJournalEntity(activity.getText());

        softAssert.assertEquals(journalEntityPage.getTitle(), activity.getText(), "Activity title is inappropriate");
        softAssert.assertEquals(journalEntityPage.getDateTime().toString(), dateTime.format(ISO_FORMAT), "Activity start date or time is inappropriate");
        softAssert.assertEquals(journalEntityPage.getDuration(), DateTimeUtils.timeParser(dateTime), "Activity duration is inappropriate");
        softAssert.assertEquals(journalEntityPage.getEnergy(), energyExpended, "Energy expended is inappropriate");
        softAssert.assertEquals(journalEntityPage.getIntensity(), intensity, "Activity intensity is inappropriate");

        journalEntityPage.openMoreOptionsMenu().deleteEntity().delete();

        softAssert.assertAll();
    }

}
