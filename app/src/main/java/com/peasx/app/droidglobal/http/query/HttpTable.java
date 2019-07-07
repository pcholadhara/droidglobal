package com.peasx.app.droidglobal.http.query;

import android.util.Log;

import com.peasx.app.droidglobal.http.connect.JSONResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class HttpTable {
    public HttpTable(String tableName){
        this.tableName = tableName;
    }

    public HttpTable(String dbName, String tableName){
        this.dbName     = dbName;
        this.tableName  = tableName;
    }

    public HttpTable setColumns(JSONObject json) {
        this.json = json;
        return this;
    }


    public HashMap<String, String> getMap(){
        HashMap<String, String> map = new HashMap<>();

        try {
            json.put("table_name", tableName);

            if(!dbName.isEmpty()){
                json.put("db_name", dbName);
            }

            map.put("json", json.toString());
        } catch (JSONException ex){
            Log.d(JSONResponse.ERROR_TAG, ""+ex.toString());
        }
        return map;
    }


    JSONObject json;
    String tableName    = "";
    String dbName       = "";
}
