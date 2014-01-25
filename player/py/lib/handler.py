import sys
import os

sys.path.append(os.path.abspath('lib'))

from api.ThriftTypes.ttypes import BetType

from betlog import BetLog
from twocards import TwoCardsEvaluator

class PlayerHandler(object):
  def __init__(self):
    self.__reset__()
    self.money = 1000
    self.bet_log = BetLog()
    self.rais = 0

  def name(self):
    return os.environ['USER']

  def competitor_status(self, competitor):
    print "competitor_status", competitor
    pass

  def hole_card(self, card):
    self.my_cards.append(card)
    self.twocards.card(card)

  def community_card(self, card):
    print "community_card", card
    pass

  def bet(self, competitor, bet):
    self.bet_log.bet(bet)
    #if self.__state__() == 2 and self.__eval__() > 24:
    pass

  def bet_request(self, pot, limits):
    if len(self.community_cards) == 0:
        niceness = self.twocards.evaluate()

        if niceness > 9:
            return max(0, self.money - 10)

        if niceness == 3:
            return limits.minimum_raise + limits.to_call
        if niceness == 0:
            return 0

        return limits.to_call

    self.rais = 0;
    if self.__state__() == 2:
      if self.__eval__() > 20:
        return limits.to_call * 2
      else:
        return 0

  def showdown(self, comptetior, cards, hand):
    print "showdown", comptetior, cards, hand
    pass

  def winner(self, competitor, amount):
    print "winner", competitor, amount
    pass

  def shutdown(self):
      sys.exit('Shutting down server')

  def __state__(self):
    return len(self.my_cards) + len(self.community_cards)

  def __reset__(self):
    self.my_cards = []
    self.community_cards = []
    self.twocards = TwoCardsEvaluator()

  def __eval_hand__(self):
    value =  self.my_cards[0].value + self.my_cards[1].value
    if (self.my_cards[0].value == self.my_cards[1].value):
      value += 10
    return value

  def __eval__(self):
    value = self.__eval_hand__()
    if self.__state__() > 2:
      if self.community_cards[0].value == self.community_cards[1].value:
        value += self.community_cards[0].value * 2
      if self.community_cards[1].value == self.community_cards[2].value:
        value += self.community_cards[1].value * 2
      if self.community_cards[0].value == self.community_cards[2].value:
        value += self.community_cards[0].value * 2
    return value
