package ylevchenko.gfit.mobile.gui.enums;

import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.common.AddBloodPressurePageBase;
import ylevchenko.gfit.mobile.gui.common.AddWeightPageBase;
import ylevchenko.gfit.mobile.gui.common.TrackWorkoutPageBase;

public enum PlusMenuItems {
    ADD_BLOOD_PRESSURE("Add blood pressure", AddBloodPressurePageBase.class), ADD_WEIGHT("Add weight", AddWeightPageBase.class),
    ADD_ACTIVITY("Add activity", AddActivityPageBase.class), TRACK_WORKOUT("Track workout", TrackWorkoutPageBase.class);

    String text;

    private Class<? extends GFitAbstractPage> pageClass;

    PlusMenuItems(String text, Class<? extends GFitAbstractPage> pageClass) {
        this.text = text;
        this.pageClass = pageClass;
    }

    public String getText() {
        return text;
    }

    public Class<? extends GFitAbstractPage> getPageClass() {
        return pageClass;
    }

}
