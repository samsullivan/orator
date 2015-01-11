package com.samsullivan.orator.util;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import com.samsullivan.orator.model.Speech;
import com.samsullivan.orator.model.SpeechManager;

public class SpeechUtil implements TextToSpeech.OnInitListener {

    Context context;
    TextToSpeech tts;
    Speech speech;

    public SpeechUtil(Context context) {
        this.context = context;
    }

    public void speak(Speech speech) {
        new SpeechManager(this.context).append(speech);

        this.speech = speech;
        this.tts =  new TextToSpeech(this.context, this);
    }

    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS) {
            this.tts.speak(this.speech.text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

}
