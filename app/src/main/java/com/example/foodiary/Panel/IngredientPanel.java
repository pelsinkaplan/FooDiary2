package com.example.foodiary.Panel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

import java.util.ArrayList;
import java.util.List;

public class IngredientPanel extends MainManager {
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
    private List<List<String>> stockListColumn = new ArrayList<List<String>>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock);

        addButton = (Button) findViewById(R.id.add);

        ingredientEdit = (EditText) findViewById(R.id.ingredient);
        amountEdit = (EditText) findViewById(R.id.amount);
        expireDateEdit = (EditText) findViewById(R.id.expiredate);

        homeButton = (Button) findViewById(R.id.home);
        backButton = (Button) findViewById(R.id.back);
        ArrayList<String> tempList =  new ArrayList<String>();
//        tempList.add("ingredient");
//        tempList.add("amount");
//        tempList.add("expireDate");
//        stockListColumn.add(tempList);


        IngredientList = (LinearLayout) findViewById(R.id.ingredient_list);
        final AppCompatActivity activity = this;

        for (int i = 0; i < stockListColumn.size(); i++) {
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
            ingredientName.setText(stockListColumn.get(i).get(0));
            ingredientName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            ingredientName.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            ingredientName.setWidth(200);
            TableRow.LayoutParams paramName = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            paramName.setMargins(0, 20, 0, 20);
            ingredientName.setLayoutParams(paramName);
            ingredientName.setTextColor(Color.parseColor("#FFFFFF"));
            layoutToAdd.addView(ingredientName);

            TextView ingredientAmount = new TextView(activity);
            ingredientAmount.setText(stockListColumn.get(i).get(1));
            TableRow.LayoutParams paramPrice = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            ingredientAmount.setWidth(100);
            paramPrice.setMargins(0, 20, 0, 20);
            ingredientAmount.setLayoutParams(paramPrice);
            ingredientAmount.setTextColor(Color.parseColor("#FFFFFF"));
            ingredientAmount.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            layoutToAdd.addView(ingredientAmount);

            TextView ingredientExpireDate = new TextView(activity);
            ingredientExpireDate.setText(stockListColumn.get(i).get(2));
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
                    //ingredient kontrol edilecek database de var mı diye (mainmanagerda metod)
                    //amount kontrol edilecek o kadar ürün var mı diye
                    //en son hepsi girilince database den silinecek
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
                    //check db else print error
                    counter++;
                } else {
                    ingredientEdit.setError(MainManager.getInstance().controlNameIngredient(ingredient));
                }
                //expire date  check if there is an error then print error message
                if (MainManager.getInstance().controlExpireDateIngredient(expireDate).length() == 0) {
                    //check db else print error
                    counter++;
                } else {
                    expireDateEdit.setError(MainManager.getInstance().controlExpireDateIngredient(expireDate));
                }
                if (counter == 2) {

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
                            //ingredient kontrol edilecek database de var mı diye (mainmanagerda metod)
                            //amount kontrol edilecek o kadar ürün var mı diye
                            //en son hepsi girilince database den silinecek
                            IngredientList.removeView(layoutToAdd);
                        }


                    });

                    IngredientList.addView(layoutToAdd);
                }

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
