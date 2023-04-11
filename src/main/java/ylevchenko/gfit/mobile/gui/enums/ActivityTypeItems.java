package ylevchenko.gfit.mobile.gui.enums;

public enum ActivityTypeItems {
    TREADMILL_RUNNING("Treadmill running"), TREADMILL_WALKING("Treadmill walking"),
    UTILITY_BIKING("Utility biking"), VOLLEYBALL("Volleyball"), WAKEBOARDING("Wakeboarding"),
    WALKING("Walking"), WATER_POLO("Water polo"), WEIGHTLIFTING("Weightlifting"),
    WHEELCHAIR("Wheelchair"), WINDSURF("Windsurf"), YOGA("Yoga"), ZUMBA("Zumba");

    String text;

    ActivityTypeItems(String mainText) {
        this.text = mainText;
    }

    public String getText() {
        return text;
    }

}
