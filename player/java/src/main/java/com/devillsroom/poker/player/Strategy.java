package com.devillsroom.poker.player;

import com.devillsroom.poker.client.BetLimits;

public abstract class Strategy {

    public abstract long doBet(BetLimits limits, Game game);


    public long doCallOrFold(BetLimits limits) {
        return limits.getTo_call();
    }

    public long doRaise(BetLimits limits) {
        return limits.getTo_call() + limits.getMinimum_raise();
    }

}
