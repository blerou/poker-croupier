package com.devillsroom.poker.player;

import com.devillsroom.poker.client.BetLimits;

public class OriginalStrategy extends Strategy {
    @Override
    public long doBet(BetLimits limits, Game game) {
        if (game.getHand().hasAtLeastPair()) {
            return doRaise(limits);
        }
        return doCall(limits);
    }
}
