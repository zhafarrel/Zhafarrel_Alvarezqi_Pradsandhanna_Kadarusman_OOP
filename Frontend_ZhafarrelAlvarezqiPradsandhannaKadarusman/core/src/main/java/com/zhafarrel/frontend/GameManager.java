package com.zhafarrel.frontend;

import com.zhafarrel.frontend.observers.Observer;
import com.zhafarrel.frontend.observers.ScoreManager;

public class GameManager {
    private static GameManager instance;
    private ScoreManager scoreManager;
    private boolean gameActive;

    private GameManager(){
        this.scoreManager = scoreManager;
        this.gameActive = false;
    }

    public static GameManager getInstance(){
        if(instance == null){
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame(){
        score = 0;
        gameActive = true;
        System.out.println("Game Started!");
    }

    public void setScore(int newScore){
        if(gameActive){
            scoreManager= newScore;
        }
    }

    public int getScore(){
        return scoreManager;
    }

    public void addObserver(Observer observer){
        scoreManager.add
    }
}
