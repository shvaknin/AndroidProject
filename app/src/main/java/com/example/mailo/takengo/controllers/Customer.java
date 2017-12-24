package com.example.mailo.takengo.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mailo.takengo.R;

/**
 * Created by USER on 19/11/2017.
 */

public class Customer extends Activity implements View.OnClickListener{

    private Button addCustomer;
    private Button showCustomers;

    private void findViews() {
        addCustomer = (Button)findViewById( R.id.add_customer );
        showCustomers = (Button)findViewById( R.id.show_customers );

        addCustomer.setOnClickListener( this );
        showCustomers.setOnClickListener( this );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if ( v == addCustomer ) {
            addCustomer();
        } else if ( v == showCustomers ) {
            showCustomers();
        }
    }

    private void addCustomer() {
        Intent intent = new Intent(Customer.this,add_customer.class);
        startActivity(intent);
        return;
    }
    private void showCustomers() {
        Intent intent = new Intent(Customer.this,list_customers.class);
        startActivity(intent);
        return;
    }

}
