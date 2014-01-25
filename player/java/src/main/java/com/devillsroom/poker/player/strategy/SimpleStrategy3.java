package com.devillsroom.poker.player.strategy;

import com.devillsroom.poker.client.BetLimits;
import com.devillsroom.poker.player.Game;
import com.devillsroom.poker.player.Strategy;

public class SimpleStrategy3 extends Strategy {

    @Override
    public long doBet(BetLimits limits, Game game) {

        long betAmount;

        if (game.isPreFlop()) {

            betAmount = doPreFlopBet(limits, game);

        } else {

            betAmount = doPostFlopBet(limits, game);

        }

        return betAmount;

    }

    private long doPostFlopBet(BetLimits limits, Game game) {

        if (game.getHand().hasAtLeastDrill() || game.getHand().hasFlush() || game.getHand().hasStraight()) {
            return doRaise(limits);

        } else if (game.getHand().hasExactlyOnePair()) {
            return doCall(limits);

        } else {
            return doCheckOrFold();

        }

    }

    private long handleMaximumCallOrFold(BetLimits limits, Game game) {
        if(myBets + doCall(limits) > game.getBigBlind()){
            return doCheckOrFold();
        } else {
            return doCall(limits);
        }
    }

    private long doPreFlopBet(BetLimits limits, Game game) {

        if (game.getHand().hasAtLeastPair() && game.getHand().hasTwoHighCardOutOfTwoCard()) {
            return doRaise(limits, 8);
        } else if (game.getHand().hasAtLeastPair() ) {
            return doRaise(limits, 4);
        } else if (game.getHand().hasTwoHighCardOutOfTwoCard()) {
            return doRaise(limits, 2);
        } else {

            return handleMaximumCallOrFold(limits, game);

        }

    }


}
