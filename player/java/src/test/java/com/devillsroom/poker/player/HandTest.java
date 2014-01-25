package com.devillsroom.poker.player;

import com.devillsroom.poker.client.Card;
import com.devillsroom.poker.client.Suit;
import junit.framework.TestCase;

public class HandTest extends TestCase {

    public void testHasNoPair() throws Exception {

        Hand hand = new Hand();

        hand.addCard(new Card((short)1, Suit.Clubs, ""));
        hand.addCard(new Card((short)2, Suit.Clubs, ""));

        assertFalse(hand.hasPair());

    }

    public void testHasPair() throws Exception {

        Hand hand = new Hand();

        hand.addCard(new Card((short)1, Suit.Clubs, ""));
        hand.addCard(new Card((short)1, Suit.Spades, ""));

        assertTrue(hand.hasPair());

    }

    public void testHasPairWithAnyNumberOfCards() throws Exception {

        Hand hand = new Hand();

        hand.addCard(new Card((short)1, Suit.Clubs, ""));
        hand.addCard(new Card((short)5, Suit.Clubs, ""));
        hand.addCard(new Card((short)2, Suit.Spades, ""));
        hand.addCard(new Card((short)10, Suit.Spades, ""));
        hand.addCard(new Card((short)3, Suit.Spades, ""));
        hand.addCard(new Card((short)5, Suit.Spades, ""));
        hand.addCard(new Card((short)4, Suit.Spades, ""));

        assertTrue(hand.hasPair());

    }

}
