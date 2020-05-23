package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

import org.w3c.dom.Text;

public class ProfilePanel extends MainManager {
    private Button editButton;
    private Button backButton;
    private Button homeButton;
    private TextView name;
    private TextView surname;
    private TextView email;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        editButton = (Button) findViewById(R.id.edit);
        backButton = (Button) findViewById(R.id.back);
        homeButton = (Button) findViewById(R.id.home);

        email = (TextView) findViewById(R.id.emailPro);
        email.setText(MainManager.getInstance().getCurrentUserEmail());
        name = (TextView) findViewById(R.id.namePro);
        name.setText(MainManager.getInstance().getCurrentUserName());
        surname = (TextView) findViewById(R.id.surnamePro);
        surname.setText(MainManager.getInstance().getCurrentUserSurname());


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openHomePanel());
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openHomePanel());
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openEditProfilePanel());
            }
        });

    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}