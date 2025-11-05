package com.zhafarrel.frontend.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.zhafarrel.frontend.obstacles.BaseObstacle;
import com.zhafarrel.frontend.obstacles.HorizontalLaser;
import com.zhafarrel.frontend.pools.HorizontalLaserPool;

import java.util.List;
import java.util.Random;

public class HorizontalLaserCreator implements ObstacleFactory.ObstacleCreator {
    private HorizontalLaserPool pool = new HorizontalLaserPool();
    private static final float MIN_LENGTH = 100F;
    private static final float MAX_LENGTH = 300F;

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        float length = MIN_LENGTH + rng.nextFloat() * (MAX_LENGTH - MIN_LENGTH);
        float minY = groundTopY + playerHeight;
        float maxY = Gdx.graphics.getHeight() - playerHeight;
        float randomY = minY + rng.nextFloat() * (maxY - minY);
        HorizontalLaser obj = pool.obtain(new Vector2(spawnX, randomY), Math.round(length));
        return obj;
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if(obstacle instanceof HorizontalLaser){
            pool.release((HorizontalLaser) obstacle);
        }
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<HorizontalLaser> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObstacle obstacle) {
        return obstacle instanceof HorizontalLaser;
    }

    @Override
    public String getName() {
        return "HorizontalLaser";
    }
}
