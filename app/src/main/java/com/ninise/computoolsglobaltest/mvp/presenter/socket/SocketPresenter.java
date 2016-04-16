package com.ninise.computoolsglobaltest.mvp.presenter.socket;

import com.ninise.computoolsglobaltest.mvp.activities.ActivitiesCounter;
import com.ninise.computoolsglobaltest.mvp.model.entities.CardViewEntity;
import com.ninise.computoolsglobaltest.utils.Constants;

public class SocketPresenter implements ISocketPresenter {

    private ISocketView mView;

    public SocketPresenter(ISocketView view) {
        this.mView = view;
    }

    @Override
    public void getResponse(String url) {
        ActivitiesCounter
                .getInstance()
                .addActivity(new CardViewEntity(Constants.FROM_SOCKET, "Get"));
        mView.displayResponse("some response");
        mView.responseFailed();
    }
}
