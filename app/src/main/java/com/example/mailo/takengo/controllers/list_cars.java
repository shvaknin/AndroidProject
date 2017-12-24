package com.example.mailo.takengo.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.mailo.takengo.models.entities.Car;
import com.example.mailo.takengo.R;
import com.example.mailo.takengo.models.backend.DBManagerFactory;

import java.util.List;

public class list_cars extends Activity {

    private LinearLayout layout1;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cars);
        layout1 = (LinearLayout)findViewById(R.id.layout1);
        listView = (ListView)findViewById( R.id.listView );

        final List<Car> listOfProduct=DBManagerFactory.getManager().getCars();
        ArrayAdapter<Car> adapter = new ArrayAdapter<Car>(list_cars.this,R.layout.row_car , listOfProduct)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                if (convertView == null)
                {
                    convertView = View.inflate(list_cars.this, R.layout.row_car,null);

                }

                TextView productCarNumTextView = (TextView) convertView .findViewById(R.id.carNum);
                TextView productCarModelTextView = (TextView) convertView .findViewById(R.id.carModel);
                TextView productBranchNumTextView = (TextView) convertView .findViewById(R.id.branchNum);
                TextView productKilometersTextView = (TextView) convertView .findViewById(R.id.kilometers);


                productCarNumTextView.setText((((Integer)listOfProduct.get(position).getCarNum()).toString()));
                productCarModelTextView.setText((((Integer)listOfProduct.get(position).getCarModel()).toString()));
                productBranchNumTextView.setText((((Integer)listOfProduct.get(position).getBranchNum()).toString()));
                productKilometersTextView.setText((((Float)listOfProduct.get(position).getKilometers()).toString()));

                return convertView;

            }

        };
        listView.setAdapter(adapter);
         this.setContentView(layout1);
    }

}