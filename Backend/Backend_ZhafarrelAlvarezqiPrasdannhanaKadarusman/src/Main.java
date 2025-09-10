import Model.Player;
import Model.Score;

public class Main {
    public static void main(String[] args) {


        Player p1 = new Player("Andi");
        Player p2 = new Player("Budi");

        Score s1 = new Score("idP1", 1500, 250, 5000);
        Score s2 = new Score("idP2", 3200, 750, 12000);
        Score s3 = new Score("idP3", 1800, 300, 6000);


        p1.showDetail();
        p2.showDetail();
    }
}