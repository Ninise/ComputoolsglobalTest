package com.ninise.computoolsglobaltest.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ninise.computoolsglobaltest.R;
import com.ninise.computoolsglobaltest.mvp.model.adapters.CardViewAdapter;
import com.ninise.computoolsglobaltest.mvp.presenter.lists.IRecyclerListView;
import com.ninise.computoolsglobaltest.mvp.presenter.lists.activities.UserActivitiesPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserActivitiesFragment extends Fragment implements IRecyclerListView {

    @Bind(R.id.rv) RecyclerView mRecyclerView;

    private UserActivitiesPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new UserActivitiesPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view, container, false);

        ButterKnife.bind(this, v);

        final LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setHasFixedSize(true);

        final RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(itemAnimator);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getRecyclerAdapter();
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    @Override
    public void setRecyclerAdapter(CardViewAdapter adapter) {
        adapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(adapter);
    }
}
