package com.zhafarrel.frontend.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.zhafarrel.frontend.obstacles.BaseObstacle;
import com.zhafarrel.frontend.obstacles.HomingMissile;
import com.zhafarrel.frontend.pools.HomingMissilePool;
import com.zhafarrel.frontend.pools.ObjectPool;

import java.util.List;
import java.util.Random;

public class HomingMissileCreator implements ObstacleFactory.ObstacleCreator {
    private final HomingMissilePool pool = new HomingMissilePool();

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        float minY = groundTopY;
        float maxY = Gdx.graphics.getHeight();
        float randomY = minY + rng.nextFloat() * (maxY - minY);
        HomingMissile obj = pool.obtain(new Vector2(spawnX, randomY));
        return obj;
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if(obstacle instanceof HomingMissile){
            pool.release((HomingMissile) obstacle);
        }
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<HomingMissile> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObstacle obstacle) {
        return obstacle instanceof HomingMissile;
    }

    @Override
    public String getName() {
        return "HomingMissile";
    }
}
