package com.devillsroom.poker.player;

public interface Player {

    long doBet(long pot, long to_call, long minimum_raise);

    void addCard(int suite, int value);
}
