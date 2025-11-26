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
        this.position = new Vector2(startPosition);
        this.active = false;
    }

    public void update(float delta){
        bobOffset += bobSpeed * delta;
        float drawY = position.y + (float)(Math.sin(bobOffset) * 5f);
        collider.setPosition(position.x - radius, position.y - radius);
    }

    public void renderShape(ShapeRenderer shapeRenderer){
        if(!active){
            return;
        }
        float drawY = position.y + (float)(Math.sin(bobOffset) * 5f);
        shapeRenderer.setColor(1f, 1f, 0f, 1f);
        shapeRenderer.circle(position.x, drawY, radius);
    }

    public boolean isColliding(Rectangle playerCollider){
        if(active && collider.overlaps(playerCollider)){
            return true;
        }
        return false;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setPosition(float x, float y) {
        this.position.set(x, y);
        this.collider.setPosition(x - radius, y - radius);
    }

    public Vector2 getPosition() {
        return position;
    }

}
