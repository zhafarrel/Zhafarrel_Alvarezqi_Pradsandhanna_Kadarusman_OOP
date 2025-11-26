package com.zhafarrel.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Coin {
    private Vector2 position;
    private Rectangle collider;
    private float radius = 15f;
    private boolean active;
    private float bobOffset;
    private float bobSpeed;

    public Coin(Vector2 startPosition){
        this.collider = new Rectangle();
    }

    public void update(float delta){
        bobOffset = bobSpeed * delta;
    }

    public void renderShape(ShapeRenderer shapeRenderer){
        float drawY = position.y + (float)(Math.sin(bobOffset) * 5f);
        shapeRenderer.setColor(1f, 1f, 0f, 1f);
        shapeRenderer.circle(position.x, drawY, radius);
        if(!active){
            return;
        }
    }

    public boolean isColliding(Rectangle playerCollider){
        if(active && collider.overlaps(playerCollider)){
            return true;
        }
        return false;
    }


}
