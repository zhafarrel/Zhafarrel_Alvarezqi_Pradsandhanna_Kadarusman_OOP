package Repository;

import java.util.HashMap;
import java.util.Optional;

public abstract class PlayerRepository <Player, UUID> extends BaseRepository{

    public Optional<Player> findByUsername(String username)
    {
        return allData.stream()
                .filter(player ->
                        player.getUsername().equals(username))
                .findFirst();
    }

    public findTopPlayersByHighScore(int limit){

    }

    public findHighscoreGreaterThan(int minScore){

    }

    public findAllOrderByTotalCoinsDesc(){

    }

    public findAllByOrderByTotalDistanceTravelledDesc(){

    }

    @Override
    public void save(Player player){

    };

    @Override
    public HashMap getId(Player entity){

    };
}
