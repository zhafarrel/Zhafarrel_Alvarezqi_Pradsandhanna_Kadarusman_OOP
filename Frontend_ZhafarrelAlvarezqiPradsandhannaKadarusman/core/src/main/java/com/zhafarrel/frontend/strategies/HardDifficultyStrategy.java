package com.zhafarrel.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class HardDifficultyStrategy implements DifficultyStrategy{
    @Override
    public Map<String, Integer> getObstacleWeights() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("VerticalLaser", 3);
        map.put("HorizontalLaser", 3);
        map.put("HomingMissile", 4);
        return map;
    }

    @Override
    public float getSpawnInterval() {
        return 1.0f;
    }

    @Override
    public int getDensity() {
        return 3;
    }

    @Override
    public float getMinGap() {
        return 100f;
    }
}
