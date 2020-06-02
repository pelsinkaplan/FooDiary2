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
        registerButton = (TextView) findViewById(R.id.registerLog);
        emailEdit = (EditText) findViewById(R.id.emailLog);
        passwordEdit = (EditText) findViewById(R.id.passwordLog);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRegisterPanel());
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailEdit.getText().toString();
                password = passwordEdit.getText().toString();

                int counter = 0;
                //email check if there is an error then print error message
                if (MainManager.getInstance().controlEmailRegister(email).length() == 0) {
                    //check db else print error

                    counter++;
                } else {
                    emailEdit.setError(MainManager.getInstance().controlEmailRegister(email));
                }
                //password check if there is an error then print error message
                if (MainManager.getInstance().controlPasswordRegister(password).length() == 0) {
                    //check db else print error

                    counter++;

                } else {
                    passwordEdit.setError(MainManager.getInstance().controlPasswordRegister(password));
                }
                //if there is no error then open home page
                if (counter == 2) {
                    MainManager.getInstance().setCurrentUserEmail(email);
                    MainManager.getInstance().setCurrentUserPassword(password);
                    changeActivity(MainManager.getInstance().openHomePanel());
                }
            }
        });

    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}