package com.devillsroom.poker.player;

import com.devillsroom.poker.client.Card;
import com.devillsroom.poker.client.Suit;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HandTest {
    @Test
    public void testHasTwoHighCardOutOfTwoCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card((short)11, Suit.Diamonds, ""));
        hand.addCard(new Card((short)14, Suit.Diamonds, ""));

        assertTrue(hand.hasTwoHighCardOutOfTwoCard());
    }

    @Test
    public void testHasTwoHighCardOutOfTwoCardFalse() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card((short)8, Suit.Diamonds, ""));
        hand.addCard(new Card((short)14, Suit.Diamonds, ""));

        assertFalse(hand.hasTwoHighCardOutOfTwoCard());
    }

    @Test
    public void testHasExactlyOnePair() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card((short)14, Suit.Diamonds, ""));
        hand.addCard(new Card((short)14, Suit.Diamonds, ""));
        hand.addCard(new Card((short)10, Suit.Diamonds, ""));
        hand.addCard(new Card((short)12, Suit.Diamonds, ""));
        hand.addCard(new Card((short)13, Suit.Diamonds, ""));

        assertTrue(hand.hasExactlyOnePair());
    }
}
