package com.samsullivan.orator.ui;

import android.os.Bundle;
import android.view.MenuItem;

import com.samsullivan.orator.R;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.pageTitle = getString(R.string.page_settings);
        super.setContentView(R.layout.home_layout);
    }

    @Override
    public void openSettings(MenuItem item) {}

}
