package com.zhafarrel.backend.controller;

import com.zhafarrel.backend.model.Player;
import com.zhafarrel.backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<?> getPlayerById(@PathVariable UUID playerId){
        playerService.getPlayerById(playerId);
        if (player.isPresent() ) {
            return ResponseEntity.ok(player.get());
        }
        return new ResponseEntity<>(
                "ERROR",
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getPlayerByUsername(@PathVariable String username){
        playerService.getPlayerByUsername(username);
        if (player.isPresent() = null) {
             ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(player.get());
    }


    @GetMapping
    public boolean checkUsername() {
        return playerService.isUsernameExists(username);
    }

    @PostMapping
    public ResponseEntity<?> createPlayer(@RequestBody Player player){
        try{
            playerService.createPlayer(player);
            return new ResponseEntity<>(
                    "CREATED",
                    HttpStatus.CREATED);
        }catch (Error e){
            return new ResponseEntity<>(
                    "ERROR",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping ("/{playerId}")
    public ResponseEntity<?> updatePlayer(@RequestBody Player player){
        try{
            playerService.updatePlayer(playerId, player);
            return new ResponseEntity<>(
                    "UPDATED",
                    HttpStatus.CREATED);
        }catch (Error e){
            return new ResponseEntity<>(
                    "ERROR",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<?> ddeletePlayer(@PathVariable UUID playerId){
        try{
            playerService.deletePlayer(playerId);
            return new ResponseEntity<>(
                    "DELETED",
                    HttpStatus.CREATED);
        }catch (Error e){
            return new ResponseEntity<>(
                    "ERROR",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/leaderboard/high-score")
    public ResponseEntity<List<Player>> getLeaderboardByHighScore(@RequestParam(defaultValue = "10") int limit){
        return ResponseEntity.ok(playerService.getLeaderboardByHighScore(limit));
    }

    @GetMapping("/leaderboard/total-coins")
    public ResponseEntity<List<Player>> getLeaderboardByTotalCoins(){
        return ResponseEntity.ok(playerService.getLeaderboardByTotalCoins());
    }

    @GetMapping("/leaderboard/total-distance")
    public ResponseEntity<List<Player>> getLeaderboardByTotalDistance(){

        return ResponseEntity.ok(playerService.getLeaderboardByTotalDistance());
    }
}
