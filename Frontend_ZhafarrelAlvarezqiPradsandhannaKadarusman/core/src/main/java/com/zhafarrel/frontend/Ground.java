package com.zhafarrel.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Ground{
    private static final float GROUND_HEIGHT = 50f;
    private Rectangle collider;

    Ground(){
        this.collider = new Rectangle(0,0,2 * Gdx.graphics.getWidth(), GROUND_HEIGHT);
    }

    public void update(float cameraX){
        collider.setPosition(cameraX - Gdx.graphics.getWidth() / 2f - 500 , 0);
        collider.setWidth(2 * Gdx.graphics.getWidth());
    }

    public boolean isColliding(Rectangle playerCollider){
        if(collider.overlaps(playerCollider)) {
            return true;
        }else{
            return false;
        }
    }

    public float getTopY(){
        return GROUND_HEIGHT;
    }

    public void renderShape(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(0.5f, 0.5f, 0.5f, 1f);
        shapeRenderer.rect(collider.x, collider.y,2 * Gdx.graphics.getWidth(), GROUND_HEIGHT);
    };
}

