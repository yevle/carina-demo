package ylevchenko.gfit.mobile.gui.enums;

public enum Gender {
    FEMALE("Female"), MALE("Male"), RATHER_NOT_SAY("Rather not say");

    public final String text;

    Gender(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
