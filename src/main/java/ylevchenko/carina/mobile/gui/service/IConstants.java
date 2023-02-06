package ylevchenko.carina.mobile.gui.service;

import java.util.List;

public interface IConstants {

    public static final int LOGIN_SYMBOL_COUNT = 7;

    public static final int TIMEOUT_SHORT = 3;

    public static final String NAME_FIELD_TEXT = "Name";

    public static final String PASSWORD_FIELD_TEXT = "Password";

    public static final String PRIVACY_POLICY_TEXT = "I agree to the Privacy Policy";

    public static final String ONE_SPACE_TEXT = " ";

    public static final String EMPTY_TEXT = "";

    public default boolean indexExists(List list, int index) {
        return index >= 0 && index < list.size();
    }

}
