package com.example.mailo.takengo.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mailo.takengo.R;
import com.example.mailo.takengo.models.utils.Constants;

public class Car extends AppCompatActivity implements View.OnClickListener {


    private Button addCar;
    private Button showCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car);
        findViews();
    }
    private void findViews() {
        addCar = (Button)findViewById( R.id.add_car );
        showCars = (Button)findViewById( R.id.show_cars );

        addCar.setOnClickListener( this );
        showCars.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if ( v == addCar ) {
            addCar();
        } else if ( v == showCars ) {
            showCars();
        }
    }

    private void addCar() {
        Intent intent = new Intent(Car.this,add_car.class);
        startActivity(intent);
        return;
    }

    private void showCars() {
        Intent intent = new Intent(Car.this,list_cars.class);
        startActivity(intent);
        return;
    }

}
