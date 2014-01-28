import unittest
from Evaluator import Evaluator
from ThriftTypes.ttypes import Card

class TestEvaluator(unittest.TestCase):
  def test_nothing(self):
    self.assert_result(Evaluator.NOTHING, [])
    self.assert_result(Evaluator.NOTHING, [Card(5, 1)])
    self.assert_result(Evaluator.NOTHING, [Card(5, 1), Card(6, 2)])

  def test_pair(self):
    self.assert_result(Evaluator.PAIR, [Card(5, 1), Card(5, 2), Card(6, 1)])

  def test_double_pair(self):
    self.assert_result(Evaluator.DOUBLE_PAIR, [Card(5, 1), Card(5, 2), Card(1, 1), Card(6, 1), Card(6, 2)])

  def test_drill(self):
    self.assert_result(Evaluator.DRILL, [Card(5, 1), Card(5, 2), Card(5, 3), Card(6, 1), Card(7, 1)])

  def test_straight(self):
    self.assert_result(Evaluator.STRAIGHT, [Card(3, 1), Card(6, 2), Card(6, 3), Card(5, 3), Card(4, 4), Card(7, 2)])

  def test_flush(self):
    self.assert_result(Evaluator.FLUSH, [Card(3, 1), Card(5, 1), Card(5, 2), Card(6, 1), Card(8, 1), Card(9, 1)])

  def assert_result(self, expected, input):
    self.assertEqual(expected, Evaluator().evaluate(input))