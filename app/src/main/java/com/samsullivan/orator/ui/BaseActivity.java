package com.samsullivan.orator.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.samsullivan.orator.R;

public class BaseActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(int layoutID) {
        super.setContentView(layoutID);
        getToolbar();
    }

    public Toolbar getToolbar() {
        if(this.toolbar == null) {
            this.toolbar = (Toolbar) findViewById(R.id.layout_toolbar);
            setSupportActionBar(this.toolbar );
        }

        return this.toolbar ;
    }

}
