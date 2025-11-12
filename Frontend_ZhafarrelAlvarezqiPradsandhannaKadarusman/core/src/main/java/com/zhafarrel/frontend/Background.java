package com.zhafarrel.frontend;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background {
    private Texture backrgoundTexture;
    private TextureRegion backrgoundRegion;
    private float width;
    private float height;
    private float currentCameraX = 0f;

    public Background(Texture backrgoundTexture, TextureRegion backrgoundRegion, float width, float height){
        this.backrgoundTexture = background.png;
        this.backrgoundRegion = backrgoundTexture;
        this.width = 2688f;
        this.height = 1536f;
    }
}
