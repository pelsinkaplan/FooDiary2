package com.example.foodiary.Panel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.DatabaseGetter.Main;
import com.example.foodiary.R;


public class RecipePanel extends MainManager {
    private Button homeButton;
    private Button backButton;
    private TextView recipeName;
    private TextView ingredients;
    private TextView description;
    private LinearLayout IngredientList;
    private LinearLayout DescriptionList;
    String recipeSearched;
    String ingredientsSearched;
    String descriptionSearched;
    boolean hasRecipe = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);
        homeButton = (Button) findViewById(R.id.home);
        backButton = (Button) findViewById(R.id.back);
        recipeName = (TextView) findViewById(R.id.recipe_name);
        ingredients = (TextView) findViewById(R.id.ingredients);
        description = (TextView) findViewById(R.id.make);


        IngredientList = (LinearLayout) findViewById(R.id.recipes_ingredients);
        DescriptionList = (LinearLayout) findViewById(R.id.recipes_description);
        final AppCompatActivity activity = this;

        getRecipe();
        getRecipe2();

        if (MainManager.getInstance().getPastPage() == 0) {//recipe category pageinden gelmişse
            if (MainManager.oneOtTwo) {
                recipeName.setText(MainManager.categoryRecipeNames.get(MainManager.getCurrentRecipeID()));
                final LinearLayout layoutToAdd1 = new LinearLayout(activity);
                layoutToAdd1.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
                params1.setMargins(0, 12, 0, 0);
                layoutToAdd1.setLayoutParams(params1);
                layoutToAdd1.setWeightSum(2);

                TextView ingredients = new TextView(activity);
                ingredients.setText(MainManager.currentIngredients);
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
                description.setText(MainManager.currentDescription);
                TableRow.LayoutParams paramPrice = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
                paramPrice.setMargins(0, 20, 0, 20);
                description.setLayoutParams(paramPrice);
                description.setTextColor(Color.parseColor("#FFFFFF"));
                description.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                layoutToAdd2.addView(description);

                IngredientList.addView(layoutToAdd1);
                DescriptionList.addView(layoutToAdd2);
            } else {
                recipeName.setText(MainManager.categoryRecipeNames2.get(MainManager.getCurrentRecipeID2()));
                final LinearLayout layoutToAdd1 = new LinearLayout(activity);
                layoutToAdd1.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
                params1.setMargins(0, 12, 0, 0);
                layoutToAdd1.setLayoutParams(params1);
                layoutToAdd1.setWeightSum(2);

                TextView ingredients = new TextView(activity);
                ingredients.setText(MainManager.currentIngredients);
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
                description.setText(MainManager.currentDescription);
                TableRow.LayoutParams paramPrice = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
                paramPrice.setMargins(0, 20, 0, 20);
                description.setLayoutParams(paramPrice);
                description.setTextColor(Color.parseColor("#FFFFFF"));
                description.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                layoutToAdd2.addView(description);

                IngredientList.addView(layoutToAdd1);
                DescriptionList.addView(layoutToAdd2);
            }


        } else if (MainManager.getInstance().getPastPage() == 1) {
            MainManager.getInstance().recipes();
            if ((MainManager.getInstance().getSearchedRecipe().toLowerCase()).equals("söğüş salata")) {
                recipeSearched = MainManager.getInstance().getRecipeNames().get(0);
                ingredientsSearched = MainManager.getInstance().corretTypeOfRecipeIngredient(MainManager.getInstance().getRecipeIngredients().get(0));
                descriptionSearched = MainManager.getInstance().corretTypeOfRecipeDescription(MainManager.getInstance().getRecipeDescriptions().get(0));
                hasRecipe = true;
            } else if ((MainManager.getInstance().getSearchedRecipe().toLowerCase()).equals("imambayıldı")) {
                recipeSearched = MainManager.getInstance().getRecipeNames().get(1);
                ingredientsSearched = MainManager.getInstance().corretTypeOfRecipeIngredient(MainManager.getInstance().getRecipeIngredients().get(1));
                descriptionSearched = MainManager.getInstance().corretTypeOfRecipeDescription(MainManager.getInstance().getRecipeDescriptions().get(1));
                hasRecipe = true;
            } else if ((MainManager.getInstance().getSearchedRecipe().toLowerCase()).equals("mantarlı makarna")) {
                recipeSearched = MainManager.getInstance().getRecipeNames().get(2);
                ingredientsSearched = MainManager.getInstance().corretTypeOfRecipeIngredient(MainManager.getInstance().getRecipeIngredients().get(2));
                descriptionSearched = MainManager.getInstance().corretTypeOfRecipeDescription(MainManager.getInstance().getRecipeDescriptions().get(2));
                hasRecipe = true;
            } else if ((MainManager.getInstance().getSearchedRecipe().toLowerCase()).equals("çoban böreği")) {
                recipeSearched = MainManager.getInstance().getRecipeNames().get(3);
                ingredientsSearched = MainManager.getInstance().corretTypeOfRecipeIngredient(MainManager.getInstance().getRecipeIngredients().get(3));
                descriptionSearched = MainManager.getInstance().corretTypeOfRecipeDescription(MainManager.getInstance().getRecipeDescriptions().get(3));
                hasRecipe = true;
            } else if ((MainManager.getInstance().getSearchedRecipe().toLowerCase()).equals("şehriyeli tavuk çorbası")) {
                recipeSearched = MainManager.getInstance().getRecipeNames().get(4);
                ingredientsSearched = MainManager.getInstance().corretTypeOfRecipeIngredient(MainManager.getInstance().getRecipeIngredients().get(4));
                descriptionSearched = MainManager.getInstance().corretTypeOfRecipeDescription(MainManager.getInstance().getRecipeDescriptions().get(4));
                hasRecipe = true;
            } else if ((MainManager.getInstance().getSearchedRecipe().toLowerCase()).equals("sütlaç")) {
                recipeSearched = MainManager.getInstance().getRecipeNames().get(5);
                ingredientsSearched = MainManager.getInstance().corretTypeOfRecipeIngredient(MainManager.getInstance().getRecipeIngredients().get(5));
                descriptionSearched = MainManager.getInstance().corretTypeOfRecipeDescription(MainManager.getInstance().getRecipeDescriptions().get(5));
                hasRecipe = true;
            }
            if (hasRecipe) {
                recipeName.setText(recipeSearched);
                final LinearLayout layoutToAdd1 = new LinearLayout(activity);
                layoutToAdd1.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
                params1.setMargins(0, 12, 0, 0);
                layoutToAdd1.setLayoutParams(params1);
                layoutToAdd1.setWeightSum(2);

                TextView ingredients = new TextView(activity);
                ingredients.setText(ingredientsSearched);
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
                description.setText(descriptionSearched);
                TableRow.LayoutParams paramPrice = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
                paramPrice.setMargins(0, 20, 0, 20);
                description.setLayoutParams(paramPrice);
                description.setTextColor(Color.parseColor("#FFFFFF"));
                description.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                layoutToAdd2.addView(description);


                IngredientList.addView(layoutToAdd1);
                DescriptionList.addView(layoutToAdd2);

            } else {
                recipeName.setText(MainManager.getInstance().getSearchedRecipe());
                final LinearLayout layoutToAdd1 = new LinearLayout(activity);
                layoutToAdd1.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
                params1.setMargins(0, 12, 0, 0);
                layoutToAdd1.setLayoutParams(params1);
                layoutToAdd1.setWeightSum(2);

                ingredients.setText("");
                description.setText("");

                TextView ingredients = new TextView(activity);
                ingredients.setText("Üzgünüz! \nAradığınız tarifi Bulamadık :(");
                ingredients.setTextSize(18);
                ingredients.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                ingredients.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                TableRow.LayoutParams paramName = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
                paramName.setMargins(0, 20, 0, 20);
                ingredients.setLayoutParams(paramName);
                ingredients.setTextColor(Color.parseColor("#FFFFFF"));
                layoutToAdd1.addView(ingredients);


                IngredientList.addView(layoutToAdd1);
            }

        }


        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oneOtTwo = false;
                changeActivity(MainManager.getInstance().openHomePanel());
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.clearArraylists();
                MainManager.clearArraylists2();
                if (MainManager.getInstance().getPastPage() == 0) {
                    oneOtTwo = false;
                    changeActivity(MainManager.getInstance().openRecipeSuggestionPanel());
                }
                 else if (MainManager.getInstance().getPastPage() == 1) {
                     oneOtTwo = false;
                    changeActivity(MainManager.getInstance().openHomePanel());
                }
            }
        });

    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}
