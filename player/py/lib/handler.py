import sys
import os

sys.path.append(os.path.abspath('lib'))

from api.ThriftTypes.ttypes import BetType

from betlog import BetLog

class PlayerHandler(object):
  def __init__(self):
    self.__reset__()
    self.money = 1000
    self.bet_log = BetLog()

  def name(self):
    return os.environ['USER']

  def competitor_status(self, competitor):
    if len(self.my_cards) == 0 and competitor.name == self.name():
      self.money += competitor.stack

  def hole_card(self, card):
    self.my_cards.append(card)

  def community_card(self, card):
    self.community_cards.append(card)

  def bet(self, competitor, bet):
    self.bet_log.bet(bet)
    #if self.__state__() == 2 and self.__eval__() > 24:
    pass

  def bet_request(self, pot, limits):
    try:
        return self.bet_log.bet_request(limits)
    except:
        return 0

    if self.__state__() == 2:
      if self.__eval__() > 20:
        return limits.to_call * 2
      else:
        return 0

    if self.__state__() == 5:
      if self.__eval__() > 30:
        return limits.to_call
      else:
        return 0

    return limits.to_call;

  def showdown(self, comptetior, cards, hand):
    pass

  def winner(self, competitor, amount):
    self.__reset__()


  def shutdown(self):
      sys.exit('Shutting down server')

  def __state__(self):
    return len(self.my_cards) + len(self.community_cards)

  def __reset__(self):
    self.my_cards = []
    self.community_cards = []

  def __eval_hand__(self):
    value =  self.my_cards[0].value + self.my_cards[1].value
    if (self.my_cards[0].value == self.my_cards[1].value):
      value += 10
    return value

  def __eval__(self):
    value = self.__eval_hand__()
    if self.community_cards[0].value == self.community_cards[1].value:
      value += self.community_cards[0].value * 2
    if self.community_cards[1].value == self.community_cards[2].value:
      value += self.community_cards[1].value * 2
    if self.community_cards[0].value == self.community_cards[2].value:
      value += self.community_cards[0].value * 2
    return value
