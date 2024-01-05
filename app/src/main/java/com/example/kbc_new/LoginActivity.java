package com.example.kbc_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText et_name = findViewById(R.id.et_name);
        EditText et_email = findViewById(R.id.et_email);

        findViewById(R.id.et_submit).setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("name", et_name.getText().toString().trim());
            intent.putExtra("email", et_email.getText().toString().trim());
            startActivity(intent);
        });


    }
}