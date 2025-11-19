package com.zhafarrel.frontend.strategies;

import java.util.Map;

public interface DifficultyStrategy {
    public Map<String, Integer> getObstacleWeights();
    public float getSpawnInterval();
    public int getDensity();
    public float getMinGap();
}
