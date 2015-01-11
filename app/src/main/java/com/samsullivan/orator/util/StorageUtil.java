package com.samsullivan.orator.util;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StorageUtil {

    private static final String FILE_NAME = "speech.history";

    public static JSONArray getSpeeches(Context context) {
        try {
            FileInputStream fis = context.openFileInput(StorageUtil.FILE_NAME);
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];
            int n;

            while ((n = fis.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }

            return new JSONArray(fileContent.toString());
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    public static void appendSpeech(Context context, String text, Integer type) {
        try {
            FileOutputStream fos = context.openFileOutput(StorageUtil.FILE_NAME, Context.MODE_PRIVATE);

            JSONObject object = new JSONObject();
            object.accumulate("type", type);
            object.accumulate("text", text);

            JSONArray array = StorageUtil.getSpeeches(context);
            array.put(object);

            String json = array.toString();
            fos.write(json.getBytes());

            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
