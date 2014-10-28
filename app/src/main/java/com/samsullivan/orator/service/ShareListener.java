package com.samsullivan.orator.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ShareListener extends Activity {

    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.intent = getIntent();
        this.handleShare();

        finish();
    }

    public void handleShare() {
        String sharedText = this.intent.getStringExtra(Intent.EXTRA_TEXT);
    }

}
