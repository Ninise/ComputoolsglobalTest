package com.ninise.computoolsglobaltest.mvp.presenter.lists.media;


import com.ninise.computoolsglobaltest.mvp.model.adapters.CardViewAdapter;
import com.ninise.computoolsglobaltest.mvp.model.entities.CardViewEntity;
import com.ninise.computoolsglobaltest.mvp.presenter.lists.IRecyclerListPresenter;
import com.ninise.computoolsglobaltest.mvp.presenter.lists.IRecyclerListView;

import java.util.Arrays;

public class MediaPresenter implements IRecyclerListPresenter {

    private IRecyclerListView mView;

    public MediaPresenter(IRecyclerListView view) {
        this.mView = view;
    }


    @Override
    public void getRecyclerAdapter() {
        mView.setRecyclerAdapter(
                new CardViewAdapter(Arrays.asList(
                        new CardViewEntity("1", "one"),
                        new CardViewEntity("2", "two"))
                )
        );
    }
}
