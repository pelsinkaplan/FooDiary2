package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

public class StockPanel extends MainManager {
    private ImageButton vegetablesButton1;
    private ImageButton fruitButton1;
    private ImageButton beefButton1;
    private ImageButton legumeButton1;
    private ImageButton milkButton1;
    private ImageButton oilButton1;
    private ImageButton breakfastButton1;
    private ImageButton flourButton1;
    private ImageButton otherButton1;
    private Button otherButton2;
    private Button vegetablesButton2;
    private Button flourButton2;
    private Button breakfastButton2;
    private Button fruitButton2;
    private Button beefButton2;
    private Button legumeButton2;
    private Button milkButton2;
    private Button oilButton2;
    private Button homeButton;
    private Button menuButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock);
        vegetablesButton1 = (ImageButton) findViewById(R.id.veg1);
        fruitButton1 = (ImageButton) findViewById(R.id.fruit1);
        beefButton1 = (ImageButton) findViewById(R.id.beef1);
        legumeButton1 = (ImageButton) findViewById(R.id.legume1);
        milkButton1 = (ImageButton) findViewById(R.id.milk1);
        oilButton1 = (ImageButton) findViewById(R.id.oil1);
        breakfastButton1 = (ImageButton) findViewById(R.id.breakfast1);
        flourButton1 = (ImageButton) findViewById(R.id.flour1);
        otherButton1 = (ImageButton) findViewById(R.id.other1);

        vegetablesButton2 = (Button) findViewById(R.id.veg2);
        fruitButton2 = (Button) findViewById(R.id.fruit2);
        beefButton2 = (Button) findViewById(R.id.beef2);
        legumeButton2 = (Button) findViewById(R.id.legume2);
        milkButton2 = (Button) findViewById(R.id.milk2);
        oilButton2 = (Button) findViewById(R.id.oil2);
        breakfastButton2 = (Button) findViewById(R.id.breakfast2);
        flourButton2 = (Button) findViewById(R.id.flour2);
        otherButton2 = (Button) findViewById(R.id.other2);

        homeButton = (Button) findViewById(R.id.home);
        menuButton = (Button) findViewById(R.id.menu);


        //category buttons

        vegetablesButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("SEBZELER");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        fruitButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("MEYVELER");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        beefButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("ET ÜRÜNLERİ");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        legumeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("BAKLİYAT");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        milkButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("SÜT ÜRÜNLERİ");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        oilButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("YAĞLAR");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        breakfastButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("KAHVALTILIKLAR");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        flourButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("UNLU MAMÜLLER");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        otherButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("DİĞER");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });

        vegetablesButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("SEBZELER");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        fruitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("MEYVELER");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        beefButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("ET ÜRÜNLERİ");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        legumeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("BAKLİYAT");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        milkButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("SÜT ÜRÜNLERİ");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        oilButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("YAĞLAR");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        breakfastButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("KAHVALTILIKLAR");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        flourButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("UNLU MAMÜLLER");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });
        otherButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainManager.getInstance().setStockCategory("DİĞER");
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });

        //other buttons

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