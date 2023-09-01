package com.ameen.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText proxyHostEditText, proxyPortEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proxyHostEditText = findViewById(R.id.proxy_host_edit_text);
        proxyPortEditText = findViewById(R.id.proxy_port_edit_text);
        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proxyHost = proxyHostEditText.getText().toString();
                int proxyPort = Integer.parseInt(proxyPortEditText.getText().toString());

                System.setProperty("http.proxyHost", proxyHost);
                System.setProperty("http.proxyPort", String.valueOf(proxyPort));

                Toast.makeText(MainActivity.this, "Proxy server set up successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}