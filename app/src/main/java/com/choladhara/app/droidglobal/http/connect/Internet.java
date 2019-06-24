package com.choladhara.app.droidglobal.http.connect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class Internet {

    public static boolean hasNetwork(Context context){
        ConnectivityManager CM = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetWorkInfo = CM.getActiveNetworkInfo();
        return activeNetWorkInfo !=null;
    }

}
