package com.samsullivan.orator.ui;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.layout_toolbar);
        toolbar.setTitle(this.pageTitle);

        setSupportActionBar(toolbar);
    }

}
