import unittest


class TwoCardsEvaluator(object):
    def __init__(self):
        self.cards = []

    def card(self, card):
        self.cards.append(card)

    def evaluate(self):
        niceness = 0

        card1, card2 = self.cards[0], self.cards[1]

        if (card1.value + card2.value >= 26) and card1.value == card2.value:
            return 10

        if card1.value + card2.value >= 24:
            niceness += 1

        if card1.value == card2.value:
            niceness += 1

        if card1.suit == card2.suit:
            niceness += 1

        if abs(card1.value - card2.value) == 1:
            niceness += 1

        return niceness


class CardStub(object):
    def __init__(self, value, suit):
        self.value = value
        self.suit = suit


class TwoCardsEvaluatorTest(unittest.TestCase):
    def test_x(self):
        self.assertEqual(0, self.__evaluate([(1, 1), (3, 3)]))
        self.assertEqual(1, self.__evaluate([(1, 1), (1, 2)]))
        self.assertEqual(1, self.__evaluate([(1, 1), (5, 1)]))
        self.assertEqual(1, self.__evaluate([(1, 1), (2, 3)]))
        self.assertEqual(1, self.__evaluate([(11, 1), (13, 2)]))
        self.assertEqual(3, self.__evaluate([(12, 1), (13, 1)]))
        self.assertEqual(2, self.__evaluate([(12, 2), (12, 1)]))
        self.assertEqual(10, self.__evaluate([(13, 2), (13, 1)]))
        self.assertEqual(10, self.__evaluate([(14, 2), (14, 1)]))

    def __evaluate(self, cards):
        e = TwoCardsEvaluator()
        for value, suit in cards:
            e.card(CardStub(value, suit))
        return e.evaluate()


if __name__ == "__main__":
    unittest.main()

