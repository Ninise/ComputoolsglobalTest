package com.ninise.computoolsglobaltest.mvp.model.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ninise.computoolsglobaltest.R;
import com.ninise.computoolsglobaltest.mvp.model.entities.CardViewEntity;
import com.ninise.computoolsglobaltest.mvp.model.viewholders.CardViewViewHolder;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewViewHolder> {

    private List<CardViewEntity> mDataSet;

    public CardViewAdapter(List<CardViewEntity> dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardViewViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {
        holder.mTitleTextView.setText(mDataSet.get(holder.getAdapterPosition()).getTitle());
        holder.mDesrpTextView.setText(mDataSet.get(holder.getAdapterPosition()).getDesrp());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
