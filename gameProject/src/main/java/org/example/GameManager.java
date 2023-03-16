package org.example;

import java.util.List;
public class GameManager {
    private List<Game> games;

    public GameManager(List<Game> games) {
        this.games = games;
    }

    List<Game> getAll(){
        return games;
    }
    void create(Game game){
        games.add(game);
        System.out.println("Sisteme "+game.getName()+" isimli oyun eklendi!");
    }
    Game read(int id){
        for (Game game:games
        ) {
            if(game.getId()==id){
                return game;
            }
        }
        return null;
    }
    void update(Game game){
        for (Game g:games
             ) {
            if(g.getId()==game.getId()){
                g.setName(game.getName());
                g.setPrice(game.getPrice());

            }

        }

    }
    void delete(int id){
        for (Game game:games
             ) {
            if(game.getId()==id) {
                game.setDeleted(true);
            }
        }

    }
}
