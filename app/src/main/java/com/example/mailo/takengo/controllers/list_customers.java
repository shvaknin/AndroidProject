package com.example.mailo.takengo.controllers;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mailo.takengo.R;
import com.example.mailo.takengo.models.backend.DBManagerFactory;
import com.example.mailo.takengo.models.entities.*;
import com.example.mailo.takengo.models.entities.Customer;

import java.util.List;

public class list_customers extends Activity {


    private LinearLayout layout1;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_customers);
        layout1 = (LinearLayout)findViewById(R.id.layout1);
        listView = (ListView)findViewById( R.id.listView );

        final List<Customer> listOfProduct= DBManagerFactory.getManager().getCustomer();
        ArrayAdapter<Customer> adapter = new ArrayAdapter<Customer>(list_customers.this,R.layout.row_customer , listOfProduct)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                if (convertView == null)
                {
                    convertView = View.inflate(list_customers.this, R.layout.row_customer,null);

                }

                TextView productIdNumTextView = (TextView) convertView .findViewById(R.id.idNum);
                TextView productFamilyNameTextView = (TextView) convertView .findViewById(R.id.familyName);
                TextView productPrivateNameTextView = (TextView) convertView .findViewById(R.id.privateName);
                TextView productPhoneNumTextView = (TextView) convertView .findViewById(R.id.phoneNum);
                TextView productCreditNumTextView = (TextView) convertView .findViewById(R.id.creditNum);
                TextView productAddressMailTextView = (TextView) convertView .findViewById(R.id.addressMail);


                productIdNumTextView.setText((((Integer)listOfProduct.get(position).getIdNum()).toString()));
                productFamilyNameTextView.setText(((listOfProduct.get(position).getFamilyName()).toString()));
                productPrivateNameTextView.setText(((listOfProduct.get(position).getPrivateName()).toString()));
                productPhoneNumTextView.setText((((Integer)listOfProduct.get(position).getPhoneNum()).toString()));
                productCreditNumTextView.setText((((Integer)listOfProduct.get(position).getCreditNum()).toString()));
                productAddressMailTextView.setText(((listOfProduct.get(position).getAddressMail()).toString()));

                return convertView;

            }

        };
        listView.setAdapter(adapter);
        this.setContentView(layout1);
    }

    }
