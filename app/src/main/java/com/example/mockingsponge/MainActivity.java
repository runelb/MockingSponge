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

        if (message.length() > 0) { // avoid trouble
            String[] words = message.split(" ");
            message = "";
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    if ((j % 2) == 0 || words[i].substring(j, j + 1).equals("i") || words[i].substring(j, j + 1).equals("I") ) {
                        words[i] = words[i].substring(0, j) + words[i].substring(j, j + 1).toLowerCase() + words[i].substring(j + 1);
                    } else {
                        words[i] = words[i].substring(0, j) + words[i].substring(j, j + 1).toUpperCase() + words[i].substring(j + 1);
                    }
                }
                message = message + " " + words[i];
            }
            message = message.trim();
        }

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
