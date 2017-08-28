package com.example.mockingsponge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
/*
        if (message.length() > 0) { // avoid trouble
            message = message.trim();   // avoid trouble
            String[] words = message.split(" ");
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    if((j % 2) == 0)
                        words[i].substring(j, j + 1);
                }
            }
        }
*/
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
