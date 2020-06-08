package com.example.foodiary.Panel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;
import com.google.android.material.navigation.NavigationView;

public class StockPanel extends MainManager implements NavigationView.OnNavigationItemSelectedListener {
    private Button addButton;
    private Button homeButton;
    private Button backButton;
    private EditText ingredientEdit;
    private EditText amountEdit;
    private EditText expireDateEdit;
    private String ingredient;
    private String amount;
    private String expireDate;
    private LinearLayout IngredientList;
    NavigationView navigationView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_top);

        addButton = (Button) findViewById(R.id.add);

        ingredientEdit = (EditText) findViewById(R.id.ingredient);
        amountEdit = (EditText) findViewById(R.id.amount);
        expireDateEdit = (EditText) findViewById(R.id.expiredate);

        homeButton = (Button) findViewById(R.id.home);
        backButton = (Button) findViewById(R.id.back);

        IngredientList = (LinearLayout) findViewById(R.id.recipe_list_with_approach);
        final AppCompatActivity activity = this;



        for (int i = 0; i < MainManager.getInstance().getStockList().size(); i++) {
            final LinearLayout layoutToAdd = new LinearLayout(activity);
            layoutToAdd.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            params.setMargins(0, 12, 0, 0);
            layoutToAdd.setLayoutParams(params);
            layoutToAdd.setWeightSum(2);

            final ImageView deleteButton = new ImageView(activity);
            deleteButton.setImageResource(R.drawable.remove);
            TableRow.LayoutParams imageProdParam = new TableRow.LayoutParams(40, 40);
            imageProdParam.setMargins(0, 20, 10, 10);
            deleteButton.setLayoutParams(imageProdParam);
            layoutToAdd.addView(deleteButton);

            TextView ingredientName = new TextView(activity);
            ingredientName.setText(MainManager.getInstance().getStockList().get(i).get(0));
            ingredientName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            ingredientName.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            ingredientName.setWidth(200);
            TableRow.LayoutParams paramName = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            paramName.setMargins(0, 20, 0, 20);
            ingredientName.setLayoutParams(paramName);
            ingredientName.setTextColor(Color.parseColor("#FFFFFF"));
            layoutToAdd.addView(ingredientName);

            TextView ingredientAmount = new TextView(activity);
            ingredientAmount.setText(MainManager.getInstance().getStockList().get(i).get(1));
            TableRow.LayoutParams paramPrice = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            ingredientAmount.setWidth(100);
            paramPrice.setMargins(0, 20, 0, 20);
            ingredientAmount.setLayoutParams(paramPrice);
            ingredientAmount.setTextColor(Color.parseColor("#FFFFFF"));
            ingredientAmount.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            layoutToAdd.addView(ingredientAmount);

            TextView ingredientExpireDate = new TextView(activity);
            ingredientExpireDate.setText(MainManager.getInstance().getStockList().get(i).get(2));
            TableRow.LayoutParams paramNote = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            ingredientExpireDate.setWidth(200);
            paramNote.setMargins(0, 20, 0, 20);
            ingredientExpireDate.setLayoutParams(paramNote);
            ingredientExpireDate.setTextColor(Color.parseColor("#FFFFFF"));
            ingredientExpireDate.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            layoutToAdd.addView(ingredientExpireDate);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int counter = 0;
                    IngredientList.removeView(layoutToAdd);
                }
            });

            IngredientList.addView(layoutToAdd);
        }


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredient = ingredientEdit.getText().toString();
                amount = amountEdit.getText().toString();
                expireDate = expireDateEdit.getText().toString();
                int counter = 0;
                if (MainManager.getInstance().controlNameIngredient(ingredient).length() == 0) {

                    counter++;
                } else {
                    ingredientEdit.setError(MainManager.getInstance().controlNameIngredient(ingredient));
                }
                //expire date  check if there is an error then print error message
                if (MainManager.getInstance().controlExpireDateIngredient(expireDate).length() == 0) {
                    counter++;
                } else {
                    expireDateEdit.setError(MainManager.getInstance().controlExpireDateIngredient(expireDate));
                }
                if (counter == 2) {
                    MainManager.getInstance().setStockList(ingredient, amount, expireDate);
                    final LinearLayout layoutToAdd = new LinearLayout(activity);
                    layoutToAdd.setOrientation(LinearLayout.HORIZONTAL);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
                    params.setMargins(0, 12, 0, 0);
                    layoutToAdd.setLayoutParams(params);
                    layoutToAdd.setWeightSum(2);

                    final ImageView deleteButton = new ImageView(activity); //Product rate button
                    deleteButton.setImageResource(R.drawable.remove);
                    TableRow.LayoutParams imageProdParam = new TableRow.LayoutParams(40, 40);
                    imageProdParam.setMargins(0, 20, 10, 10);
                    deleteButton.setLayoutParams(imageProdParam);
                    layoutToAdd.addView(deleteButton);

                    TextView ingredientName = new TextView(activity); // Product Title
                    ingredientName.setText(ingredient);
                    ingredientName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                    ingredientName.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    ingredientName.setWidth(200);
                    TableRow.LayoutParams paramName = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
                    paramName.setMargins(0, 20, 0, 20);
                    ingredientName.setLayoutParams(paramName);
                    ingredientName.setTextColor(Color.parseColor("#FFFFFF"));
                    layoutToAdd.addView(ingredientName);

                    TextView ingredientAmount = new TextView(activity); //Product Price
                    ingredientAmount.setText(amount);
                    TableRow.LayoutParams paramPrice = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
                    ingredientName.setWidth(100);
                    paramPrice.setMargins(0, 20, 0, 20);
                    ingredientAmount.setLayoutParams(paramPrice);
                    ingredientAmount.setTextColor(Color.parseColor("#FFFFFF"));
                    ingredientAmount.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    layoutToAdd.addView(ingredientAmount);

                    TextView ingredientExpireDate = new TextView(activity); //Product Note
                    ingredientExpireDate.setText(expireDate);
                    TableRow.LayoutParams paramNote = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
                    ingredientExpireDate.setWidth(200);
                    paramNote.setMargins(0, 20, 0, 20);
                    ingredientExpireDate.setLayoutParams(paramNote);
                    ingredientExpireDate.setTextColor(Color.parseColor("#FFFFFF"));
                    ingredientExpireDate.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    layoutToAdd.addView(ingredientExpireDate);
                    deleteButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int counter = 0;
                            //arrayden silme işlemini yapppppppp ***********************************************************
                            IngredientList.removeView(layoutToAdd);
                        }


                    });

                    IngredientList.addView(layoutToAdd);
                }

            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    //menü için kullanılacak sonradan
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                changeActivity(MainManager.getInstance().openHomePanel());
                break;
            case R.id.nav_profile:
                changeActivity(MainManager.getInstance().openProfilePanel());
                break;
            case R.id.nav_stock:
                changeActivity(MainManager.getInstance().openIngredientPanel());
                break;
            case R.id.nav_recipe:
                changeActivity(MainManager.getInstance().openRecipeCaregoryPanel());
                break;
        }
        return true;
    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}
