package com.zhafarrel.frontend.factories;

import com.badlogic.gdx.utils.Array;
import com.zhafarrel.frontend.Coin;
import com.zhafarrel.frontend.pools.CoinPool;

import java.util.Random;

public class CoinFactory {
    private CoinPool coinPool;
    private Array<Coin> activeCoins;
    private Random random;

    public CoinFactory() {
        this.coinPool = new CoinPool();
        this.activeCoins = new Array<>();
        this.random = new Random();
    }

    public void createCoinPattern(float spawnX, float groundTopY){
        if(random.nextFloat() < 0.3f){
            float startY = groundTopY + 50 + random.nextInt(100);

            for(int i=0; i<3; ++i){
                Coin coin = coinPool.obtain(spawnX + (i*40), startY);
                activeCoins.add(coin);
            }
        }
    }

    public Array<Coin> getActiveCoins() {
        return activeCoins;
    }

    public void releaseCoin(Coin coin) {
        activeCoins.removeValue(coin, true);
        coinPool.release(coin);
    }

    public void releaseAll() {
        for(Coin coin : activeCoins) {
            coinPool.release(coin);
        }
        activeCoins.clear();
    }
}
