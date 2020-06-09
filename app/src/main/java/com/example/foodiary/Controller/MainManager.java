package com.example.foodiary.Controller;

import android.os.Bundle;

import com.example.foodiary.DatabaseGetter.DatabaseGetter;
import com.example.foodiary.DatabaseGetter.User;
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
    DatabaseGetter db = new DatabaseGetter();
    private final static MainManager instance = new MainManager();
    //password, name ve surname db den çekilecek (defaultları)
    private List<List<String>> recipeList = new ArrayList<List<String>>();
    private String currentUserName = "";
    private String currentUserSurname = "";
    private String currentUserEmail = "";
    private String currentUserPassword = "";
    private int currentUserID = 0;
    private String currentRecipeCategory = "";
    private String currentRecipeName = "";
    private int currentCategoryID = 0;
    private static User currentUser;
    //recipeList categorye göre çekilir

    //user ilk girişte userListten çekilir ve current bilgiler değiştirilir. Userın stoğu stockListe atılır

    private List<User> userList = new ArrayList<User>();
    private List<String> pastExpireDate = new ArrayList<String>();
    private List<String> approachingExpirationDate = new ArrayList<String>();
    private List<List<String>> stockList = new ArrayList<List<String>>();



    public void users() {
        db.createUsersandStock();
        userList = db.returnUserList();
        currentUser = userList.get(0);
    }


    public List<String> getPastExpireDate() {
        return pastExpireDate;
    }


    public List<String> getApproachingExpirationDate() {
        return approachingExpirationDate;
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

    //Ürün ekleme
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

    //Registration Control
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


    //Getter and Setters
    public static MainManager getInstance() {
        return instance;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<List<String>> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<List<String>> recipeList) {
        this.recipeList = recipeList;
    }

    public List<List<String>> getStockList() {
        return stockList;
    }

    public void setStockList(List<List<String>> stockList) {
        this.stockList = stockList;
    }
    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        MainManager.currentUser = currentUser;
    }

}
