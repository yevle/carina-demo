package ylevchenko.mapmyrun.mobile.gui.enums;

public enum Gender {
    FEMALE("Female", 1), MALE("Male", 2);
//    RATHER_NOT_SAY("Rather not say");

    final String text;

    final int index;

    Gender(String text, int index) {
        this.text = text;
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public int getIndex() {
        return index;
    }
}
