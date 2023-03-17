package org.example;

import java.util.List;

public class CartManager {
    private List<Cart> orders;

    private CampaignManager campaignManager;

    public CartManager(List<Cart> orders, CampaignManager campaignManager) {
        this.orders = orders;
        this.campaignManager=campaignManager;

    }

    List<Cart> getAll(){
        return orders;
    }
    void create(Cart order){
        orders.add(order);
        calculateDiscount(order);

    }
    Cart read(int id){
        for (Cart order:orders
        ) {
            if(order.getId()==id){
                return order;
            }
        }
        return null;
    }
    void update(Cart order){
        for (Cart o:orders
        ) {
            if(o.getId()==order.getId())
            {
                o.setDate(order.getDate());
                o.setGames(order.getGames());
                o.setGamer(order.getGamer());
                o.setTotalCost(order.getTotalCost());

            }

        }

    }
    void delete(int id){
        for (Cart order:orders
        ) {
            if(order.getId()==id)
            {
                order.setDeleted(true);
            }
        }

    }
    void calculateDiscount(Cart order){
        System.out.println("Almak istediğiniz oyunların kampanyasız fiyatı:"+order.getTotalCost());
        boolean campaignFits=false;
        for (Campaign campaign:campaignManager.getAll()
        ) {
            if(!campaign.isDeleted()) {
                for (Game gameOfCampaign : campaign.getGames()
                ) {
                    for (Game gameOfOrder : order.getGames()
                    ) {
                        if (gameOfOrder.getId() == gameOfCampaign.getId()) {
                            campaignFits = true;
                            System.out.println("İyi haber! " + campaign.getDescription() + " kampanyası uygulandı!");
                            double discountAmount = (campaign.getDiscountPercentage() * gameOfOrder.getPrice()) / 100;
                            System.out.println(discountAmount + "tl Daha az ödüyorsunuz!");
                            order.setTotalCost(order.getTotalCost() - discountAmount);
                        }
                    }
                }
            }

        }
        if(campaignFits){
            System.out.println("Almak istediğiniz oyunların indirimli fiyatı: "+order.getTotalCost());
        }
        else {
            System.out.println("Ne yazık ki uygun kampanya bulunamadı!");
        }
    }
}