package com.example.foodiary.DatabaseGetter;

import java.util.ArrayList;

public class Product
{
    private String product_name;
    private ArrayList<Recipe> product_recipes;
    
    public Product(final String product_name) {
        this.product_recipes = new ArrayList<Recipe>();
        this.product_name = product_name;
    }
    
    public ArrayList<Recipe> getProduct_recipes() {
        return this.product_recipes;
    }
    
    public void setProduct_recipes(final Recipe e) {
        this.product_recipes.add(e);
    }
    
    public String getProduct_name() {
        return this.product_name;
    }
    
    public void setProduct_name(final String product_name) {
        this.product_name = product_name;
    }
}
