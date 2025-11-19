package com.zhafarrel.frontend.strategies;

import java.util.Map;

public class EasyDifficultyStrategy implements DifficultyStrategy{


    @Override
    public Map<String, Integer> getObstacleWeights() {
        return Map.of();
    }

    @Override
    public float getSpawnInterval() {
        return 0;
    }

    @Override
    public int getDensity() {
        return 0;
    }

    @Override
    public float getMinGap() {
        return 0;
    }
}
