
class Evaluator:
  NOTHING     = 0
  PAIR        = 1
  DOUBLE_PAIR = 2
  DRILL       = 3
  STRAIGHT    = 4

  def evaluate(self, deal):
    numpairs = self._number_of_pairs(deal)

    if self._has_straight(deal):
      return Evaluator.STRAIGHT

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

    for value in value_cat:
      if value_cat[value] > 2:
        return True
    return False

  def _has_straight(self, deal):
    values = self._value_categories(deal).keys()

    if len(values) < 5:
      return False

    sorted_values = sorted(values)
    last_value = sorted_values[0]
    del sorted_values[0]

    while len(sorted_values) > 0:
      value = sorted_values[0]
      del sorted_values[0]

      if value != last_value + 1:
        return False

      last_value = value

    return True

  def _value_categories(self, deal):
    value_cat = {}

    for card in deal:
      if not value_cat.has_key(card.value):
        value_cat[card.value] = 0
      value_cat[card.value] = value_cat[card.value] + 1

    return value_cat

