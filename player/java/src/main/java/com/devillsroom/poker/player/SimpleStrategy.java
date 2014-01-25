package com.devillsroom.poker.player;

import com.devillsroom.poker.client.BetLimits;

public class SimpleStrategy extends Strategy {

    @Override
    public long doBet(BetLimits limits, Game game) {

        if (game.getHand().hasPair()) {
            return doRaise(limits);
        }

        return doCallOrFold(limits);
    }

}
