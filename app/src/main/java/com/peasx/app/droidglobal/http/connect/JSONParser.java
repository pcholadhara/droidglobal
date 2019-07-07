package com.peasx.app.droidglobal.http.connect;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser implements JSONResponse{
    public JSONParser(String jsonString){
        this.jsonString = jsonString;
    }

    public void parse(){
        try{
            json = new JSONObject(jsonString);
        }catch (JSONException ex){
            Log.d(JSON_ERROR, ex.toString());
        }
    }


    public JSONObject getJSON(){
          return json;
    }


    public int getIntSuccess(){
        int success = 0;
        try{
            success = json.getInt(SUCCESS);
        }catch (JSONException ex){
            Log.d(JSON_ERROR, ex.toString());
        }
        return success;
    }

    public long getLongSuccess(){
        long success = 0;
        try{
            success = json.getLong(SUCCESS);
        }catch (JSONException ex){
            Log.d(JSON_ERROR, ex.toString());
        }
        return success;
    }

    public JSONObject getContents(){
        JSONObject cont = new JSONObject();
        try{
            cont = json.getJSONObject(CONTENTS);
        }catch (JSONException ex){
            Log.d(JSON_ERROR, ex.toString());
        }
        return cont;
    }

    String jsonString = "{\"SUCCESS\" : 0}";
    JSONObject json = new JSONObject();

}
