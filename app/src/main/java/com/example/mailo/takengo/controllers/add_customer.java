package com.example.mailo.takengo.controllers;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mailo.takengo.R;
import com.example.mailo.takengo.models.backend.DBManagerFactory;
import com.example.mailo.takengo.models.entities.Customer;

import static com.example.mailo.takengo.models.utils.Constants.CustomerToContentValues;

public class add_customer extends Activity implements View.OnClickListener {


    private EditText idNum;
    private EditText familyName;
    private EditText privateName;
    private EditText phoneNum;
    private EditText creditNum;
    private EditText addressMail;
    private Button addCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        findViews();
    }

    private void findViews() {
        idNum = (EditText)findViewById( R.id.id_num );
        familyName = (EditText)findViewById( R.id.family_name );
        privateName = (EditText)findViewById( R.id.private_name );
        phoneNum = (EditText)findViewById( R.id.phone_num );
        creditNum = (EditText)findViewById( R.id.credit_num );
        addressMail = (EditText)findViewById( R.id.mail_address);
        addCustomer = (Button)findViewById( R.id.add_customer );

        addCustomer.setOnClickListener( this );
    }


    @Override
    public void onClick(View v) {
        if ( v == addCustomer )
            addCustomer();
    }

    private void addCustomer() {


        Customer customer=new Customer();
        customer.setIdNum(Integer.valueOf(this.idNum.getText().toString()));
        customer.setFamilyName(this.familyName.getText().toString());
        customer.setPrivateName(this.privateName.getText().toString());
        customer.setPhoneNum(Integer.valueOf(this.phoneNum.getText().toString()));
        customer.setCreditNum(Integer.valueOf(this.creditNum.getText().toString()));
        customer.setAddressMail(this.addressMail.getText().toString());

        final ContentValues contentValues=(CustomerToContentValues(customer));

        new AsyncTask<Void, Void, Long>() {//all the act which conected with the backend will commited in AsyncTask

            @Override
            protected void onPostExecute(Long result) {
                super.onPostExecute(result);
                if (result ==0)//message for the user
                    Toast.makeText(getBaseContext(), "Successfully added!" , Toast.LENGTH_LONG).show();

                idNum.getText().clear();//clear all the field after added
                familyName.getText().clear();
                privateName.getText().clear();
                phoneNum.getText().clear();
                creditNum.getText().clear();
                addressMail.getText().clear();
            }

            @Override
            protected Long doInBackground(Void... params) {
                return DBManagerFactory.getManager().addCustomer(contentValues);
            }

        }.execute();

    }
    }

