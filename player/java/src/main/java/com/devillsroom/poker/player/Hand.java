package com.devillsroom.poker.player;


import com.devillsroom.poker.client.Card;

import java.util.LinkedList;
import java.util.List;

public class Hand {

    private List<Card> cards = new LinkedList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean hasPair() {

        for (Card cardX : cards) {

            for (Card cardY : cards) {

                if (!cardX.equals(cardY)) {

                    if (cardX.getValue() == cardY.getValue()) {
                        return true;
                    }

                }

            }

        }

        return false;

    }
}
