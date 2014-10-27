package com.samsullivan.orator.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.samsullivan.orator.R;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_layout);

        Toolbar toolbar = this.getToolbar();
        toolbar.setTitle(R.string.app_name);
    }

}
