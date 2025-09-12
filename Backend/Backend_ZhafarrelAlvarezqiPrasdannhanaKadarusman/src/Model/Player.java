package Model;
import java.time.LocalDateTime;
import java.util.UUID;

public class Player {
    private UUID playerId;
    private String username;
    private int highscore;
    private int totalCoins;
    private int totalDistance;
    private LocalDateTime createdAt;

    public Player(String username){
        this.playerId = UUID.randomUUID();
        this.username = username;
        this.highscore = 0;
        this.totalCoins = 0;
        this.totalDistance = 0;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getPlayerId(){
        return playerId;
    }


    public void updateHighscore(int newScore){
        if(newScore > highscore){
            this.highscore = newScore;
        }
    }

    public void addCoins(int coins){
        totalCoins += coins;
    }

    public void addDistance(int distance){
        totalDistance += distance;
    }


    public void showDetail(){
        System.out.println("Player ID: " + playerId);
        System.out.println("Username: " + username);
        System.out.println("Highscore: " + highscore);
        System.out.println("Total Coins: " + totalCoins);
        System.out.println("Total Distance: " + totalDistance);
        System.out.println("Created At: " + createdAt);
    }

}
