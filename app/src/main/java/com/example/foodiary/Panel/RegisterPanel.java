package com.example.foodiary.Panel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

public class RegisterPanel extends MainManager {
    private Button registerButton;
    private EditText emailEdit;
    private EditText passwordEdit;
    private EditText nameEdit;
    private EditText surnameEdit;
    private Button backButton;
    private String name;
    private String surname;
    private String email;
    private String password;
    private AppCompatActivity act;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        registerButton = (Button) findViewById(R.id.register);
        backButton = (Button) findViewById(R.id.back);
        emailEdit = (EditText) findViewById(R.id.email);
        passwordEdit = (EditText) findViewById(R.id.password);
        nameEdit = (EditText) findViewById(R.id.name);
        surnameEdit = (EditText) findViewById(R.id.surname);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openLoginPanel());
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameEdit.getText().toString();
                surname = surnameEdit.getText().toString();
                email = emailEdit.getText().toString();
                password = passwordEdit.getText().toString();

                int counter = 0;
                //name check if there is an error then print error message
                if (MainManager.getInstance().controlNameRegister(name).length() == 0) {
                    counter++;
                } else {
                    nameEdit.setError(MainManager.getInstance().controlNameRegister(name));
                }
                //surname check if there is an error then print error message
                if (MainManager.getInstance().controlSurnameRegister(surname).length() == 0) {
                    counter++;
                } else {
                    surnameEdit.setError(MainManager.getInstance().controlSurnameRegister(surname));
                }
                //email check if there is an error then print error message
                if (MainManager.getInstance().controlEmailRegister(email).length() == 0) {
                    counter++;
                } else {
                    emailEdit.setError(MainManager.getInstance().controlEmailRegister(email));
                }
                //password check if there is an error then print error message
                if (MainManager.getInstance().controlPasswordRegister(password).length() == 0) {
                    counter++;
                } else {
                    passwordEdit.setError(MainManager.getInstance().controlPasswordRegister(password));
                }
                //if there is no error then go back login page
                if (counter == 4) {
                    changeActivity(MainManager.getInstance().openLoginPanel());
                }


            }
        });
    }


    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}