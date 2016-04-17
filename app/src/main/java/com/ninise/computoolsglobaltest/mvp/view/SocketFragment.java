package com.ninise.computoolsglobaltest.mvp.view;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
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
    @BindString(R.string.edit_is_empty) String mEditIsEmpty;
    @BindString(R.string.no_response_from) String mNoResponseFrom;

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

        mGetTextView.setMovementMethod(new ScrollingMovementMethod());

        RxView.clicks(mGetButton).subscribe(aVoid -> mPresenter.getResponse(getActivity(), mGetEditText.getText().toString()));

        return v;
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    @Override
    public void networkNotFound() {
        Toast.makeText(getActivity(), mNetworkStateFalse, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void displayResponse(String response) {
        mGetTextView.setText(mGetString + " " + response);
    }

    @Override
    public void disposeProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public void startProgress() {
        mProgressDialog = ProgressDialog.show(getActivity(), mProgressDialogTitle, mProgressDialogMessage);
    }

    @Override
    public void editIsEmpty() {
        Toast.makeText(getActivity(), mEditIsEmpty, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noResponseFrom(String url) {
        Toast.makeText(getActivity(), mNoResponseFrom + " " + url, Toast.LENGTH_SHORT).show();
    }
}
