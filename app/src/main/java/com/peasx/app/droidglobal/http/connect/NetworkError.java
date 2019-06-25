package com.peasx.app.droidglobal.http.connect;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class NetworkError implements Response.ErrorListener{
    public NetworkError(Context ctx){
        this.context = ctx;
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        try {
            Log.d(TAG, error.getMessage());
            Toast.makeText(context, "Network error", Toast.LENGTH_LONG).show();
        } catch (Exception ex){
            Toast.makeText(context, "Network error", Toast.LENGTH_LONG).show();
        }
    }


    String TAG = "NETWORK";
    Context context;
}
