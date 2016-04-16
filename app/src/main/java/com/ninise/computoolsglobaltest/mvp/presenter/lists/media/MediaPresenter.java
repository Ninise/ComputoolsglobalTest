package com.ninise.computoolsglobaltest.mvp.presenter.lists.media;


import android.content.Context;

import com.ninise.computoolsglobaltest.mvp.model.adapters.MediaAdapter;
import com.ninise.computoolsglobaltest.mvp.model.entities.DoubleViewEntity;
import com.ninise.computoolsglobaltest.mvp.model.media.UserMedia;
import com.ninise.computoolsglobaltest.mvp.presenter.lists.IRecyclerListPresenter;
import com.ninise.computoolsglobaltest.mvp.presenter.lists.IRecyclerListView;

public class MediaPresenter implements IRecyclerListPresenter {

    private IRecyclerListView mView;

    public MediaPresenter(IRecyclerListView view) {
        this.mView = view;
    }


    @Override
    public void getRecyclerAdapter(Context context) {
        UserMedia.getUserMusic(context)
                .map(s -> new DoubleViewEntity(s.getTitle(), s.getDesrp()))
                .toList()
                .subscribe(cardViewEntities -> {
                    mView.setRecyclerAdapter(
                            new MediaAdapter(context, cardViewEntities)
                    );
                });

    }
}
