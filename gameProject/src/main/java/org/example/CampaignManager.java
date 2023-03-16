package org.example;

import java.util.Date;
import java.util.List;

public class CampaignManager {
   private List<Campaign> campaigns;


    public CampaignManager(List<Campaign> campaigns) {

        this.campaigns = campaigns;
    }
    List<Campaign> getAll(){
        return campaigns;
    }
    void create(Campaign campaign){
        campaigns.add(campaign);
        System.out.println("Kampanya başarı ile oluşturuldu");
    }
    Campaign read(int id){
        for (Campaign campaign:campaigns
        ) {
            if(campaign.getId()==id){
                return campaign;
            }
        }
        return null;
    }
    void update(Campaign campaign){
        for (Campaign c:campaigns) {
            if(c.getId()==campaign.getId()){
                c.setDescription(campaign.getDescription());
                c.setStartDate(campaign.getStartDate());
                c.setDiscountPercentage(campaign.getDiscountPercentage());
                c.setEndDate(campaign.getStartDate());
                c.setGames(campaign.getGames());
                System.out.println("Kampanya bilgileri başarı ile güncellendi!");

            }
        }

    }
    void delete(int id){
        for (Campaign c:campaigns) {
            if (c.getId() == id) {
                c.setDeleted(true);
                System.out.println("Kampanya silindi!");
            }
        }

    }
    void addGame(Game game,int id){
        read(id).getGames().add(game);
    }

}
