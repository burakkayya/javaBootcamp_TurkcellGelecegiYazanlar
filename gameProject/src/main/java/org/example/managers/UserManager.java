package org.example.managers;
import org.example.entities.User;

import java.util.List;
public class UserManager {
    private List<User> users;

    public UserManager(List<User> users) {
        this.users = users;
    }

    public List<User> getAll(){
        return users;
    }
    void create(User user){
      users.add(user);
    }
    User get(String id){
        for (User user:users
        ) {
            if(user.getNationalityId()==id){
                return user;
            }
        }
        return null;
    }
    public void update(User user){
        for (User u:users
             ) {
            if(u.getNationalityId()==user.getNationalityId()){
                u.setBirthDate(user.getBirthDate());
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());

            }
        }


    }
    public void delete(String id){
        for (User user:users
             ) {
            if(user.getNationalityId()==id){
                user.setDeleted(true);
            }
        }

    }
}
