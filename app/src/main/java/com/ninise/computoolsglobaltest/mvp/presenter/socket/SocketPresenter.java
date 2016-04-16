package com.ninise.computoolsglobaltest.mvp.presenter.socket;

public class SocketPresenter implements ISocketPresenter {

    private ISocketView mView;

    public SocketPresenter(ISocketView view) {
        this.mView = view;
    }

    @Override
    public void getResponse(String url) {
        mView.displayResponse("some response");
        mView.responseFailed();
    }
}
