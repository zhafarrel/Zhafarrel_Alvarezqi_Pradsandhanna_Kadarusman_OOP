package com.zhafarrel.frontend.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.zhafarrel.frontend.obstacles.BaseObstacle;
import com.zhafarrel.frontend.obstacles.VerticalLaser;
import com.zhafarrel.frontend.pools.VerticalLaserPool;

import java.util.List;
import java.util.Random;

public class VerticalLaserCreator implements ObstacleFactory.ObstacleCreator {
    private VerticalLaserPool pool = new VerticalLaserPool();
    private static final float MIN_LENGTH = 100F;
    private static final float MAX_LENGTH = 300F;

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        float length = MIN_LENGTH - rng.nextFloat() * (MAX_LENGTH - MIN_LENGTH);
        float minY = groundTopY + playerHeight;
        float maxY = Gdx.graphics.getHeight() - playerHeight;
        float randomY = minY + rng.nextFloat() * (maxY - minY);
        VerticalLaser obj = pool.obtain(new Vector2(spawnX, randomY), Math.round(length));
        return obj;
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if(obstacle instanceof VerticalLaser){
            pool.release((VerticalLaser) obstacle);
        }
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<VerticalLaser> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObstacle obstacle) {
        return obstacle instanceof VerticalLaser;
    }

    @Override
    public String getName() {
        return "VerticalLaser";
    }
}
