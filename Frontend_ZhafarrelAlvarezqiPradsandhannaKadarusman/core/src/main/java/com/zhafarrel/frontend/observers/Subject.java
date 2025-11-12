package com.zhafarrel.frontend.observers;

public abstract interface Subject {
    abstract void addObserver(Observer observer);
    abstract void removeObserver(Observer observer);
    abstract void notifyObservers(int score);
}
