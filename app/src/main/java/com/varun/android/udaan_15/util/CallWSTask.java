package com.varun.android.udaan_15.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.varun.android.udaan_15.helpers.JSONHelpers;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Varun Barad on 2015-03-17.
 */
public class CallWSTask extends AsyncTask<Object, Integer, String> {

    private GetJSONListener getJSONListener;
    private String responseStr;
    private String mType;
    private int pos;
    private Context mContext;
    private ArrayList<BasicNameValuePair> postParameters;

    public CallWSTask(Context context,GetJSONListener listener) {
        this.getJSONListener = listener;
        this.mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Object... urls) {

        DefaultHttpClient client = JSONHelpers.getNewHttpClient();

        ((ArrayList<BasicNameValuePair>) urls[1]).add(new BasicNameValuePair("auth-key", "123456798"));
        postParameters = (ArrayList<BasicNameValuePair>) urls[1];

        HttpPost httpPost = new HttpPost(urls[0].toString());
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(postParameters));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            HttpResponse execute = client.execute(httpPost);
            HttpEntity entity = execute.getEntity();
            responseStr = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseStr;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        this.getJSONListener.onRemoteCallComplete(responseStr);
    }
}
