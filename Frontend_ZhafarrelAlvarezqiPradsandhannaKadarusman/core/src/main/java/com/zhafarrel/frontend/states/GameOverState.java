package com.zhafarrel.frontend.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera; // Import Camera
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zhafarrel.frontend.GameManager; // Import GameManager

public class GameOverState implements GameState {
    private final GameStateManager gsm;
    private final BitmapFont font;
    private final OrthographicCamera camera; // Tambahkan Kamera

    public GameOverState(GameStateManager gsm) {
        this.gsm = gsm;
        this.font = new BitmapFont();

        // 1. Setup Kamera Baru agar fokus kembali ke tengah layar
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            // Reset player/game state jika perlu sebelum main lagi
            gsm.set(new PlayingState(gsm)); // Lebih aman balik ke Menu dulu
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        // 2. Bersihkan Layar (Penting!)
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // 3. Reset pandangan Batch menggunakan Kamera UI yang statis
        if (batch != null) {
            batch.setProjectionMatrix(camera.combined); // KUNCI PERBAIKANNYA DISINI

            batch.begin();
            // Perbesar font sedikit biar jelas
            font.getData().setScale(2f);

            // Gambar teks di tengah
            font.draw(batch, "GAME OVER", Gdx.graphics.getWidth() / 2f - 100, Gdx.graphics.getHeight() / 2f + 50);

            font.getData().setScale(1f);
            font.draw(batch, "Press SPACE to Menu", Gdx.graphics.getWidth() / 2f - 80, Gdx.graphics.getHeight() / 2f - 20);

            batch.end();
        }
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
