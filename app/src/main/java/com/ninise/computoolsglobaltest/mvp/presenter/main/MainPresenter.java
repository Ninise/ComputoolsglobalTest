package com.ninise.computoolsglobaltest.mvp.presenter.main;

import android.view.MenuItem;

import com.ninise.computoolsglobaltest.R;
import com.ninise.computoolsglobaltest.mvp.view.MediaFragment;
import com.ninise.computoolsglobaltest.mvp.view.SocketFragment;
import com.ninise.computoolsglobaltest.mvp.view.UserActivitiesFragment;

public class MainPresenter implements IMainPresenter {

    private IMainView mView;

    public MainPresenter(IMainView view) {
        this.mView = view;
    }

    @Override
    public boolean menuSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menuMedia:
                mView.switchToFragment(new MediaFragment());
                return true;
            case R.id.menuUserActivities:
                mView.switchToFragment(new UserActivitiesFragment());
                return true;
            case R.id.menuSocket:
                mView.switchToFragment(new SocketFragment());
                return true;
            case R.id.menuExit:
                mView.exit();
                return true;
        }

        return false;
    }
}
