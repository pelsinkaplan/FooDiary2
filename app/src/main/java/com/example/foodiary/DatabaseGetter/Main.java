package com.example.foodiary.DatabaseGetter;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static List<String> pastExpireDate = new ArrayList<String>();
    private static List<String> approachingExpirationDate = new ArrayList<String>();
    private static User currentUser;
    private static Recipe currentRecipe;
    private static int currentRecipeID;
    private static String currentRecipeCategory = "";
    private static String currentRecipeName = "";



    private static int currentCategoryID = 0;
    private static String currentDescription="";
    private static ArrayList<String> currentIngredients= new ArrayList<String>();


    private static ArrayList<String> categoryRecipeNames =new ArrayList<String>();//Category recipelarını gösterir
    private static ArrayList<String> productNameOfCurrentRecipe = new ArrayList<>();//recipeların hangi üründe olduğu
    private static ArrayList<Integer> recipeIndexInProduct = new ArrayList<Integer>();//recipeın hangi indexde odluğu
    static DatabaseGetter db;

    public static void main(String[] args) throws IOException, ParseException {
        db = new DatabaseGetter();
        db.createUsersandStock();
        db.createDatabase();
        currentUser = DatabaseGetter.allUsers.get(0);
        currentRecipeID = 7;
        setInformations();
        currentRecipe = db.getRecipe(productNameOfCurrentRecipe.get(currentRecipeID),recipeIndexInProduct.get(currentRecipeID));
        setRecipeInformations();
    }
    public static void setRecipeInformations(){
        currentRecipeName = currentRecipe.getName();
        currentDescription = currentRecipe.getDescription();
        currentIngredients = currentRecipe.getIngredients();
        System.out.println(currentRecipeName);
        System.out.println(currentDescription);
        System.out.println(currentIngredients);
    }
    public static void setInformations(){
        HashMap<String,Product> category = db.getCategoryRecipes(currentCategoryID);
        showFoodRecipesInCategoryPage(category,currentUser);
    }

    public static void showFoodRecipesInCategoryPage(HashMap<String, Product> category, User user){
        for (int i = 0; i <user.getApproachingExpirationDate().size() ; i++) {
            if(category.containsKey(user.getApproachingExpirationDate().get(i))){//Son kullanma tarihi yaklaşan ürünlere
                //bak eğer stoktaki yiyeceklerden listemde varsa bastır
                Product p = category.get(user.getApproachingExpirationDate().get(i));
                for (int j = 0; j <p.getProduct_recipes().size() ; j++) {
                    String recipeName = p.getProduct_recipes().get(j).getName();//recipeların isimlerini göster
                    categoryRecipeNames.add(recipeName);
                    productNameOfCurrentRecipe.add(p.getProduct_name());
                    recipeIndexInProduct.add(j);
                    System.out.println(recipeName);
                }
            }
        }
    }

    public void iterateRecipe(Recipe recipe){
        String recipeName = recipe.getName();
        String description = recipe.getDescription();
        ArrayList<String> list = new ArrayList<>();
        list = recipe.getIngredients();
    }

    public void getUpComingFoodRecipes(ArrayList<String> upcomingExpire){
        for (int i = 0; i <upcomingExpire.size() ; i++) {

        }
    }

    public void setCurrentCategoryID(int currentCategoryID) {
        this.currentCategoryID = currentCategoryID;
    }

    public static int getCurrentRecipeID() {
        return currentRecipeID;
    }

    public static void setCurrentRecipeID(int currentRecipeID) {
        Main.currentRecipeID = currentRecipeID;
    }

    public static ArrayList<String> getCategoryRecipeNames() {
        return categoryRecipeNames;
    }
}

