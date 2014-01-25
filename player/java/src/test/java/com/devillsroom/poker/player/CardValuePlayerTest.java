package com.devillsroom.poker.player;

import junit.framework.Assert;
import org.junit.Test;

public class CardValuePlayerTest {
    @Test
    public void testDoBet() throws Exception {
        CardValuePlayer p = new CardValuePlayer();
        p.addCard(1, 14);
        p.addCard(2, 14);
        Assert.assertTrue(p.doBet(0, 10, 10) > 0);
    }
}
