package com.samsullivan.orator.ui;

import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.samsullivan.orator.R;
import com.samsullivan.orator.model.Speech;
import com.samsullivan.orator.model.SpeechAdapter;
import com.samsullivan.orator.model.SpeechManager;
import com.samsullivan.orator.util.SpeechUtil;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_layout);

        RecyclerView view = (RecyclerView) findViewById(R.id.layout_list);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setItemAnimator(new DefaultItemAnimator());

        SpeechManager manager = new SpeechManager(getApplicationContext());
        SpeechAdapter adapter = new SpeechAdapter(manager.getAll(), R.layout.speech_row, this);

        view.setAdapter(adapter);
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

    public void clickNewText(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Text");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);


        builder.setPositiveButton("Speak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Speech speech = new Speech();
                speech.text = input.getText().toString();
                speech.type = Speech.TYPE_TEXT;

                SpeechUtil speechUtil = new SpeechUtil(getApplicationContext());
                speechUtil.speak(speech);
            }
        });

        builder.setView(input);
        builder.show();

        FloatingActionsMenu FAB = (FloatingActionsMenu) findViewById(R.id.layout_fab);
        FAB.collapse();
    }

    public void clickNewClipboard(View v) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        Speech speech = new Speech();
        speech.text = clipboard.getPrimaryClip().getItemAt(0).getText().toString();
        speech.type = Speech.TYPE_CLIPBOARD;

        SpeechUtil speechUtil = new SpeechUtil(getApplicationContext());
        speechUtil.speak(speech);

        FloatingActionsMenu FAB = (FloatingActionsMenu) findViewById(R.id.layout_fab);
        FAB.collapse();
    }

}
