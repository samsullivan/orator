package com.samsullivan.orator.ui;

import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.samsullivan.orator.R;
import com.samsullivan.orator.util.SpeechUtil;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setContentView(R.layout.home_layout);
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
                SpeechUtil speechUtil = new SpeechUtil(getApplicationContext());

                String inputText = input.getText().toString();
                speechUtil.speak(inputText);
            }
        });

        builder.setView(input);
        builder.show();

        FloatingActionsMenu FAB = (FloatingActionsMenu) findViewById(R.id.layout_fab);
        FAB.collapse();
    }

    public void clickNewClipboard(View v) {
        SpeechUtil speechUtil = new SpeechUtil(getApplicationContext());
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        String clipboardText = clipboard.getPrimaryClip().getItemAt(0).getText().toString();
        speechUtil.speak(clipboardText);

        FloatingActionsMenu FAB = (FloatingActionsMenu) findViewById(R.id.layout_fab);
        FAB.collapse();
    }

}
