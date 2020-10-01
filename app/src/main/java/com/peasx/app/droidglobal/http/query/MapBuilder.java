package com.peasx.app.droidglobal.http.query;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MapBuilder<T> {
    public MapBuilder(T mdl){
        this.model = mdl;
        this.klass = model.getClass();
    }

    public MapBuilder build(){
        fields  = klass.getDeclaredFields();
        iCols    = new HashMap();
        uCols    = new HashMap();
        uParms   = new HashMap();

        Field identity      = null;
        String identityCol  = "ID";

        for(Field f : fields) {
            if(f.isAnnotationPresent(Fields.class)){
                iCols             .put(f.getAnnotation(Fields.class).column(), varValue(f));
                if(f.isAnnotationPresent(Identity.class)){
                    identity      = f ;
                    identityCol   = f.getAnnotation(Fields.class).column();
                    uParms        .put(identityCol, varValue(f));
                }else{
                    uCols          .put(f.getAnnotation(Fields.class).column(), varValue(f));
                }
            }
        }

        return this;
    }

    public Map getiCols(){
        return this.iCols;
    }

    public Map getuCols() {
        return uCols;
    }

    public Map getuParms() {
        return uParms;
    }

    private Object varValue(Field f){
        Object obj = null;
        try {
            f.setAccessible(true);
            return f.get(model);
        } catch (IllegalArgumentException | IllegalAccessException ex) {

        }
        return obj;
    }


    Map iCols, uCols, uParms;
    Field[] fields;
    Class klass;
    T model;
}
