package com.zhafarrel.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.zhafarrel.frontend.observers.Observer;
import com.zhafarrel.frontend.observers.ScoreManager;
import com.zhafarrel.frontend.services.BackendService;

public class GameManager {
    private static GameManager instance;
    private ScoreManager scoreManager;
    private boolean gameActive;
    private BackendService backendService;
    private String currentPlayerId;
    private int coinsCollected;

    private GameManager() {
        this.scoreManager = new ScoreManager();
        this.gameActive = false;
        backendService = new BackendService();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame() {
        scoreManager.setScore(0);
        gameActive = true;
        coinsCollected = 0;
        System.out.println("Game Started!");
    }

    public void setScore(int distance) {
        if (gameActive) {
            scoreManager.setScore(distance);
        }
    }

    public int getScore() {
        return scoreManager.getScore();
    }

    public void addObserver(Observer observer) {
        scoreManager.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        scoreManager.removeObserver(observer);
    }

    public void registerPlayer(String username){
        backendService.createPlayer(username, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                try{
                    JsonValue json = new JsonReader().parse(response);
                    currentPlayerId = json.getString("playerId");
                    Gdx.app.log("GameManager", "Player ID Saved: " + currentPlayerId);
                }catch (Exception e) {
                    Gdx.app.error("GameManager", "Parsing error: " + e.getMessage());
                }

            }

            @Override
            public void onError(String error) {
                Gdx.app.error("Error", "Cannot Register");
            }
        });
    }

    public void endGame(){
        if(currentPlayerId == null){
            System.out.println("Cannot Submit Score...");
            return;
        }
        int currentScore = scoreManager.getScore();
        int currentCoins = coinsCollected * 10;
        int endScore = currentScore + currentCoins;
        backendService.submitScore(currentPlayerId, endScore, coinsCollected, currentScore, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                Gdx.app.log("Success","Success");
            }

            @Override
            public void onError(String error) {
                Gdx.app.error("Error", "Error");
            }
        });
    }

    public void addCoin(){
        coinsCollected++;
        Gdx.app.log("COIN COLLECTED!", "Total: " + coinsCollected);
    }

    public int getCoins(){
        return coinsCollected;
    }
}
