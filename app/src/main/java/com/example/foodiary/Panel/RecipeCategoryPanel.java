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
    private Button backButton;

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
        pastryButton2 = (Button) findViewById(R.id.firstrecipe);

        homeButton = (Button) findViewById(R.id.home);
        backButton = (Button) findViewById(R.id.back);

        soupButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
            }
        });
        soupButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
            }
        });
        ricepastaButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
            }
        });
        ricepastaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
            }
        });
        dessertButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
            }
        });
        dessertButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
            }
        });
        saladButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
            }
        });
        saladButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
            }
        });
        mainCourseButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
            }
        });
        mainCourseButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
            }
        });
        pastryButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
            }
        });
        pastryButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seçilenleri mainManager a at recipeCategory sayfasında db den çekerken kullanılacak
                changeActivity(MainManager.getInstance().openSecondRecipeCategoryPanel());
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
