package com.example.lab_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button helloButton;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloButton = findViewById(R.id.hello_button);

        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String greeting = "Hello! What is your name?";
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("greeting", greeting);
                startActivityForResult(intent, 0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        result = findViewById(R.id.result);
        if (data != null && resultCode == 0) {
            result.setText("Hello " + data.getStringExtra("name"));
        }
    }
}