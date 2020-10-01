package com.peasx.app.droidglobal.http.query;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;


public class MySQLUpdater {

    public MySQLUpdater(String tableName){
        this.tableName = tableName;
    }

    public MySQLUpdater setDb(String db){
        this.dbName= db; return this;
    }

    public MySQLUpdater setColumns(Map map){
        this.columns = new JSONObject(map);
        return this;
    }

    public MySQLUpdater setParams(Map map){
        this.params = new JSONObject(map);
        return this;
    }


    public <T> MySQLUpdater setObject(T t){
        Class klass = t.getClass();

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
