package com.example.samramezanli.pizzadelivery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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

        View view = inflater.inflate(R.layout.item_recyclerview, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, final int position) {

        Coordinate coordinate = coordinates.get(position);

        holder.xValueText.setText(String.valueOf(coordinate.getXValue()));

        holder.yValueText.setText(String.valueOf(coordinate.getYValue()));

        handleDeleteButton(holder);
    }

    @Override
    public int getItemCount() {
        return coordinates.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    void add(Coordinate coordinate) {
        coordinates.add(coordinate);
        notifyItemInserted(coordinates.size());
    }

    private void handleDeleteButton(final ListViewHolder holder) {
        holder.deleteRowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("##", "coordinates.size() before: " + coordinates.size());
                int position = holder.getAdapterPosition();
                coordinates.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, coordinates.size());
                Log.e("##", "coordinates.size() after: " + coordinates.size());
            }
        });
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.x_cordinate_edit_text) TextView xValueText;
        @BindView(R.id.y_cordinate_edit_text) TextView yValueText;
        @BindView(R.id.delete_row_button) ImageButton deleteRowButton;

        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
