package com.peasx.app.droidglobal.http.query;

import android.util.Log;

import com.peasx.app.droidglobal.http.connect.Internet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JParser<T> {
    public JParser(Class<T> klass){
        this.klass = klass;
    }

    public JParser setString(String jStr){
        this.jStr = jStr;
        parse();
        return this;
    }


    private void parse(){
        try {
            json = new JSONObject(jStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getIntSuccess(){
        try {
            return json.get(SUCCESS) == null ? 0 : json.getInt(SUCCESS);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long getLongSuccess(){
        try {
            return json.get(SUCCESS) == null ? 0 : json.getLong(SUCCESS);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public T getModel(){
        try {
            row = json.getJSONObject(CONTENTS);
            setModel(row);
        } catch (JSONException ex){

        }
        return t;
    }

    public void setModel(JSONObject r){
        this.row    = r;
        setKeys();
        createObject();

        methods        = new ArrayList<>();
        for(Method m : t.getClass().getMethods()){
            if(m.isAnnotationPresent(Column.class)){
                Column col = m.getAnnotation(Column.class);
                for(String key : jKeys){
                    if(key.equals(col.name().toUpperCase())){
                         methods.add(m);
                    }
                }
            }
        }

        for(Method method: methods){
              Column col = method.getAnnotation(Column.class);
              setValue(method, row, col.name().toUpperCase());
        }
    }


    public void loadData(ModelLoader<T> load){
          load.run(getModel());
    }

    public void loadData(ListLoader<T> load){
          load.run(getList());
    }

    public ArrayList<T> getList(){
          list = new ArrayList<>();
        try {
            jArr = json.getJSONArray(CONTENTS);
            for(int i = 0; i < jArr.length(); i++){
                  row = jArr.getJSONObject(i);
                  setModel(row);
                  list.add(t);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    private void setKeys(){
        jKeys = new ArrayList<>();
        Iterator<String> it = row.keys();
        while (it.hasNext()){
            jKeys.add(it.next());
        }
    }

    private void createObject(){
        try {
            this.t = klass.newInstance();
        } catch (IllegalAccessException e) {
            Log.d(LOG_TAG , ":: createObject" + e.toString());
        } catch (InstantiationException e) {
            Log.d(LOG_TAG , ":: createObject" + e.toString());
        }
    }

    private void setValue(Method method, JSONObject r, String key) {
          Class type = method.getParameterTypes()[0];
              try {
                  if(type == int.class) {
                      method.invoke(t, r.get(key) == null ? 0 : r.getInt(key));
                  }

                  if(type == long.class) {
                      method.invoke(t, r.get(key) == null ? 0 : Long.parseLong(r.get(key).toString()));
                  }

                  if(type == double.class) {
                      method.invoke(t, r.get(key) == null ? 0 : r.getDouble(key));
                  }

                  if(type == String.class) {
                      method.invoke(t, r.get(key) == null ? "" : r.getString(key));
                  }

              } catch (IllegalAccessException e) {
                  Log.d(LOG_TAG + ": setValue()" , e.toString());
              } catch (InvocationTargetException e) {
                  Log.d(LOG_TAG + ": setValue()" , e.toString());
              } catch (JSONException e) {
                  e.printStackTrace();
                  Log.d(LOG_TAG + ": setValue()" , e.toString());
              }
    }



    JSONObject json, row;
    JSONArray jArr;
    List<String> jKeys;
    List<Method> methods;
    String jStr     = "";
    String SUCCESS  = "SUCCESS";
    String CONTENTS = "CONTENTS";
    String LOG_TAG  = "JPARSER";
    ArrayList<T> list;
    T t;
    Class<T> klass;
}
