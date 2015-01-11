package com.samsullivan.orator.model;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SpeechManager {

    private static final String FILE_NAME = "speech.history";

    private Context context;
    private List<Speech> speeches;

    public SpeechManager(Context context) {
        this.context = context;
    }

    public List<Speech> getAll() {
        if(speeches == null) {
            speeches = new ArrayList<Speech>();

            try {
                FileInputStream fis = context.openFileInput(FILE_NAME);
                StringBuilder fileContent = new StringBuilder("");

                byte[] buffer = new byte[1024];
                int n;

                while ((n = fis.read(buffer)) != -1) {
                    fileContent.append(new String(buffer, 0, n));
                }

                JSONArray array = new JSONArray(fileContent.toString());
                for(int i = 0; i < array.length(); i++) append(Speech.fromJson(array.getJSONObject(i)));
            } catch (FileNotFoundException e) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return speeches;
    }

    public void append(Speech speech) {
        if(speeches == null) {
            getAll();
        }

        assert speeches != null;
        speeches.add(0, speech);

        updateFile();
    }

    private void updateFile() {
        JSONArray array = new JSONArray();
        for(Speech speech : speeches) array.put(speech.toJson());

        try {
            FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);

            String json = array.toString();
            fos.write(json.getBytes());

            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
