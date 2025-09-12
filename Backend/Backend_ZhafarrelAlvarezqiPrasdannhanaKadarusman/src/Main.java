import Model.Player;
import Model.Score;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Andi");
        Player p2 = new Player("Budi");

        Score s1 = new Score(p1.getPlayerId(), 1500, 250, 5000);
        Score s2 = new Score(p2.getPlayerId(), 3200, 750, 12000);
        Score s3 = new Score(p1.getPlayerId(), 1800, 300, 6000);

        p1.updateHighscore(s1.getValue());
        p1.addCoins(s1.getCoinsCollected());
        p1.addDistance(s1.getDistance());

        p1.updateHighscore(s3.getValue());
        p1.addCoins(s3.getCoinsCollected());
        p1.addDistance(s3.getDistance());

        p2.updateHighscore(s2.getValue());
        p2.addCoins(s2.getCoinsCollected());
        p2.addDistance(s2.getDistance());

        // Tampilkan detail player
        System.out.println("=========================== Players Details ===========================");
        p1.showDetail();
        System.out.println();
        p2.showDetail();
        System.out.println();


    }
}