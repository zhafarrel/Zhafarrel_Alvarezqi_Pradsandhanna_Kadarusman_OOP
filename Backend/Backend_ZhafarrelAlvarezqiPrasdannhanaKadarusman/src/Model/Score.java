package Model;
import java.nio.file.LinkOption;
import java.time.LocalDateTime;
import java.util.UUID;


public class Score {
    private UUID scoreId;
    private UUID playerId;
    private Player player;
    private int value;
    private int coinsCollected;
    private int distance;
    private LocalDateTime createdAt;

    public Score(UUID scoreId, int value, int coinsCollected, int distance){
        this.scoreId = UUID.randomUUID();
        this.value = value;
        this.coinsCollected = coinsCollected;
        this.distance = distance;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getScoreId(){
        return scoreId;
    }

    public int getValue(){
        return value;
    }

    public int getCoinsCollected(){
        return coinsCollected;
    }

    public int getDistance(){
        return distance;
    }

    public void showDetail(){
        System.out.println("Score ID: " + getScoreId());
        System.out.println("Player ID: " + player.getPlayerId());
        System.out.println("Score Value: " + getValue());
        System.out.println("Coins Collected: " + getCoinsCollected());
        System.out.println("Distance: " + getDistance());
        System.out.println("Created At: " + createdAt);
    }


}
