package com.devillsroom.poker.player;

import org.junit.Assert;
import org.junit.Test;

public class RaiseOnPairOrCheckPlayerTest {
    @Test
    public void hasNoPair() {
        RaiseOnPairOrCheckPlayer p = new RaiseOnPairOrCheckPlayer();
        p.addCard(1, (short)1);
        p.addCard(1, (short)2);
        p.addCard(1, (short)3);
        Assert.assertFalse(p.hasPair());
    }
    @Test
    public void hasPair() {
        RaiseOnPairOrCheckPlayer p = new RaiseOnPairOrCheckPlayer();
        p.addCard(1, (short)1);
        p.addCard(1, (short)2);
        p.addCard(1, (short)1);
        Assert.assertTrue(p.hasPair());
    }
}
