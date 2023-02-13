package ylevchenko.gfit.mobile.gui.enums;

public enum MainPageCards {

    DAILY_GOALS("Your daily goals"), WEEKLY_TARGET("Your weekly target"), ACTIVITY_TRACKING("Activity tracking is off"),
    WEIGHT("Weight"), ENERGY_EXPENDED("Energy expended"), SIMPLE_WAY("A simple way to stay healthy"),
    HOW_MUCH_SLEEP("How much sleep you need"), YOUTUBE("The YouTube logo and slogan Stay Fit With Me"),
    SET_A_PACE("Set a pace for your walks"), YOUR_SLEEP("Your sleep in Fit");

    String text;

    MainPageCards(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
