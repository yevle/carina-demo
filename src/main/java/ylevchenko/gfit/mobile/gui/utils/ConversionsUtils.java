package ylevchenko.gfit.mobile.gui.utils;

import ylevchenko.gfit.mobile.gui.service.IConstants;

public class ConversionsUtils implements IConstants {
    public static final double KG_TO_LB = 2.20462;
    public static final double CM_TO_IN = 0.393701;

    public static final double CM_TO_FT = 1 / 30.48;

    public static final double LB_TO_KG = 1 / KG_TO_LB;
    public static final double IN_TO_CM = 1 / CM_TO_IN;

    public static double poundsToKilograms(double lb) {
        return lb * LB_TO_KG;
    }

    public static double inchesToCentimeters(double in) {
        return in * IN_TO_CM;
    }

    public static double kilogramsToPounds(double kg) {
        kg = kg * KG_TO_LB;
        return Double.parseDouble(String.format("%.1f", kg).replace(COMMA, POINT));
    }

    public static double centimetersToInches(double cm) {
        return cm * CM_TO_IN;
    }

    public static String centimetersToFeetAndInches(int cm) {
        int feet = (int) (cm * CM_TO_FT);
        int inches = Math.round((float) (cm * CM_TO_IN) % 12);
        if (inches > 11) {
            feet += 1;
            inches = 0;
        }
        return feet + FEET_MARK + inches + INCH_MARK;
    }

}
