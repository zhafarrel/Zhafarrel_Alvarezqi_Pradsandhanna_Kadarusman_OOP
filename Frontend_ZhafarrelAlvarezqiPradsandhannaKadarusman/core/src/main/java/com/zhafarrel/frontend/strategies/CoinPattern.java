package com.zhafarrel.frontend.strategies;

import com.zhafarrel.frontend.Coin;
import com.zhafarrel.frontend.factories.CoinFactory;

import java.util.List;

public interface CoinPattern {
    List<Coin> spawn(CoinFactory factory, float groundTopY, float spawnX, float screenHeight);

    String getName();

}

