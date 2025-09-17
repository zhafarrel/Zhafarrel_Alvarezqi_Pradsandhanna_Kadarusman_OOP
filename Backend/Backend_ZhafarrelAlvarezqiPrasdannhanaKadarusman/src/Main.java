import Model.Player;
import Model.Score;
import Repository.PlayerRepository;
import Repository.ScoreRepository;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        PlayerRepository playerRepo = new PlayerRepository();
        ScoreRepository scoreRepo = new ScoreRepository();
        Player player1 = new Player("Stelle");
        Player player2 = new Player("gamerLooxmaxxing");
        Player player3 = new Player("Stelle123");
        3
        Player player4 = new Player("Banananana");

        // Buat dan simpan player

        player1.updateHighScore(1500);
        player1.addCoins(250);
        player1.addDistance(5000);

        player2.updateHighScore(3200);
        player2.addCoins(750);
        player2.addDistance(12000);
        // Buat update stats untuk player 3 dan 4 (bebas)
        player3.updateHighscore(3900);
        player3.addCoins(500);
        player3.addDistance(10000);

        player4.updateHighscore(4000);
        player4.addCoins(1000);
        player4.addDistance(15000);

        // Buat dan simpan nilai dengan ketentuan;
        // Score 1: Untuk player 2, memiliki score 1500, coins 250, dan distance 5000
        // Score 2: Untuk Player 4, memiliki score 3200, coins 750, dan distance 12000
        // Score 3: Untuk Player 1, memiliki score 4000, coins 400, dan distance 32000
        // Score 4: Untuk Player 4, memiliki score 1800, coins 300, dan distance 6000
        // Score 5: Untuk Player 3, memiliki score 2400, coins 240, dan distance 2400
        // Score 6: Untuk Player 2, memiliki score 6200, coins 320, dan distance 5000
        // Score 7: Untuk Player 4, memiliki score 1800, coins 60, dan distance 1200
        // Score 8: Untuk Player 1, memiliki score 2100, coins 200, dan distance 7000
        // Score 9: Untuk Player 1, memiliki score 8000, coins 720, dan distance 6200
        // Score 10: Untuk Player 3,memiliki score 1900, coins 210, dan distance 4200

        System.out.println("=== TESTING CS3 ===");

        System.out.println("Find player by ID:");
        // Tunjukkan detail Player 3
        player3.showDetail();

        System.out.println("All players:");
        // Tunjukkan semua player


        // Urutkan player berdasar highscore

        System.out.println("Scores for player1:");
        // Cari Score Player 1
        player1.showDetail();
    }
}