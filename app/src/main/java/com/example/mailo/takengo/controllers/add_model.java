package com.example.mailo.takengo.controllers;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mailo.takengo.R;
import com.example.mailo.takengo.models.backend.DBManagerFactory;
import com.example.mailo.takengo.models.entities.*;

import static com.example.mailo.takengo.models.utils.Constants.CarModelToContentValues;
import static com.example.mailo.takengo.models.utils.Constants.CustomerToContentValues;

public class add_model extends Activity implements View.OnClickListener{


    private EditText modelCode;
    private EditText modelName;
    private EditText companyName;
    private EditText seats;
    private EditText engineCapacity;
    private Button addModel;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_model);
        findViews();
    }

    private void findViews() {
        modelCode = (EditText)findViewById( R.id.model_code );
        modelName = (EditText)findViewById( R.id.model_name );
        companyName = (EditText)findViewById( R.id.company_name );
        seats = (EditText)findViewById( R.id.seats );
        engineCapacity = (EditText)findViewById( R.id.engine_capacity );
        addModel = (Button)findViewById( R.id.add_model );

        spinner = (Spinner)findViewById( R.id.spinner );
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gearbox, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        addModel.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if ( v == addModel ) {
            addModel();
        }
    }

    private void addModel() {

        CarModel carModel=new CarModel();

        carModel.setModelCode(Integer.valueOf(this.modelCode.getText().toString()));
        carModel.setModelName(this.modelName.getText().toString());
        carModel.setCompanyName(this.companyName.getText().toString());
        carModel.setEngineCapacity(Float.valueOf(this.engineCapacity.getText().toString()));
        carModel.setSeats(Integer.valueOf(this.seats.getText().toString()));
        carModel.setGearbox(Gearbox.valueOf(this.spinner.getSelectedItem().toString()));

        final ContentValues contentValues=(CarModelToContentValues(carModel));

        new AsyncTask<Void, Void, Long>() {//all the act which connected with the backend will commited in AsyncTask

            @Override
            protected void onPostExecute(Long result) {
                super.onPostExecute(result);
                if (result ==0)//message for the user
                    Toast.makeText(getBaseContext(), "Successfully added!" , Toast.LENGTH_LONG).show();

                modelCode.getText().clear();//clear all the field after added
                modelName.getText().clear();
                companyName.getText().clear();
                engineCapacity.getText().clear();
                seats.getText().clear();
                //spinner
            }

            @Override
            protected Long doInBackground(Void... params) {
                return DBManagerFactory.getManager().addCarModel(contentValues);
            }

        }.execute();

    }
}
