package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EDevlet {
    List<User> users;

    public EDevlet() {
        users=new ArrayList<>();
        users.add(new User(1,"111111111","Ahmet","Yılmaz",new Date(1999,1,1),false));
        users.add(new User(2,"211111111","Ayşe","Özdemir",new Date(1998,1,1),false));
        users.add(new User(3,"311111111","Mehmet","Çelik",new Date(1997,1,1),false));


    }

    public boolean checkPerson(Gamer gamer){

        for (User user:users
             ) {
            if(user.getNationalityId()==gamer.getNationalityId()&&user.getFirstName()==gamer.getFirstName()&&user.getLastName()==gamer.getLastName()&&user.getBirthDate().compareTo(gamer.getBirthDate()) == 0){//&&==
                System.out.println("Kullancı doğrulandı!");
                return true;
            }

        }

        System.out.println("Kullancı doğrulanamadı!");

        return false;
    }

}
