package com.samsullivan.orator.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Speech {

    public static final Integer TYPE_NOTIFICATION = 0;
    public static final Integer TYPE_SHARE = 1;
    public static final Integer TYPE_TEXT = 2;
    public static final Integer TYPE_CLIPBOARD = 3;

    public String text;
    public Integer type;

    public JSONObject toJson() {
        JSONObject object = new JSONObject();

        try {
            object.accumulate("text", this.text);
            object.accumulate("type", this.type);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object;
    }

    public static Speech fromJson(JSONObject object) {
        Speech speech = new Speech();

        if(object.has("text")) speech.text = object.optString("text");
        if(object.has("type")) speech.type = object.optInt("type");

        return speech;
    }

}
