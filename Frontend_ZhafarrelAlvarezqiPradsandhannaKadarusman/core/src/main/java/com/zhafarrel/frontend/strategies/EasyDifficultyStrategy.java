package com.zhafarrel.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class EasyDifficultyStrategy implements DifficultyStrategy{


    @Override
    public Map<String, Integer> getObstacleWeights() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("VerticalLaser", 1);
        map.put("HorizontalLaser", 1);
        map.put("HomingMissile", 0);
        return map;
    }

    @Override
    public float getSpawnInterval() {
        return 2.0f;
    }

    @Override
    public int getDensity() {
        return 1;
    }

    @Override
    public float getMinGap() {
        return 300f;
    }
}
