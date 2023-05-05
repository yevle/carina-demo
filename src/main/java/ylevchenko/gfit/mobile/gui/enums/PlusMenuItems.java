package ylevchenko.gfit.mobile.gui.enums;

import com.zebrunner.carina.utils.resources.L10N;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.common.AddBloodPressurePageBase;
import ylevchenko.gfit.mobile.gui.common.AddWeightPageBase;
import ylevchenko.gfit.mobile.gui.common.TrackWorkoutPageBase;

public enum PlusMenuItems {
    ADD_BLOOD_PRESSURE(L10N.getText("addBloodPressure"), AddBloodPressurePageBase.class), ADD_WEIGHT(L10N.getText("addWeight"), AddWeightPageBase.class),
    ADD_ACTIVITY(L10N.getText("addActivity"), AddActivityPageBase.class), TRACK_WORKOUT(L10N.getText("trackWorkout"), TrackWorkoutPageBase.class);

    final String text;

    private final Class<? extends GFitAbstractPage> pageClass;

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
