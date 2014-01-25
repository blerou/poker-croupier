package com.devillsroom.poker.player;

import com.devillsroom.poker.client.BetLimits;
import com.devillsroom.poker.client.Card;

public class Game {

    private Hand hand = new Hand();
    private long pot;

    public void addHoleCard(Card card) {
        hand.addCard(card);
    }

    public void addCommunityCard(Card card) {
        hand.addCard(card);
    }

    public void setPot(long pot) {
        this.pot = pot;
    }

    public Hand getHand() {
        return hand;
    }
}
