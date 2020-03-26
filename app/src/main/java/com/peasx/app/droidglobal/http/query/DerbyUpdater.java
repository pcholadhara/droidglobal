package com.peasx.app.droidglobal.http.query;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class DerbyUpdater {

    public DerbyUpdater(String tableName){
        this.tableName = tableName;
    }

    public DerbyUpdater setDb(String db){
        this.dbName= db; return this;
    }

    public DerbyUpdater setColumns(Map map){
        this.columns = new JSONObject(map);
        return this;
    }

    public DerbyUpdater setParams(Map map){
        this.params = new JSONObject(map);
        return this;
    }

    public HashMap<String, String> getParams(){
        return getMap();
    }

    public HashMap<String, String> getMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("db_name", dbName);
        map.put("table_name", tableName);
        map.put("columns", columns.toString());
        map.put("params", params.toString());

        return map;
    }


    JSONObject params   = new JSONObject();
    JSONObject columns  = new JSONObject();
    String tableName    = "";
    String dbName       = "";

}
