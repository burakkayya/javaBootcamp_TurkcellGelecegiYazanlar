package org.example;
import java.util.List;
public class GamerManager{
    private List<Gamer> gamers;
    private UserManager userManager;

    private EDevlet eDevlet;

    public GamerManager(List<Gamer> gamers, UserManager userManager, EDevlet eDevlet) {
        this.gamers = gamers;
        this.userManager = userManager;
        this.eDevlet = eDevlet;
    }

    List<Gamer> getAll(){
        return gamers;
    }
    void create(Gamer gamer){
        if(eDevlet.checkPerson(gamer)) {
            gamers.add(gamer);
            userManager.create(gamer);
        }
    }
    Gamer read(int id){
        for (Gamer gamer:gamers
             ) {
            if(gamer.getId()==id){
                return gamer;
            }
        }
        return null;
    }
    void update(Gamer gamer){
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
    void delete(int id){
        for (Gamer gamer:gamers
        ) {
            if(gamer.getId()==id){
                gamer.setDeleted(true);
                userManager.read(gamer.getNationalityId()).setDeleted(true);
                System.out.println("Kullanıcı kaydınız başarı ile silindi!");
            }
        }
    }
}
/*


 */