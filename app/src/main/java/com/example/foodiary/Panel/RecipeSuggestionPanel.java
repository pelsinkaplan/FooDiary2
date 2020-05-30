package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

public class RecipeSuggestionPanel extends MainManager {
    private Button recipe1Button;
    private Button recipe2Button;
    private Button recipe3Button;
    private Button recipe4Button;
    private Button recipe5Button;
    private Button homeButton;
    private Button backButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_suggestion);

        recipe1Button = (Button) findViewById(R.id.firstrecipe);
        recipe2Button = (Button) findViewById(R.id.secondrecipe);
        recipe3Button = (Button) findViewById(R.id.thirdrecipe);
        recipe4Button = (Button) findViewById(R.id.fourthrecipe);
        recipe5Button = (Button) findViewById(R.id.fifthrecipe);
        homeButton = (Button) findViewById(R.id.home);
        backButton = (Button) findViewById(R.id.back);


        recipe1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        recipe2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        recipe3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        recipe4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        recipe5Button.setOnClickListener(new View.OnClickListener() {
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
                changeActivity(MainManager.getInstance().openHomePanel());
            }
        });

    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}
