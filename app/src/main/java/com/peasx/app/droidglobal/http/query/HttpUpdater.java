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

    public HttpUpdater(String dbName, String tableName){
        this.dbName     = dbName;
        this.tableName  = tableName;
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

            if(!dbName.isEmpty()){
                json.put("db_name", dbName);
            }

            if(params != null){
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
    String tableName    = "";
    String dbName       = "";

}
