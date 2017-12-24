package com.example.mailo.takengo.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mailo.takengo.R;
import com.example.mailo.takengo.models.backend.DBManagerFactory;


import static com.example.mailo.takengo.models.utils.Constants.BranchToContentValues;

/**
 * Created by USER on 21/11/2017.
 */

public class Branch  extends Activity implements View.OnClickListener {
    private Button showBranches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.branch);
        findViews();
    }

    private void findViews() {

        showBranches = (Button)findViewById( R.id.show_Branches );
        showBranches.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==showBranches)
            showBranches();

    }

    private void showBranches() {
        Intent intent = new Intent(Branch.this,list_branches.class);
        startActivity(intent);
        return;
    }

}
