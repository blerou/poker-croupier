package com.devillsroom.poker.player;

import com.devillsroom.poker.client.BetLimits;

public class SimpleStrategy extends Strategy {

    private RankingClient rankingClient;

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
            return doCallOrFold(limits);

        } else {
            return 0;

        }

    }

    private long doPreFlopBet(BetLimits limits, Game game) {

        if (game.getHand().hasAtLeastPair() || game.getHand().hasTwoHighCard()) {
            return doRaise(limits);

        } else {

            return 0;

        }

    }


}
