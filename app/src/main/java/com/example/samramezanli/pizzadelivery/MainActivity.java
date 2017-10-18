package com.example.samramezanli.pizzadelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView recycleView;
    @BindView(R.id.add_row_button) ImageButton addRowButton;
    @BindView(R.id.result_text) TextView resultText;

    private List<Coordinate> coordinates;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        coordinates = Coordinate.getTestCoordinates();

        adapter = new Adapter(coordinates);

        recycleView.setAdapter(adapter);

        recycleView.setLayoutManager(new LinearLayoutManager(this));

    }
}
