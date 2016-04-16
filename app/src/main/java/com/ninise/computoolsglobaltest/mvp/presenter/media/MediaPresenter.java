package com.ninise.computoolsglobaltest.mvp.presenter.media;


import com.ninise.computoolsglobaltest.mvp.model.adapters.CardViewAdapter;
import com.ninise.computoolsglobaltest.mvp.model.entities.CardViewEntity;

import java.util.Arrays;

public class MediaPresenter implements IMediaPresenter {

    private IMediaView mView;

    public MediaPresenter(IMediaView view) {
        this.mView = view;
    }


    @Override
    public void getMedia() {
        mView.getCardViewAdapter(
                new CardViewAdapter(Arrays.asList(
                        new CardViewEntity("1", "one"),
                        new CardViewEntity("2", "two"))
                )
        );
    }
}
