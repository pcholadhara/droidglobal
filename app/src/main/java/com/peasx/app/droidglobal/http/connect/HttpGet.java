package com.peasx.app.droidglobal.http.connect;


import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class HttpGet {
    Context context;
    public HttpGet(Context context){
        this.context = context;
    }

    public HttpGet setUrl(String url){
        this.url = url;
        return this;
    }

    public HttpGet addParam(String key, String value){
           this.url = url+ "?" + key + "=" + value;
           return this;
    }

    public HttpGet and(String key, String value){
           this.url = "&"+ key + "=" + value;
           return this;
    }


    public void getResponse(final GetCallback calback){
        this.networkError = new NetworkError(context);
        Log.d(NetRequest.TAG, url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        calback.onSuccess(response);
                    }
                },
                networkError
        );

        request.setRetryPolicy(new DefaultRetryPolicy(10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        request.setTag(NetRequest.TAG);
        NetRequest.getInstance(context).addToRequestQueue(request);
    }


    public void sendGetRequest(String url){
        this.networkError = new NetworkError(context);
        Log.d(NetRequest.TAG, url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                },
                networkError
        );

        request.setRetryPolicy(new DefaultRetryPolicy(10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        request.setTag(NetRequest.TAG);
        NetRequest.getInstance(context).addToRequestQueue(request);
    }



    NetworkError networkError;
    String url = "";


}
