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
    static HashMap<String, Product> deserts = new HashMap<String, Product>();
    static HashMap<String, Product> pastry = new HashMap<String, Product>();//hamurişi
    static HashMap<String, Product> soups = new HashMap<String, Product>();//çorba
    static HashMap<String, Product> mainDish = new HashMap<String, Product>();//ana yemekler
    static HashMap<String, Product> salads = new HashMap<String, Product>();//salatalar
    static HashMap<String, Product> riceMakaroni = new HashMap<String, Product>();//pilav makarnalar
    static ArrayList<User> allUsers = new ArrayList<>();

    public ArrayList<User> returnUserList(){
        return allUsers;
    }
    public void createUsersandStock(){

         User user1 = new User("Seda","Aslan","sedaaslan","sedaaslan@gmail.com","sedaaslan");
         User user2 = new User("Mehmet"," Kara","mehmetkara","mehmetkara@gmail.com","mehmetkara");
         User user3 = new User("Buse"," Ayhan","buseayhan","buseayhan@gmail.com","mehmetkara");
         allUsers.add(user1);
         allUsers.add(user2);
         allUsers.add(user3);
         StockProduct p3 = new StockProduct("nohut",20200610,"1 kilo");
         StockProduct p1 = new StockProduct("muz",20200608,"3 tane");
         StockProduct p2 = new StockProduct("un",20200609,"1 kilo");
        StockProduct p4 = new StockProduct("tereyag",20200609,"1 kilo");

        user1.addToStock(p1);
         user2.addToStock(p2);
         user1.addToStock(p3);
         user1.setApproachingExpirationDate(p3.getName());
         user1.setApproachingExpirationDate(p4.getName());


    }
    public HashMap<String, Product> getCategoryRecipes(int categoryID) {
        switch (categoryID) {
            case 0:
                return soups;
            case 1:
                return mainDish;
            case 2:
                return riceMakaroni;
            case 3:
                return salads;
            case 4:
                return deserts;
            case 5:
                return pastry;
            default:
                System.out.println("Wrong id");
        }
        return null;
    }
    public void addProductToStockList(User user,String name,int skt, String amount){
        StockProduct product = new StockProduct(name, skt,amount);
        user.addToStock(product);
    }

    public Recipe getRecipe(String productName,int index){//o ürünün i. index recipeını döndürür.
        if(allProducts.containsKey(productName)){
            return allProducts.get(productName).getProduct_recipes().get(index);
        }
        return null;
    }


    public void createDatabase() throws IOException, ParseException {
        final JSONParser jsonParser = new JSONParser();
        final JSONObject jsonObject = (JSONObject)jsonParser.parse((Reader)new FileReader("src/main/java/com/example/foodiary/files/tatlilar.json"));
        deserts.put("kakao",iterateJson("kakao", jsonObject));
        deserts.put("muz",iterateJson("muz", jsonObject));
        deserts.put("cikolata",iterateJson("cikolata", jsonObject));
        deserts.put("sut", iterateJson("sut", jsonObject));
        deserts.put("cilek",iterateJson("cilek", jsonObject));
        deserts.put("havuc",iterateJson("havuc", jsonObject));
        deserts.put("limon",iterateJson("limon", jsonObject));
        deserts.put("un",iterateJson("un", jsonObject));
        deserts.put("armut",iterateJson("armut", jsonObject));
        System.out.println("**********************************");
        final JSONObject jsonObject2 = (JSONObject)jsonParser.parse((Reader)new FileReader("src/main/java/com/example/foodiary/files/anayemekler.json"));
        mainDish.put("sogan",iterateJson("sogan", jsonObject2));
        mainDish.put("tereyag",iterateJson("tereyag", jsonObject2));
        mainDish.put("nohut",iterateJson("nohut", jsonObject2));
        mainDish.put("nane",iterateJson("nane", jsonObject2));
        mainDish.put("fasulye",iterateJson("fasulye", jsonObject2));
        mainDish.put("enginar",iterateJson("enginar", jsonObject2));
        mainDish.put("kabak",iterateJson("kabak", jsonObject2));
        mainDish.put("krema",iterateJson("krema", jsonObject2));
        mainDish.put("patates",iterateJson("patates", jsonObject2));
        mainDish.put("tavuk",iterateJson("tavuk", jsonObject2));
        mainDish.put("yogurt",iterateJson("yogurt", jsonObject2));
        mainDish.put("patlican",iterateJson("patlican", jsonObject2));
        mainDish.put("et",iterateJson("et", jsonObject2));
        mainDish.put("domates",iterateJson("domates", jsonObject2));
        mainDish.put("kıyma",iterateJson("kıyma", jsonObject2));
        mainDish.put("yumurta",iterateJson("yumurta", jsonObject2));
        System.out.println("**********************************");
        final JSONObject jsonObject3 = (JSONObject)jsonParser.parse((Reader)new FileReader("src/main/java/com/example/foodiary/files/hamur.json"));
        pastry.put("karnabahar",iterateJson("karnabahar", jsonObject3));
        pastry.put("mantar",iterateJson("mantar", jsonObject3));
        pastry.put("domates",iterateJson("domates", jsonObject3));
        pastry.put("peynir",iterateJson("peynir", jsonObject3));
        pastry.put("ispanak",iterateJson("ispanak", jsonObject3));
        pastry.put("patates",iterateJson("patates", jsonObject3));
        pastry.put("pırasa",iterateJson("pırasa", jsonObject3));
        pastry.put("un",iterateJson("un", jsonObject3));
        System.out.println("*********************************");
        final JSONObject jsonObject4 = (JSONObject)jsonParser.parse((Reader)new FileReader("src/main/java/com/example/foodiary/files/corbalar.json"));
        soups.put("krema",iterateJson("krema", jsonObject4));
        soups.put("tavuk",iterateJson("tavuk", jsonObject4));
        soups.put("tereyag",iterateJson("tereyag", jsonObject4));
        soups.put("nohut",iterateJson("nohut", jsonObject4));
        soups.put("nane",iterateJson("nane", jsonObject4));
        soups.put("kıyma",iterateJson("kıyma", jsonObject4));
        soups.put("balık", iterateJson("balık", jsonObject4));
        System.out.println("*********************************");
        final JSONObject jsonObject5 = (JSONObject)jsonParser.parse((Reader)new FileReader("src/main/java/com/example/foodiary/files/makarna_pilav.json"));
        riceMakaroni.put("pirinç",iterateJson("pirinç", jsonObject5));
        riceMakaroni.put("patlıcan",iterateJson("patlıcan", jsonObject5));
        riceMakaroni.put("et",iterateJson("et", jsonObject5));
        riceMakaroni.put("bulgur",iterateJson("bulgur", jsonObject5));
        riceMakaroni.put("makarna",iterateJson("makarna", jsonObject5));
        riceMakaroni.put("domates",iterateJson("domates", jsonObject5));
        riceMakaroni.put("kıyma",iterateJson("kıyma", jsonObject5));
        riceMakaroni.put("mantar",iterateJson("mantar", jsonObject5));
        riceMakaroni.put("kabak",iterateJson("kabak", jsonObject5));
        System.out.println("*********************************");
        final JSONObject jsonObject6 = (JSONObject)jsonParser.parse((Reader)new FileReader("src/main/java/com/example/foodiary/files/salatalar.json"));
        salads.put("kereviz",iterateJson("kereviz", jsonObject6));
        salads.put("börülce",iterateJson("börülce", jsonObject6));
        salads.put("makarna",iterateJson("makarna", jsonObject6));
        salads.put("kırmızı lahana",iterateJson("kırmızı lahana", jsonObject6));
        salads.put("semizotu",iterateJson("semizotu", jsonObject6));
        salads.put("maydanoz",iterateJson("maydanoz", jsonObject6));
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
