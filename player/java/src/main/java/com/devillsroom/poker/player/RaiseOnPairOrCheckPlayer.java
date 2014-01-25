package com.devillsroom.poker.player;

import java.util.LinkedList;
import java.util.List;

public class RaiseOnPairOrCheckPlayer implements Player {
    private List<Card> hand = new LinkedList<>();

    @Override
    public long doBet(long pot, long to_call, long minimum_raise) {
        if (hasPair()) {
            return minimum_raise + to_call;
        }
        return to_call;
    }

    public boolean hasPair() {
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (Card c : hand) {
            if (a[c.value] == 1)
                return true;
            a[c.value]++;
        }
        return false;
    }

    @Override
    public void addCard(int suite, int value) {
        hand.add(new Card(suite, value));
    }
}
