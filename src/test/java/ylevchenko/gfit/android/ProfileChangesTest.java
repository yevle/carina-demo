package ylevchenko.gfit.android;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import ylevchenko.gfit.mobile.gui.common.*;
import ylevchenko.gfit.mobile.gui.enums.AboutYouItems;
import ylevchenko.gfit.mobile.gui.enums.Gender;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;
import ylevchenko.gfit.mobile.gui.utils.ConversionsUtils;
import ylevchenko.gfit.mobile.gui.utils.ExtractorUtils;

import java.time.LocalDate;


public class ProfileChangesTest extends BaseTest {

    @Test(description = "Checking changes in profile and weight/height measures")
    @MethodOwner(owner = "ylevchenko")
    public void mainPageContentTest() {
        LocalDate date = LocalDate.now().minusYears(RandomUtils.nextInt(20, 40)).minusDays(RandomUtils.nextInt(0, 365));
        double weightKg = Math.round(RandomUtils.nextDouble(55, 95) * 10.0) / 10.0;
        int heightCm = RandomUtils.nextInt(150, 190);
        Gender gender = Gender.values()[RandomUtils.nextInt(0, Gender.values().length - 1)];

        MainPageBase mainPage = initPage(getDriver(), MainPageBase.class);
        ProfilePageBase profilePage = (ProfilePageBase) mainPage.openMainMenuItem(MainMenuItems.PROFILE);
        Assert.assertTrue(profilePage.isPageOpened(), "Profile page isn't opened");

        SetGenderPageBase setGenderPage = (SetGenderPageBase) profilePage.editAboutYouField(AboutYouItems.GENDER);
        Assert.assertEquals(setGenderPage.setGender(gender).backToProfilePage().getAboutYouFieldText(AboutYouItems.GENDER), gender.getText(), "[PROFILE PAGE] - Gender choice mismatch");

        SetBirthdayPageBase setBirthdayPage = (SetBirthdayPageBase) profilePage.editAboutYouField(AboutYouItems.BIRTHDAY);
        Assert.assertEquals(setBirthdayPage.setBirthday(date).saveChanges().getAboutYouFieldText(AboutYouItems.BIRTHDAY), date.format(BIRTH_DATE), "[PROFILE PAGE] - Birthday choice mismatch");

        SetWeightPageBase setWeightPage = (SetWeightPageBase) profilePage.editAboutYouField(AboutYouItems.WEIGHT);
        Assert.assertEquals(setWeightPage.setWeight(weightKg).getWeight(UNITS.get("LB")), ConversionsUtils.kilogramsToPounds(weightKg), WEIGHT_LB_DELTA, "[WEIGHT PAGE] - KG to LB conversion mismatch");

        profilePage = setWeightPage.setUnits(UNITS.get("KG")).saveChanges();
        Assert.assertEquals(ExtractorUtils.extractDoubleValue(profilePage.getAboutYouFieldText(AboutYouItems.WEIGHT)), weightKg, WEIGHT_KG_DELTA, "[PROFILE PAGE] - Weight choice mismatch");

        SetHeightPageBase setHeightPage = (SetHeightPageBase) profilePage.editAboutYouField(AboutYouItems.HEIGHT);
        Assert.assertEquals(setHeightPage.setHeight(heightCm).getHeightFt(), ConversionsUtils.centimetersToFeetAndInches(heightCm), "[HEIGHT PAGE] - CM to FT conversion mismatch");

        profilePage = setHeightPage.setUnits(UNITS.get("CM")).saveChanges();
        Assert.assertEquals(ExtractorUtils.extractIntValue(profilePage.getAboutYouFieldText(AboutYouItems.HEIGHT)), heightCm, HEIGHT_CM_DELTA, "[PROFILE PAGE] - Height choice mismatch");
    }

}
