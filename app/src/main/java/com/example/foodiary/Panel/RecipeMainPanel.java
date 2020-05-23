package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

public class RecipeMainPanel extends MainManager {
    private Button allRecipesButton1;
    private Button allRecipesButton2;
    private Button stockRecipesButton;
    private Button expireDateButton;
    private Button homeButton;
    private Button menuButton; //menuButton işlevi tanımlanacak

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_main);
        allRecipesButton1 = (Button) findViewById(R.id.allrecipes1);
        allRecipesButton2 = (Button) findViewById(R.id.allrecipes2);
        stockRecipesButton = (Button) findViewById(R.id.stockrecipes);
        expireDateButton = (Button) findViewById(R.id.expirerecipes);
        homeButton = (Button) findViewById(R.id.home);
        menuButton = (Button) findViewById(R.id.menu);

        allRecipesButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allRecipesButton1.setVisibility(View.INVISIBLE);
                allRecipesButton2.setVisibility(View.VISIBLE);
                expireDateButton.setVisibility(View.INVISIBLE);
                stockRecipesButton.setVisibility(View.VISIBLE);
            }
        });

        allRecipesButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openRecipeCategoryPanel());
            }
        });

        expireDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allRecipesButton1.setVisibility(View.INVISIBLE);
                allRecipesButton2.setVisibility(View.VISIBLE);
                expireDateButton.setVisibility(View.INVISIBLE);
                stockRecipesButton.setVisibility(View.VISIBLE);
            }
        });

        stockRecipesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openRecipeCategoryPanel());
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
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
