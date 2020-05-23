package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

public class IngredientPanel extends MainManager{
    private Button addButton;
    private Button deleteButton;
    private Button homeButton;
    private Button backButton;
    private EditText ingredientEdit;
    private EditText amountEdit;
    private EditText expireDateEdit;
    private String ingredient;
    private String amount;
    private String expireDate;
    private TextView ingredientType;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingredients);

        addButton = (Button) findViewById(R.id.add);
        deleteButton = (Button) findViewById(R.id.delete);

        ingredientEdit = (EditText) findViewById(R.id.ingredient);
        amountEdit = (EditText) findViewById(R.id.amount);
        expireDateEdit = (EditText) findViewById(R.id.expiredate);

        ingredientType = (TextView) findViewById(R.id.ingredientType);
        ingredientType.setText(MainManager.getInstance().getIngredientCategory());

        homeButton = (Button) findViewById(R.id.home);
        backButton = (Button) findViewById(R.id.back);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredient = ingredientEdit.getText().toString();
                amount = amountEdit.getText().toString();
                expireDate = expireDateEdit.getText().toString();
                int counter = 0;
                //meyveler için condition
                //ingredient kontrol edilecek ve database de var ise yanına numara eklenerek yazılacak (mainmanagerda metod)
                //en son hepsi girilince database e eklenecek
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredient = ingredientEdit.getText().toString();
                amount = amountEdit.getText().toString();
                expireDate = expireDateEdit.getText().toString();
                int counter = 0;
                //ingredient kontrol edilecek database de var mı diye (mainmanagerda metod)
                //amount kontrol edilecek o kadar ürün var mı diye
                //en son hepsi girilince database den silinecek
                changeActivity(MainManager.getInstance().openIngredientPanel());
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
                changeActivity(MainManager.getInstance().openStockPanel());
            }
        });




    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}
