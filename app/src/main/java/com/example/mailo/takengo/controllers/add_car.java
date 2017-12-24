package com.example.mailo.takengo.controllers;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mailo.takengo.R;
import com.example.mailo.takengo.models.backend.DBManagerFactory;
import com.example.mailo.takengo.models.entities.Car;
import com.example.mailo.takengo.models.entities.CarModel;

import java.util.List;

import static com.example.mailo.takengo.models.utils.Constants.CarToContentValues;

public class add_car extends Activity implements View.OnClickListener {

    private EditText carNum;
    private Spinner carModel;
    private EditText branchNum;
    private EditText kilometers;
    private Button addCar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        findViews();
    }


    private void findViews() {

        carNum = (EditText) findViewById(R.id.car_num);
        carModel = (Spinner) findViewById(R.id.spinner2);
        branchNum = (EditText) findViewById(R.id.branch_num);
        kilometers = (EditText) findViewById(R.id.kilometers);
        addCar = (Button) findViewById(R.id.add_car);

         List<CarModel> spinnerArray= DBManagerFactory.getManager().getCarModel();
        ArrayAdapter<CarModel> adapter =
                new ArrayAdapter<CarModel>
                        ( this,android.R.layout.simple_spinner_dropdown_item,spinnerArray);
        carModel.setAdapter(adapter);
        addCar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == addCar) {
            setAddCar();
        }
    }

    private void setAddCar() {

        Car car = new Car();
        car.setBranchNum(Integer.valueOf(this.branchNum.getText().toString()));
        String string =this.carModel.getSelectedItem().toString();
        String[] bits = string.split(" ", -1);
        car.setCarModel(Integer.valueOf(bits[bits.length-1]));
        car.setCarNum(Integer.valueOf(this.carNum.getText().toString()));
        car.setKilometers(Float.valueOf(this.kilometers.getText().toString()));

        final ContentValues contentValues = (CarToContentValues(car));

        new AsyncTask<Void, Void, Long>() {//all the act which conected with the backend will commited in AsyncTask

            @Override
            protected void onPostExecute(Long result) {
                super.onPostExecute(result);
                if (result == 0)//message for the user
                    Toast.makeText(getBaseContext(), "Successfully added!", Toast.LENGTH_LONG).show();

                branchNum.getText().clear();//clear all the field after added
                carNum.getText().clear();
                kilometers.getText().clear();
                //spinner
            }

            @Override
            protected Long doInBackground(Void... params) {
                return DBManagerFactory.getManager().addCar(contentValues);
            }

        }.execute();

    }
}
