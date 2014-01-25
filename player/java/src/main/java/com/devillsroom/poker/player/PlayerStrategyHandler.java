package com.devillsroom.poker.player;

import com.devillsroom.poker.client.*;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class PlayerStrategyHandler implements PlayerStrategy.Iface {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String name;

    private Game game;
    private Strategy strategy;

    public PlayerStrategyHandler(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    @Override
    public String name() throws TException {
        return name;
    }

    @Override
    public long bet_request(long pot, BetLimits limits) throws TException {
        logger.debug(name + " bet_request pot : " + pot + " minimum raise: " + limits.getMinimum_raise() + " to call : " + limits.getTo_call());

        game.setPot(pot);
        return strategy.doBet(limits, game);
    }

    @Override
    public void competitor_status(Competitor competitor) throws TException {
        logger.debug(name + " competitor_status Name : " + competitor.name + " Stack " + competitor.getStack());

        game = new Game();

    }

    @Override
    public void bet(Competitor competitor, Bet bet) throws TException {
        logger.debug(name + " bet Competitor : " + competitor.getName() + " bet:" + bet.getAmount());

    }

    @Override
    public void hole_card(Card card) throws TException {
        logger.debug(name + " hole_card Name : " + card.getName() + " Suite : " + card.getSuit() );

        game.addHoleCard(card);

    }

    @Override
    public void community_card(Card card) throws TException {
        logger.debug(name + " community_card Name : " + card.getName() + " Suite : " + card.getSuit());

        game.addCommunityCard(card);

    }

    @Override
    public void showdown(Competitor competitor, List<Card> cards, HandDescriptor hand) throws TException {
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
