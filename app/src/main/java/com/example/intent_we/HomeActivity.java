package com.example.intent_we;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView mTvUserNmae;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTvUserNmae = findViewById(R.id.tvUserName);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");
        mTvUserNmae.setText(userName);
    }
}