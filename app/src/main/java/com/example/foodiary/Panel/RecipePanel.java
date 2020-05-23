package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;


public class RecipePanel extends MainManager{
    private Button homeButton;
    private Button backButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);
        homeButton = (Button) findViewById(R.id.home);
        backButton = (Button) findViewById(R.id.back);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openHomePanel());
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}
