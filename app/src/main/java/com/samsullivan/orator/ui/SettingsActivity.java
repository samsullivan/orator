package com.samsullivan.orator.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.provider.Settings;
import android.util.Log;

import com.samsullivan.orator.R;
import com.samsullivan.orator.util.SettingsUtil;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.pageTitle = getString(R.string.page_settings);
        super.setContentView(R.layout.settings_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                .add(R.id.container_settings, new SettingsFragment())
                .commit();
        }
    }

    public static class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
            SettingsUtil.registerOnSharedPreferenceChangeListener(getActivity(), this);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            SettingsUtil.unregisterOnSharedPreferenceChangeListener(getActivity(), this);
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if(key.equals(SettingsUtil.SETTINGS_READ_NOTIFICATIONS)) {
                if(sharedPreferences.getBoolean(SettingsUtil.SETTINGS_READ_NOTIFICATIONS, false) && !SettingsUtil.canReadNotifications(getActivity())) {
                    Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                    startActivity(intent);
                }
            }
        }

    }

}
