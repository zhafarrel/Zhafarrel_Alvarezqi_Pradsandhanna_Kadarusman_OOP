package com.zhafarrel.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background {
    private Texture backrgoundTexture;
    private TextureRegion backrgoundRegion;
    private float width;
    private float height;
    private float currentCameraX = 0f;

    public Background(){
        backrgoundTexture = new Texture("background.png");
        backrgoundRegion = new TextureRegion(backrgoundTexture);
        width = 2688f;
        height = 1536f;
    }

    public void update(float cameraX){
        this.currentCameraX = cameraX;
    }

    public void render(SpriteBatch batch){
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float scale = screenHeight / height;
        float scaledWidth = width * scale;
        float scaledHeight = height * scale;

        float startX = (currentCameraX - screenWidth * 0.5f) - (currentCameraX - screenWidth * 0.5f) % scaledWidth;
        int tiles = (int) (screenWidth / scaledWidth) + 2;

        for (int i = 0; i < tiles; i++) {
            batch.draw(backrgoundRegion, startX + i * scaledWidth, 0, scaledWidth, scaledHeight);
        }
    }

    public void dispose(){
        if(backrgoundTexture != null){
            backrgoundTexture.dispose();
        }
    }

}
