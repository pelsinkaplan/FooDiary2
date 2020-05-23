package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

public class SecondRecipeCategoryPanel extends MainManager {
    private Button dessert1Button;
    private Button dessert2Button;
    private Button dessert3Button;
    private Button dessert4Button;
    private Button dessert5Button;
    private Button homeButton;
    private Button backButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_category_2);

        dessert1Button = (Button) findViewById(R.id.firstrecipe);
        dessert2Button = (Button) findViewById(R.id.secondrecipe);
        dessert3Button = (Button) findViewById(R.id.thirdrecipe);
        dessert4Button = (Button) findViewById(R.id.fourthrecipe);
        dessert5Button = (Button) findViewById(R.id.fifthrecipe);
        homeButton = (Button) findViewById(R.id.home);
        backButton = (Button) findViewById(R.id.back);


        dessert1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        dessert2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        dessert3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        dessert4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        dessert5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

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
