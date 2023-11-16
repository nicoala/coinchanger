package org.example;

import java.util.List;

public class CoinChanger {

    private final List<Integer> coins;

    public CoinChanger(List<Integer> coins) {
        this.coins = coins;
    }

    List<Integer> change(int amount) {
        throw new IllegalStateException();
    }
}