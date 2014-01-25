package com.devillsroom.poker.player;

import com.devillsroom.poker.client.Bet;
import com.devillsroom.poker.client.Card;
import com.devillsroom.poker.client.Competitor;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Hand hand = new Hand();
    private long pot;
    private long bigBlind = 0;

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


    public long getBigBlind() {
        return bigBlind;
    }

    public void addBetByOthers(Competitor competitor, Bet bet) {
        if(bigBlind == 0) {
            bigBlind = 2 * bet.getAmount();
        }
        bets.put(competitor, bet);
    }

    public void resetBets() {
        bets = new HashMap<>();
    }
}
