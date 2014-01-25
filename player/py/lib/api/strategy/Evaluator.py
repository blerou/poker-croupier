
class Evaluator:
  NOTHING     = 0
  PAIR        = 1
  DOUBLE_PAIR = 2
  DRILL       = 3

  def evaluate(self, deal):
    numpairs = self._number_of_pairs(deal)

    if self._has_drill(deal):
      return Evaluator.DRILL

    if numpairs > 1:
      return Evaluator.DOUBLE_PAIR

    if numpairs > 0:
      return Evaluator.PAIR

    return Evaluator.NOTHING

  def _number_of_pairs(self, deal):
    value_cat = self._value_categories(deal)
    numpairs = 0

    for k in value_cat:
      if value_cat[k] > 1:
        numpairs = numpairs + 1

    return numpairs

  def _has_drill(self, deal):
    value_cat = self._value_categories(deal)

    for k in value_cat:
      if value_cat[k] > 2:
        return True
    return False

  def _value_categories(self, deal):
    value_cat = {}

    for v in deal:
      if not value_cat.has_key(v[0]):
        value_cat[v[0]] = 0
      value_cat[v[0]] = value_cat[v[0]] + 1

    return value_cat

