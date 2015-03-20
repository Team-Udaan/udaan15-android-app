package com.varun.android.udaan_15.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Varun Barad on 2015-03-17.
 */
public class GeneralUtilities {

    private static final String NO_INTERNET_CONNECTION_MESSAGE = "\nSorry! No Active Internet Connection.\n\nPress settings and activate your data connection and try again.\n";

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni!=null && ni.isAvailable() && ni.isConnected()) {
            return true;
        } else {
            showNoInternetPopup(context);
            return false;
        }
    }

    public static void showNoInternetPopup(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Error");
        builder.setMessage(NO_INTERNET_CONNECTION_MESSAGE)
                .setCancelable(false)
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        ((Activity)context).finish();
                    }
                });
        builder.setNegativeButton("Settings", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                dialog.cancel();
                ((Activity)context).finish();
            }
        });
        builder.show();
    }

}
