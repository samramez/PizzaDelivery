package com.example.samramezanli.pizzadelivery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Adapter extends RecyclerView.Adapter<Adapter.ListViewHolder> {


    private List<Coordinate> coordinates;

    public Adapter(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_recyclerview, parent, false);

        return new ListViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

        Coordinate coordinate = coordinates.get(position);

        holder.xValueEditText.setText(coordinate.getXValue(), TextView.BufferType.EDITABLE);
        holder.yValueEditText.setText(coordinate.getYValue(), TextView.BufferType.EDITABLE);
    }

    @Override
    public int getItemCount() {
        return coordinates.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    class ListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.x_cordinate_edit_text)
        EditText xValueEditText;
        @BindView(R.id.y_cordinate_edit_text)
        EditText yValueEditText;

        ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
