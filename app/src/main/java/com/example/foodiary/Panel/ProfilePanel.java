package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

public class ProfilePanel extends MainManager {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}