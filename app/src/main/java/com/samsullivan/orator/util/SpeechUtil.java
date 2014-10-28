package com.samsullivan.orator.util;

import android.content.Context;
import android.speech.tts.TextToSpeech;

public class SpeechUtil implements TextToSpeech.OnInitListener {

    Context context;
    TextToSpeech tts;
    String text;

    public SpeechUtil(Context context) {
        this.context = context;
    }

    public void speak(String text) {
        this.text = text;
        this.tts =  new TextToSpeech(this.context, this);
    }

    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS) {
            this.tts.speak(this.text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

}
