package com.example.foodiary.Controller;

import android.os.Bundle;
import com.example.foodiary.Panel.EditProfilePanel;
import com.example.foodiary.Panel.HomePanel;
import com.example.foodiary.Panel.RecipeCategoryPanel;
import com.example.foodiary.Panel.StockPanel;
import com.example.foodiary.Panel.LoginPanel;
import com.example.foodiary.Panel.ProfilePanel;
import com.example.foodiary.Panel.RecipePanel;
import com.example.foodiary.Panel.RegisterPanel;
import com.example.foodiary.Panel.RecipeSuggestionPanel;
import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainManager extends AppCompatActivity {
    private final static MainManager instance = new MainManager();
    //password, name ve surname db den çekilecek (defaultları)
    private String currentUserName = "";
    private String currentUserSurname = "";
    private String currentUserEmail = "";
    private String currentUserPassword = "";
    private int currentUserID = 0;
    private String currentRecipeCategory = "";
    private String currentRecipeName = "";
    private int currentCategoryID = 0;
    //recipeList categorye göre çekilir
    private List<List<String>> recipeList = new ArrayList<List<String>>();
    //user ilk girişte userListten çekilir ve current bilgiler değiştirilir. Userın stoğu stockListe atılır
    private List<List<String>> userList = new ArrayList<List<String>>();
    private List<List<String>> stockList = new ArrayList<List<String>>();
    private List<String> pastExpireDate = new ArrayList<String>();
    private List<String> approachingExpirationDate = new ArrayList<String>();

    public int getCurrentUserID() {
        return currentUserID;
    }

    public void setCurrentUserID(int currentUserID) {
        this.currentUserID = currentUserID;
    }

    public void users() {
        List<String> tempList1 = new ArrayList<String>();
        List<String> tempList2 = new ArrayList<String>();
        List<String> tempList3 = new ArrayList<String>();
        List<String> tempList4 = new ArrayList<String>();
        tempList1.add("Seda");
        tempList1.add("Aslan");
        tempList1.add("sedaaslan@gmail.com");
        tempList1.add("sedaaslan");
        userList.add(tempList1);

        tempList2.add("Mehmet");
        tempList2.add("Kara");
        tempList2.add("mehmetkara@gmail.com");
        tempList2.add("mehmetkara");
        userList.add(tempList2);

        tempList3.add("Buse");
        tempList3.add("Ayhan");
        tempList3.add("buseayhan@gmail.com");
        tempList3.add("buseayhan");
        userList.add(tempList3);

        tempList4.add("Zeynep");
        tempList4.add("Korkmaz");
        tempList4.add("zeynepkorkmaz@gmail.com");
        tempList4.add("zeynepkorkmaz");
        userList.add(tempList4);
    }

//    public void stockFirstUser() {
//        List<String> tempList1 = new ArrayList<String>();
//        List<String> tempList2 = new ArrayList<String>();
//        List<String> tempList3 = new ArrayList<String>();
//        List<String> tempList4 = new ArrayList<String>();
//        List<String> tempList5 = new ArrayList<String>();
//        List<String> tempList6 = new ArrayList<String>();
//        List<String> tempList7 = new ArrayList<String>();
//        List<String> tempList8 = new ArrayList<String>();
//        tempList1.add("Kakao");
//        tempList1.add("125 gr");
//        tempList1.add("08.06.2020");
//        tempList2.add("Makarna");
//        tempList2.add("250 gr");
//        tempList2.add("30.01.2021");
//        tempList3.add("Patates");
//        tempList3.add("3 kg");
//        tempList3.add(" ");
//        tempList4.add("Et");
//        tempList4.add("2 kg");
//        tempList4.add(" ");
//        tempList5.add("Un");
//        tempList5.add("5 kg");
//        tempList5.add("10.12.2020");
//        tempList6.add("Muz");
//        tempList6.add("2 kg");
//        tempList6.add(" ");
//        tempList7.add("Mantar");
//        tempList7.add("1 kg");
//        tempList7.add(" ");
//        tempList8.add("Tavuk");
//        tempList8.add("2 kg");
//        tempList8.add(" ");
//        stockList.add(tempList1);
//        stockList.add(tempList2);
//        stockList.add(tempList3);
//        stockList.add(tempList4);
//        stockList.add(tempList5);
//        stockList.add(tempList6);
//        stockList.add(tempList7);
//        stockList.add(tempList8);
//    }

    public List<String> getPastExpireDate() {
        return pastExpireDate;
    }

    public void setPastExpireDate() {
        date();
    }

    public List<String> getApproachingExpirationDate() {
        return approachingExpirationDate;
    }

    public void setApproachingExpirationDate() {
        date();
    }


    public List<List<String>> getRecipeList() {
        return recipeList;
    }


    public List<List<String>> getUserList() {
        return userList;
    }

    public void setUserList(List<String> newUserList) {
        userList.add(newUserList);
    }

    public List<List<String>> getStockList() {
        return stockList;
    }

    public void setStockList(String ingredientName, String ingredientAmount, String ingredientExpireDate) {
        List<String> tempList = new ArrayList<String>();
        tempList.add(ingredientName);
        tempList.add(ingredientAmount);
        tempList.add(ingredientExpireDate);
        stockList.add(tempList);
    }

    public String getCurrentRecipeName() {
        return currentRecipeName;
    }

    public void setCurrentRecipeName(String currentRecipeName) {
        this.currentRecipeName = currentRecipeName;
    }

    public int getCurrentCategoryID() {
        return currentCategoryID;
    }

    public void setCurrentCategoryID(int currentCategoryID) {
        this.currentCategoryID = currentCategoryID;
    }

    public String getCurrentRecipeCategory() {
        return currentRecipeCategory;
    }

    public void setCurrentRecipeCategory(String currentRecipeCategory) {
        this.currentRecipeCategory = currentRecipeCategory;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public String getCurrentUserSurname() {
        return currentUserSurname;
    }

    public void setCurrentUserSurname(String currentUserSurname) {
        this.currentUserSurname = currentUserSurname;
    }


    public String getCurrentUserEmail() {
        return currentUserEmail;
    }

    public void setCurrentUserEmail(String currentUserEmail) {
        this.currentUserEmail = currentUserEmail;
    }

    public String getCurrentUserPassword() {
        return currentUserPassword;
    }

    public void setCurrentUserPassword(String currentUserPassword) {
        this.currentUserPassword = currentUserPassword;
        //database den de değiştir
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static MainManager getInstance() {
        return instance;
    }

    public Class openLoginPanel() {
        return LoginPanel.class;
    }

    public Class openProfilePanel() {
        return ProfilePanel.class;
    }

    public Class openRegisterPanel() {
        return RegisterPanel.class;
    }

    public Class openHomePanel() {
        return HomePanel.class;
    }

    public Class openEditProfilePanel() {
        return EditProfilePanel.class;
    }

    public Class openIngredientPanel() {
        return StockPanel.class;
    }

    public Class openRecipeSuggestionPanel() {
        return RecipeSuggestionPanel.class;
    }

    public Class openRecipePanel() {
        return RecipePanel.class;
    }

    public Class openRecipeCaregoryPanel() {
        return RecipeCategoryPanel.class;
    }


    public String controlNameIngredient(String name) {
        if (name.length() == 0) {
            return "Lütfen ürünün adını girin!";
        }
        for (int i = 0; i < name.length(); i++) {
            if ((int) (name.toUpperCase().charAt(i)) > 90 || (int) (name.toUpperCase().charAt(i)) < 65) {
                return "Ürün adı sadece alfabetik karakterlerden oluşabilir!";
            }
        }
        return "";
    }

    public String controlExpireDateIngredient(String name) {
        if (!((int) (name.charAt(0)) > 47 || (int) (name.charAt(0)) < 58 || (int) (name.charAt(1)) > 47 ||
                (int) (name.charAt(1)) < 58 || (int) (name.charAt(3)) > 47 || (int) (name.charAt(3)) < 58 ||
                (int) (name.charAt(4)) > 47 || (int) (name.charAt(4)) < 58 || (int) (name.charAt(6)) > 47 ||
                (int) (name.charAt(6)) < 58 || (int) (name.charAt(7)) > 47 || (int) (name.charAt(7)) < 58 ||
                (int) (name.charAt(8)) > 47 || (int) (name.charAt(8)) < 58 || (int) (name.charAt(9)) > 47 ||
                (int) (name.charAt(9)) < 58))
            return "Ürün son kullanma tarihi sadece sayısal karakterlerden oluşabilir!";
        if (((int) (name.charAt(2)) != 46 || (int) (name.charAt(5)) != 46))
            return "Lütfen tarihi 11.11.1111 formatına uygun giriniz!";
        if (name.length() > 10)
            return "Lütfen tarihi 11.11.1111 formatına uygun giriniz!";
        return "";
    }

    public String controlNameRegister(String name) {
        if (name.length() == 0) {
            return "Lütfen isminizi girin!";
        }
        for (int i = 0; i < name.length(); i++) {
            if ((int) (name.toUpperCase().charAt(i)) > 90 || (int) (name.toUpperCase().charAt(i)) < 65) {
                return "İsim sadece alfabetik karakterlerden oluşabilir!";
            }
        }
        return "";
    }

    public String controlOldPasswordRegister(String password) {
        if (password != currentUserPassword) {
            return "Eski şifrenizi yanlış girdiniz!";
        }
        return "";
    }

    public String controlSurnameRegister(String surname) {
        if (surname.length() == 0) {
            return "Lütfen soyadınızı girin!";
        }
        for (int i = 0; i < surname.length(); i++) {
            if ((int) (surname.toUpperCase().charAt(i)) > 90 || (int) (surname.toUpperCase().charAt(i)) < 65) {
                return "Soyad sadece alfabetik karakterlerden oluşabilir!";
            }
        }
        return "";
    }

    public String controlEmailRegister(String email) {
        if (email.length() == 0) {
            return "Lütfen e-posta adresinizi girin!";
        }
        boolean statement1 = false;
        boolean statement2 = false;
        int index1 = 0;
        int index2 = 0;
        for (int i = 1; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                statement1 = true;
                index1 = i + 1;
                break;
            }
        }
        for (int i = index1; i < email.length(); i++) {
            if (email.charAt(i) == '.') {
                statement2 = true;
                break;
            }
        }
        if (!statement1 || !statement2) {
            return "Lütfen geçerli bir e-posta adresi girin!";
        } else {
            return "";
        }
    }

    public String controlPasswordRegister(String password) {
        if (password.length() == 0) {
            return "Lütfen şifrenizi girin!";
        }
        if (password.length() < 6) {
            return "Lütfen en az 6 karakterden oluşan bir şifre girin!";
        }
        return "";
    }

    //tarih hesaplamada sıkıntı var sorun nerede bulamadım!!!!!!!!!!!!

    public void date() {
        for (int i = 0; i < stockList.size(); i++) {
            if (stockList.get(i).get(2).length() > 4) {
                Date expireDate = new GregorianCalendar(Integer.parseInt(stockList.get(i).get(2).substring(6)), Integer.parseInt(stockList.get(i).get(2).substring(3, 5)),
                        Integer.parseInt(stockList.get(i).get(2).substring(0, 2)), 00, 00).getTime();
                Date nowaDay = new Date();

                long day = expireDate.getTime() - nowaDay.getTime();//iki tarih arasındaki fark

                long remainderDay = day / (1000 * 60 * 60 * 24);

                if (day < 0) {
                    pastExpireDate.add(stockList.get(i).get(0));
                }

                if (remainderDay > 0 && remainderDay < 5) {
                    approachingExpirationDate.add(stockList.get(i).get(0));
                }
            }

        }
    }
}
