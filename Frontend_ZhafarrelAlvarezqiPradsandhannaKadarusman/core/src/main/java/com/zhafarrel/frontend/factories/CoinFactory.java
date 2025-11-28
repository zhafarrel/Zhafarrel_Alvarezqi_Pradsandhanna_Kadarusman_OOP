package com.zhafarrel.frontend.factories;

import com.badlogic.gdx.utils.Array;
import com.zhafarrel.frontend.Coin;
import com.zhafarrel.frontend.pools.CoinPool;

public class CoinFactory {
    public final CoinPool coinPool;
    private Array<Coin> activeCoins;

    public CoinFactory() {
        this.coinPool = new CoinPool();
        this.activeCoins = new Array<>();
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
