package com.example.mailo.takengo.controllers;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mailo.takengo.R;
import com.example.mailo.takengo.models.backend.DBManagerFactory;
import com.example.mailo.takengo.models.entities.*;
import com.example.mailo.takengo.models.entities.Branch;
import com.example.mailo.takengo.models.utils.Constants;

import static com.example.mailo.takengo.models.utils.Constants.BranchToContentValues;
import static com.example.mailo.takengo.models.utils.Constants.CarToContentValues;
import static com.example.mailo.takengo.models.utils.Constants.UserToContentValues;

/**
 * Created by USER on 21/11/[2017.
 */

public class Login extends Activity implements View.OnClickListener{

    private EditText editText;
    private EditText editText2;
    private Button loginButton;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        findViews();

       }

    private void findViews(){
        loginButton=(Button)findViewById(R.id.button1);
        signUpButton=(Button)findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        loginButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
        editText.setOnClickListener(this);
        editText2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==loginButton)
            setLoginButton();
        if(v==signUpButton)
            setSignUpButton();
    }
    private void setLoginButton() {

        final User u = new User();
        u.setUserName(editText.getText().toString());
        u.setPassword(editText2.getText().toString());

        final ContentValues contentValues=(UserToContentValues(u));

        new AsyncTask<Void, Void, Long>() {
            @Override
            protected void onPostExecute(Long result) {
                super.onPostExecute(result);
                if (result == 1){
                    Intent intent = new Intent(Login.this,Main.class);
                    intent.putExtra(Constants.UserConst.USER_NAME,u.getUserName());
                    intent.putExtra(Constants.UserConst.PASSWORD,u.getPassword());
                    startActivity(intent);
                }
                else
                    Toast.makeText(getBaseContext(), u.getUserName()+" isn't exist!" , Toast.LENGTH_LONG).show();

            }

            @Override
            protected Long doInBackground(Void... params) {
                return Long.valueOf(DBManagerFactory.getManager().isExists(contentValues));
            }
        }.execute();
    }

    private void setSignUpButton(){
        final User u = new User();
        u.setUserName(editText.getText().toString());
        u.setPassword(editText2.getText().toString());

        final ContentValues contentValues=(UserToContentValues(u));

        new AsyncTask<Void, Void, Long>() {

            @Override
            protected Long doInBackground(Void... params) {
                return DBManagerFactory.getManager().addUser(contentValues);
            }

            @Override
            protected void onPostExecute(Long result) {
                super.onPostExecute(result);

                if (result >0)//message for the user
                    Toast.makeText(getBaseContext(), "Successfully added!" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Login.this,Main.class);
                intent.putExtra(Constants.UserConst.USER_NAME,u.getUserName());
                intent.putExtra(Constants.UserConst.PASSWORD,u.getPassword());
                startActivity(intent);

            }

        }.execute();


    }

}
