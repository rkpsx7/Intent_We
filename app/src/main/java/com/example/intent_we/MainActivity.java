package com.example.intent_we;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtUserName;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private String emailValidation ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEmailValid = isEmailValid();
                boolean isUserNameValid = isUserNameValid();
                boolean isPasswordValid = isPasswordValid();
                if(isEmailValid && isUserNameValid && isPasswordValid){
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    intent.putExtra("username",mEtUserName.getText().toString());
                    startActivity(intent);
                }

            }
        });
    }

    private boolean isEmailValid() {
        if(mEtEmail.getText().toString().matches(emailValidation)){
            return true;
        }else{
            mEtEmail.setError("Invalid Email");
            return false;
        }
    }

    private boolean isUserNameValid() {
        if(mEtUserName.getText().toString().trim().length() >=4){
            return true;
        }else{
            mEtUserName.setError("Invalid UserName");
            return false;
        }
    }
    private boolean isPasswordValid() {
        if(mEtPassword.getText().toString().length() >=6){
            return true;
        }else{
            mEtPassword.setError("Length is less than 6");
            return false;
        }
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mEtUserName = findViewById(R.id.etUserName);
        mEtPassword = findViewById(R.id.etPassword);
        mBtnLogin = findViewById(R.id.btnLogin);
    }

}