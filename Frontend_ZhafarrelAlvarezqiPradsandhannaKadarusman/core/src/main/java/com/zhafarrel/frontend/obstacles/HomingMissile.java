package com.zhafarrel.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.zhafarrel.frontend.Player;

public class HomingMissile extends BaseObstacle{
    private Player target;
    private Vector2 velocity;
    private float speed = 200f;
    private float width = 40f;
    private float height = 20f;

    public HomingMissile(Vector2 startPosition, int length) {
        super(startPosition, length);
        this.velocity = velocity;
    }

    @Override
    public void initialize(Vector2 startPosition,int length){
        super.initialize(startPosition, length);
        velocity.set(0,0);
    }

    public void setTarget(Player target){
        this.target = target;
    }

    public boolean isTargetingPlayer() {
        if (target == null) {
            return false;
        }
        if (){
        }
        return false;
    }

    public void update(float delta){
        if(target != null && active){
            this.targetPosition = targetPosition;
            velocity.set(targetPosition).sub(position).nor().scl(speed);
        }
        position.x = velocity.x * delta;
        position.y = velocity.y * delta;
        updateCollider();
    }

    @Override
    protected void updateCollider() {
        collider = new Rectangle(position.x, position.y, WIDTH, length);
    }

    @Override
    protected void drawShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(position.x, position.y, WIDTH, length);
    }

    @Override
    protected float getRenderWidth() {
        return length;
    }

    @Override
    protected float getRenderHeight() {
        return WIDTH;
    }
}
