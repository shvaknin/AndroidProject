package com.example.mailo.takengo.controllers;

import android.app.Activity;
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
import com.example.mailo.takengo.models.entities.Branch;

import java.util.List;

import static com.example.mailo.takengo.models.utils.Constants.BranchToContentValues;

public class list_branches extends Activity {


    private LinearLayout layout1;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_branches);
        layout1 = (LinearLayout)findViewById(R.id.layout1);
        listView = (ListView)findViewById( R.id.listView );

        Branch b=new Branch(9,6,"telaviv","yapo",7);
        DBManagerFactory.getManager().addBranch(BranchToContentValues(b));

        final List<Branch> listOfProduct= DBManagerFactory.getManager().getBranches();

        ArrayAdapter<Branch> adapter = new ArrayAdapter<Branch>(list_branches.this,R.layout.row_branch, listOfProduct)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                if (convertView == null)
                {
                    convertView = View.inflate(list_branches.this, R.layout.row_branch,null);

                }

                TextView productNumBranchTextView = (TextView) convertView .findViewById(R.id.numBranch);
                TextView productNumOfParkingSpacesTextView = (TextView) convertView .findViewById(R.id.numOfParkingSpaces);
                TextView productCityTextView = (TextView) convertView .findViewById(R.id.city);
                TextView productStreetTextView = (TextView) convertView .findViewById(R.id.street);
                TextView productNumberTextView = (TextView) convertView .findViewById(R.id.number);

                productNumBranchTextView.setText((((Integer)listOfProduct.get(position).getNumBranch()).toString()));
                productNumOfParkingSpacesTextView.setText((((Integer)listOfProduct.get(position).getNumOfParkingSpaces()).toString()));
                productCityTextView.setText(((listOfProduct.get(position).getCity()).toString()));
                productStreetTextView.setText(((listOfProduct.get(position).getStreet()).toString()));
                productNumberTextView.setText((((Integer)listOfProduct.get(position).getNumber()).toString()));

                return convertView;

            }

        };
        listView.setAdapter(adapter);
        this.setContentView(layout1);
    }

}
