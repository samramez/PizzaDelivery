package com.example.samramezanli.pizzadelivery;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Adapter extends RecyclerView.Adapter<Adapter.ListViewHolder> {


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    protected class ListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.x_cordinate_edit_text) EditText x_value;
        @BindView(R.id.y_cordinate_edit_text) EditText y_value;

        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
