import unittest


class BetLog(object):
    FOLD = 1
    CALL = 2
    RAISE = 4

    def __init__(self):
        self.folds = 0
        self.raises = 0
        self.calls = 0

    def bet_request(self, bet_limits):
        if self.raises > self.calls:
            return bet_limits.minimum_raise
        else:
            return bet_limits.to_call

    def bet(self, bet):
        if bet.type == self.FOLD:
            self.folds += 1
        elif bet.type == self.CALL:
            self.calls += 1
        elif bet.type == self.RAISE:
            self.raises += 1


class BetLimitsStub(object):
    def __init__(self, minimum_raise, to_call):
        self.minimum_raise = minimum_raise
        self.to_call = to_call


class BetStub(object):
    def __init__(self, amount, type, new_pot_size):
        self.amount = amount
        self.type = type
        self.new_pot_size = new_pot_size


class BetLogTest(unittest.TestCase):
    def test_x(self):
        log = BetLog()

        log.bet(BetStub(100, BetLog.CALL, 100))
        log.bet(BetStub(100, BetLog.FOLD, 100))
        log.bet(BetStub(100, BetLog.FOLD, 100))
        log.bet(BetStub(100, BetLog.RAISE, 100))
        log.bet(BetStub(100, BetLog.RAISE, 100))
        log.bet(BetStub(100, BetLog.RAISE, 100))

        self.assertEqual(1, log.calls)
        self.assertEqual(2, log.folds)
        self.assertEqual(3, log.raises)
        self.assertEqual(200, log.bet_request(BetLimitsStub(minimum_raise=200, to_call=100)))


if __name__ == "__main__":
    unittest.main()
