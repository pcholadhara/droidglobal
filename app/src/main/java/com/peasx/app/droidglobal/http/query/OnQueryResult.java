package com.peasx.app.droidglobal.http.query;

import org.json.JSONObject;

public interface OnQueryResult {
    void process(JSONObject jsonObject);
}
