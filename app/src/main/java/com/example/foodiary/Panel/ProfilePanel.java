package com.example.foodiary.Panel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
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


public class ProfilePanel extends MainManager implements NavigationView.OnNavigationItemSelectedListener {
    private Button editButton;
    private Button backButton;
    private Button homeButton;
    private Button deleteButton;
    private TextView name;
    private TextView surname;
    private TextView email;
    NavigationView navigationView;
    LinearLayout notificationList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_top);
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
        //MainManager.getInstance().date();

        //Kanki buraları commente aldım kod çalışssın diye burda currentUser objesinin
        //expire date arraylisti vardı ya ordan for ile iterate edicen

        for (int i = 0; i < MainManager.getCurrentUser().getPastExpirationDate().size(); i++) {
            final LinearLayout layoutToAdd = new LinearLayout(activity);
            layoutToAdd.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            params.setMargins(0, 12, 0, 0);
            layoutToAdd.setLayoutParams(params);
            layoutToAdd.setWeightSum(2);

            final ImageView notificationButton = new ImageView(activity);
            notificationButton.setImageResource(R.drawable.arrow_white);
            TableRow.LayoutParams imageProdParam = new TableRow.LayoutParams(40, 40);
            imageProdParam.setMargins(0, 20, 10, 10);
            notificationButton.setLayoutParams(imageProdParam);
            layoutToAdd.addView(notificationButton);

            TextView ingredientName = new TextView(activity);
            ingredientName.setText(MainManager.getCurrentUser().getPastExpirationDate().get(i) + " - skt geçti!");
            ingredientName.setTextSize(15);
            ingredientName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            ingredientName.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            ingredientName.setWidth(400);
            TableRow.LayoutParams paramName = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            paramName.setMargins(0, 20, 0, 20);
            ingredientName.setLayoutParams(paramName);
            ingredientName.setTextColor(Color.parseColor("#FFFFFF"));
            layoutToAdd.addView(ingredientName);

            notificationList.addView(layoutToAdd);
        }


        for (int i = 0; i < MainManager.getCurrentUser().getApproachingExpirationDate().size(); i++) {
            final LinearLayout layoutToAdd = new LinearLayout(activity);
            layoutToAdd.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            params.setMargins(0, 12, 0, 0);
            layoutToAdd.setLayoutParams(params);
            layoutToAdd.setWeightSum(2);

            final ImageView notificationButton = new ImageView(activity);
            notificationButton.setImageResource(R.drawable.arrow_white);
            TableRow.LayoutParams imageProdParam = new TableRow.LayoutParams(40, 40);
            imageProdParam.setMargins(0, 20, 10, 10);
            notificationButton.setLayoutParams(imageProdParam);
            layoutToAdd.addView(notificationButton);

            TextView ingredientName = new TextView(activity);
            ingredientName.setText(MainManager.getCurrentUser().getApproachingExpirationDate().get(i) + " - skt yaklaştı!");
            ingredientName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            ingredientName.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            ingredientName.setWidth(400);
            ingredientName.setTextSize(15);
            TableRow.LayoutParams paramName = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            paramName.setMargins(0, 20, 0, 20);
            ingredientName.setLayoutParams(paramName);
            ingredientName.setTextColor(Color.parseColor("#FFFFFF"));
            layoutToAdd.addView(ingredientName);

            notificationList.addView(layoutToAdd);
        }


        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openEditProfilePanel());
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

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
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
                MainManager.clearArraylists();
                MainManager.clearArraylists2();
                changeActivity(MainManager.getInstance().openRecipeCaregoryPanel());
                break;
        }
        return true;
    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}