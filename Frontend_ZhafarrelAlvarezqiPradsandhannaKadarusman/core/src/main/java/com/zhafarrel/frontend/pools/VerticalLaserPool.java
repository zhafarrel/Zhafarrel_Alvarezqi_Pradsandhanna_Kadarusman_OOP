package com.zhafarrel.frontend.pools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.zhafarrel.frontend.obstacles.VerticalLaser;

public class VerticalLaserPool extends ObjectPool<VerticalLaser> {
    @Override
    protected VerticalLaser createObject() {
        return new VerticalLaser(new Vector2(0, 0), 100);
    }

    @Override
    protected void resetObject(VerticalLaser object) {
        object.setPosition(0,0);
        object.setActive(false);
    }

    public VerticalLaser obtain(Vector2 position, int length) {
        VerticalLaser obj = super.obtain();
        obj.initialize(position, length);
        obj.setActive(true);
        return obj;
    }


}
