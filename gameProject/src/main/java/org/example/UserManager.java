package org.example;
import java.util.List;
public class UserManager {
    private List<User> users;

    public UserManager(List<User> users) {
        this.users = users;
    }

    List<User> getAll(){
        return users;
    }
    void create(User user){
      users.add(user);
    }
    User read(String id){
        for (User user:users
        ) {
            if(user.getNationalityId()==id){
                return user;
            }
        }
        return null;
    }
    void update(User user){
        for (User u:users
             ) {
            if(u.getNationalityId()==user.getNationalityId()){
                u.setBirthDate(user.getBirthDate());
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());

            }
        }


    }
    void delete(String id){
        for (User user:users
             ) {
            if(user.getNationalityId()==id){
                user.setDeleted(true);
            }
        }

    }
}
