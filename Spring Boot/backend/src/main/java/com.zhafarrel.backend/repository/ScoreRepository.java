package com.zhafarrel.backend.repository;
import com.zhafarrel.backend.model.Player;
import com.zhafarrel.backend.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface ScoreRepository extends JpaRepository<Score, UUID> {
    List<Score> findByPlayerId(UUID uuid);
    List<Score> findByValueGreaterThan(Integer minValue);
    List<Score> findAllByOrderByCreatedAtDesc();
    List<Score> findByPlayerIdOrderByValueDesc(UUID playerId);

    @Query("SELECT s FROM Score s ORDER BY s.value DESC")
    List<Score> findTopScores(int limit);

    @Query("SELECT s FROM Score s WHERE s.playerId = :playerId ORDER BY s.value DESC")
    List<Score> findHighestScoreByPlayerId(@Param("playerId") UUID playerId);

    @Query("SELECT SUM(s.coinsCollected) FROM Score s WHERE s.playerId = :playerId")
    Integer getTotalCoinsByPlayerId(@Param("playerId") UUID playerId);

    @Query("SELECT SUM(s.distanceTravelled) FROM Score s WHERE s.playerId = :playerId")
    Integer getTotalDistanceByPlayerId(@Param("playerId") UUID playerId);
}
