package com.devillsroom.poker.player;

import com.devillsroom.poker.client.BetLimits;

public abstract class Strategy {

    public abstract long doBet(BetLimits limits, Game game);


    protected long doCall(BetLimits limits) {
        return limits.getTo_call();
    }

    protected long doRaise(BetLimits limits) {
        return limits.getTo_call() + limits.getMinimum_raise();
    }

    protected long doCheckOfFold() {
        return 0;
    }


}
