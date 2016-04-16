package com.ninise.computoolsglobaltest.mvp.model.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ninise.computoolsglobaltest.R;
import com.ninise.computoolsglobaltest.mvp.activities.ActivitiesCounter;
import com.ninise.computoolsglobaltest.mvp.model.entities.CardViewEntity;
import com.ninise.computoolsglobaltest.mvp.model.network.NetworkConnection;
import com.ninise.computoolsglobaltest.mvp.model.viewholders.CardViewViewHolder;
import com.ninise.computoolsglobaltest.utils.Constants;

import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<CardViewViewHolder> {

    private List<CardViewEntity> mDataSet;
    private Context mContext;

    public MediaAdapter(Context context, List<CardViewEntity> dataSet) {
        mDataSet = dataSet;
        mContext = context;
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


           holder.mCardView.setOnClickListener(view -> {
               if (NetworkConnection.isNetworkConnectionOn(mContext)) {

                   Intent intent = new Intent(Intent.ACTION_SEND);
                   intent.setType(Constants.EMAIL_TYPE);
                   intent.putExtra(Intent.EXTRA_STREAM,
                           Uri.parse("file://" + mDataSet.get(holder.getAdapterPosition()).getDesrp()));

                   mContext.startActivity(Intent.createChooser(intent, Constants.SEND_EMAIL));

                   ActivitiesCounter
                           .getInstance()
                           .addActivity(new CardViewEntity(
                                   Constants.FROM_MEDIA,
                                   Constants.SEND_EMAIL)
                           );
               } else {
                     Toast.makeText(
                           mContext,
                           mContext.getResources().getText(R.string.network_not_found),
                           Toast.LENGTH_SHORT)
                           .show();
               }
           });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
