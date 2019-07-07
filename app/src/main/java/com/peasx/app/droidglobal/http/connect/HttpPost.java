package com.peasx.app.droidglobal.http.connect;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class HttpPost {
    public HttpPost(Context context)
    {this.context = context;}

    public HttpPost setParams(Map<String,String> params){
        this.params = params;
        return this;
    }

    public HttpPost setUrl(String url){
        this.url = url;
        return this;
    }

    public void getResponse(final PostCallback callback) {
        Log.d(NetRequest.TAG, url);
        StringRequest request = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String object) {
                        callback.onSuccess(object);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
                ){
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        request.setTag(NetRequest.TAG);
        NetRequest.getInstance(context).addToRequestQueue(request);
    }

/*---------------------------------------------------------------------*/
    Context context;
    Map<String,String> params;
    String url;

}
