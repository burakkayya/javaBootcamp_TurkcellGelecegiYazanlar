package org.example;

import org.example.entities.*;
import org.example.managers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Gamer> gamers=new ArrayList<>();
        List<User> users=new ArrayList<>();
        List<Game> games=new ArrayList<>();
        List<Cart> carts=new ArrayList<>();
        List<Campaign> campaigns=new ArrayList<>();
        List<Sale> sales=new ArrayList<>();
        EDevletVerificationManager eDevletVerificationManager =new EDevletVerificationManager();
        UserManager userManager=new UserManager(users);
        GamerManager gamerManager=new GamerManager(gamers,userManager, eDevletVerificationManager);
        GameManager gameManager=new GameManager(games);
        CampaignManager campaignManager=new CampaignManager(campaigns);
        CartManager cartManager=new CartManager(carts,campaignManager);
        SaleManager saleManager=new SaleManager(sales);


        //Kullanıcı E-devlet sistemi ile uyumlu olmayan bilgilerini girer ve
        //kayıt ol butonuna basar;
        gamerManager.create(new Gamer(1,"111112", "Yıldız", "Demir", new Date(1999,1,1),  "1234", "user1", null));

        //Kullanıcı E-devlet sistemi ile uyumlu olan kullanıcı bilgilerini girer ve
        //kayıt ol tuşuna basar;
        gamerManager.create(new Gamer(2,"111111111", "Ahmet", "Yılmaz", new Date(1999,1,1),  "1234", "user1", null));

        //başka bir kullanıcı kayıt olur
        gamerManager.create(new Gamer(3,"211111111", "Ayşe", "Özdemir", new Date(1998,1,1),  "1235", "user2", null));

        //kullanıcı bilgilerini güncelle sayfasından değiştirerek güncelle butonuna basar;
        gamerManager.update(new Gamer(3,"211111111", "Ayşe", "Özdemir", new Date(1998,1,1),  "1236", "user3", null));

        //kullanıcı kaydı sil butonuna basar;
        gamerManager.delete(2);

        //Sisteme oyun girişi yapılır;
        gameManager.create(new Game(1,"Life is Strange",248.39,false));
        gameManager.create(new Game(2,"Murdered Soul Suspect",35.24,false));
        gameManager.create(new Game(3,"Dreamfall",10.00,false));
        gameManager.create(new Game(4,"We Happy Few",104.89,false));

        //Sistemde kampanya olacak oyunlar seçilir
        //ve seçilen oyunlar bir listeye aklenir
        ArrayList<Game> campaignGames=new ArrayList<Game>();
        campaignGames.add(gameManager.get(3));
        campaignGames.add(gameManager.get(4));

        //Sisteme diğer kampanya bilgileri girilir ve
        // kampanya oluştur butonu tıklanır;
        campaignManager.create(new Campaign(1,35,"Kış indirimleri distopik oyunlarda!",campaignGames,new Date(2023,3,3),new Date(2023,4,4),false));

        //Kampanya bilgileri güncelleme sayfasından değiştirilmek istenen bilgiler girilir;
        campaignManager.update(new Campaign(1,35,"Bahar kapıda indirimleri distopik oyunlarda!",campaignGames,new Date(2023,3,3),new Date(2023,4,4),false));

        //Sisteme kayıt olan kullanıcı sistemden istediği oyunları sepetine ekler
        List<Game> cart=new ArrayList<>();
        cart.add(gameManager.get(3));
        cart.add(gameManager.get(4));

        // ve satın al butonuna basar;
        cartManager.create(new Cart(1,new Date(2023,3,16),cart,gamerManager.get(3),false));
        saleManager.add(new Sale(1,cartManager.get(1)));
        saleManager.sell(cartManager.get(1));

        //kampanya sistemden sil butonuna basılarak silinir;
        campaignManager.delete(1);

        //Başka bir satın alma işlemi gerçekleşir;
        cartManager.create(new Cart(1,new Date(2023,3,16),cart,gamerManager.get(3),false));
        saleManager.add(new Sale(1,cartManager.get(1)));
        saleManager.sell(cartManager.get(1));

    }
}