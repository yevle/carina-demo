package ylevchenko.gfit.mobile.gui.enums;

public enum AddActivityTextFields {

    TITLE("Title"), DISTANCE("Distance"), ENERGY_EXPENDED("Energy expended"), STEPS("Steps");

    String text;

    AddActivityTextFields(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
