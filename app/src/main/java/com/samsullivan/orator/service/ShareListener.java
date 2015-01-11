package com.samsullivan.orator.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.samsullivan.orator.model.Speech;
import com.samsullivan.orator.util.SpeechUtil;
import com.samsullivan.orator.util.StorageUtil;

public class ShareListener extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.handleShare();

        finish();
    }

    public void handleShare() {
        Speech speech = new Speech();
        speech.text = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        speech.type = Speech.TYPE_SHARE;

        SpeechUtil speechUtil = new SpeechUtil(getApplicationContext());
        speechUtil.speak(speech);
    }

}
