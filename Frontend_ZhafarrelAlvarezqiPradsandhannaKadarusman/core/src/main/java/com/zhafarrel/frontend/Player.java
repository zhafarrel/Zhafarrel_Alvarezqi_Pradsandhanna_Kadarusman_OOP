package com.zhafarrel.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private float gravity = 2000f;
    private float force = 4500f;
    private float maxVerticalSpeed = 700f;
    private Rectangle collider;
    private float width = 64f;
    private float height = 64f;
    private float baseSpeed = 300f;
    private float distanceTraveled = 0f;

    Player(Vector2 startPosition){
        this.position = new Vector2(startPosition);
        this.velocity = new Vector2(baseSpeed, 0);
        this.collider = new Rectangle(position.x, position.y, width, height);
    }

    public void update(float delta, boolean isFlying){
        updateDistanceAndSpeed(delta);
        updatePosition(delta);
        applyGravity(delta);
        if(isFlying) {
            fly(delta);
        }
        updateCollider();
    }

    private void updateDistanceAndSpeed(float delta){
        distanceTraveled += velocity.x * delta;
    }

    private void  updatePosition(float delta){
        position.x += velocity.x * delta;
        position.y += velocity.y * delta;
    }

    private void applyGravity(float delta){
        velocity.y -= gravity * delta;
        velocity.x = baseSpeed;
        if (velocity.y > maxVerticalSpeed){
            velocity.y = maxVerticalSpeed;
        }
        if(velocity.y < -maxVerticalSpeed){
            velocity.y = -maxVerticalSpeed;
        }
    }

    private void fly(float delta){
        velocity.y += force * delta;
    }

    private void updateCollider(){
        collider.setPosition(position.x, position.y);
    }

    public void checkBoundaries(Ground ground, float ceilingY){
        if(ground.isColliding(collider)){
            position.y = ground.getTopY();
            velocity.y = 0;
            updateCollider();
        }

        if(position.y + height > ceilingY){
            position.y = ceilingY - height;
            velocity.y = 0;
            updateCollider();
        }
    }

    public void renderShape(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(position.x, position.y, width, height);
    }

    public Vector2 getPosition(){
        return position;
    }

    public float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }

    public Rectangle getCollider(){
        return collider;
    }

    public float getDistanceTraveled(){
        return distanceTraveled / 10f;
    }
}
