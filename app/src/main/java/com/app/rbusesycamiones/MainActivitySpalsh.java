package com.app.rbusesycamiones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivitySpalsh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_spalsh);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivitySpalsh.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 300);
    }
}