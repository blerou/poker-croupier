package com.devillsroom.poker.player.strategy;

import com.devillsroom.poker.client.BetLimits;
import com.devillsroom.poker.player.Game;
import com.devillsroom.poker.player.Strategy;

public class OriginalStrategy extends Strategy {
    @Override
    public long doBet(BetLimits limits, Game game) {
        if (game.getHand().hasAtLeastPair()) {
            return doRaise(limits);
        }
        return doCall(limits);
    }
}
