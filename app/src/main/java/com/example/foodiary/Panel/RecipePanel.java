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


public class RecipePanel extends MainManager {
    private Button homeButton;
    private Button backButton;
    private TextView recipeName;
    private LinearLayout IngredientList;
    private LinearLayout DescriptionList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);
        homeButton = (Button) findViewById(R.id.home);
        backButton = (Button) findViewById(R.id.back);
        recipeName = (TextView) findViewById(R.id.recipe_name);

        recipeName.setText(MainManager.getInstance().getRecipeNames().get(Main.getCurrentRecipeID()));

        IngredientList = (LinearLayout) findViewById(R.id.recipes_ingredients);
        DescriptionList = (LinearLayout) findViewById(R.id.recipes_description);
        final AppCompatActivity activity = this;
        if (MainManager.getInstance().getPastPage() == 0) {
            final LinearLayout layoutToAdd1 = new LinearLayout(activity);
            layoutToAdd1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            params1.setMargins(0, 12, 0, 0);
            layoutToAdd1.setLayoutParams(params1);
            layoutToAdd1.setWeightSum(2);

            TextView ingredients = new TextView(activity);
            ingredients.setText(MainManager.getInstance().corretTypeOfRecipeIngredient(MainManager.getInstance().getRecipeIngredients().get(Main.getCurrentRecipeID())));
            ingredients.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            ingredients.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            TableRow.LayoutParams paramName = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            paramName.setMargins(0, 20, 0, 20);
            ingredients.setLayoutParams(paramName);
            ingredients.setTextColor(Color.parseColor("#FFFFFF"));
            layoutToAdd1.addView(ingredients);

            final LinearLayout layoutToAdd2 = new LinearLayout(activity);
            layoutToAdd2.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            params2.setMargins(0, 12, 0, 0);
            layoutToAdd2.setLayoutParams(params2);
            layoutToAdd2.setWeightSum(2);

            TextView description = new TextView(activity);
            description.setText(MainManager.getInstance().corretTypeOfRecipeDescription(MainManager.getInstance().getRecipeDescriptions().get(Main.getCurrentRecipeID())));
            TableRow.LayoutParams paramPrice = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            paramPrice.setMargins(0, 20, 0, 20);
            description.setLayoutParams(paramPrice);
            description.setTextColor(Color.parseColor("#FFFFFF"));
            description.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            layoutToAdd2.addView(description);


            IngredientList.addView(layoutToAdd1);
            DescriptionList.addView(layoutToAdd2);

        } else if (MainManager.getInstance().getPastPage() == 1) {

            final LinearLayout layoutToAdd1 = new LinearLayout(activity);
            layoutToAdd1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            params1.setMargins(0, 12, 0, 0);
            layoutToAdd1.setLayoutParams(params1);
            layoutToAdd1.setWeightSum(2);

            TextView ingredients = new TextView(activity);
            ingredients.setText(MainManager.getInstance().corretTypeOfRecipeIngredient(MainManager.getInstance().getRecipeIngredients().get(Main.getCurrentRecipeID())));
            ingredients.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            ingredients.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            TableRow.LayoutParams paramName = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            paramName.setMargins(0, 20, 0, 20);
            ingredients.setLayoutParams(paramName);
            ingredients.setTextColor(Color.parseColor("#FFFFFF"));
            layoutToAdd1.addView(ingredients);

            final LinearLayout layoutToAdd2 = new LinearLayout(activity);
            layoutToAdd2.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            params2.setMargins(0, 12, 0, 0);
            layoutToAdd2.setLayoutParams(params2);
            layoutToAdd2.setWeightSum(2);

            TextView description = new TextView(activity);
            description.setText(MainManager.getInstance().corretTypeOfRecipeDescription(MainManager.getInstance().getRecipeDescriptions().get(Main.getCurrentRecipeID())));
            TableRow.LayoutParams paramPrice = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            paramPrice.setMargins(0, 20, 0, 20);
            description.setLayoutParams(paramPrice);
            description.setTextColor(Color.parseColor("#FFFFFF"));
            description.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            layoutToAdd2.addView(description);


            IngredientList.addView(layoutToAdd1);
            DescriptionList.addView(layoutToAdd2);
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
                finish();
            }
        });

    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}
