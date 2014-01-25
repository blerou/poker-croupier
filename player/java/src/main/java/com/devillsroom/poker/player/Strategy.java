package com.devillsroom.poker.player;

import com.devillsroom.poker.client.BetLimits;

public abstract class Strategy {

    public abstract long doBet(BetLimits limits, Game game);

    protected long myBets = 0;

    protected long doCall(BetLimits limits) {
        return limits.getTo_call();
    }

    protected long doRaise(BetLimits limits) {
        return limits.getTo_call() + limits.getMinimum_raise();
    }

    protected long doRaise(BetLimits limits, int multiplier) {
        return limits.getTo_call() + (multiplier * limits.getMinimum_raise());
    }


    protected long doCheckOrFold() {
        return 0;
    }


    public void resetMyBets() {
        myBets = 0;
    }

    public void addBet(long amount) {
        myBets += amount;
    }
}
