package com.ninise.computoolsglobaltest.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ninise.computoolsglobaltest.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SocketFragment extends Fragment {

    @Bind(R.id.socketEditText) EditText mGetEditText;
    @Bind(R.id.socketGetButton) Button mGetButton;
    @Bind(R.id.socketGetTextView) TextView mGetTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.socket_layout, container, false);

        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
