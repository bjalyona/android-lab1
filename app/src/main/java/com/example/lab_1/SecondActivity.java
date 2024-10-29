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

public class SecondActivity extends AppCompatActivity {

    private EditText editName;
    private Button sendButton;
    private TextView greetingView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        sendButton = findViewById(R.id.button2);
        editName = findViewById(R.id.editTextText);
        greetingView = findViewById(R.id.textView2);

        Intent intent = getIntent();
        greetingView.setText(intent.getStringExtra("greeting"));

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                Intent res = new Intent();
                res.putExtra("name", name);
                setResult(0, res);
                finish();
            }
        });

    }
}