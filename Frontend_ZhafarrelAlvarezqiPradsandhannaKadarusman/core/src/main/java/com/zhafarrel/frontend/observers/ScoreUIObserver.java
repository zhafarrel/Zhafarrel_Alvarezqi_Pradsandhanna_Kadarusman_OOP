package com.zhafarrel.frontend.observers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreUIObserver implements Observer{
    private BitmapFont font;
    private SpriteBatch batch;

    ScoreUIObserver(BitmapFont font, SpriteBatch batch){
        this.font = new BitmapFont();
        font.setColor(Color.WHITE);
        this.batch = new SpriteBatch();
    }

    @Override
    public void update(int score) {
        System.out.println("Skor telah diperbarui!");
    }

    public void render(int score){
        batch.begin();
        batch.draw();
        batch.end();
    }

    public void dispose(){
        font.;
    }

}
