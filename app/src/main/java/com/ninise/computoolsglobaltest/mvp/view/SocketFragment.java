package com.ninise.computoolsglobaltest.mvp.view;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.ninise.computoolsglobaltest.R;
import com.ninise.computoolsglobaltest.mvp.presenter.socket.ISocketView;
import com.ninise.computoolsglobaltest.mvp.presenter.socket.SocketPresenter;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

public class SocketFragment extends Fragment implements ISocketView {

    @Bind(R.id.socketEditText) EditText mGetEditText;
    @Bind(R.id.socketGetButton) Button mGetButton;
    @Bind(R.id.socketGetTextView) TextView mGetTextView;
    @BindString(R.string.network_not_found) String mNetworkStateFalse;
    @BindString(R.string.socket_get_textview) String mGetString;
    @BindString(R.string.progress_dialog_title) String mProgressDialogTitle;
    @BindString(R.string.progress_dialog_message) String mProgressDialogMessage;

    private SocketPresenter mPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new SocketPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.socket_layout, container, false);

        ButterKnife.bind(this, v);

        RxView.clicks(mGetButton).subscribe(
                aVoid -> {
                    mProgressDialog = ProgressDialog.show(getActivity(), mProgressDialogTitle, mProgressDialogMessage);
                    mPresenter.getResponse(getActivity(), mGetEditText.getText().toString());
                }
        );

        return v;
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    @Override
    public void responseFailed() {
        Toast.makeText(getActivity(), mNetworkStateFalse, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void displayResponse(String response) {
        mProgressDialog.dismiss();
        mGetTextView.setText(mGetString + " " + response);
    }
}
