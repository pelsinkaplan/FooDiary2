package com.example.foodiary.Controller;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;

import com.example.foodiary.DatabaseGetter.DatabaseGetter;
import com.example.foodiary.DatabaseGetter.Product;
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
import com.example.foodiary.R;

import androidx.appcompat.app.AppCompatActivity;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainManager extends AppCompatActivity {
    DatabaseGetter db = new DatabaseGetter();
    private final static MainManager instance = new MainManager();
    private List<List<String>> recipeList = new ArrayList<List<String>>();
    private String currentUserName = "";
    private String currentUserSurname = "";
    private String currentUserEmail = "";
    private String currentUserPassword = "";
    private String currentRecipeCategory = "";
    private String currentRecipeName = "";
    private String searchedRecipe = "";
    public static String currentDescription = "";
    public static String currentIngredients = "";
    private int pastPage = 0; // if 0 recipeSuggestion, if 1 homepage
    private static int currentCategoryID = 0;
    public static boolean oneOtTwo = false;


    public static int currentRecipeID;
    public static int currentRecipeID2;

    private static User currentUser;
    private static Recipe currentRecipe;
    private static Recipe currentRecipe2;
    public static Layout recipe1 = null;
    public static Layout recipe2 = null;
    public static ArrayList<String> categoryRecipeNames = new ArrayList<String>();//Category recipelarını gösterir
    public static ArrayList<String> productNameOfCurrentRecipe = new ArrayList<>();//recipeların hangi üründe olduğu
    public static ArrayList<Integer> recipeIndexInProduct = new ArrayList<Integer>();//recipeın hangi indexde odluğu

    public static ArrayList<String> categoryRecipeNames2 = new ArrayList<String>();//Category recipelarını gösterir
    public static ArrayList<String> productNameOfCurrentRecipe2 = new ArrayList<>();//recipeların hangi üründe olduğu
    public static ArrayList<Integer> recipeIndexInProduct2 = new ArrayList<Integer>();//recipeın hangi indexde odluğu


    //search bar
    /************************************************************************************************************************************************************/

    private static ArrayList<String> recipeNames = new ArrayList<String>();//Category recipelarını gösterir
    private static ArrayList<String> recipeIngredients = new ArrayList<>();//recipeların hangi üründe olduğu
    private static ArrayList<String> recipeDescriptions = new ArrayList<String>();//recipeın hangi indexde odluğu

    public void recipes() {
        //Daily Suggestion
        recipeNames.add("Söğüş Salata");
        recipeNames.add("İmambayıldı");
        recipeNames.add("Mantarlı Makarna");
        recipeNames.add("Çoban Böreği");
        recipeNames.add("Şehriyeli Tavuk Çorbası");
        recipeNames.add("Sütlaç");

        recipeIngredients.add("1 adet iri domates, 5-6 adet sivri biber, 2 adet salatalık, Yarım limon, Yarım çay bardağı zeytinyağı, 1 çay kaşığı tuz, Çıtır Ekmek (İsteğe göre)");
        recipeIngredients.add("8 orta boy patlıcan, 4 soğan, 12 diş sarımsak, 3 domates, 4 sivri biber, 1 çay bardağı zeytinyağı, Tuz, Karabiber, 2 kesme şeker, 2 su bardağı sıcak su");
        recipeIngredients.add("1 yemek kaşığı tereyağı, 1 adet soğan, 20 adet kültür mantarı, 3 diş sarımsak, 4-5 dal frenk soğanı (Veya taze soğan), 200 ml krema, 1 paket kelebek makarna");
        recipeIngredients.add("1 tavuk budu, 6 iri patates, 3~4 dal maydanoz, 500 gr ıspanak, 2 pırasa, 4 yumurta, 100 gr sucuk (veya pastırma), 1 çorba kaşığı kurutulmuş domates, 1 çay bardağı sıvıyağ, 2 çorba kaşığı un, 1 su bardağı rendelenmiş kaşar peyniri, 3 çorba kaşığı çörekotu, Tuz, karabiber");
        recipeIngredients.add("tavuk göğsü veya 2 tavuk budu, Tavuk suyu (5 bardak), Un (1 dolu yemek kaşığı), Margarin veya tereyağı (1.5 yemek kaşığı), Sıvı yağ ( 2 yemek kaşığı), Tel şehriye (1.5 kahve fincanı), Karabiber (servis sırasında), Tuz");
        recipeIngredients.add("3/4 su bardağı Amerikan pirinci, 1.5 su bardağı su, 3 su bardağı süt, 1/2 su bardağı toz şeker, 1 tatlı kaşığı vanilin, 1 adet yumurta sarısı, Tuz");

        recipeDescriptions.add("İlk olarak domates ve salataların kabuklarını soyun.Ardından biberleri yıkayın ve uç kısımlarını kesin.Tüm malzemeleri iri iri doğrayın ve geniş bir kap içerisine ekleyin.Çıtır ekmek kullanmak istiyorsanız, bayatlamış ekmekleri fırında ısıtıp küçük parçalar halinde salataya ekleyebilirsiniz.Son olarak tuz, kekik ve zeytinyağını salataya ilave edin ve tüm malzemeleri karıştırın. Afiyet olsun.");
        recipeDescriptions.add("Patlıcanların sap kısımlarını kesmeden\r\nalacalı soyun. Acısını almak için tuzlu suda\r\n10 dakika bekletin. Süzüp kağıt havlu ile\r\nkurulayın. Soğanları soyup piyazlık doğrayın.\r\nSarımsakları ayıklayın. Domatesleri\r\nsoyup küp doğrayın. Biberleri temizleyip\r\nortadan ikiye kesin ve ince doğrayın. Zeytinyağını\r\ntavada ısıtın. Soğan ve tuzu ilave edip\r\nsoteleyin. Sarımsak, domates, biber, şeker\r\nve karabiberi ekleyin. Kısık ateşte 10 dakika\r\npişirin. Ayçiçeği yağını bir tavada ısıtın. Isınan\r\nyağda patlıcanları iki taraflı hafif kızartın.\r\nKızaran patlıcanları kağıt havlu üzerine\r\nalıp fazla yağını çektirin.Patlıcanları yayvan\r\nbir tencereye aralıklı olarak yerleştirin.\r\nOrta kısımlarını bıçakla hafif kesip açın ve\r\nsoğanlı harcı paylaştırın. Tencerenin kenarından\r\n2 su bardağı sıcak su ekleyin. Kapağını\r\nkapatıp kısık ateşte 20 dakika suyunu\r\nçekene kadar pişirin. Domates sosu hazırlamak için zeytinyağını tavada ısıtın. Rendelenmiş domatesi ve salçayı ekleyip bir taşımkaynatın. Sosu bir servis tabağına alın.Üzerine patlıcanları yerleştirip ince kıyılmış maydanoz serpin. Soğuk servis yapın.İmam bayıldının yanına ne gider diyorsanız, fırında baharatlı patates ile şık bir sunum hazırlayabilirsiniz. Afiyet olsun.");
        recipeDescriptions.add("Kuşbaşı kuzu etlerini yapışmaz yüzeyli bir tavada mühürleyin. Kırmızı soğanı halka doğrayıp fırın güvecinizin tabanına dizin. Arpacık soğanlar, küp doğradığınız kabak, patlıcan, domates, ortadan ikiye kestiğiniz fasulyeler ve kuşbaşı kuzu etlerini geniş bir kasede karıştırıp güvece alın. Defne yapraklarını ilave edin ve güvecin üzerine zeytinyağı gezdirin. Tuz ve baharatlarla tatlandırıp önceden ısıtılmış 180 derece fırında iki saat pişirin. Sıcak servis yapın.");
        recipeDescriptions.add("Tavuk etini yumuşayana kadar haşlayıp süzün. Eti kemiklerinden ayırıp didikleyin. Patatesleri kabuğu ile hafif haşlayın. Süzün ve kabuklarını soyup rendeleyin. Maydanozu temizleyip kıyın. Sucuğu soyup ince doğrayın. Pırasaları temizleyip incecik doğrayın.\\nIspanakları temizleyip yıkayın. Doğrayıp tavada suyunu tamamen çekene kadar soteleyin.Rendelenmiş patates, pırasa, yumurta, tavuk eti, sucuk, kurutulmuş domates, sıvıyağ, maydanoz, rendelenmiş peynir, tuz ve biberi bir kaba alıp karıştırın. 20 cm çapındaki derin kek kalıbını yağlı kağıtla kaplayın. Ispanaklı harcı döküp spatula ile düzelterek yayın.Önceden ısıtılmış 180 dereceye ayarlı fırında üzeri pembeleşene kadar pişirin. Servis tabağına alıp üzerini çörekotu ile süsleyin ve ılınmaya bırakın. Dilimleyip servis yapın.");
        recipeDescriptions.add("Yemeklerinizin yanına çok yakışacak, sıcacık ve mis gibi şehriyeli tavuk çorbası yapılışı oldukça kolaydır. Kullanacağınız tavuk etini göğüs veya but olarak tercih edebilirsiniz. Fakat kemikli bir tavuk eti seçmek daha yararlı olur. Böylece tavuğun lezzeti güzelce suyuna geçer. Tavuk etini tuzsuz bir şekilde haşlayarak işe başlayabilirsiniz. Suyu biraz fazla eklemelisiniz çünkü haşlanan sudan 5 bardak alarak çorba için kullanacaksınız. 1 litre su yeterli olur.Tavuk haşlandıktan sonra küçük parçalara ayırın ve ayrı bir tabağa koyun. Daha sonra, çorbanızı yapacağınız tencereyi ocağa yerleştirin. Margarin ve sıvı yağı ekleyin. Margarin eridikten sonra unu ekleyin. Topaklanmaması için iyice kavurun. Önceden ayırdığınız 5 bardak tavuk suyunu ve önceden küçük parçalara böldüğünüz tavukları ekleyin.Güzelce karıştırın ve kaynadıktan sonra şehriyeleri ekleyin.Şehriyeleri yaklaşık 10-15 dakika pişinceye kadar kaynatın. Tuz ekleyin ve çorbanız piştikten sonra tencerenin kapağını kapatarak dinlenmeye bırakın. Servis ederken üzerine biraz karabiber ekleyin.Mis gibi şehriyeli tavuk çorbanız hazır. Afiyet olsun!");
        recipeDescriptions.add("İlk önce sosu hazırlayın. Sos için gerekli olan tüm malzemeleri ufak bir sos tenceresine alıp kaynama noktasına gelince altını kısarak 7-8 dakika pişirin. Ocaktan alıp soğumaya bırakın.Sütlaç için; pirinçleri su ile bir tencereye alıp suyunu çekene kadar pişirin. 2.5 su bardağı süt ilave edip karıştırın. Daha sonra bir tutam tuz ile toz şekeri ekleyip karıştırarak pişirmeye devam edin. Pirinçler sütü çekince kalan süt ile yumurta sarısını çırpıp tencereye ilave edin. Karıştırarak birkaç dakika daha pişirip ocaktan alın. Aralarına ve üstüne çilek sosu ekleyerek servis bardaklarına paylaştırın. Son olarak üstünü kavrulmuş ceviz içi ile tamamlayarak ılıması için bir kenarda bekletin.Dilerseniz çilek sosuna ek olarak, ev yapımı çikolata sosu da kullanabilirsiniz.");

        //Daily Suggestion
        recipeNames.add("Kremalı mantar çorbası");
        recipeNames.add("Orman Kebabı");
        recipeNames.add("Enginarlı bulgur pilavı");
        recipeNames.add("Saray Sarması");

        recipeIngredients.add("500 g kültür mantarı, 2 yemek kaşığı tereyağı, 2 diş sarımsak, 2 yemek kaşığı un, 4 su bardağı su, 200 ml krema, Tuz, Karabiber");
        recipeIngredients.add("1 yemek kaşığı tereyağı, 2 adet büyük boy soğan, 4-5 diş sarımsak, 1 yemek kaşığı biber salçası, 1 yemek kaşığı domates salçası, 2 adet kereviz sapı, 2 adet patlıcan, 2 adet büyük boy patates, 2 adet büyük boy havuç, 2 adet kırmızı kapya biber, 3-4 adet yeşil köy biberi, 1 su bardağı bezelye, Tuz, karabiber, 3 su bardağı et suyu, 1 adet defne yaprağı");
        recipeIngredients.add("1 su bardağı bulgur, 1.5 su bardağı sıcak su, 2 adet sivri biber, 1 adet orta boy soğan, 2 yemek kaşığı zeytinyağı, 2 adet enginar (Küp doğranmış), 1 yemek kaşığı tereyağı, 2 dal kuşkonmaz (Yarım parmak doğranmış) ,1 çay kaşığı rendelenmiş limon kabuğu, Tuz");
        recipeIngredients.add("1 litre süt, 1 su bardağı un, 1 su bardağı toz şeker, 3 dolu dolu yemek kaşığı kakao, 1 paket vanilya, 1 yemek kaşığı tereyağ veya margarin");


        recipeDescriptions.add("İlk olarak mantarları bol suda durulayın ve süzün. Ardından mantarları iri formda doğrayarak tereyağında 3-4 dakika soteleyin.İnce ince ezilmiş sarımsak ve unu, mantar soteye ilave edip unun rengi dönünceye kadar kavurun. Topaklanmaması için sürekli karıştırın ve azar azar suyu ilave edin. Tuz ve karabiber ve istediğiniz baharatlar ile tatlandırıp kaynatın. Son olarak koyulaşan çorbanın içerisine kremayı ilave edip kısık ateşte 7-8 dakika daha pişirin.Pişirme işleminden sonra çorbayı ocaktan alın. Üzerini ince ince kıydığınız dereotu ve maydanoz ile süsleyin.Kremalı mantar çorbasını, balık yemekleri ile birlikte servis edebilirsiniz. Şimdiden afiyet olsun.");
        recipeDescriptions.add("İlk olarak tencereyi ocakta ısıtmaya koyun. Etin üzerine un serpin ve kuzu etine yedirin. Unlamanın amacı çıtır olmasını sağlamak. Tencere ısındıktan sonra ayçiçeği yağını ve eti ilave edin. Et altın sarısı kıvamına gelene kadar pişirin. Bu sırada elinizdeki sebzeleri aşırı küçük olmayacak şekilde doğrayın. Et altın sarısı kıvamına geldikten sonra tabağa alın. Aynı tencerede biraz tereyağı erittikten soğanları ekleyin ve kavurun. Daha sonra sarımsakları doğrayıp ilave edin. Salçayı da erittikten sonra sebzeleri ekleyin. Sebzeler biraz yumuşadıktan sonra domatesleri ilave edin.Daha önce ayırdığımız etleri sebzelerle buluşturun. Tuz ve karabiberini ekleyin. 3 bardak et suyu ekleyin ve karıştırın. Bir adet defne yaprağı ekleyerek lezzet vermesini sağlayın. 45- 50 dakika pişmeye bırakın. Afiyet olsun.");
        recipeDescriptions.add("Ege yöresine özgü çok lezzetli enginarlı bulgur pilavı tek başına bile doyurucu.Soğanı ince kıyıp zeytinyağında yumuşayana kadar kavurun. Sivri biberi, temizlenmiş kuşkonmazları ve enginarları ekleyin. 5-6 dakika daha kavurun.Bulguru ilave edin. Birkaç dakika karıştırdıktan sonra sıcak suyu ve tuzu ekleyin. Yüksek ateşte 2-3 dakika kaynatın. Daha sonra tencerenin kapağını kapatın. Kısık ateşte, suyunu çekene dek pişirin.Pilavı ocaktan almaya 3-4 dakika kala rendelenmiş limon kabuğu ile tereyağını ekleyin. Karıştırıp tencerenin kapağını kapatın. Ocaktan aldıktan sonra 10 dakika kadar demlendirin.Lezzetli enginarlı ve dereotlu pilav tarifi için tıklayın.");
        recipeDescriptions.add("İlk olarak derin bir tencereye süt ve şeker koyulur. Üzerine elekten geçirilen un ve kakao eklenerek iyice karıştırılır. Un ve kakaonun elenmesi muhallebinin kıvamının pürüzsüz olmasına yardımcı olacaktır.Kısık ateşte sürekli karıştırılarak pişirilir. Dibinin tutmaması ve kıvamın düzgün olması için sürekli karıştırmak önemli.Koyulaşıp muhallebi kıvamına gelen karışım 2 dakika kaynatılarak ocaktan alınır.İçerisine tereyağ ve vanilya eklenir. Böylece aroma katılmış olur.Ocaktan alınan muhallebinin daha pürüzsüz bir kıvamda olması için 5 dakika mikser ile çırpılır.Büyük boy fırın tepsisine 2 bardak hindistan cevizi serpilir. Tepside açık kalmayacak şekilde tüm tabana yayılır.Üzerine sıcak muhallebi dökülerek yayılır. Her yeri eşit olacak şekilde spatula yardımıyla düzleştirilir.Tepsiye yayılan muhallebi soğumaya bırakılır (1 saat kadar dolapta bekletilirse daha güzel kıvam alır) 1 çay bardağı soğuk süt ile çırpılan krem şanti, dinlendirilen muhallebinin üzerine her yerine eşit şekilde yayılır.Buzdolabına kaldırılarak 2-3 saat dinlendirilir. İyice dinlendikten sonra uzunlamasına ortadan 2’ye kesilir. Kalan bölümler enine dilimlere ayrılır.Daha sonra rulo şeklinde sarılıp, servis tabağına alınır.Hem şekliyle hem lezzetiyle etkileyici bir tatlı olan saray sarması çok hafif bir lezzettir.Dilerseniz, tam kıvamında saray sarmasını ev yapımı çikolata sosu ile süsleyebilirsiniz. Afiyet olsun.\"");


    }

    public String corretTypeOfRecipeIngredient(String ingredients) {
        ingredients = ingredients.replaceAll(",", "\n");
        return ingredients;
    }

    public String corretTypeOfRecipeDescription(String description) {
        description = description.replaceAll("\r\n", " ");
        return description;
    }

    /******************************************************************************************************************************************************************/
    /*-----------------------------------------------------------------------------------------------------------------------*/
    public static void clearArraylists() {
        categoryRecipeNames.clear();
        productNameOfCurrentRecipe.clear();
        recipeIndexInProduct.clear();
    }

    public static void clearArraylists2() {
        categoryRecipeNames2.clear();
        productNameOfCurrentRecipe2.clear();
        recipeIndexInProduct2.clear();
    }

    //user ilk girişte userListten çekilir ve current bilgiler değiştirilir. Userın stoğu stockListe atılır
    private List<User> userList = new ArrayList<User>();//userlar burada hala

    public static ArrayList<String> getCategoryRecipeNames() {
        return categoryRecipeNames;
    }

    public void getRecipe() { //kanki bu metod ile current recipeı oluşturmuş oluyoruz
        //getCategory();
        if (productNameOfCurrentRecipe.size() != 0) {
            currentRecipe = db.getRecipe(productNameOfCurrentRecipe.get(currentRecipeID), recipeIndexInProduct.get(currentRecipeID));
            setRecipeInformations();
        }
    }

    public void getRecipe2() { //kanki bu metod ile current recipeı oluşturmuş oluyoruz
        // getCategory();
        if (productNameOfCurrentRecipe2.size() != 0) {
            currentRecipe2 = db.getRecipe(productNameOfCurrentRecipe2.get(currentRecipeID2), recipeIndexInProduct2.get(currentRecipeID2));
            setRecipeInformations();
        }
    }

    //Bu metodda da user ve database oluşturuluyor önce bu metod sonra get recipe çağrılmalı
    public void usersAndDatabase() {
        db.createUsersandStock();
        userList = db.returnUserList();//burda userliste kullanıcıları atıyor
        currentUser = userList.get(0); //current usera temp değer verdim onu da loginde id den alıcaz
    }

    public void createDatabase() throws IOException, ParseException {
        db.createDatabase(this);//database oluşturuyor recipelar için
    }

    public void getCategory() {//kategoryi alıyo o kategorideki ürünlere göre alttaki metoda geçiyo
        HashMap<String, Product> category = db.getCategoryRecipes(currentCategoryID);
        showFoodRecipesInCategoryPage(category, currentUser);
    }

    public static void showFoodRecipesInCategoryPage(HashMap<String, Product> category, User user) {
        for (int i = 0; i < user.getApproachingExpirationDate().size(); i++) {
            if (category.containsKey(user.getApproachingExpirationDate().get(i))) {//Son kullanma tarihi yaklaşan ürünlere
                //bak eğer stoktaki yiyeceklerden listemde varsa bastır
                Product p = category.get(user.getApproachingExpirationDate().get(i));
                for (int j = 0; j < p.getProduct_recipes().size(); j++) {
                    String recipeName = p.getProduct_recipes().get(j).getName();//recipeların isimlerini göster
                    recipeName = recipeName.replaceAll("\n", "");
                    categoryRecipeNames.add(recipeName);
                    productNameOfCurrentRecipe.add(p.getProduct_name());
                    recipeIndexInProduct.add(j);
                    System.out.println(recipeName);
                }
            }
        }

        for (int i = 0; i < user.getNotApproachingExpirationDate().size(); i++) {
            if (category.containsKey(user.getNotApproachingExpirationDate().get(i))) {//Son kullanma tarihi yaklaşan ürünlere
                //bak eğer stoktaki yiyeceklerden listemde varsa bastır
                Product p = category.get(user.getNotApproachingExpirationDate().get(i));
                for (int j = 0; j < p.getProduct_recipes().size(); j++) {
                    String recipeName = p.getProduct_recipes().get(j).getName();//recipeların isimlerini göster
                    recipeName = recipeName.replaceAll("\n", "");
                    categoryRecipeNames2.add(recipeName);
                    productNameOfCurrentRecipe2.add(p.getProduct_name());
                    recipeIndexInProduct2.add(j);
                    System.out.println(recipeName);
                }
            }
            //else aradığınız ürünle ilgili tarif yok
        }
    }

    public void setRecipeInformations() {
        if (currentRecipe != null) {
            currentRecipeName = currentRecipe.getName();
            currentDescription = currentRecipe.getDescription();
            currentIngredients = returnIngredientsString(currentRecipe.getIngredients());
            //currentIngredients = currentRecipe.getIngredients();
            System.out.println(currentRecipeName);
            System.out.println(currentDescription);
            System.out.println(currentIngredients);
        }
        if (currentRecipe2 != null) {

            currentRecipeName = currentRecipe2.getName();
            currentDescription = currentRecipe2.getDescription();
            currentIngredients = returnIngredientsString(currentRecipe2.getIngredients());
            //currentIngredients = currentRecipe.getIngredients();
            System.out.println(currentRecipeName);
            System.out.println(currentDescription);
            System.out.println(currentIngredients);

        }
    }

    public String returnIngredientsString(ArrayList<String> list) {
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            s = s.concat(list.get(i));
            s = s.concat("\n");
        }
        return s;
    }

    /*-----------------------------------------------------------------------------------------------------------------------*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Open Class Methods
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


    //Control Methods
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


    public void addUserList(User user) {
        userList.add(user);
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

    public ArrayList<String> getRecipeNames() {
        return recipeNames;
    }

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

    public static void setCategoryRecipeNames(ArrayList<String> categoryRecipeNames) {
        MainManager.categoryRecipeNames = categoryRecipeNames;
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

    public static int getCurrentRecipeID() {
        return currentRecipeID;
    }

    public static void setCurrentRecipeID(int currentRecipeID) {
        MainManager.currentRecipeID = currentRecipeID;
    }

    public static int getCurrentRecipeID2() {
        return currentRecipeID2;
    }

    public static void setCurrentRecipeID2(int currentRecipeID2) {
        MainManager.currentRecipeID2 = currentRecipeID2;
    }

}
