package com.example.foodiary.Controller;

import android.os.Bundle;

import com.example.foodiary.DatabaseGetter.DatabaseGetter;
import com.example.foodiary.DatabaseGetter.Main;
import com.example.foodiary.DatabaseGetter.Recipe;
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

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
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
    private String currentRecipeCategory = "";
    private String currentRecipeName = "";
    private int currentCategoryID = 0;
    private int pastPage = 0; // if 0 recipesuggestion, if 1 homepage
    private String searchedRecipe = "";
    private static int currentRecipeID;
    private static User currentUser;
    private static ArrayList<String> categoryRecipeNames = new ArrayList<String>();//Category recipelarını gösterir
    private static ArrayList<String> productNameOfCurrentRecipe = new ArrayList<>();//recipeların hangi üründe olduğu
    private static ArrayList<Integer> recipeIndexInProduct = new ArrayList<Integer>();//recipeın hangi indexde odluğu


    /************************************************************************************************************************************************************/

    private static ArrayList<String> recipeNames = new ArrayList<String>();//Category recipelarını gösterir
    private static ArrayList<String> recipeIngredients = new ArrayList<>();//recipeların hangi üründe olduğu
    private static ArrayList<String> recipeDescriptions = new ArrayList<String>();//recipeın hangi indexde odluğu


    public ArrayList<String> getRecipeNames() {
        return recipeNames;
    }

    public void setRecipeNames(ArrayList<String> recipeNames) {
        MainManager.recipeNames = recipeNames;
    }

    public ArrayList<String> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(ArrayList<String> recipeIngredients) {
        MainManager.recipeIngredients = recipeIngredients;
    }

    public ArrayList<String> getRecipeDescriptions() {
        return recipeDescriptions;
    }

    public void setRecipeDescriptions(ArrayList<String> recipeDescriptions) {
        MainManager.recipeDescriptions = recipeDescriptions;
    }


    public void recipes() {
        recipeNames.add("Sebzeli Patlıcan Dolması");
        recipeNames.add("İmambayıldı");
        recipeNames.add("Yaz Güveci");
        recipeNames.add("Karışık Dolma");
        recipeNames.add("Patlıcan Kebabı");

        recipeIngredients.add("[3 kırmızı kapya biberi, Yarım demet maydanoz, 2 bostan patlıcanı, 2 soğan, 3 yemek kaşığı sızma zeytinyağı, 1 yemek kaşığı biber salçası, 1.5 su bardağı sıcak su]");
        recipeIngredients.add("[8 orta boy patlıcan, 4 soğan, 12 diş sarımsak, 3 domates, 4 sivri biber, 1 çay bardağı zeytinyağı, Tuz, Karabiber, 2 kesme şeker, 2 su bardağı sıcak su]");
        recipeIngredients.add("[500 kuşbaşı kuzu eti, 1 kırmızı soğan, 7~8 arpacık soğan, 1 kabak, 1 patlıcan, 10~12 taze fasulye, 1 domates, 2 domates, 2 defne yaprağı, Zeytinyağı, Tuz, Karabiber]");
        recipeIngredients.add("[Domates, Patlıcan, Dolmalık biber, Kabak]");
        recipeIngredients.add("[3 bostan patlıcanı, 3 domates, 1 su bardağı rendelenmiş, Kaşar peyniri]");

        recipeDescriptions.add("Patlıcanları yıkayıp sapları üzerinde kalacak şekilde uzunlamasına ortadan ikiye kesin. Kesik yerlerine bir fırça yardımıyla sızma zeytinyağı, sürüp önceden ısıtılmış 180 derece fırında 10 dakika pişirin. Pişen patlıcanların içlerini çıkartıp küp doğrayın. Yemeklik doğradığınız soğanı sızma zeytinyağında pembeleşinceye kadar soteleyin. Jülyen doğradığınız kırmızı biber, patlıcanlar ve biber salçasını ilave edin. Tuz ve baharatlarla tatlandırıp ocaktan alın. Harcı patlıcanların içlerine paylaştırıp bir fırın kabına alın. Sosu için, rendelenmiş domates, sızma zeytinyağı, salça ve tuzu geniş bir kasede karıştırıp patlıcanların üzerine gezdirin. Soslu patlıcanları önceden ısıtılmış 180 derece fırında 20 dakika pişirin. Sıcak servis yapın.");
        recipeDescriptions.add("Patlıcanların sap kısımlarını kesmeden\r\nalacalı soyun. Acısını almak için tuzlu suda\r\n10 dakika bekletin. Süzüp kağıt havlu ile\r\nkurulayın. Soğanları soyup piyazlık doğrayın.\r\nSarımsakları ayıklayın. Domatesleri\r\nsoyup küp doğrayın. Biberleri temizleyip\r\nortadan ikiye kesin ve ince doğrayın. Zeytinyağını\r\ntavada ısıtın. Soğan ve tuzu ilave edip\r\nsoteleyin. Sarımsak, domates, biber, şeker\r\nve karabiberi ekleyin. Kısık ateşte 10 dakika\r\npişirin. Ayçiçeği yağını bir tavada ısıtın. Isınan\r\nyağda patlıcanları iki taraflı hafif kızartın.\r\nKızaran patlıcanları kağıt havlu üzerine\r\nalıp fazla yağını çektirin.Patlıcanları yayvan\r\nbir tencereye aralıklı olarak yerleştirin.\r\nOrta kısımlarını bıçakla hafif kesip açın ve\r\nsoğanlı harcı paylaştırın. Tencerenin kenarından\r\n2 su bardağı sıcak su ekleyin. Kapağını\r\nkapatıp kısık ateşte 20 dakika suyunu\r\nçekene kadar pişirin. Domates sosu hazırlamak için zeytinyağını tavada ısıtın. Rendelenmiş domatesi ve salçayı ekleyip bir taşımkaynatın. Sosu bir servis tabağına alın.Üzerine patlıcanları yerleştirip ince kıyılmış maydanoz serpin. Soğuk servis yapın.İmam bayıldının yanına ne gider diyorsanız, fırında baharatlı patates ile şık bir sunum hazırlayabilirsiniz. Afiyet olsun.");
        recipeDescriptions.add("Kuşbaşı kuzu etlerini yapışmaz yüzeyli bir tavada mühürleyin. Kırmızı soğanı halka doğrayıp fırın güvecinizin tabanına dizin. Arpacık soğanlar, küp doğradığınız kabak, patlıcan, domates, ortadan ikiye kestiğiniz fasulyeler ve kuşbaşı kuzu etlerini geniş bir kasede karıştırıp güvece alın. Defne yapraklarını ilave edin ve güvecin üzerine zeytinyağı gezdirin. Tuz ve baharatlarla tatlandırıp önceden ısıtılmış 180 derece fırında iki saat pişirin. Sıcak servis yapın.");
        recipeDescriptions.add("Öncelikle domates ve biberleri yıkayıp baş kısımlarını kesin. Domatesleri alacalı bir şekilde soyun. Ortadan ikiye kestiğiniz kabak ve patlıcanların içlerini temizleyin.İç harcı için; tereyağı, yıkayıp süzdüğünüz pirinç, kıyma, rendelediğiniz soğan, su, salça, sumak ekşisi, tuz ve baharatları geniş bir kasede karıştırın. Hazırladığınız harcı sebzelerin içlerine paylaştırıp yayvan bir tencereye dizin. Üzerine, dolmaların yarısına gelecek kadar su ekleyip kısık ateşte 15-20 dakika pişirin. Sosu için salça, su, nar ekşisi ve ezdiğiniz sarımsağı bir kasede karıştırın. Dolmaları ocaktan almadan önce üzerine sosu gezdirin ve 10 dakika daha pişirin. Karışık dolmayı, cacık ile birlikte servis edebilirsiniz. Afiyet olsun.");
        recipeDescriptions.add("Davetlerinizde hazırladığınız tariflerle farklılık yaratın. Köfte için gerekli tüm malzemeyi derin bir kapta yoğurun. Streç filme sarıp buzdolabında 45 dakika dinlendirin. Patlıcanları alacalı soyup 1 parmak kalınlığında daire şeklinde dilimleyin ve limonlu tuzlu suda 30 dakika bekletin. Köfteleri patlıcan büyüklüğünde daire şeklinde hazırlayın. Yağı tavada ısıtın. Sırayla önce patlıcanları ardından köfteleri hafif kızartın. Domatesleri de patlıcan gibi 1 parmak kalınlığında dilimleyin. Fırın tepsisine 1 dilim patlıcan, üzerine köfte, 1 dilim domates yerleştirin. Üzerine rendelenmiş kaşar peyniri serpin. Kalan malzemelere de aynı işlemi uygulayın. Domatesli sos için gerekli malzemeleri bir kasede karıştırın ve fırın kabına aktarın. Fırın tepsisini önceden ısıttığınız 180 dereceye ayarlı fırında kızarıncaya kadar pişirin. Sıcak servis yapın.");

    }

    public String corretTypeOfRecipeIngredient(String ingredients) {
        ingredients = ingredients.replaceAll(",", "\n");
        ingredients = ingredients.substring(1, ingredients.length() - 1);
        return ingredients;
    }

    public String corretTypeOfRecipeDescription(String description) {
        description = description.replaceAll("\r\n", " ");
        return description;
    }


    /******************************************************************************************************************************************************************/

    public String getSearchedRecipe() {
        return searchedRecipe;
    }

    public void setSearchedRecipe(String searchedRecipe) {
        this.searchedRecipe = searchedRecipe;
    }

    public int getPastPage() {
        return pastPage;
    }

    public void setPastPage(int pastPage) {
        this.pastPage = pastPage;
    }

    //recipeList categorye göre çekilir

    private static Recipe currentRecipe;

    //user ilk girişte userListten çekilir ve current bilgiler değiştirilir. Userın stoğu stockListe atılır

    private List<User> userList = new ArrayList<User>();//userlar burada hala

    public static ArrayList<String> getCategoryRecipeNames() {
        return categoryRecipeNames;
    }

    public static void setCategoryRecipeNames(ArrayList<String> categoryRecipeNames) {
        MainManager.categoryRecipeNames = categoryRecipeNames;
    }


    public void getRecipe() { //kanki bu metod ile current recipeı oluşturmuş oluyoruz
        currentRecipeID = 7;
        Main.setInformations();
        currentRecipe = db.getRecipe(productNameOfCurrentRecipe.get(currentRecipeID), recipeIndexInProduct.get(currentRecipeID));
        Main.setRecipeInformations();
    }

    //Bu metodda da user ve database oluşturuluyor önce bu metod sonra get recipe çağrılmalı
    public void usersAndDatabase() {
        db.createUsersandStock();
        userList = db.returnUserList();//burda userliste kullanıcıları atıyor
        currentUser = userList.get(0); //current usera temp değer verdim onu da loginde id den alıcaz
    }

    public void createDatabase() throws IOException, ParseException {
        db.createDatabase();//database oluşturuyor recipelar için
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

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        MainManager.currentUser = currentUser;
    }

}
