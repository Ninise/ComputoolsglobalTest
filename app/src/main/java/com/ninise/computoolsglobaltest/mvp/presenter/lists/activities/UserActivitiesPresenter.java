package com.ninise.computoolsglobaltest.mvp.presenter.lists.activities;

import com.ninise.computoolsglobaltest.mvp.model.adapters.CardViewAdapter;
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
    public void getRecyclerAdapter() {
        mView.setRecyclerAdapter(
                new CardViewAdapter(Arrays.asList(
                        new CardViewEntity("3", "three"),
                        new CardViewEntity("4", "four"))
                )
        );
    }
}
