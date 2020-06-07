package com.example.foodiary.DatabaseGetter;

import java.util.ArrayList;

public class Recipe
{
    private String name;
    private String img;
    private String description;
    private ArrayList<String> ingredients;
    
    public Recipe(final String name, final String img, final String description) {
        this.ingredients = new ArrayList<String>();
        this.name = name;
        this.img = img;
        this.description = description;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public String getImg() {
        return this.img;
    }
    
    public void setImg(final String img) {
        this.img = img;
    }
    
    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }
    
    public void setIngredients(final String ingredient) {
        this.ingredients.add(ingredient);
    }
}
