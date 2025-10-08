package com.zhafarrel.backend.service;
import com.zhafarrel.backend.model.Score; // sesuaikan
import com.zhafarrel.backend.repository.ScoreRepository; //sesuaikan
import com.zhafarrel.backend.repository.PlayerRepository; //sesuaikan
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @Transactional
    public Score createScore(Score score){
        if (!scoreRepository.existsById(score.getPlayerId())){
            throw new RuntimeException("Player not found with ID : " + score.getPlayerId());
        }
        Score newScore = scoreRepository.save(score);
        playerService.updatePlayerStats(
                newScore.getPlayerId(),
                newScore.getValue(),
                newScore.getCoinsCollected(),
                newScore.getDistanceTravelled()
        );
        return newScore;
    }

    public Optional<Score> getScoreById(UUID scoreId) {
        return scoreRepository.findById(scoreId);
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public List<Score> getScoresByPlayerId(UUID playerId) {
        return scoreRepository.findByPlayerId(playerId);
    }

    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId) {
        return scoreRepository.findByPlayerIdOrderByValueDesc(playerId);
    }

    public List<Score> getLeaderboard(int limit) {
        return scoreRepository.findTopScores(limit);
    }
}
