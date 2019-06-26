package com.peasx.app.droidglobal.http.query;

import java.util.HashMap;

public class HttpQuery {
    public HttpQuery(String tableName){
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

    public HttpQuery innerJoin(String table1, String column_1, String table2, String column_2){
        innerJoin.append(" INNER JOIN  ").append(table1).append(".").append(column_1)
                .append(" ON ")
                .append(table2).append(".").append(column_2);
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
        this.groupBy = tableColumns;
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


    public HashMap<String, String> getMap(){
        StringBuilder queryBuilder = new StringBuilder("SELECT ");
        queryBuilder.append(select).append(" FROM ").append(tableName);

        queryBuilder.append(!innerJoin.toString().isEmpty() ? innerJoin : "");
        queryBuilder.append(!where.toString().isEmpty() ? where : "");
        queryBuilder.append(!orderBy.isEmpty() ? orderBy : "");
        queryBuilder.append(limit   > 0 ? " LIMIT " + limit : "");
        queryBuilder.append(offset  > 0 ? " OFFSET " + offset : "");
        queryBuilder.append(!groupBy.isEmpty() ? groupBy : "");


        HashMap<String, String> map = new HashMap<>();
        map.put("json", queryBuilder.toString());
        return map;
    }






    String tableName    = "";
    String select       = "";
    int limit           = 0;
    int offset          = 0;
    String groupBy      = "";
    String orderBy      = "";
    StringBuilder innerJoin     = new StringBuilder("");
    StringBuilder where         = new StringBuilder("");

}
