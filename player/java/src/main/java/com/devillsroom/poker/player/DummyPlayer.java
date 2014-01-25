package com.devillsroom.poker.player;

public class DummyPlayer implements Player {
    @Override
    public long doBet(long pot, long to_call, long minimum_raise) {
        return 0;
    }

    @Override
    public void addCard(int suite, int value) {

    }
}
