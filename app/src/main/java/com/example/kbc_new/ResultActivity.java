package com.example.kbc_new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView tv_name = findViewById(R.id.tv_name);
        TextView tv_email = findViewById(R.id.tv_email);
        TextView tv_result = findViewById(R.id.tv_result);
        tv_name.setText(getIntent().getExtras().getString("name"));
        tv_email.setText(getIntent().getExtras().getString("email"));
        tv_result.setText(getIntent().getExtras().getString("result"));
    }
}