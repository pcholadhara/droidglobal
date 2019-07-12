package com.peasx.app.droidglobal.http.query;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class HttpQuery {
    public HttpQuery(String tableName){
        this.tableName = tableName;
    }

    public HttpQuery(String dbName, String tableName){
        this.dbName = dbName;
        this.tableName = tableName;
    }

    public HttpQuery select(String tableColumns){
        this.select = tableColumns;
        return this;
    }

    public HttpQuery select(String[] tableColumns){
        StringBuilder queryBuilder = new StringBuilder();
        for(int i = 0; i < tableColumns.length ; i++){
            queryBuilder.append((i < tableColumns.length-1) ? tableColumns[i] + " , " : tableColumns[i]);
        }
        this.select = queryBuilder.toString();
        return this;
    }

    public HttpQuery count(String count, String as){
        this.select = " COUNT( "+ count+" ) AS "+as;
        return this;
    }

    public HttpQuery sum(String column, String as){
        this.select = " SUM( "+ column+" ) AS "+as;
        return this;
    }

    public HttpQuery innerJoin(String table2, String column_1, String column_2){
        innerJoin.append(" INNER JOIN  ").append(table2)
                .append(" ").append(column_1)
                .append(" ON ").append(column_2);
        return this;
    }

    public HttpQuery orderBy(String column, boolean asc){
        this.orderBy = " ORDER BY " + column + (asc ? " ASC " : " DESC ");
        return this;
    }

    public HttpQuery limit(int limit){
        this.limit = limit; return this;
    }

    public HttpQuery offset(int offset){
        this.offset = offset; return this;
    }

    public HttpQuery groupBy(String tableColumns){
        this.groupBy = " GROUP BY " + tableColumns;
        return this;
    }

    public HttpQuery groupBy(String[] tableColumns){
        StringBuilder queryBuilder = new StringBuilder(" GROUP BY ");
        for(int i = 0; i < tableColumns.length ; i++){
            queryBuilder.append((i < tableColumns.length-1) ? tableColumns[i] + " , " : tableColumns[i]);
        }
        this.groupBy = queryBuilder.toString();
        return this;
    }

    public HttpQuery where(String condition){
        where.append( " WHERE ").append(condition);
        return this;
    }

    public HttpQuery where(String column, String value){
        where.append(" WHERE ").append(column).append(" = ").append(value);
        return this;
    }

    public HttpQuery where(String column, String operator, String value){
        where.append(" WHERE ").append(column).append(" " + operator + " ").append(value);
        return this;
    }

    public HttpQuery appendWhere(String column, String operator, String value){
        where.append(" AND ").append(column).append(" " + operator + " ").append(value);
        return this;
    }


    public HttpQuery filter(String filter, String[] params){
        where.append(" WHERE ").append(filter);
        StringBuilder queryBuilder = new StringBuilder("");
        for(int i = 0; i < params.length ; i++){
            queryBuilder.append((i < params.length-1) ? params[i] + ", " : params[i]);
        }
        this.params = queryBuilder.toString();
        return this;
    }


    public HashMap<String, String> getMap(){
        StringBuilder queryBuilder = new StringBuilder("SELECT ");
        queryBuilder.append(select).append(" FROM ").append(tableName).append(" ");

        queryBuilder.append(!innerJoin.toString().isEmpty() ? innerJoin : "");
        queryBuilder.append(!where.toString().isEmpty() ? where : "");
        queryBuilder.append(!orderBy.isEmpty() ? orderBy : "");
        queryBuilder.append(limit   > 0 ? " LIMIT " + limit : "");
        queryBuilder.append(offset  > 0 ? " OFFSET " + offset : "");
        queryBuilder.append(!groupBy.isEmpty() ? groupBy : "");

        HashMap<String, String> map = new HashMap<>();
        if(!dbName.isEmpty()){
            map.put("db_name", dbName);
        }

        map.put("json", queryBuilder.toString());
        map.put("param", params);
        return map;
    }

    private void runs(){
        OnQuery q = new OnQuery(){
            @Override
            public void processObject(JSONObject jsonObject) {
                super.processObject(jsonObject);
            }
        };
    }


    private String dbName       = "";
    private String tableName    = "";
    private String select       = "";
    private int limit           = 0;
    private int offset          = 0;
    private String groupBy      = "";
    private String orderBy      = "";
    private String params       = "";
    private StringBuilder innerJoin     = new StringBuilder("");
    private StringBuilder where         = new StringBuilder("");

}
