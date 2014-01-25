import unittest
from Evaluator import Evaluator

class TestEvaluator(unittest.TestCase):
  def test_nothing(self):
    self.assert_result(Evaluator.NOTHING, [])
    self.assert_result(Evaluator.NOTHING, [[5, 1]])
    self.assert_result(Evaluator.NOTHING, [[5, 1], [6, 2]])

  def test_pair(self):
    self.assert_result(Evaluator.PAIR, [[5, 1], [5, 2], [6, 1]])

  def test_double_pair(self):
    self.assert_result(Evaluator.DOUBLE_PAIR, [[5, 1], [5, 2], [1, 1], [6, 1], [6, 2]])

  def test_drill(self):
    self.assert_result(Evaluator.DRILL, [[5, 1], [5, 2], [5, 3], [6, 1], [7, 1]])

  def assert_result(self, expected, input):
    self.assertEqual(expected, Evaluator().evaluate(input))