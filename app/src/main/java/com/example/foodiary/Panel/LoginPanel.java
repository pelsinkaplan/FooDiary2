package com.example.foodiary.Panel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

public class LoginPanel extends MainManager {
    private Button loginButton;
    private TextView registerButton;
    private EditText emailEdit;
    private EditText passwordEdit;
    private String email;
    private String password;
    private AppCompatActivity act;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginButton = (Button) findViewById(R.id.login);
        registerButton = (TextView) findViewById(R.id.register);
        emailEdit = (EditText) findViewById(R.id.email);
        passwordEdit = (EditText) findViewById(R.id.password);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRegisterPanel());
            }
        });

    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}