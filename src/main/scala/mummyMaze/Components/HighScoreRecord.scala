package Components

import scalafx.beans.property.{StringProperty, ObjectProperty}

class HighScoreRecord(_playerName: String, _score: Score) {
  var playerName = new StringProperty(_playerName)
  var score = ObjectProperty(_score)
}
