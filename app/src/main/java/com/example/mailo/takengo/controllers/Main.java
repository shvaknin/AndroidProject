package com.example.mailo.takengo.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mailo.takengo.R;
import com.example.mailo.takengo.models.utils.Constants;

/**
 * Created by USER on 19/11/2017.
 */

public class Main extends Activity implements View.OnClickListener {


    private TextView welcomeTextView;
    private TextView UserTextView;
    private Button UserButton;
    private Button CarButton;
    private Button ModelsButton;
    private Button BranchesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViews();

        Intent iin= getIntent();//set the user name in the ui
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            String s =(String) b.get(Constants.UserConst.USER_NAME);
            UserTextView.setText(s);
        }
    }

    private void findViews() {
        welcomeTextView = (TextView)findViewById( R.id.welcome_textView );
        UserTextView = (TextView)findViewById( R.id.textView2);
        UserButton = (Button)findViewById( R.id.User_button );
        CarButton = (Button)findViewById( R.id.Car_button );
        ModelsButton = (Button)findViewById( R.id.Models_button );
        BranchesButton = (Button)findViewById( R.id.Branches_button );

        UserButton.setOnClickListener( this );
        CarButton.setOnClickListener( this );
        ModelsButton.setOnClickListener( this );
        BranchesButton.setOnClickListener( this );
    }



    private void setCustomerButton() {
        Intent intent = new Intent(Main.this,Customer.class);
        startActivity(intent);
        return;
    }


    private void setCarButton() {
        Intent intent = new Intent(Main.this,Car.class);
        startActivity(intent);
        return;
    }

    private void setModelsButton() {
        Intent intent = new Intent(Main.this,Model.class);
        startActivity(intent);
        return;
    }

    private void setBranchesButton() {
        Intent intent = new Intent(Main.this,Branch.class);
        startActivity(intent);
        return;
    }


    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-29 20:53:53 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == UserButton ) {
            setCustomerButton();
        } else if ( v == CarButton ) {
                setCarButton();
        } else if ( v == ModelsButton ) {
                setModelsButton();
        } else if ( v == BranchesButton ) {
                setBranchesButton();
        }
    }

}

