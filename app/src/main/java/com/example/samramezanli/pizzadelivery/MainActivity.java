package com.example.samramezanli.pizzadelivery;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.samramezanli.pizzadelivery.Direction.*;

public class MainActivity extends AppCompatActivity implements AddCoordinateDialog.OnAddNewItemListener {

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

    @OnClick(R.id.get_result_buttn) void getResult() {

        String result = "";
        Coordinate currentCoordinate = new Coordinate(0,0);
        List<Coordinate> coordinates = adapter.getCoordinates();

        for (Coordinate destCoordinate : coordinates) {

            int x = destCoordinate.getXValue() - currentCoordinate.getXValue();
            int y = destCoordinate.getYValue() - currentCoordinate.getYValue();

            if (x == 0 && y == 0) {
                result += DROP;
            }
            else {
                result = getXDirection(result, x);
                result = getYDirection(result, y);
                result += DROP;
            }
            currentCoordinate.setCoordinate(destCoordinate.getXValue(), destCoordinate.getYValue());
        }
        resultText.setText(result);
    }

    @OnClick(R.id.add_row_button) void addRowButton() {
        showAddValueDialog();
    }

    private void showAddValueDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        AddCoordinateDialog addNewCoordinateDialogFragment = new AddCoordinateDialog();
        addNewCoordinateDialogFragment.setListener(this);
        addNewCoordinateDialogFragment.show(fragmentManager, AddCoordinateDialog.class.getSimpleName());
    }

    @Override
    public void onAddItemListener(int x, int y) {
        adapter.add(new Coordinate(x,y));
    }
}
