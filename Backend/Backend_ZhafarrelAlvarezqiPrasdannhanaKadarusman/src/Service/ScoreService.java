package Service;
import Model.Score;
import Repository.PlayerRepository;
import Repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ScoreService {
    private ScoreRepository scoreRepository
    private PlayerRepository playerRepository;
    private PlayerService playerService;

    public ScoreService(ScoreRepository scoreRepository, PlayerRepository playerRepository, PlayerService playerService) {
        this.scoreRepository = scoreRepository;
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }

    public Score createScore(Score score) {
        return 0;
    }

    public Optional<Score> getScoreById(UUID scoreId) {
        return 0;
    }

    public List<Score> getAllScores() {
        return 0;
    }

    public List<Score> getScoresByPlayerId(UUID playerId) {
        return 0;
    }

    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId) {
        return 0;
    }

    public List<Score> getLeaderboard(int limit) {
        return 0;
    }

    public Optional<Score> getHighestScoreByPlayerId(UUID playerId) {
        return 0;
    }

    public List<Score> getScoresAboveValue(int minValue) {
        return 0;
    }

    public List<Score> getRecentScores() {
        return 0;
    }

    public int getTotalCoinsByPlayerId(UUID playerId) {
        return 0;
    }

    public int getTotalDistanceByPlayerId(UUID playerId) {
        return 0;
    }

    public Score updateScore(UUID scoreId, Score updatedScore) {
        return 0;
    }

    public void deleteScore(UUID scoreId) {

    }

    public void deleteScoresByPlayerId(UUID playerId) {

    }
}
