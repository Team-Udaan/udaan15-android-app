package com.varun.android.udaan_15.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.varun.android.udaan_15.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Varun Barad on 2015-03-18.
 */
public class PushNotification extends Activity {

    private final String PARSE_EXTRA_KEY = "com.parse.Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_push_notification);
        try {
            JSONObject json = new JSONObject(getIntent().getExtras().getString(PARSE_EXTRA_KEY));
            ((TextView) findViewById(R.id.textview_activity_push_notification_message)).setText(json.getString("alert"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
