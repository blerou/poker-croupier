from handler import PlayerHandler

__author__ = 'Balazs Vendeg'

import unittest
from api.ThriftTypes.ttypes import Card, BetLimits

class PlayerTest(unittest.TestCase):

    def setUp(self):
        self.player = PlayerHandler()

    def test_all_in_with_ace_pair_in_hand(self):
        c1 = Card()
        c2 = Card()
        c1.value = 14
        c2.value = 14

        self.player.hole_card(c1)
        self.player.hole_card(c2)

        l = BetLimits()
        l.minimum_raise = 10
        l.to_call = 10
        self.assertEqual(self.player.bet_request(100, l), 1000)


    def test_fold(self):
        c1 = Card()
        c2 = Card()
        c1.value = 8
        c2.value = 8

        self.player.hole_card(c1)
        self.player.hole_card(c2)

        l = BetLimits()
        l.minimum_raise = 10
        l.to_call = 10
        #self.assertEqual(self.player.bet_request(10, l), 0)

    def test_no_fold_after_flop(self):

      c1 = Card()
      c2 = Card()
      c1.value = 12
      c2.value = 13

      self.player.hole_card(c1)
      self.player.hole_card(c2)

      l = BetLimits()
      l.minimum_raise = 10
      l.to_call = 10
      self.assertEqual(self.player.bet_request(10, l), 20)
