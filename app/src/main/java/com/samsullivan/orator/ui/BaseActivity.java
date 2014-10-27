package com.samsullivan.orator.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.samsullivan.orator.R;

public class BaseActivity extends ActionBarActivity {

    protected String pageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pageTitle = getString(R.string.app_name);
    }

    @Override
    public void setContentView(int layoutID) {
        super.setContentView(layoutID);
        createToolbar();
    }

    public void createToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.layout_toolbar);

        toolbar.setTitle(this.pageTitle);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void openSettings(MenuItem item) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

}
