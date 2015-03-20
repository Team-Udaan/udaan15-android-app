package com.varun.android.udaan_15.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.varun.android.udaan_15.R;

/**
 * Created by Varun Barad on 2015-03-18.
 */
public class HomeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.FILENAME_LOGIN_DETAILS), Context.MODE_PRIVATE);
        if(sharedPreferences != null) {
            if(!sharedPreferences.getBoolean(getString(R.string.KEY_INITIALIZED), false)) {
                this.setContentView(R.layout.activity_initialize);
            } else {
                String userType = sharedPreferences.getString(getString(R.string.KEY_USER_TYPE), null);
                if(userType != null) {
                    if(userType.equals("Participant")) {

                    } else if(userType.equals("Manager")) {

                    } else {
                        this.setContentView(R.layout.activity_initialize);
                    }
                } else {
                    this.setContentView(R.layout.activity_initialize);
                }
            }
        } else {
            this.setContentView(R.layout.activity_initialize);
        }
    }

    public void onClick(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.FILENAME_LOGIN_DETAILS), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(view.getId() == R.id.button_activity_initialize_participant) {
            editor.putBoolean(getString(R.string.KEY_INITIALIZED), true);
            editor.putString(getString(R.string.KEY_USER_TYPE), "Participant");
            editor.apply();
        } else if(view.getId() == R.id.button_activity_initialize_administration) {
            editor.putBoolean(getString(R.string.KEY_INITIALIZED), true);
            editor.apply();
        }
    }
}
