package com.devillsroom.poker.player;

import com.devillsroom.poker.client.Card;
import com.devillsroom.poker.client.Suit;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HandTest {

    @Test
    public void testHasNoStraight() {

        Hand hand = new Hand();
        hand.addCard(new Card((short)11, Suit.Diamonds, ""));
        hand.addCard(new Card((short)14, Suit.Diamonds, ""));
        hand.addCard(new Card((short)11, Suit.Diamonds, ""));
        hand.addCard(new Card((short)14, Suit.Diamonds, ""));
        hand.addCard(new Card((short)14, Suit.Diamonds, ""));

        assertFalse(hand.hasStraight());
    }

    @Test
    public void testHasStraight() {

        Hand hand = new Hand();
        hand.addCard(new Card((short)5, Suit.Diamonds, ""));
        hand.addCard(new Card((short)6, Suit.Diamonds, ""));
        hand.addCard(new Card((short)7, Suit.Diamonds, ""));
        hand.addCard(new Card((short)8, Suit.Diamonds, ""));
        hand.addCard(new Card((short)9, Suit.Diamonds, ""));

        assertTrue(hand.hasStraight());

        hand = new Hand();
        hand.addCard(new Card((short)10, Suit.Diamonds, ""));
        hand.addCard(new Card((short)11, Suit.Diamonds, ""));
        hand.addCard(new Card((short)12, Suit.Diamonds, ""));
        hand.addCard(new Card((short)13, Suit.Diamonds, ""));
        hand.addCard(new Card((short)14, Suit.Diamonds, ""));

        assertTrue(hand.hasStraight());
    }

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

    @Test
    public void hasFlush() {
        Hand hand = new Hand();
        hand.addCard(new Card((short) 2, Suit.Clubs, ""));

        assertFalse("One card never make a flush.", hand.hasFlush());

        hand.addCard(new Card((short) 2, Suit.Diamonds, ""));
        hand.addCard(new Card((short) 2, Suit.Spades, ""));
        hand.addCard(new Card((short) 2, Suit.Hearts, ""));
        hand.addCard(new Card((short) 3, Suit.Hearts, ""));
        assertFalse("Different suites never make a flush", hand.hasFlush());

        hand.addCard(new Card((short) 3, Suit.Clubs, ""));
        hand.addCard(new Card((short) 4, Suit.Clubs, ""));
        hand.addCard(new Card((short) 5, Suit.Clubs, ""));
        hand.addCard(new Card((short) 6, Suit.Clubs, ""));
        assertTrue("5 of a suite make a flush", hand.hasFlush());
    }
}
