package com.ninise.computoolsglobaltest.mvp.model.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ninise.computoolsglobaltest.R;

public class CardViewViewHolder extends RecyclerView.ViewHolder {

    public final CardView mCardView;
    public final TextView mTitleTextView;
    public final TextView mDesrpTextView;

    public CardViewViewHolder(View itemView) {
        super(itemView);
        mCardView = (CardView) itemView.findViewById(R.id.cv);
        mTitleTextView = (TextView) itemView.findViewById(R.id.titleCardView);
        mDesrpTextView = (TextView) itemView.findViewById(R.id.desrpCardView);
    }
}
