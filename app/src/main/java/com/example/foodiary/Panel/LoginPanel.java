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

import org.json.simple.parser.ParseException;

import java.io.IOException;

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

        try {
            MainManager.getInstance().usersAndDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


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
                int id = 0;
                //email check if there is an error then print error message
                if (MainManager.getInstance().controlEmailRegister(email).length() == 0) {
                    for (int i = 0; i < MainManager.getInstance().getUserList().size(); i++) {
                        if (MainManager.getInstance().getUserList().get(i).getMail().contains(email)) {
                            id = i;
                            counter++;
                        }
                    }
                    if (counter == 0)
                        emailEdit.setError("Sistemimize kayıtlı böyle bir eposta adresi bulunmamaktadır!");
                } else {
                    emailEdit.setError(MainManager.getInstance().controlEmailRegister(email));
                }
                //password check if there is an error then print error message
                if (MainManager.getInstance().controlPasswordRegister(password).length() == 0) {
                    if (!password.equals(MainManager.getInstance().getUserList().get(id).getPassword()))
                        passwordEdit.setError("Şifrenizi yanlış girdiniz!");
                    else
                        counter++;
                } else {
                    passwordEdit.setError(MainManager.getInstance().controlPasswordRegister(password));
                }
                //if there is no error then open home page
                if (counter == 2) {
                    MainManager.getInstance().setCurrentUserEmail(MainManager.getInstance().getUserList().get(id).getMail());
                    MainManager.getInstance().setCurrentUserPassword(MainManager.getInstance().getUserList().get(id).getPassword());
                    MainManager.getInstance().setCurrentUserName(MainManager.getInstance().getUserList().get(id).getUsername());
                    MainManager.getInstance().setCurrentUserSurname(MainManager.getInstance().getUserList().get(id).getSurname());
                    changeActivity(MainManager.getInstance().openHomePanel());
                }
            }
        });

    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}