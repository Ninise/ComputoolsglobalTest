package com.ninise.computoolsglobaltest.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jakewharton.rxbinding.support.design.widget.RxNavigationView;
import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;
import com.ninise.computoolsglobaltest.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.mainToolbar) Toolbar mMainToolbar;
    @Bind(R.id.mainDrawer) DrawerLayout mMainDrawerLayout;
    @Bind(R.id.mainNavigationView) NavigationView mMainNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);

        setSupportActionBar(mMainToolbar);
        RxToolbar.itemClicks(mMainToolbar).subscribe(this::menuSelected);

        RxNavigationView.itemSelections(mMainNavigationView).subscribe(menuItem -> {
            mMainDrawerLayout.closeDrawers();
            menuSelected(menuItem);
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mMainDrawerLayout, mMainToolbar, R.string.openDrawer,
                R.string.closeDrawer);

        mMainDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

    }

    private boolean menuSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menuMedia:
                return true;
            case R.id.menuUserActivities:
                return true;
            case R.id.menuSocket:
                return true;
            case R.id.menuExit:
                return true;
        }

        return false;
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
