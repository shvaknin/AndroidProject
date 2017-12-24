package com.example.mailo.takengo.controllers;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mailo.takengo.R;

public class Model extends AppCompatActivity implements View.OnClickListener{

    private Button addModel;
    private Button showModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model);
        findViews();
    }

    private void findViews() {
        addModel = (Button)findViewById( R.id.add_model );
        showModels = (Button)findViewById( R.id.show_models );

        addModel.setOnClickListener( this );
        showModels.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if ( v == addModel ) {
            addModel();
        } else if ( v == showModels ) {
            showModels();
        }
    }

    private void addModel() {
        Intent intent = new Intent(Model.this,add_model.class);
        startActivity(intent);
        return;
    }

    private void showModels() {
        Intent intent = new Intent(Model.this,list_models.class);
        startActivity(intent);
        return;
    }
}
