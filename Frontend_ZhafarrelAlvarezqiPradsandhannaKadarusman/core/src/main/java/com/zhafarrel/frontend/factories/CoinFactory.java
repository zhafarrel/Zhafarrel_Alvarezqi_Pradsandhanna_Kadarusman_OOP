package com.zhafarrel.frontend.factories;

import com.zhafarrel.frontend.pools.CoinPool;

import java.util.Random;

public class CoinFactory {
    private CoinPool coinPool;
    private Random random;

    public void createCoinPattern(float spawnX, float groundTopY){
        coinPool.obtain();
    }

    public void getCoinList(){
        getActiveCoins;
        releaseCoins;
    }
}
