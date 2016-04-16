package com.ninise.computoolsglobaltest.mvp.activities;

import com.ninise.computoolsglobaltest.mvp.model.entities.CardViewEntity;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesCounter {

    private static ActivitiesCounter mInstance = null;
    private static List<CardViewEntity> cardViewEntityList;

    private ActivitiesCounter() {
        cardViewEntityList = new ArrayList<>();
    }

    public static ActivitiesCounter getInstance() {
        if (mInstance == null) {
            mInstance = new ActivitiesCounter();
        }

        return mInstance;
    }

    public void addActivity(CardViewEntity activity) {
        cardViewEntityList.add(activity);
    }

    public List<CardViewEntity> getActivities() {
        return cardViewEntityList;
    }
}
