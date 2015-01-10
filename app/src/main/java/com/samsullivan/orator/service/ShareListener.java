package com.samsullivan.orator.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.samsullivan.orator.util.SpeechUtil;
import com.samsullivan.orator.util.StorageUtil;

public class ShareListener extends Activity {

    private SpeechUtil speechUtil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.speechUtil = new SpeechUtil(getApplicationContext());
        this.handleShare();

        finish();
    }

    public void handleShare() {
        String sharedText = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        this.speechUtil.speak(sharedText, StorageUtil.TYPE_SHARE);
    }

}
