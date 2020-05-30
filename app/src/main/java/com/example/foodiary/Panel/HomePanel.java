package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

public class HomePanel extends MainManager {
    private TextView soupButton;
    private TextView mainFoodButton;
    private TextView legumesButton;
    private TextView dessertButton;
    private Button profileButton;
    private Button searchButton;
    private Button menuButton;
    private EditText searchEdit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        soupButton = (TextView) findViewById(R.id.daily_soup);
        mainFoodButton = (TextView) findViewById(R.id.main_food);
        legumesButton = (TextView) findViewById(R.id.legumes);
        dessertButton = (TextView) findViewById(R.id.dessert);
        profileButton = (Button) findViewById(R.id.profileButton);
        searchButton = (Button) findViewById(R.id.search);
        menuButton = (Button) findViewById(R.id.menu);
        searchEdit = (EditText) findViewById(R.id.searchBar);

        //bu kısımda db den random çekilen tariflerin adı alınarak gerekli yerlere konulacak

        soupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        mainFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        legumesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        dessertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openProfilePanel());
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bu kısımda db den tarif aranır ardından tarif bulunduysa recipe sayfasına geçilir
                changeActivity(MainManager.getInstance().openRecipePanel());
                //tarif bulunamadıysa ekrana error basılır
            }
        });

    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }

}
