package com.example.foodiary.DatabaseGetter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseGetter
{
    static HashMap<String, Product> allProducts = new HashMap<String, Product>();
    static ArrayList<Product> deserts = new ArrayList<Product>();//tatlılar
    static ArrayList<Product> pastry = new ArrayList<Product>();//hamurişi
    static ArrayList<Product> soups = new ArrayList<Product>();//çorba
    static ArrayList<Product> mainDish = new ArrayList<Product>();//ana yemekler
    static ArrayList<Product> salads = new ArrayList<Product>();//salatalar
    static ArrayList<Product> riceMakaroni = new ArrayList<Product>();//pilav makarnalar

    
    public static void dataGetter(final String[] args) throws IOException, ParseException {
        final JSONParser jsonParser = new JSONParser();
        final JSONObject jsonObject = (JSONObject)jsonParser.parse((Reader)new FileReader("src/files/tatlilar.json"));
        deserts.add(iterateJson("kakao", jsonObject));
        deserts.add(iterateJson("muz", jsonObject));
        deserts.add(iterateJson("cikolata", jsonObject));
        deserts.add(iterateJson("sut", jsonObject));
        deserts.add(iterateJson("cilek", jsonObject));
        deserts.add(iterateJson("havuc", jsonObject));
        deserts.add(iterateJson("limon", jsonObject));
        deserts.add(iterateJson("un", jsonObject));
        deserts.add(iterateJson("armut", jsonObject));
        System.out.println("**********************************");
        final JSONObject jsonObject2 = (JSONObject)jsonParser.parse((Reader)new FileReader("src/files/anayemekler.json"));
        mainDish.add(iterateJson("sogan", jsonObject2));
        mainDish.add(iterateJson("tereyag", jsonObject2));
        mainDish.add(iterateJson("nohut", jsonObject2));
        mainDish.add(iterateJson("nane", jsonObject2));
        mainDish.add(iterateJson("fasulye", jsonObject2));
        mainDish.add(iterateJson("enginar", jsonObject2));
        mainDish.add(iterateJson("kabak", jsonObject2));
        mainDish.add(iterateJson("krema", jsonObject2));
        mainDish.add(iterateJson("patates", jsonObject2));
        mainDish.add(iterateJson("tavuk", jsonObject2));
        mainDish.add(iterateJson("yogurt", jsonObject2));
        mainDish.add(iterateJson("patlican", jsonObject2));
        mainDish.add(iterateJson("et", jsonObject2));
        mainDish.add(iterateJson("domates", jsonObject2));
        mainDish.add(iterateJson("kıyma", jsonObject2));
        mainDish.add(iterateJson("yumurta", jsonObject2));
        System.out.println("**********************************");
        final JSONObject jsonObject3 = (JSONObject)jsonParser.parse((Reader)new FileReader("src/files/hamur.json"));
        pastry.add(iterateJson("karnabahar", jsonObject3));
        pastry.add(iterateJson("mantar", jsonObject3));
        pastry.add(iterateJson("domates", jsonObject3));
        pastry.add(iterateJson("peynir", jsonObject3));
        pastry.add(iterateJson("ispanak", jsonObject3));
        pastry.add(iterateJson("patates", jsonObject3));
        pastry.add(iterateJson("pırasa", jsonObject3));
        pastry.add(iterateJson("un", jsonObject3));
        System.out.println("*********************************");
        final JSONObject jsonObject4 = (JSONObject)jsonParser.parse((Reader)new FileReader("src/files/corbalar.json"));
        soups.add(iterateJson("krema", jsonObject4));
        soups.add(iterateJson("tavuk", jsonObject4));
        soups.add(iterateJson("tereyag", jsonObject4));
        soups.add(iterateJson("nohut", jsonObject4));
        soups.add(iterateJson("nane", jsonObject4));
        soups.add(iterateJson("k\u0131yma", jsonObject4));
        soups.add(iterateJson("bal\u0131k", jsonObject4));
        System.out.println("*********************************");
        final JSONObject jsonObject5 = (JSONObject)jsonParser.parse((Reader)new FileReader("src/files/makarna_pilav.json"));
        riceMakaroni.add(iterateJson("pirinç", jsonObject5));
        riceMakaroni.add(iterateJson("patlıcan", jsonObject5));
        riceMakaroni.add(iterateJson("et", jsonObject5));
        riceMakaroni.add(iterateJson("bulgur", jsonObject5));
        riceMakaroni.add(iterateJson("makarna", jsonObject5));
        riceMakaroni.add(iterateJson("domates", jsonObject5));
        riceMakaroni.add(iterateJson("kıyma", jsonObject5));
        riceMakaroni.add(iterateJson("mantar", jsonObject5));
        riceMakaroni.add(iterateJson("kabak", jsonObject5));
        System.out.println("*********************************");
        final JSONObject jsonObject6 = (JSONObject)jsonParser.parse((Reader)new FileReader("src/files/salatalar.json"));
        salads.add(iterateJson("kereviz", jsonObject6));
        salads.add(iterateJson("börülce", jsonObject6));
        salads.add(iterateJson("makarna", jsonObject6));
        salads.add(iterateJson("kırmızı lahana", jsonObject6));
        salads.add(iterateJson("semizotu", jsonObject6));
        salads.add(iterateJson("maydanoz", jsonObject6));
        System.out.println("*********************************");
    }
    
    public static void parseArray(final JSONObject rec, final Product category) {
        final String name = rec.get((Object)"name").toString();
        final String img = rec.get((Object)"img").toString();
        final JSONArray ingr = (JSONArray)rec.get((Object)"ingredients");
        final String description = rec.get("description").toString();
        final Recipe recipe = new Recipe(name, img, description);
        for (int i = 0; i < ingr.size(); ++i) {
            recipe.setIngredients(ingr.get(i).toString());
        }
        category.setProduct_recipes(recipe);
    }

    
    public static Product iterateJson(final String productName, final JSONObject jsonObject) {
        final JSONObject a = (JSONObject)jsonObject.get((Object)productName);
        final JSONArray recipes = (JSONArray)a.get((Object)"recipes");
        final Product product1 = new Product(productName);
        for (int i = 0; i <recipes.size() ; i++) {
            parseArray((JSONObject) recipes.get(i),product1);
        }
        System.out.println("//////////////////////////////");
        System.out.println(productName);
        System.out.println("//////////////////////////////");
        allProducts.put(productName, product1);
        return product1;
    }
    

}
