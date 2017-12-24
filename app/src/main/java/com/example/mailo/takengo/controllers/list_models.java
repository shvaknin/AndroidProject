package com.example.mailo.takengo.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mailo.takengo.R;
import com.example.mailo.takengo.models.backend.DBManagerFactory;
import com.example.mailo.takengo.models.entities.*;

import java.util.List;

public class list_models extends AppCompatActivity {

    private LinearLayout layout1;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_models);
        layout1 = (LinearLayout)findViewById(R.id.layout1);
        listView = (ListView)findViewById( R.id.listView );

        final List<CarModel> listOfProduct= DBManagerFactory.getManager().getCarModel();
        ArrayAdapter<CarModel> adapter = new ArrayAdapter<CarModel>(list_models.this,R.layout.row_model ,listOfProduct)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                if (convertView == null)
                {
                    convertView = View.inflate(list_models.this, R.layout.row_model,null);

                }

                TextView productModelCodeTextView = (TextView) convertView .findViewById(R.id.modelCode);
                TextView productCompanyNameTextView = (TextView) convertView .findViewById(R.id.companyName);
                TextView productModelNameTextView = (TextView) convertView .findViewById(R.id.modelName);
                TextView productEngineCapacityTextView = (TextView) convertView .findViewById(R.id.engineCapacity);
                TextView productGearboxTextView = (TextView) convertView .findViewById(R.id.gearbox);
                TextView productSeatsTextView = (TextView) convertView .findViewById(R.id.seats);


                productModelCodeTextView.setText((((Integer)listOfProduct.get(position).getModelCode()).toString()));
                productCompanyNameTextView.setText(((listOfProduct.get(position).getCompanyName()).toString()));
                productModelNameTextView.setText(((listOfProduct.get(position).getModelName()).toString()));
                productEngineCapacityTextView.setText((((Float)listOfProduct.get(position).getEngineCapacity()).toString()));
                productGearboxTextView.setText(((listOfProduct.get(position).getGearbox()).toString()));
                productSeatsTextView.setText((((Integer)listOfProduct.get(position).getSeats()).toString()));

                return convertView;

            }

        };
        listView.setAdapter(adapter);
        this.setContentView(layout1);
    }

}
