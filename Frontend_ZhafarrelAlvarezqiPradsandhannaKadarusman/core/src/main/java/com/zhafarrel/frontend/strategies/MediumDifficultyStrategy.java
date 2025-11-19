package com.zhafarrel.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class MediumDifficultyStrategy implements DifficultyStrategy{
    @Override
    public Map<String, Integer> getObstacleWeights() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("VerticalLaser", 2);
        map.put("HorizontalLaser", 2);
        map.put("HomingMissile", 1);
        return map;
    }

    @Override
    public float getSpawnInterval() {
        return 1.9f;
    }

    @Override
    public int getDensity() {
        return 2;
    }

    @Override
    public float getMinGap() {
        return 270f;
    }
}
