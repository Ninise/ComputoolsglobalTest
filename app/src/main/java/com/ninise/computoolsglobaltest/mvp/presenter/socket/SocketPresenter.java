package com.ninise.computoolsglobaltest.mvp.presenter.socket;

import android.content.Context;

import com.ninise.computoolsglobaltest.mvp.model.activities.ActivitiesCounter;
import com.ninise.computoolsglobaltest.mvp.model.entities.DoubleViewEntity;
import com.ninise.computoolsglobaltest.mvp.model.network.GetResponse;
import com.ninise.computoolsglobaltest.mvp.model.network.NetworkConnection;
import com.ninise.computoolsglobaltest.utils.Constants;

import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SocketPresenter implements ISocketPresenter {

    private ISocketView mView;

    public SocketPresenter(ISocketView view) {
        this.mView = view;
    }

    @Override
    public void getResponse(Context context, String url) {
        if (NetworkConnection.isNetworkConnectionOn(context)) {
            if (!url.equals("")) {
                mView.startProgress();
                GetResponse.createResponse(url)
                        .timeout(8, TimeUnit.SECONDS)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(s -> {
                            mView.displayResponse(s);
                            ActivitiesCounter.getInstance().addActivity(new DoubleViewEntity(Constants.FROM_SOCKET, "Get"));
                        }, throwable -> {
                            mView.noResponseFrom(url);
                            mView.disposeProgress();
                        }, () -> mView.disposeProgress());
            } else {
                mView.editIsEmpty();
            }
        } else {
            mView.networkNotFound();
        }
    }
}
