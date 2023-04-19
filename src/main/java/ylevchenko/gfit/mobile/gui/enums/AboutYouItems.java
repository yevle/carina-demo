package ylevchenko.gfit.mobile.gui.enums;

import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.SetBirthdayPageBase;
import ylevchenko.gfit.mobile.gui.common.SetGenderPageBase;
import ylevchenko.gfit.mobile.gui.common.SetHeightPageBase;
import ylevchenko.gfit.mobile.gui.common.SetWeightPageBase;

public enum AboutYouItems {

    GENDER("gender", SetGenderPageBase.class), BIRTHDAY("birthday", SetBirthdayPageBase.class),
    WEIGHT("weight", SetWeightPageBase.class), HEIGHT("height", SetHeightPageBase.class);

    final Class<? extends GFitAbstractPage> classType;
    final String text;

    AboutYouItems(String text, Class<? extends GFitAbstractPage> classType) {
        this.classType = classType;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Class<? extends GFitAbstractPage> getClassType() {
        return classType;
    }

}
