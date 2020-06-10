package com.example.foodiary.Panel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.DatabaseGetter.Main;
import com.example.foodiary.R;

public class RecipeSuggestionPanel extends MainManager {
    private TextView category;
    private Button homeButton;
    private Button backButton;
    private LinearLayout RecipeList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_suggestion);

        category = (TextView) findViewById(R.id.category);
        homeButton = (Button) findViewById(R.id.home);
        backButton = (Button) findViewById(R.id.back);

        RecipeList = (LinearLayout) findViewById(R.id.recipe_list_with_approach);
        final AppCompatActivity activity = this;

        category.setText(MainManager.getInstance().getCurrentRecipeCategory());
        MainManager.getInstance().recipes();
//        MainManager.getInstance().getRecipe();
        RecipeList.removeAllViews();

        for (int i = 0; i < MainManager.getInstance().getRecipeNames().size(); i++) {
            final LinearLayout layoutToAdd = new LinearLayout(activity);
            layoutToAdd.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            params.setMargins(0, 12, 0, 0);
            layoutToAdd.setLayoutParams(params);
            layoutToAdd.setWeightSum(2);

            final ImageView recipeButton = new ImageView(activity);
            recipeButton.setImageResource(R.drawable.arrow_white);
            TableRow.LayoutParams imageProdParam = new TableRow.LayoutParams(40, 40);
            imageProdParam.setMargins(0, 20, 10, 10);
            recipeButton.setLayoutParams(imageProdParam);
            layoutToAdd.addView(recipeButton);

            TextView recipeName = new TextView(activity);
            recipeName.setText(MainManager.getInstance().getRecipeNames().get(i));
            recipeName.setTextSize(15);
            recipeName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            recipeName.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            recipeName.setWidth(200);
            TableRow.LayoutParams paramName = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT, 1f);
            paramName.setMargins(0, 20, 0, 20);
            recipeName.setLayoutParams(paramName);
            recipeName.setTextColor(Color.parseColor("#FFFFFF"));
            layoutToAdd.addView(recipeName);

            final int finalI = i;
            recipeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Main.setCurrentRecipeID(finalI);
                    MainManager.getInstance().setPastPage(0);
                    changeActivity(MainManager.getInstance().openRecipePanel());
                }
            });

            recipeName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Main.setCurrentRecipeID(finalI);
                    MainManager.getInstance().setPastPage(0);
                    changeActivity(MainManager.getInstance().openRecipePanel());
                }
            });

            RecipeList.addView(layoutToAdd);
        }


        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openHomePanel());
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipeCaregoryPanel());
            }
        });

    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}
