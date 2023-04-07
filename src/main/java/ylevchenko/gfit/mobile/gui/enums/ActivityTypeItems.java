package ylevchenko.gfit.mobile.gui.enums;

public enum PlusMenuItems {
    ADD_BLOOD_PRESSURE("Add blood pressure"), ADD_WEIGHT ("Add weight"),
    ADD_ACTIVITY ("Add activity"), TRACK_WORKOUT ("Track workout");

    String mainText;

    PlusMenuItems(String mainText) {
        this.mainText = mainText;
    }
}
