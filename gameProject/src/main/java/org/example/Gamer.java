package org.example;

import java.util.Date;

public class Gamer extends User{
    private String password;
    private String userName;
    private Game[] games;


    public Gamer(int id, String nationalityId, String firstName, String lastName, Date birthDate, String password, String userName, Game[] games) {
        super(id,nationalityId, firstName, lastName, birthDate,false);
        this.password = password;
        this.userName = userName;
        this.games = games;
    }

    public Gamer() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }
}
