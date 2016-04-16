package com.ninise.computoolsglobaltest.mvp.model.activities;

import com.ninise.computoolsglobaltest.mvp.model.entities.DoubleViewEntity;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesCounter {

    private static ActivitiesCounter mInstance = null;
    private static List<DoubleViewEntity> doubleViewEntityList;

    private ActivitiesCounter() {
        doubleViewEntityList = new ArrayList<>();
    }

    public static ActivitiesCounter getInstance() {
        if (mInstance == null) {
            mInstance = new ActivitiesCounter();
        }

        return mInstance;
    }

    public void addActivity(DoubleViewEntity activity) {
        doubleViewEntityList.add(activity);
    }

    public List<DoubleViewEntity> getActivities() {
        return doubleViewEntityList;
    }
}
