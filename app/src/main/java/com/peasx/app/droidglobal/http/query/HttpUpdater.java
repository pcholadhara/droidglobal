package com.peasx.app.droidglobal.http.query;

import android.util.Log;

import com.peasx.app.droidglobal.http.connect.JSONResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class HttpUpdater {

    public HttpUpdater(String tableName){
        this.tableName = tableName;
    }

    public HttpUpdater setColumns(JSONObject json) {
        this.json = json;
        return this;
    }

    public HttpUpdater setParams(JSONObject params) {
        this.params = params;
        return this;
    }

    public HashMap<String, String> getMap(){
        HashMap<String, String> map = new HashMap<>();

        try {
            json.put("table_name", tableName);
            if(!params.toString().isEmpty()){
                json.put("param", params);
            }
            map.put("json", json.toString());
        } catch (JSONException ex){
            Log.d(JSONResponse.ERROR_TAG, ""+ex.toString());
        }
        return map;
    }


    JSONObject json;
    JSONObject params;
    String tableName = "";

}
