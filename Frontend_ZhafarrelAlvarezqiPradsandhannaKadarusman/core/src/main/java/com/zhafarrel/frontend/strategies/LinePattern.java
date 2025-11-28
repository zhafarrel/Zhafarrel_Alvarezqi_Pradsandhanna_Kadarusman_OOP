package com.zhafarrel.frontend.strategies;

import com.zhafarrel.frontend.Coin;
import com.zhafarrel.frontend.factories.CoinFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinePattern implements CoinPattern {
    private static final float SPACING = 40f;
    private static final Random random = new Random();

    @Override
    public List<Coin> spawn(CoinFactory factory, float groundTopY, float spawnX, float screenHeight) {
        List<Coin> coins = new ArrayList<>();

        int count = 3 + random.nextInt(3);

        float minY = groundTopY + 50f;
        float maxY = screenHeight - 100f;
        float startY = minY + random.nextFloat() * (maxY - minY);

        for (int i = 0; i < count; i++) {
            float x = spawnX + (i * SPACING);

            Coin c = factory.coinPool.obtain(x, startY);

            factory.getActiveCoins().add(c);

            coins.add(c);
        }

        return coins;
    }

    @Override
    public String getName() {
        return "Line";
    }
}
