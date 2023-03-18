package org.example.managers;
import org.example.entities.Gamer;

import java.util.List;
public class GamerManager{
    private List<Gamer> gamers;
    private UserManager userManager;

    private EDevletVerificationManager eDevletVerificationManager;

    public GamerManager(List<Gamer> gamers, UserManager userManager, EDevletVerificationManager eDevletVerificationManager) {
        this.gamers = gamers;
        this.userManager = userManager;
        this.eDevletVerificationManager = eDevletVerificationManager;
    }

    public List<Gamer> getAll(){
        return gamers;
    }
    public void create(Gamer gamer){
        if(eDevletVerificationManager.checkPerson(gamer)) {
            gamers.add(gamer);
            userManager.create(gamer);
        }
    }
    public Gamer get(int id){
        for (Gamer gamer:gamers
             ) {
            if(gamer.getId()==id){
                return gamer;
            }
        }
        return null;
    }
    public void update(Gamer gamer){
        for (Gamer g:gamers
        ) {
            if(g.getId()==gamer.getId()) {
                g.setBirthDate(gamer.getBirthDate());
                g.setGames(gamer.getGames());
                g.setFirstName(gamer.getFirstName());
                g.setLastName(gamer.getLastName());
                g.setNationalityId(gamer.getNationalityId());
                g.setPassword(gamer.getPassword());
                g.setUserName(gamer.getUserName());
                userManager.update(gamer);
                System.out.println("Kullanıcı bilgileriniz güncellendi!");
            }
        }
    }
    public void delete(int id){
        for (Gamer gamer:gamers
        ) {
            if(gamer.getId()==id){
                gamer.setDeleted(true);
                userManager.get(gamer.getNationalityId()).setDeleted(true);
                System.out.println("Kullanıcı kaydınız başarı ile silindi!");
            }
        }
    }
}