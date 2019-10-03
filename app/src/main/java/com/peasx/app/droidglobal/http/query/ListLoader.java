package com.peasx.app.droidglobal.http.query;

import java.util.ArrayList;

public interface ListLoader<T> {
    void run(ArrayList<T> list);
}
