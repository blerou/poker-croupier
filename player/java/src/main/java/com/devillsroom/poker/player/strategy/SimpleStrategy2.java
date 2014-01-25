package com.devillsroom.poker.player.strategy;

import com.devillsroom.poker.client.BetLimits;
import com.devillsroom.poker.player.Game;
import com.devillsroom.poker.player.Strategy;

public class SimpleStrategy2 extends Strategy {

    @Override
    public long doBet(BetLimits limits, Game game) {

        if (game.isPreFlop()) {

            return doPreFlopBet(limits, game);

        } else {

            return doPostFlopBet(limits, game);

        }

    }

    private long doPostFlopBet(BetLimits limits, Game game) {

        if (game.getHand().hasAtLeastDrill()) {
            return doRaise(limits);

        } else if (game.getHand().hasExactlyOnePair()) {
            return doCall(limits);

        } else {
            return doCheckOfFold();

        }

    }

    private long doPreFlopBet(BetLimits limits, Game game) {

        if (game.getHand().hasAtLeastPair() || game.getHand().hasTwoHighCardOutOfTwoCard()) {
            return doRaise(limits);

        } else {

            return doCheckOfFold();

        }

    }


}
