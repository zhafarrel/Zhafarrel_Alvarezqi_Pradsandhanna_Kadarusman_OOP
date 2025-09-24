package Service;
import Model.Player;
import Repository.PlayerRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PlayerService {
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public boolean existByUsername(String username){
        return playerRepository.existByUsername(username);
    }

    public Player createPlayer(Player player){
        if (existByUsername(player.getUsername())){
            throw new RuntimeException("Error: username already exist!");
        }else{
            playerRepository.save(player);
        }
    }

    public Optional<Player> getPlayerByUsername(String username)(UUID playerId){
        return 0;
    }

    public Optional<Player> getPlayerById(String username)(UUID playerId){
        return 0;
    }

    public getAllPlayers()

    public Player updatePlayer(UUID playerId, Player updatedPlayer){
        return Player;
    }

    public void deletePlayer(UUID playerId){

    }

    public void deletePlayerByUsername(String username){

    }

    public Player updatePlayerStats(UUID playerId, int scoreValue, int coinsCollected, int distanceTravelled){
        return 0;
    }

    public List<Player> getLeaderboardByHighScore(int limit){
        return 0;
    }

    public List<Player> getLeaderboardByTotalCoins(){
        return 0;
    }

    public List<Player> getLeaderboardByTotalDistance(){
        return 0;
    }

}
