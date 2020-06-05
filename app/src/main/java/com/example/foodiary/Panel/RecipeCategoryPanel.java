package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

public class RecipeCategoryPanel extends MainManager {
    private ImageButton soupButton1;
    private ImageButton ricepastaButton1;
    private ImageButton dessertButton1;
    private ImageButton saladButton1;
    private ImageButton mainCourseButton1;
    private ImageButton pastryButton1;
    private Button soupButton2;
    private Button ricepastaButton2;
    private Button dessertButton2;
    private Button saladButton2;
    private Button mainCourseButton2;
    private Button pastryButton2;
    private Button homeButton;
    private Button menuButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_category);
        soupButton1 = (ImageButton) findViewById(R.id.soups1);
        ricepastaButton1 = (ImageButton) findViewById(R.id.ricepasta1);
        dessertButton1 = (ImageButton) findViewById(R.id.dessert1);
        saladButton1 = (ImageButton) findViewById(R.id.salads1);
        mainCourseButton1 = (ImageButton) findViewById(R.id.maincourse1);
        pastryButton1 = (ImageButton) findViewById(R.id.pastry1);

        soupButton2 = (Button) findViewById(R.id.soups2);
        ricepastaButton2 = (Button) findViewById(R.id.ricepasta2);
        dessertButton2 = (Button) findViewById(R.id.dessert2);
        saladButton2 = (Button) findViewById(R.id.salads2);
        mainCourseButton2 = (Button) findViewById(R.id.maincourse2);
        pastryButton2 = (Button) findViewById(R.id.pastry2);

        homeButton = (Button) findViewById(R.id.home);
        menuButton = (Button) findViewById(R.id.menu);

        soupButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(0);
                MainManager.getInstance().setCurrentRecipeCategory("Çorbalar");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });
        soupButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(0);
                MainManager.getInstance().setCurrentRecipeCategory("Çorbalar");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });
        mainCourseButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(1);
                MainManager.getInstance().setCurrentRecipeCategory("Ana Yemekler");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });
        mainCourseButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(1);
                MainManager.getInstance().setCurrentRecipeCategory("Ana Yemekler");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });
        ricepastaButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(2);
                MainManager.getInstance().setCurrentRecipeCategory("Pilavlar / Makarnalar");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });
        ricepastaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(2);
                MainManager.getInstance().setCurrentRecipeCategory("Pilavlar / Makarnalar");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });
        saladButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(3);
                MainManager.getInstance().setCurrentRecipeCategory("Salatalar");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });
        saladButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(3);
                MainManager.getInstance().setCurrentRecipeCategory("Salatalar");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });


        dessertButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(4);
                MainManager.getInstance().setCurrentRecipeCategory("Tatlılar");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });
        dessertButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(4);
                MainManager.getInstance().setCurrentRecipeCategory("Tatlılar");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });
        pastryButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(5);
                MainManager.getInstance().setCurrentRecipeCategory("Hamurişi");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });
        pastryButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setCurrentCategoryID(6);
                MainManager.getInstance().setCurrentRecipeCategory("Hamurişi");
                changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openHomePanel());
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
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
