package Repository;
import Model.Score;
import java.util.HashMap;
import java.util.UUID;

public abstract class ScoreRepository extends BaseRepository{
    public ScoreRepository(){
        super(T, ID);
    }

    public UUID findPlayerById(UUID playerId){
        return playerId;
    }

    public UUID findByPlayerIdOrderByValueDesc(UUID playerId){
        return;
    }

    public UUID findTopScores(int limit) {
        return;
    }

    public UUID  findHighestScoreByPlayerId(UUID playerId){
        return;
    }

    public int findByValueGreaterThan(Integer minValue){
        return;
    }

    public UUID findAllByOrderByCreatedAtDesc() {
        return;
    }

    public Integer getTotalCoinsByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(score ->
                        score.getPlayerId().equals(playerId))
                .mapToInt(Score::getCoinsCollected)
                .sum();
    }

    public UUID getTotalDistanceByPlayerId(UUID playerId){
        return;
    }

    @Override
    public void save(Score score){

    };

    @Override
    public HashMap getId(Score entity){

    };


}
