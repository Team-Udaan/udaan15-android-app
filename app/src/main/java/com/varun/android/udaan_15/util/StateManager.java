package com.varun.android.udaan_15.util;

import android.app.Application;

import com.parse.Parse;
import com.parse.PushService;
import com.varun.android.udaan_15.R;
import com.varun.android.udaan_15.activities.PushNotification;

import java.util.ArrayList;

/**
 * Created by Varun Barad on 2015-03-18.
 */
public class StateManager extends Application {

    private ArrayList<String> channels;

    public ArrayList<String> getChannels() {
        return(channels);
    }

    public void setChannels(ArrayList<String> channels) {
        this.channels = channels;
    }

    public void addChannel(String channel) {
        if(this.channels == null) {
            this.channels = new ArrayList<String>();
        }
        this.channels.add(channel);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, getString(R.string.PARSE_APPLICATION_KEY), getString(R.string.PARSE_CLIENT_KEY));
        PushService.setDefaultPushCallback(this, PushNotification.class);
    }
}
