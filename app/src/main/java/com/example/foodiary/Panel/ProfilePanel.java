package com.example.foodiary.Panel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;


public class ProfilePanel extends MainManager {
    private Button editButton;
    private Button backButton;
    private Button homeButton;
    private Button deleteButton;
    private TextView name;
    private TextView surname;
    private TextView email;
    LinearLayout notificationList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        editButton = (Button) findViewById(R.id.edit);
        backButton = (Button) findViewById(R.id.back);
        homeButton = (Button) findViewById(R.id.home);

        email = (TextView) findViewById(R.id.emailPro);
        email.setText(MainManager.getInstance().getCurrentUserEmail());
        name = (TextView) findViewById(R.id.namePro);
        name.setText(MainManager.getInstance().getCurrentUserName());
        surname = (TextView) findViewById(R.id.surnamePro);
        surname.setText(MainManager.getInstance().getCurrentUserSurname());

        notificationList = (LinearLayout) findViewById(R.id.notification_list);
        final AppCompatActivity activity = this;
        MainManager.getInstance().date();

        for (int i = 0; i < MainManager.getInstance().getPastExpireDate().size(); i++) {
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
            ingredientName.setText(MainManager.getInstance().getPastExpireDate().get(i) + " - skt geçti!");
            ingredientName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            ingredientName.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            ingredientName.setWidth(400);
            TableRow.LayoutParams paramName = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            paramName.setMargins(0, 20, 0, 20);
            ingredientName.setLayoutParams(paramName);
            ingredientName.setTextColor(Color.parseColor("#FFFFFF"));
            layoutToAdd.addView(ingredientName);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int counter = 0;
                    //ingredient kontrol edilecek database de var mı diye (mainmanagerda metod)
                    //amount kontrol edilecek o kadar ürün var mı diye
                    //en son hepsi girilince database den silinecek
                    notificationList.removeView(layoutToAdd);
                }
            });

            notificationList.addView(layoutToAdd);
        }


        for (int i = 0; i < MainManager.getInstance().getApproachingExpirationDate().size(); i++) {
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
            ingredientName.setText(MainManager.getInstance().getApproachingExpirationDate().get(i) + " - skt yaklaştı!");
            ingredientName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            ingredientName.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            ingredientName.setWidth(400);
            TableRow.LayoutParams paramName = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            paramName.setMargins(0, 20, 0, 20);
            ingredientName.setLayoutParams(paramName);
            ingredientName.setTextColor(Color.parseColor("#FFFFFF"));
            layoutToAdd.addView(ingredientName);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int counter = 0;
                    //ingredient kontrol edilecek database de var mı diye (mainmanagerda metod)
                    //amount kontrol edilecek o kadar ürün var mı diye
                    //en son hepsi girilince database den silinecek
                    notificationList.removeView(layoutToAdd);
                }
            });

            notificationList.addView(layoutToAdd);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openHomePanel());
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openHomePanel());
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openEditProfilePanel());
            }
        });


    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}