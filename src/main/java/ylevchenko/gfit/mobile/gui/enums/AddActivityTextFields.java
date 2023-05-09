package ylevchenko.gfit.mobile.gui.enums;

import com.zebrunner.carina.utils.resources.L10N;

public enum AddActivityTextFields {

    TITLE(L10N.getText("title")), DISTANCE(L10N.getText("distance")),
    ENERGY_EXPENDED(L10N.getText("energyExpended")), STEPS(L10N.getText("steps"));

    final String text;

    AddActivityTextFields(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
