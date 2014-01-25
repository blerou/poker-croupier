package com.devillsroom.poker.player;


import com.devillsroom.poker.client.Card;
import com.devillsroom.poker.client.HandDescriptor;
import org.apache.thrift.TException;

import java.util.LinkedList;
import java.util.List;

public class Hand {

    private List<Card> cards = new LinkedList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    private int[] evaluateValues () {

        int[] values = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (Card card : cards) {
            values[card.getValue()]++;

            if (cardIsAce(card)) {
                values[1]++;
            }
        }

        return values;

    }

    public boolean hasTwoHighCard() {
        int[] values = evaluateValues();

        for (int pos = 0; pos < values.length; pos++) {
            if (pos < 10 && values[pos] > 0) {
                return false;
            }
        }

        return true;
    }

    public boolean hasAtLeastPair() {

        int[] values = evaluateValues();

        for (int i : values) {
            if (i > 1) {
                return true;
            }
        }

        return false;
    }

    public boolean hasExactlyOnePair() {

        int[] values = evaluateValues();

        int pairCount = 0;

        for (int i : values) {
            if (i > 1) {
                pairCount ++;
            }
        }

        return pairCount == 1;
    }

    private boolean cardIsAce(Card card) {
        return card.getValue() == 14;
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean hasAtLeastDrill() {

        int[] values = evaluateValues();


        int pairCount = 0;
        for (int i : values) {
            if (i > 2) {
                return true;
            }

            if (i == 2) {
                pairCount ++;
            }
        }

        if (pairCount > 1) {
            return true;
        }

        return false;

    }
}
