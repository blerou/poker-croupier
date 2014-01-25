package com.devillsroom.poker.player;

import com.devillsroom.poker.client.Bet;
import com.devillsroom.poker.client.Card;
import com.devillsroom.poker.client.Competitor;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Hand hand = new Hand();
    private long pot;

    private Map<Competitor, Bet> bets = new HashMap<>();

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

    public boolean isPreFlop() {
        return getHand().getCards().size() <= 2;
    }

    public void addBet(Competitor competitor, Bet bet) {
        bets.put(competitor, bet);
    }

    public void resetBets() {
        bets = new HashMap<>();
    }
}
