package com.devillsroom.poker.player;

import java.util.LinkedList;
import java.util.List;

public class CardValuePlayer implements Player {
    private List<Card> hand = new LinkedList<>();

    @Override
    public long doBet(long pot, long to_call, long minimum_raise) {
        double d = actualValue() / totalValue();
        if (d > 0.75) {
            return (long) ((minimum_raise + to_call) + pot * Math.random());
        } else if (d > 0.5) {
            return (long) ((minimum_raise + to_call) +  100 * d);
        }
        return 0;
    }

    private int actualValue() {
        int v = 0;
        for (Card c : hand) {
            v += c.value;
        }
        return v;
    }

    private int totalValue() {
        return 14 * hand.size();
    }

    @Override
    public void addCard(int suite, int value) {
        hand.add(new Card(suite, value));
    }
}
