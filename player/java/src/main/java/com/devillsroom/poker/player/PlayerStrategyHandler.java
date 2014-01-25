package com.devillsroom.poker.player;

import com.devillsroom.poker.client.*;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PlayerStrategyHandler implements PlayerStrategy.Iface {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String name;

    private Player p;

    public PlayerStrategyHandler(String name, Player player) {
        this.name = name;
        p = player;
    }

    @Override
    public String name() throws TException {
        return name;
    }

    @Override
    public long bet_request(long pot, BetLimits limits) throws TException {
        logger.debug(name + " bet_request pot : " + pot + " minimum raise: " + limits.getMinimum_raise() + " to call : " + limits.getTo_call());

        return p.doBet(pot, limits.getTo_call(), limits.getMinimum_raise());
    }

    @Override
    public void competitor_status(Competitor competitor) throws TException {
        logger.debug(name + " competitor_status Name : " + competitor.name + " Stack " + competitor.getStack());
    }

    @Override
    public void bet(Competitor competitor, Bet bet) throws TException {
        logger.debug(name + " bet Competitor : " + competitor.getName() + " bet:" + bet.getAmount());


    }

    @Override
    public void hole_card(com.devillsroom.poker.client.Card card) throws TException {
        logger.debug(name + " hole_card Name : " + card.getName() + " Suite : " + card.getSuit() );

        p.addCard(card.getSuit().getValue(), (int)card.getValue());
    }

    @Override
    public void community_card(com.devillsroom.poker.client.Card card) throws TException {
        logger.debug(name + " community_card Name : " + card.getName() + " Suite : " + card.getSuit());

        p.addCard(card.getSuit().getValue(), card.getValue());
    }

    @Override
    public void showdown(Competitor competitor, List<com.devillsroom.poker.client.Card> cards, HandDescriptor hand) throws TException {
        logger.debug(name + " showdown");

    }

    @Override
    public void winner(Competitor competitor, long amount) throws TException {
        logger.debug(name + " winner");

    }

    @Override
    public void shutdown() throws TException {
        logger.debug(name + " shutdown");

    }
}
