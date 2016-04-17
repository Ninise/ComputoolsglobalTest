package com.ninise.computoolsglobaltest.mvp.presenter.socket;

public interface ISocketView {

    void networkNotFound();
    void displayResponse(String response);
    void disposeProgress();
    void startProgress();
    void editIsEmpty();
    void noResponseFrom(String url);

}
