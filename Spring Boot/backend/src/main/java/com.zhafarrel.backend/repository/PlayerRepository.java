package com.zhafarrel.backend.repository;

import com.zhafarrel.backend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    Optional<Player> findByUsername(String username);
    boolean existsByUsername(String username);
    @Query("SELECT p FROM Player p ORDER BY p.highScore DESC")
    List<Player> findTopPlayersByHighScore(@Param("limit") int limit);
    List<Player> findByHighScoreGreaterThan(Integer minScore);
    List<Player> findAllByOrderByTotalCoinsDesc();
    List<Player> findAllByOrderByTotalDistanceTravelledDesc();
}