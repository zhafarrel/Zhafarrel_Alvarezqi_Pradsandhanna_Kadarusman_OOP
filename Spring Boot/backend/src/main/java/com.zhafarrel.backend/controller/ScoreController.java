package com.zhafarrel.backend.controller; //sesuaikan
import com.zhafarrel.backend.model.Player;
import com.zhafarrel.backend.model.Score; //sesuaikan
import com.zhafarrel.backend.service.ScoreService; //sesuaikan
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<?> createScore(@RequestBody Score score) {
        try {
            Score createdScore = scoreService.createScore(score);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdScore);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping
    public ResponseEntity<List<Score>> getAllScores() {
        List<Score> scores = scoreService.getAllScores();
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/{scoreId}")
    public ResponseEntity<?> getScoreById(@PathVariable UUID scoreId) {
        Optional<Score> score = scoreService.getScoreById(scoreId);
        if (score.isPresent()) {
            return ResponseEntity.ok(score.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Player not found with ID: " + scoreId + "\"}");
        }
    }

    @PutMapping("/{scoreId}")
    public ResponseEntity<?> updateScore(@PathVariable UUID scoreId, @RequestBody Score score) {
        try {
            Score updatedScore = scoreService.updateScore(scoreId, score);
            return ResponseEntity.ok(updatedScore);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<?> deleteScore(@PathVariable UUID scoreId) {
        try {
            scoreService.deleteScore(scoreId);
            return ResponseEntity.ok("{\"message\": \"Player deleted successfully\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<?>  getScoresByPlayerId (@PathVariable UUID playerId) {
        List<Score> score = scoreService.getScoresByPlayerId(playerId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Score not found with playerId: " + playerId + "\"}");
        }
    }

    @GetMapping("/player/{playerId}/ordered")
    public ResponseEntity<List<Score>>  getScoresByPlayerIdOrdered (@PathVariable UUID playerId) {
        List<Score> score = scoreService.getScoresByPlayerIdOrderByValue(playerId);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Score not found with playerId: " + playerId + "\"}");
        }
    }
}
