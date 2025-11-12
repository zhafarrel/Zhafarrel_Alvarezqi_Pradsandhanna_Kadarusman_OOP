package com.zhafarrel.frontend.observers;


import java.util.ArrayList;
import java.util.List;

public class ScoreManager implements Subject {
    private List<Observer> observers;
    private int score;

    ScoreManager(List<Observer> observers, int score){
        this.observers = new ArrayList<>();
        this.score = 0;
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observers);
    }

    @Override
    public void notifyObservers(int score) {
        for(Observer observer : observers){
            observer.update(score);
        }
    }

    public void setScore(int newScore){
        if(score != newScore){
            this.score = newScore;
            notifyObservers(score);
        }
    }

    public int getScore(){
        return score;
    }
}
