package org.example;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private Date date;
    private List<Game> games;
    private  Gamer gamer;
    private double totalCost=0;
    private  boolean isDeleted;

    public Order(int id, Date date, List<Game> games, Gamer gamer, boolean isDeleted) {
        this.id = id;
        this.date = date;
        this.games = games;
        this.gamer = gamer;
        this.isDeleted = isDeleted;
        for (Game game:games
             ) {
            this.totalCost+=game.getPrice();
        }
    }
    public Order(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
