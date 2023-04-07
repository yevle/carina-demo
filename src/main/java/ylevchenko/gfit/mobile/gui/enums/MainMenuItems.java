package ylevchenko.gfit.mobile.gui.enums;

public enum MainMenuItems {
    HOME("Home"), JOURNAL("Journal"),
    BROWSE("Browse"), PROFILE("Profile");

    String text;

    MainMenuItems(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
