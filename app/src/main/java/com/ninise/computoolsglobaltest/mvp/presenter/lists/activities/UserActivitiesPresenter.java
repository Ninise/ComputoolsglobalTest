package com.ninise.computoolsglobaltest.mvp.presenter.lists.activities;

import android.content.Context;

import com.ninise.computoolsglobaltest.mvp.model.adapters.ActivitiesAdapter;
import com.ninise.computoolsglobaltest.mvp.model.entities.CardViewEntity;
import com.ninise.computoolsglobaltest.mvp.presenter.lists.IRecyclerListPresenter;
import com.ninise.computoolsglobaltest.mvp.presenter.lists.IRecyclerListView;

import java.util.Arrays;

public class UserActivitiesPresenter implements IRecyclerListPresenter {

    private IRecyclerListView mView;

    public UserActivitiesPresenter(IRecyclerListView view) {
        this.mView = view;
    }

    @Override
    public void getRecyclerAdapter(Context context) {
        mView.setRecyclerAdapter(
                new ActivitiesAdapter(Arrays.asList(
                        new CardViewEntity("3", "three"),
                        new CardViewEntity("4", "four"))
                )
        );
    }
}
