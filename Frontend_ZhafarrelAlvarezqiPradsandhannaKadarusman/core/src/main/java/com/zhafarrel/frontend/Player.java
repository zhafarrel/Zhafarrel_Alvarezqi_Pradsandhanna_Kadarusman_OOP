package com.zhafarrel.frontend;

import com.badlogic.gdx.Gdx;
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
        this.position = startPosition;
        this.velocity = baseSpeed;
        this.collider = Rectangle();
    }

    public void update(float delta, boolean isFlying){
        public void updateDistanceAndSpeed(float delta){

        }
        public void  updatePosition(float delta){
            position.x = velocity.x * delta;
            position.y = velocity.y * delta;
        }

        public void applyGravity(float delta){
            velocity.y -= gravity * delta;
            velocity.x = baseSpeed;
            if (velocity.y > maxVerticalSpeed){
                velocity.y = maxVerticalSpeed;
            }else{
                velocity.y = maxVerticalSpeed;
            }
        }


    }


}
