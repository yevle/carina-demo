package ylevchenko.gfit.mobile.gui.enums;

import com.zebrunner.carina.utils.resources.L10N;

public enum MainPageCards {

    DAILY_GOALS(L10N.getText("dailyGoals")),
    WEEKLY_TARGET(L10N.getText("weeklyTarget")),
    ACTIVITY_TRACKING(L10N.getText("activityTracking")),
    WEIGHT(L10N.getText("weight")),
    ENERGY_EXPENDED(L10N.getText("energyExpended")),
    SIMPLE_WAY(L10N.getText("simpleWay")),
    HOW_MUCH_SLEEP(L10N.getText("howMuchSleep")),
    YOUTUBE(L10N.getText("youTube")),
    SET_A_PACE(L10N.getText("setPace")),
    YOUR_SLEEP(L10N.getText("yourSleep"));

    String text;

    MainPageCards(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
