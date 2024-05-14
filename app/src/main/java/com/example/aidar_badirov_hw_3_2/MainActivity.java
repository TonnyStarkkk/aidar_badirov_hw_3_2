package com.example.aidar_badirov_hw_3_2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextTo, editTextSubject, editTextMessage;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTo = (EditText) findViewById(R.id.edit_text1);
        editTextSubject = (EditText) findViewById(R.id.edit_text2);
        editTextMessage = (EditText) findViewById(R.id.edit_text3);

        send = (Button) findViewById(R.id.btn1);

        send.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String to = editTextTo.getText().toString();
                String subject = editTextSubject.getText().toString();
                String message = editTextMessage.getText().toString();

                Intent gmail = new Intent(Intent.ACTION_SEND);
                gmail.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                gmail.putExtra(Intent.EXTRA_SUBJECT, subject);
                gmail.putExtra(Intent.EXTRA_TEXT, message);

                //Это нужно только для того, чтобы запрашивать почтовый клиент
                gmail.setType("message/rfc332");

                startActivity(Intent.createChooser(gmail, "Choose an Email client:"));
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Раздуть меню; Это добавит элементы на панель действий, если она присутствует.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}