package com.example.samramezanli.pizzadelivery;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddCoordinateDialog extends DialogFragment {

    @BindView(R.id.x_edit_text) EditText xEditText;
    @BindView(R.id.y_edit_text) EditText yEditText;

    private OnAddNewItemListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_fragment, container);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }

    @OnClick(R.id.cancel) void onCancelClicked() {
        getDialog().dismiss();
    }

    @OnClick(R.id.add) void onAddClicked() {

        if (xEditText.getText().toString().isEmpty() || yEditText.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show();
            return;
        }
        int x =  Integer.valueOf(xEditText.getText().toString());
        int y =  Integer.valueOf(yEditText.getText().toString());

        listener.onAddItemListener(x, y);

        getDialog().dismiss();
    }

    public void setListener(OnAddNewItemListener listener) {
        this.listener = listener;
    }

    interface OnAddNewItemListener {
        void onAddItemListener(int x, int y);
    }

}
