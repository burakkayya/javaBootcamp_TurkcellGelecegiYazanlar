package org.example.managers;

import org.example.entities.Campaign;
import org.example.entities.Cart;
import org.example.entities.Game;

import java.util.List;

public class CartManager {
    private List<Cart> carts;

    private CampaignManager campaignManager;

    public CartManager(List<Cart> carts, CampaignManager campaignManager) {
        this.carts = carts;
        this.campaignManager=campaignManager;

    }

    public List<Cart> getAll(){
        return carts;
    }
    public void create(Cart cart){
        carts.add(cart);
        calculateDiscount(cart);

    }
    public Cart get(int id){
        for (Cart order: carts
        ) {
            if(order.getId()==id){
                return order;
            }
        }
        return null;
    }
    public void update(Cart cart){
        for (Cart c: carts
        ) {
            if(c.getId()==cart.getId())
            {
                c.setDate(cart.getDate());
                c.setGames(cart.getGames());
                c.setGamer(cart.getGamer());
                c.setTotalCost(cart.getTotalCost());

            }

        }

    }
    public void delete(int id){
        for (Cart order: carts
        ) {
            if(order.getId()==id)
            {
                order.setDeleted(true);
            }
        }

    }
    public void calculateDiscount(Cart cart){
        System.out.println("Almak istediğiniz oyunların kampanyasız fiyatı:"+cart.getTotalCost());
        boolean campaignFits=false;
        for (Campaign campaign:campaignManager.getAll()
        ) {
            if(!campaign.isDeleted()) {
                for (Game gameOfCampaign : campaign.getGames()
                ) {
                    for (Game gameOfCart : cart.getGames()
                    ) {
                        if (gameOfCart.getId() == gameOfCampaign.getId()) {
                            campaignFits = true;
                            System.out.println("İyi haber! " + campaign.getDescription() + " kampanyası uygulandı!");
                            double discountAmount = (campaign.getDiscountPercentage() * gameOfCart.getPrice()) / 100;
                            System.out.println(discountAmount + "tl Daha az ödüyorsunuz!");
                            cart.setTotalCost(cart.getTotalCost() - discountAmount);
                        }
                    }
                }
            }

        }
        if(campaignFits){
            System.out.println("Almak istediğiniz oyunların indirimli fiyatı: "+cart.getTotalCost());
        }
        else {
            System.out.println("Ne yazık ki uygun kampanya bulunamadı!");
        }
    }
}